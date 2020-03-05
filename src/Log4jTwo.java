import org.apache.log4j.MDC;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.config.plugins.util.PluginManager;
import org.apache.logging.log4j.core.config.plugins.util.PluginRegistry;
import org.apache.logging.log4j.core.config.plugins.util.PluginType;
import org.apache.logging.log4j.core.lookup.MainMapLookup;
import org.apache.logging.log4j.core.lookup.MapLookup;
import org.apache.logging.log4j.core.lookup.StrLookup;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.apache.logging.log4j.message.*;
import org.apache.logging.log4j.util.PropertiesUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2020/2/22 6:55.
 */
public class Log4jTwo {
    public static void main(String[] args) {
        Log4jTwo log4jTwo = new Log4jTwo();

//        log4jTwo.logManager();
//        log4jTwo.loggerInfo(LogManager.getRootLogger());

//        log4jTwo.logger();
//        log4jTwo.entry();
//        log4jTwo.at();
//        log4jTwo.message();

//        log4jTwo.appender();
//        log4jTwo.layout();
//        log4jTwo.filter();
//        log4jTwo.substitutor();
//        log4jTwo.formate();
//        log4jTwo.print();

//        log4jTwo.inherit();
//        log4jTwo.config();
//        log4jTwo.lookup();

//        log4jTwo.loggerContext();
        log4jTwo.async();
//        log4jTwo.plugin();

//        log4jTwo.util();

    }

    private void message() {
        System.setProperty("log4j.configurationFile", "log4j2.message.xml");
//        System.setProperty("log4j2.messageFactory", "OneMessageFactory");

        Logger logger = LogManager.getLogger();
        System.out.println("getMessageFactory is " + logger.getMessageFactory());

//        Message message = new SimpleMessage("mmmmm");
        Message message = new StructuredDataMessage("00007", "mmmm", "TTT");
        System.out.println("getFormat is " + message.getFormat());
        System.out.println("getFormattedMessage is " + message.getFormattedMessage());
        System.out.println("getParameters is " + message.getParameters());
        System.out.println("getThrowable is " + message.getThrowable());

        logger.info(message);
    }

    private void lookup() {

        System.setProperty("log4j.configurationFile", "log4j2.lookup.xml");
//        System.setProperty("hhh", "9999999");
//        ThreadContext.put("one", "123456");
//        MainMapLookup.setMainArguments("one", "two");
        Logger logger = LogManager.getLogger("aa");
        loggerInfo(logger);
        logger.info("mm");

    }

    private void util() {

        //log4j2.component.properties将被log4j2.system.properties覆盖
//        Properties properties = new Properties();
//        properties.put("one", "000");
//        properties.put("three", "333");
//        PropertiesUtil propertiesUtil = new PropertiesUtil(properties);//构造函数将读取log4j2.system.properties
//        System.out.println(propertiesUtil.getStringProperty("one"));
//        System.out.println(propertiesUtil.getStringProperty("two"));
//        System.out.println(propertiesUtil.getStringProperty("three"));


        //系统属性将被log4j2.component.properties覆盖
        Properties properties = new Properties();
        properties.put("one", "000");
        properties.put("two", "222");

        PropertiesUtil propertiesUtil = PropertiesUtil
                .getProperties();//首先读取log4j2.component.properties覆盖系统属性，然后再用log4j2.system.properties覆盖
        System.out.println(propertiesUtil.getStringProperty("one"));
        System.out.println(propertiesUtil.getStringProperty("two"));
        System.out.println(propertiesUtil.getStringProperty("three"));
    }

    private void loggerContext() {
        LoggerContext loggerContext = (LoggerContext) LogManager.getContext();
        configInfo(loggerContext.getConfiguration());
    }

