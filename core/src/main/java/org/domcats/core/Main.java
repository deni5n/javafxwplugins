package org.domcats.core;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.module.Configuration;
import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public final class Main {


    public static void main(String[] args) {
        ModuleFinder pluginsFinder = ModuleFinder.of(rootPath("plugins"));
        List<String> plugins = pluginsFinder.findAll().stream().map(ModuleReference::descriptor).map(ModuleDescriptor::name)
                                            .collect(Collectors.toList());
        Configuration pluginsConfiguration = ModuleLayer.boot().configuration().resolve(pluginsFinder, ModuleFinder.of(), plugins);
        ModuleLayer layer = ModuleLayer.boot().defineModulesWithOneLoader(pluginsConfiguration, ClassLoader.getSystemClassLoader());
        List<Plugin> services = Plugin.getServices(layer);
        for (Plugin service : services) {
            System.out.println(service.name());
            service.doJob();
        }
    }


    private static Path rootPath(String plugins) {
        try {
            URI uri = Main.class.getProtectionDomain().getCodeSource().getLocation().toURI();
            String stringToJar = new File(uri).getPath();
            String decodedPath = URLDecoder.decode(stringToJar, "UTF-8");
            return Paths.get(decodedPath).getParent().resolve(plugins);
        } catch (URISyntaxException | UnsupportedEncodingException e) {
            return Paths.get(plugins);
        }
    }
}
