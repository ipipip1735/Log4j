import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.plugins.Plugin;

import java.net.URI;

/**
 * Created by Administrator on 2020/2/27 15:40.
 */
public class OneConfigurationFactory extends ConfigurationFactory {
    public OneConfigurationFactory() {
        System.out.println("+++++" + getClass().getSimpleName() + ".Constructor+++++");
    }

    @Override
    protected String[] getSupportedTypes() {
        System.out.println("~~" + getClass().getSimpleName() + ".getSupportedTypes~~");

//        return new String[]{"*"};
        return new String[]{".xml"};
//        return new String[]{".xml", "*"};
    }

    @Override
    public Configuration getConfiguration(LoggerContext loggerContext, String name, URI configLocation, ClassLoader loader) {
        System.out.println("~~" + getClass().getSimpleName() + ".getConfiguration1~~");
        System.out.println("loggerContext is " + loggerContext);
        System.out.println("name is " + name);
        System.out.println("configLocation is " + configLocation);
        System.out.println("loader is " + loader);
        return null;
    }

    @Override
    public Configuration getConfiguration(LoggerContext loggerContext, ConfigurationSource source) {
        System.out.println("~~" + getClass().getSimpleName() + ".getConfiguration~~");
        System.out.println("loggerContext is " + loggerContext);
        System.out.println("source is " + source);
        return null;
    }
}
