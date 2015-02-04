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

  opts.on('-t', '--type TEMPLATE', 'The type of block that you want to generate files for') do |type|
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

def edit_content(options, directory, file_list) 
  file_list.each do |file_name| 
    file = File.open(directory + "/" + file_name, 'w+') do |content|
      puts "Content: " + content
    end
  end
end

# Execute the script

check_valid_type(options[:type], type_options)

source = "json-source/block-models/#{options[:type]}"
destination = "../src/main/resources/assets/#{options[:mod]}/models/block"

new_files = copy_sources(options, source, destination)
edit_content(options, destination, new_files)