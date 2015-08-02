require 'rubygems'

env = {
    'GEM_PATH' => [Gem.dir],
    'GEM_HOME' => $jruby_options.gemHome.absolutePath
}
Gem.paths = env

puts "GEM VERSION " + Gem::VERSION
puts "GEM HOME " + Gem.dir
puts "GEMS PATH " + Gem.paths.path.to_s

def load_gem(gem)
    begin
        gem_spec = Gem::Specification.find_by_name(gem.name)
        puts gem.to_s + " found"
    rescue LoadError
        puts "installing " + gem.to_s
        Gem.install(gem.name, gem.version)
        gem_spec = Gem::Specification.find_by_name(gem.name)
        puts gem.to_s + " installed"
    end
end

$jruby_options.gems.each { |gem|
    load_gem(gem)
    require gem.name
}

require 'sass/plugin'

Sass::Plugin.options.merge!(
    :template_location => $sass_options.input.path,
    :css_location => $sass_options.output.path,
    :style => $sass_options.style.name.downcase.to_sym,
    :cache_location => $sass_options.cache.path,
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