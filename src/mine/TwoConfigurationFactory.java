package mine;

import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Order;
import org.apache.logging.log4j.core.config.plugins.Plugin;

import java.net.URI;

/**
 * Created by Administrator on 2020/2/27 15:40.
 */
@Plugin(name = "xmltwo", category = "ConfigurationFactory")
@Order(6)
public class TwoConfigurationFactory extends ConfigurationFactory {
    public TwoConfigurationFactory() {
        System.out.println("+++++" + getClass().getSimpleName() + ".Constructor+++++");
    }

    @Override
    protected String[] getSupportedTypes() {
        System.out.println("~~" + getClass().getSimpleName() + ".getSupportedTypes~~");
        return new String[]{".xml", "*"};
    }
    @Override
    public Configuration getConfiguration(LoggerContext loggerContext, ConfigurationSource source) {
        System.out.println("~~" + getClass().getSimpleName() + ".getConfiguration~~");
        System.out.println("loggerContext is " + loggerContext);
        System.out.println("source is " + source);
        return null;
    }
}
