require 'rubygems'

env = {
    'GEM_PATH' => Gem.dir,
    'GEM_HOME' => $rubygems_options.home.absolutePath
}
Gem.paths = env

$logger.info "GEM VERSION " + Gem::VERSION
$logger.info "GEM HOME " + Gem.dir
$logger.info "GEMS PATH " + Gem.paths.path.to_s

def load_gem(gem)
    begin
        gem_spec = Gem::Specification.find_by_name(gem.name)
        $logger.info gem_spec.name + ":" + gem_spec.version.to_s + " found"
    rescue LoadError
        $logger.info "installing " + gem.to_s
        Gem.install(gem.name, gem.version)
        gem_spec = Gem::Specification.find_by_name(gem.name)
        $logger.info gem_spec.name + ":" + gem_spec.version.to_s + " installed"
    end
end

$rubygems_options.gems.each { |gem|
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