    private void configInfo(Configuration configuration) {

        System.out.println("getAdvertiser is " + configuration.getAdvertiser());
        System.out.println("getAppenders is " + configuration.getAppenders());
        System.out.println("getAsyncLoggerConfigDelegate is " + configuration.getAsyncLoggerConfigDelegate());
        System.out.println("getConfigurationSource is " + configuration.getConfigurationSource());
        System.out.println("getCustomLevels is " + configuration.getCustomLevels());
        System.out.println("getLoggerContext is " + configuration.getLoggerContext());
        System.out.println("getLoggers is " + configuration.getLoggers());
        System.out.println("getName is " + configuration.getName());
        System.out.println("getNanoClock is " + configuration.getNanoClock());
        System.out.println("getPluginPackages is " + configuration.getPluginPackages());
        System.out.println("getProperties is " + configuration.getProperties());
        System.out.println("getRootLogger is " + configuration.getRootLogger());
        System.out.println("getScheduler is " + configuration.getScheduler());
        System.out.println("getScriptManager is " + configuration.getScriptManager());
        System.out.println("getShutdownTimeoutMillis is " + configuration.getShutdownTimeoutMillis());
        System.out.println("getStrSubstitutor is " + configuration.getStrSubstitutor());
        System.out.println("getWatchManager is " + configuration.getWatchManager());

//        System.out.println("getComponent is " + configuration.getComponent());
//        System.out.println("getLoggerConfig is " + configuration.getLoggerConfig());
//        System.out.println("getReliabilityStrategy is " + configuration.getReliabilityStrategy());
    }

    private void plugin() {

        //方式一：使用add()方法指定包名
//        PluginManager pluginManager = new PluginManager("Core");
//        PluginManager.addPackage("mine");
//        System.out.println(pluginManager.getPlugins().size());


        //方式二：使用参数传递包名
//        PluginManager pluginManager = new PluginManager("Core");
//        pluginManager.collectPlugins(Arrays.asList("mine"));
//        System.out.println(pluginManager.getPlugins().size());


        //检索插件
//        PluginManager pluginManager = new PluginManager("testp");
//        pluginManager.collectPlugins(Arrays.asList("mine"));
//        PluginType pluginType = pluginManager.getPluginType("tp");
//        System.out.println(pluginType.toString());
//        System.out.println(pluginType.getElementName());


        //检索查询插件
//        PluginManager pluginManager = new PluginManager(StrLookup.CATEGORY);
//        pluginManager.collectPlugins(Arrays.asList("mine"));
//        PluginType pluginType = pluginManager.getPluginType("olu");
//        System.out.println(pluginType.toString());
//        System.out.println(pluginType.getElementName());

        System.setProperty("log4j.configurationFile", "log4j2.plugin.xml");
        Logger logger = LogManager.getLogger("xxx");
        logger.info("mmmmm");
    }

    private void logManager() {
//        Logger logger = LogManager.getFormatterLogger();
//        info(logger);
//
//        logger = LogManager.getFormatterLogger(this);
//        info(logger);
//
//        logger = LogManager.getFormatterLogger(this.getClass());
//        info(logger);
//
        Logger logger = LogManager.getLogger("xx");
//        loggerInfo(logger);
        logger.info("mmmm");


        //获取上下文工厂
//        LoggerContextFactory loggerContextFactory = LogManager.getFactory();

        //获取上下文对象
//        LoggerContext loggerContext = (LoggerContext) LogManager.getContext();
    }

    private void config() {


        //使用系统变量指定配置工厂
//        System.setProperty("log4j.configurationFile", "log4j2.xml");
//        System.setProperty("log4j.configurationFactory", "OneConfigurationFactory");

        //使用静态方法指定工厂
//        ConfigurationFactory.setConfigurationFactory(new OneConfigurationFactory());

        //使用复合配置
//        System.setProperty("log4j.configurationFile", "log4j2.xml, log4j2.properties");


        //配置工厂插件需要手动指定插件包名
//        PluginManager.addPackage("mine");
//        Logger logger = LogManager.getLogger();
//        logger.info("mmm");


    }

