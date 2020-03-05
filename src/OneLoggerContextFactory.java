import org.apache.logging.log4j.spi.LoggerContext;
import org.apache.logging.log4j.spi.LoggerContextFactory;

import java.net.URI;

/**
 * Created by Administrator on 2020/2/27 8:51.
 */
public class OneLoggerContextFactory implements LoggerContextFactory {
    public OneLoggerContextFactory() {
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
    public LoggerContext getContext(String fqcn, ClassLoader loader, Object externalContext, boolean currentContext) {
        System.out.println("~~" + getClass().getSimpleName() + ".getContext~~");
        System.out.println("fqcn is " + fqcn);
        System.out.println("loader is " + loader);
        System.out.println("externalContext is " + externalContext);
        System.out.println("currentContext is " + currentContext);

        return null;
    }

    @Override
    public LoggerContext getContext(String fqcn, ClassLoader loader, Object externalContext, boolean currentContext, URI configLocation, String name) {
        System.out.println("~~" + getClass().getSimpleName() + ".getContext~~");
        System.out.println("fqcn is " + fqcn);
        System.out.println("loader is " + loader);
        System.out.println("externalContext is " + externalContext);
        System.out.println("currentContext is " + currentContext);
        return null;
    }

    @Override
    public void removeContext(LoggerContext context) {
        System.out.println("~~" + getClass().getSimpleName() + ".removeContext~~");
        System.out.println("context is " + context);

    }
}
