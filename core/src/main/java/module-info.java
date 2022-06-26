import org.domcats.pluginapp.core.BasicService;
import org.domcats.pluginapp.core.IService;


module core {
    exports org.domcats.pluginapp.core;
    uses IService;
    provides IService with BasicService;
}