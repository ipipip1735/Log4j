package mine;

import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;

/**
 * Created by Administrator on 2020/2/29 21:57.
 */
@Plugin(name = "ttt", category = Core.CATEGORY_NAME, elementType = "sss")
public class Two {
    public Two() {
        System.out.println("+++++" + getClass().getSimpleName() + ".Constructor+++++");
    }

    @PluginFactory
    public static Two dddd() {
        System.out.println("~~Two.ddd~~");
        return new Two();
    }
}
