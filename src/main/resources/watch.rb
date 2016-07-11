Sass::Plugin.on_template_modified do |inputfile|
    puts "modified " + inputfile
end

Sass::Plugin.on_template_created do |inputfile|
    puts "modified " + inputfile
end

Sass::Plugin.on_template_deleted do |inputfile|
    puts "modified " + inputfile
end

Sass::Plugin.watch