package org.domcats.core;

import java.util.List;
import java.util.ServiceLoader;
import java.util.ServiceLoader.Provider;
import java.util.stream.Collectors;


public interface Plugin {


    void doJob();

    String name();

    static List<Plugin> getServices(ModuleLayer layer) {
        return ServiceLoader.load(layer, Plugin.class).stream().map(Provider::get).collect(Collectors.toList());
    }
}
