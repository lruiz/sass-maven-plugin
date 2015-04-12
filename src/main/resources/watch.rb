require 'rubygems'

env = {
    'GEM_PATH' => [Gem.dir],
    'GEM_HOME' => $jrubyOptions.gemHome.absolutePath
}
Gem.paths = env

puts "GEM VERSION " + Gem::VERSION
puts "GEM HOME " + Gem.dir
puts "GEMS PATH " + Gem.paths.path.to_s

begin
    sass_spec = Gem::Specification.find_by_name("sass")
    puts "sass found"
rescue LoadError
    puts "no sass, installing... "
    Gem.install("sass")
    sass_spec = Gem::Specification.find_by_name("sass")
    puts "sass installed"
end

require 'sass'
require 'sass/plugin'

begin
    susy_spec = Gem::Specification.find_by_name("susy")
    puts "susy found"
rescue LoadError
    puts "no susy, installing..."
    Gem.install("susy")
    susy_spec = Gem::Specification.find_by_name("susy")
    puts "susy installed"
end

require 'susy'


Sass::Plugin.options.merge!(
    :template_location => $sassOptions.input.absolutePath,
    :css_location => $sassOptions.output.absolutePath,
    :cache_location => $sassOptions.cache.absolutePath,
    :cache => true,
    :always_update => true,
    :unix_newlines => true,
    :style => :expanded
)

Sass::Plugin.watch