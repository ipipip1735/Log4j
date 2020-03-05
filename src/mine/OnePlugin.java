package mine;

import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.plugins.*;

/**
 * Created by Administrator on 2020/2/28 13:31.
 */
@Plugin(name = "ooo", category = Core.CATEGORY_NAME)
public class OnePlugin {
    public OnePlugin() {
        System.out.println("+++++" + getClass().getSimpleName() + ".Constructor+++++");
    }

    @PluginFactory
    public static OnePlugin cccc(@PluginAttribute("aaa") String att,
                                 @PluginElement("sss") Two[] twos,
                                 @PluginConfiguration Configuration configuration,
                                 @PluginNode Node node,
                                 @PluginValue("name") String pv) {
        System.out.println("~~OnePlugin.cccc~~");
        System.out.println("att is " + att);
        System.out.println("configuration is " + configuration);
        System.out.println("node is " + node);
        System.out.println("pv is " + pv);

        for (int i = 0; i < twos.length; i++) {
            System.out.println(twos[i]);
        }


        return new OnePlugin();
    }
//    @PluginFactory
//    public static LoggerConfig oneXXX(@PluginAttribute(value = "additivity") boolean additivity) {
//        System.out.println("~~OnePlugin.oneXXX~~");
//
//        return null;
//    }
}
