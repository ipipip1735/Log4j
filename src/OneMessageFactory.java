import org.apache.logging.log4j.message.AbstractMessageFactory;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.SimpleMessage;

/**
 * Created by Administrator on 2020/3/3 18:00.
 */
public class OneMessageFactory extends AbstractMessageFactory {

    public OneMessageFactory() {
        System.out.println("+++" + getClass().getSimpleName() + ".Constructor+++");
    }

    @Override
    public Message newMessage(String message) {
        System.out.println("~~" + getClass().getSimpleName() + ".newMessage~~");
        System.out.println("message is " + message);

        System.out.println(Thread.currentThread());
        return new SimpleMessage(message);
//        return null;
    }

    @Override
    public Message newMessage(String message, Object... params) {
        System.out.println("~~" + getClass().getSimpleName() + ".newMessage~~");
        System.out.println("message is " + message);
        for (Object o : params)
            System.out.println("o is " + o);
        return new SimpleMessage(message);
//        return null;
    }
}
