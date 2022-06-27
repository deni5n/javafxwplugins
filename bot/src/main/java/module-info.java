
import org.domcats.core.Plugin;
import org.domcats.plugin.PluginA;

module bot {
    requires core;

    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;

    opens org.domcats.plugin to javafx.fxml;
    exports org.domcats.plugin;

    provides Plugin with PluginA;
}