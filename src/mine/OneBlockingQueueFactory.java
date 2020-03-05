package mine;

import org.apache.logging.log4j.core.async.ArrayBlockingQueueFactory;
import org.apache.logging.log4j.core.async.BlockingQueueFactory;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Administrator on 2020/3/5 6:50.
 */
@Plugin(name = "BQF", category = Node.CATEGORY, elementType = BlockingQueueFactory.ELEMENT_TYPE)
public class OneBlockingQueueFactory<E> implements BlockingQueueFactory<E> {

    public OneBlockingQueueFactory() {
        System.out.println("+++++" + getClass().getSimpleName() + ".Constructor+++++");
    }

    @Override
    public BlockingQueue<E> create(int capacity) {
        System.out.println("~~" + getClass().getSimpleName() + ".getConfiguration~~");
        System.out.println("capacity is " + capacity);
        return new ArrayBlockingQueue<>(capacity);
    }

    @PluginFactory
    public static <E> OneBlockingQueueFactory<E> createFactory() {
        return new OneBlockingQueueFactory<>();
    }
}
