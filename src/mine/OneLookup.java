package mine;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.lookup.StrLookup;

/**
 * Created by Administrator on 2020/3/3 17:19.
 */
@Plugin(name = "olu", category = StrLookup.CATEGORY)
public class OneLookup implements StrLookup {

    @Override
    public String lookup(String key) {
        System.out.println("~~" + getClass().getSimpleName() + ".lookup~~");
        System.out.println("key is " + key);
        return null;
    }

    @Override
    public String lookup(LogEvent event, String key) {
        System.out.println("~~" + getClass().getSimpleName() + ".lookup1~~");
        System.out.println("event is " + event);
        System.out.println("key is " + key);
        return "ppppppppp";
    }
}
