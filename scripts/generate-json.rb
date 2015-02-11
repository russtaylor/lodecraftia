#
# A basic script for generating json based on predefined templates.
#

require 'optparse'
require 'fileutils'

type_options = [:fence, :slab, :stairs, :wall, :block]

# Handle the command line options.
options = {}
optionParser = OptionParser.new do |opts|
  opts.banner = 'Usage: generate-json.rb [options]'

  opts.on('-m', '--mod NAME', 'The name of your target mod') do |mod|
    options[:mod] = mod
  end

  opts.on('-t', '--type TYPE', 'The type of block that you want to generate files for') do |type|
    options[:type] = type
  end

  opts.on('-n', '--name NAME', 'The name of the block you\'re generating.') do |name|
    options[:name] = name;
  end

  opts.on('-x', '--texture NAME', 'The name of the texture used for this block') do |texture|
    options[:texture] = texture
  end

  opts.on('-u', '--up TEXTURE', 'The name of the \'top\' texture of this block') do |up|
    options[:up] = up
  end

  opts.on('-d', '--down TEXTURE', 'The name of the \'bottom\'texture of this block') do |down|
    options[:down] = down
  end

  opts.on('-s', '--side TEXTURE', 'The name of the \'side\' texture of this block') do |side|
    options[:side] = side
  end

  opts.on('-i', '--include', 'Whether or not the mod name should be included in the texture path') do |include|
    options[:include] = include
  end

  opts.on('-p', '--parent', 'The parent block - for example, slabs need a block to use for the double slab') do |parent|
    options[:parent] = parent
  end
end

begin
  optionParser.parse!
  mandatory = [:mod, :type, :name]
  missing = mandatory.select{ |param| options[param].nil? }
  if not missing.empty?
    puts "Missing required options: #{missing.join(', ')}"
    puts optionParser
    exit
  end
rescue OptionParser::InvalidOption, OptionParser::MissingArgument
  puts $!.to_s
  puts optionParser
  exit
end

def check_valid_type(type, type_options)
  if(type_options.include? type.to_sym)
    return true
  else
    raise "Invalid 'type' option: #{type}, must be one of #{type_options}"
  end
end

def validate_texture_options(options)
  if(not(options[:texture]))
    if(not(options[:up]) or not(options[:down]) or not(options[:side]))
      raise "Must specify either 'texture' or 'up', 'down', and 'side'"
    end
  end
end

def copy_sources(options, source, destination)
  new_sources = Array.new
  Dir.entries(source).each do |current_file|
    if(current_file == '.' or current_file == '..')
      next
    end
    new_filename = current_file.gsub(/template/, options[:name])
    FileUtils.cp(source + '/' + current_file, destination + "/" + new_filename)
    new_sources << new_filename
  end
  return new_sources
end

def set_texture_names(options, source_text)
  mod_name_texture = ''
  if(options[:include])
    mod_name_texture = options[:mod] + ':'
  end

  if(options[:up] and options[:down] and options[:side])
    
  end

  if(options[:texture])
    source_text.gsub!(/\{texture_name\}/, options[:texture])
  end
end

def edit_content(options, directory, file_list)
  file_list.each do |file_name|
    full_path = directory + '/' + file_name
    file_text = File.read(full_path)
    file_text.gsub!(/\{mod_name\}/, options[:mod] + ":")
    file_text = set_texture_names(options, file_text)
    File.open(full_path, 'w') do |file|
      file.puts(file_text)
    end
  end
end

# Execute the script
check_valid_type(options[:type], type_options)
validate_texture_options(options)

source = "json-source/block-models/#{options[:type]}"
destination = "../src/main/resources/assets/#{options[:mod]}/models/block"

new_files = copy_sources(options, source, destination)
edit_content(options, destination, new_files)