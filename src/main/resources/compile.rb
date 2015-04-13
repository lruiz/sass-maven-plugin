require 'rubygems'

env = {
    'GEM_PATH' => [Gem.dir],
    'GEM_HOME' => $jrubyOptions.gemHome.absolutePath
}
Gem.paths = env

puts "GEM VERSION " + Gem::VERSION
puts "GEM HOME " + Gem.dir
puts "GEMS PATH " + Gem.paths.path.to_s

def load_gem(gem)
    begin
        gem_spec = Gem::Specification.find_by_name(gem)
        puts gem + " found"
    rescue LoadError
        puts "installing " + gem
        Gem.install(gem)
        gem_spec = Gem::Specification.find_by_name("sass")
        puts gem + " installed"
    end
end

load_gem("sass")
require 'sass'
require 'sass/plugin'

load_gem("susy")
require 'susy'

Sass::Plugin.options.merge!(
    :template_location => $sassOptions.input.path,
    :css_location => $sassOptions.output.path,
    :style => $sassOptions.style.name.downcase.to_sym,
    :cache_location => $sassOptions.cache.path,
    :cache => true,
    :always_update => true,
    :unix_newlines => true
)

Sass::Plugin.on_updated_stylesheet do |inputfile, outputfile|
    $callback.compiled(inputfile, outputfile)
end

Sass::Plugin.on_compilation_error do |error|
    java_import org.tautua.maven.plugins.sass.SyntaxException
    $callback.error(SyntaxException.new(error.to_s, error.sass_filename, error.sass_line))
end

Sass::Plugin.update_stylesheets