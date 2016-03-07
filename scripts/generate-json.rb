#
# A basic script for generating json based on predefined templates.
#

require 'optparse'
require 'set'
require 'fileutils'

type_options = %w(fence slab stairs wall block)
model_directories = %w(models/block blockstates models/item)
non_custom_options = %w(block_name mod_name vanilla texture)

# Handle the command line options.
options = {}
optionParser = OptionParser.new do |opts|
  opts.banner = 'Usage: generate-json.rb [options]'

  opts.on('-t', '--type TYPE', 'The type of block that you want to generate files for') do |type|
    options['type'] = type
  end

  opts.on('-n', '--name NAME', 'The name of the block you\'re generating.') do |name|
    options['block_name'] = name;
  end

  opts.on('-x', '--texture NAME', 'The name of the texture used for this block') do |texture|
    options['texture'] = texture
  end

  opts.on('-o', '--options OPTIONS', 'A comma-separated list of other custom options that appear ' + 
    'in this type\'s templates. In the format variable=value.') do |custom|
    options['custom'] = custom
  end

  opts.on('-v', '--vanilla', 'Should be specified to utilize a vanilla texture with this block.') do |vanilla|
    options['vanilla'] = vanilla
  end
end

begin
  optionParser.parse!
  mandatory = %w(type block_name)
  missing = mandatory.select{ |param| options[param].nil? }
  unless missing.empty?
    puts "Missing required options: #{missing.join(', ')}"
    puts optionParser
    exit
  end
rescue OptionParser::InvalidOption, OptionParser::MissingArgument
  puts $!.to_s
  puts optionParser
  exit
end

def load_mod_name
  File.open('../build.gradle', 'r') do |file|
    file.find do |line|
      if line =~ /archivesBaseName/
        match = /"(?<modname>.*)"/.match(line)
        return match[:modname]
      end
    end
  end
end

def check_valid_type(type, type_options)
  if type_options.include? type
    true
  else
    raise "Invalid 'type' option: #{type}, must be one of #{type_options}"
  end
end

def parse_options(options)
  unless options['custom'].nil?
    split = options['custom'].split(',')
    split_options = Hash.new
    split.each do |option|
      current_option = option.split('=')
      split_options[current_option[0]] = current_option[1]
    end
  end
  options['custom'] = split_options
  options
end

def find_options(files)
  template_options = Set.new
  files.each do |file_name|
    file_text = File.read(file_name)
    matches = file_text.scan(/\{(?<option_name>[a-z_-]+?)\}/)
    matches.each do |match|
      template_options << match
    end
  end
  template_options
end

def find_templates(options, source, directories)
  templates = Array.new
  directories.each do |directory|
    current_directory = source.gsub(/\{directory\}/, directory)
    Dir.entries(current_directory).each do |current_file|
      if current_file == '.' or current_file == '..'
        next
      end
      templates << "#{current_directory}/#{current_file}"
    end
  end
  templates
end

def copy_templates(options, templates, destination)
  new_sources = Array.new
  templates.each do |current_file|
    new_filename = current_file.gsub(/template/, options['block_name'])
    new_filename = new_filename.gsub(/json-source\//, '')
    new_filename = new_filename.gsub(/#{options['type']}\//, '')
    FileUtils.cp(current_file, "#{destination}/#{new_filename}")
    new_sources << new_filename
  end
  new_sources
end

def edit_content(passed_options, file_options, directory, file_list)
  file_list.each do |file_name|
    full_path = directory + '/' + file_name
    file_text = File.read(full_path)
    file_text = replace_options(passed_options, file_options, file_text, full_path)
    File.open(full_path, 'w') do |file|
      file.puts(file_text)
    end
  end
end

def validate_options(passed_option_list, file_option_list, non_custom_options)
  missing_options = Array.new
  file_option_list.each do |option|
    unless non_custom_options.include?(option[0])
      if passed_option_list.nil? or not passed_option_list.include?(option[0])
        missing_options.push(option[0])
      end
    end
  end
  unless missing_options.empty?
    raise "Your 'custom options' list is missing the following options: #{missing_options}"
  end
end

def replace_options(passed_option_list, file_option_list, file_text, file_path)
  file_option_list.each do |option|
    option = option[0]
    replace_option = passed_option_list[option]
    if replace_option.nil? and not passed_option_list[option].nil?
      replace_option = passed_option_list[option.to_sym]
    end
    if replace_option.nil?
      replace_option = passed_option_list['custom'][option]
    end
    if option == 'mod_name'
      if passed_option_list['vanilla'] and not file_path.include? 'models/block'
        replace_option = ''
      else
        replace_option = "#{replace_option}:"
      end
    end
    file_text.gsub!(/\{#{option}\}/, replace_option)
  end
  file_text
end

# Execute the script
check_valid_type(options['type'], type_options)

source = "json-source/{directory}/#{options['type']}"

options = parse_options(options)
source_files = find_templates(options, source, model_directories)
options['mod_name'] = load_mod_name

destination = "../src/main/resources/assets/#{options['mod_name']}"

all_options = find_options(source_files)
validate_options(options['custom'], all_options, non_custom_options)

new_files = copy_templates(options, source_files, destination)
edit_content(options, all_options, destination, new_files)