    private void async() {

        System.setProperty("log4j.configurationFile", "log4j2.async.xml");
//        System.setProperty("log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
//        System.setProperty("log4j2.messageFactory", "OneMessageFactory");

//        Logger logger = LogManager.getRootLogger();
        Logger logger = LogManager .getLogger("async");
//        Logger logger = LogManager .getLogger("asyncAppender");
        logger.info("mmm");


//        while (true) {
//            for (int i = 0; i < 1 * 1 * 1024; i++) {
//                logger.info("mmm");
//            }
//            try {
//                Thread.sleep(3000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }




    }

    private void layout() {
        System.setProperty("log4j.configurationFile", "log4j2.layout.xml");

        Logger logger = LogManager.getLogger();
//        logger.info("mmm");
        logger.log(Level.INFO, "xxx", new Throwable("iii"));
//        logger.info(null, 1,2);

    }

    private void appender() {
        Logger logger = LogManager.getLogger();
        for (int i = 0; i < 5 * 1024; i++) {
            logger.info("mm - " + i);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        logger.info("mm");


//        try {
//            Thread.sleep(30000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    private void inherit() {

        //使用默认Logger名，即类名作Logger名
//        Logger logger = LogManager.getLogger();
//        info(logger);

        //使用空名Logger
//        Logger logger = LogManager.getLogger("");
//        info(logger);

        //使用自名命Logger
        Logger logger = LogManager.getLogger("xxx");
//        info(logger);
        logger.info("mmmmm");

        //使用子Logger
        logger = LogManager.getLogger("xxx.aa");//继承父Logger
//        info(logger);
        logger.info("mmmmm");

    }

    private void filter() {


        //使用MarkerFilter
        Logger logger = LogManager.getLogger();
        Marker marker = MarkerManager.getMarker("AAA");
        Marker markerOne = MarkerManager.getMarker("BBB").setParents(marker);
        Marker markerTwo = MarkerManager.getMarker("CCC");
        logger.error(marker, "AAAAAAAAAAA");
        logger.error(markerOne, "BBBBBBBBBBBBB");
        logger.error(markerTwo, "CCCCCC");
        logger.error("DDD");


        //使用Logger过滤器
//        Logger logger = LogManager.getLogger("xxx.aa");
//        logger.error("eeeee");


        //使用Appender过滤器
//        Logger logger = LogManager.getLogger();
//        logger.error("SELECT * FROM");


    }

    private void entry() {
        Logger logger = LogManager.getLogger();

        EntryMessage entryMessage = logger.traceEntry("one={}", 1);
        System.out.println("getMessage is " + entryMessage.getMessage());
        System.out.println("getText() is " + entryMessage.getText());
        logger.traceExit(entryMessage, 2);
    }

    private void at() {
        Logger logger = LogManager.getLogger("aa");

        logger.atError().withLocation()
                .withMarker(MarkerManager.getMarker("one"))
                .withThrowable(new Exception("xxx"))
                .log("eeee");

    }

    private void print() {

        Logger logger = LogManager.getLogger("aa");

        logger.printf(Level.ALL, "%s", "xx");
    }

    private void formate() {

        Logger logger = LogManager.getLogger("aa");

        logger.error("%s", "xx");
    }

    private void substitutor() {
        Logger logger = LogManager.getLogger("aa");

        logger.error("eee{}ffff{}", "xx", "yy");

    }

    private void loggerInfo(Logger logger) {
        System.out.println("logger is " + logger);
        System.out.println("getLevel is " + logger.getLevel());
        System.out.println("getName is " + logger.getName());
//        System.out.println("getMessageFactory is " + logger.getMessageFactory());

    }

    private void logger() {

        Logger logger = LogManager.getLogger();
        loggerInfo(logger);

        //字符串日志
//        logger.trace("ttt");
//        logger.debug("ddd");
//        logger.info("iii");
//        logger.warn("www");
//        logger.error("eee");
//        logger.fatal("fff");


        //资源日志
        ResourceBundle resourceBundle = ResourceBundle.getBundle("msg", Locale.forLanguageTag("xx-YY"));
        Message message = new LocalizedMessage(resourceBundle, "one");
        logger.trace(message);
        logger.debug(message);
        logger.info(message);
        logger.warn(message);
        logger.error(message);
        logger.fatal(message);


    }
}
