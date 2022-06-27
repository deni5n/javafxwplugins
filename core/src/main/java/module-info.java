import org.domcats.core.BasicService;
import org.domcats.core.Plugin;


module core {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;

    opens org.domcats.core to javafx.fxml;
    exports org.domcats.core;
    uses Plugin;
    provides Plugin with BasicService;
}