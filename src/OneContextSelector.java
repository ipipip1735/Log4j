import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.selector.ContextSelector;

import java.net.URI;
import java.util.List;

/**
 * Created by Administrator on 2020/2/27 14:20.
 */
public class OneContextSelector implements ContextSelector {
    public OneContextSelector() {
        System.out.println("+++++" + getClass().getSimpleName() + ".Constructor+++++");
    }

    @Override
    public void shutdown(String fqcn, ClassLoader loader, boolean currentContext, boolean allContexts) {
        System.out.println("~~" + getClass().getSimpleName() + ".shutdown~~");
        System.out.println("fqcn is " + fqcn);
        System.out.println("loader is " + loader);
        System.out.println("currentContext is " + currentContext);
        System.out.println("allContexts is " + allContexts);

    }

    @Override
    public boolean hasContext(String fqcn, ClassLoader loader, boolean currentContext) {
        System.out.println("~~" + getClass().getSimpleName() + ".hasContext~~");
        System.out.println("fqcn is " + fqcn);
        System.out.println("loader is " + loader);
        System.out.println("currentContext is " + currentContext);

        return false;
    }

    @Override
    public LoggerContext getContext(String fqcn, ClassLoader loader, boolean currentContext) {
        System.out.println("~~" + getClass().getSimpleName() + ".getContext~~");
        System.out.println("fqcn is " + fqcn);
        System.out.println("loader is " + loader);
        System.out.println("currentContext is " + currentContext);

        return null;
    }

    @Override
    public LoggerContext getContext(String fqcn, ClassLoader loader, boolean currentContext, URI configLocation) {
        System.out.println("~~" + getClass().getSimpleName() + ".getContext~~");
        System.out.println("fqcn is " + fqcn);
        System.out.println("loader is " + loader);
        System.out.println("currentContext is " + currentContext);
        System.out.println("configLocation is " + configLocation);

        return null;
    }

    @Override
    public List<LoggerContext> getLoggerContexts() {
        System.out.println("~~" + getClass().getSimpleName() + ".getLoggerContexts~~");

        return null;
    }

    @Override
    public void removeContext(LoggerContext context) {
        System.out.println("~~" + getClass().getSimpleName() + ".removeContext~~");
        System.out.println("context is " + context);

    }
}
