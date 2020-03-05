package mine;

import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.filter.AbstractFilter;

/**
 * Created by Administrator on 2020/2/29 22:55.
 */
@Plugin(name = "san", category = Core.CATEGORY_NAME)
public class Three extends AbstractFilter {
    public Three() {
        System.out.println("+++++" + getClass().getSimpleName() + ".Constructor+++++");
    }

    @PluginFactory
    public static Three createFilter(@PluginAttribute("aaa") String att) {
        System.out.println("~~Three.createFilter~~");
        System.out.println("att is " + att);
        return new Three();
    }
}
