package org.domcats.pluginapp.core;

public class BasicService implements org.domcats.pluginapp.core.IService {
    @Override
    public void doJob() {
        System.out.println("Basic service");
    }
}
