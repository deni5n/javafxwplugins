
import org.domcats.pluginapp.core.IService;
import org.domcats.pluginapp.bot.Service1;

module bot {
    requires core;

    provides IService with Service1;
}