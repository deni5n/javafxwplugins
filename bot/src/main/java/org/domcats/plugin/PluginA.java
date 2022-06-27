package org.domcats.plugin;

import org.domcats.core.Plugin;


public class PluginA implements Plugin {

    @Override
    public void doJob() {
    }

    @Override
    public String name() {
        return "pluginA";
    }
}
