Sass::Plugin.on_template_modified do |inputfile|
    $callback.modified(inputfile)
end

Sass::Plugin.on_template_created do |inputfile|
    $callback.created(inputfile)
end

Sass::Plugin.on_template_deleted do |inputfile|
    $callback.deleted(inputfile)
end

Sass::Plugin.watch