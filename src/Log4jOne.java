import org.apache.log4j.*;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Administrator on 2020/2/19 19:58.
 */
public class Log4jOne {
    public static void main(String[] args) {
        Log4jOne log4jOne = new Log4jOne();

//        log4jOne.log();
//        log4jOne.inherit();//继承
//        log4jOne.appender();//追加器
//        log4jOne.layout();//布局
//        log4jOne.level();//日志级别
//        log4jOne.info(Logger.getLogger(""));//打印Logger信息
//        log4jOne.config();//配置
        log4jOne.logManager();


    }

    private void logManager() {

        //获取实例
//        System.out.println(Logger.getLogger("a"));
//        System.out.println(LogManager.getLogger("a"));


        //重读配置
        LogManager.resetConfiguration();

    }

    private void inherit() {


        Logger logger = Logger.getLogger("");//无名Logger（无名Logger的父Logger是根Logger）
        logger.setLevel(Level.ALL);
        logger.addAppender(new ConsoleAppender(new SimpleLayout()));//设置追加器
        info(logger);//打印信息


        Logger loggerA = Logger.getLogger(".a");//无名Logger的子Logger
        loggerA.addAppender(new ConsoleAppender(new SimpleLayout()));//设置追加器
        //loggerA.setAdditivity(false);//禁用父Logger的追加器
        info(loggerA);//打印信息

        loggerA.info("AAAA");

    }

    private void appender() {

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.INFO);

        //使用控制台追加器
//        ConsoleAppender appender = new ConsoleAppender(new SimpleLayout());


        //使用文件追加器
//        FileAppender appender = null;
//        try {
//            appender = new FileAppender(new SimpleLayout(), "res/log", true, true, 1024);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        //使用滚动文件追加器
        RollingFileAppender appender = null;
        try {
            appender = new RollingFileAppender(new SimpleLayout(), "res/log", true);
//            appender.setMaxFileSize("1KB");
            appender.setMaximumFileSize(1024);
            appender.setMaxBackupIndex(2);
        } catch (IOException e) {
            e.printStackTrace();
        }


        logger.addAppender(appender);

        for (int i = 0; i < 1024 * 8; i++) {
            logger.info("mmmmmm");
        }


    }

    private void layout() {


        Logger logger = Logger.getLogger("aa");
        logger.setLevel(Level.ALL);

        //使用简单布局
//        Layout layout = new SimpleLayout();

        //使用XML布局
//        XMLLayout layout = new XMLLayout();
//        layout.setLocationInfo(true);//设置定位信息（显示记录日志的类名、方法名、文件名、行数）

        //使用HTML布局
//        HTMLLayout layout = new HTMLLayout();
//        layout.setLocationInfo(true);//设置定位信息（显示记录日志的类名、方法名、文件名、行数）
//        layout.setTitle("xxx");//设置HTML的<title>标签

        Layout layout = new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN);
//        Layout layout = new PatternLayout(PatternLayout.DEFAULT_CONVERSION_PATTERN);
//        String pattern = "%c{2}";
//        String pattern = "%C - %C{1}";
//        String pattern = "%M";
//        String pattern = "%d";
//        String pattern = "%d{yyyy-MMM-dd HH:mm:ss,SSS}";
//        String pattern = "%F";
//        String pattern = "%l";
//        String pattern = "%L";
//        String pattern = "%m";
//        String pattern = "XXX%nYYY";
//        String pattern = "%p";
//        String pattern = "%r";
//        String pattern = "%t";
//        String pattern = "%x";
//        String pattern = "%X";
//        String pattern = "xx is 5%%";
//        String pattern = "%20";
//        String pattern = "%-20coooo";
//        String pattern = "%.2c";
//        String pattern = "%20.2c";
//        String pattern = "%20.1c";
//        Layout layout = new PatternLayout(pattern);


        Appender appender = new ConsoleAppender(layout);
        logger.addAppender(appender);
        logger.info("mmmmm");

    }

    private void config() {

        //方式一：使用属性文件
//        PropertyConfigurator.configure("res/log4j.properties");//读取属性配置文件
//        System.setProperty("log4j.configuration", "res/xx.properties");

//        Logger logger = Logger.getRootLogger();
//        info(logger);
//        logger.info("mmmm");

//        Logger logger = Logger.getLogger("aa");
//        info(logger);
//        logger.info("mmmm");


        //方式二：使用系统属性
        File file = new File("res/log.config");
        System.out.println(file.toURI());
        System.setProperty("log4j.configuration", file.toURI().toString());

        Logger logger = Logger.getRootLogger();
        info(logger);
        logger.info("mmmm");


        //方式三：使用Java对象配置
//        BasicConfigurator.configure();
//        Logger logger = Logger.getRootLogger();
//        info(logger);
//        logger.info("mmmm");

    }

    private void level() {
        System.out.println("OFF is " + Level.OFF);
        System.out.println("OFF_INT is " + Level.OFF_INT);
        System.out.println("TRACE is " + Level.TRACE);
        System.out.println("TRACE_INT is " + Level.TRACE_INT);
        System.out.println("DEBUG is " + Level.DEBUG);
        System.out.println("DEBUG_INT is " + Level.DEBUG_INT);
        System.out.println("INFO is " + Level.INFO);
        System.out.println("INFO_INT is " + Level.INFO_INT);
        System.out.println("WARN is " + Level.WARN);
        System.out.println("WARN_INT is " + Level.WARN_INT);
        System.out.println("ERROR is " + Level.ERROR);
        System.out.println("ERROR_INT is " + Level.ERROR_INT);
        System.out.println("FATAL is " + Level.FATAL);
        System.out.println("FATAL_INT is " + Level.FATAL_INT);
        System.out.println("ALL is " + Level.ALL);
        System.out.println("ALL_INT is " + Level.ALL_INT);
    }

    private void log() {

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.ALL);

        Appender appender = new ConsoleAppender(new SimpleLayout());
        logger.addAppender(appender);//设置追加器
//        info(logger);//打印信息


        //国家化日志
//        logger.setResourceBundle(ResourceBundle.getBundle("msg"));
//        logger.setResourceBundle(ResourceBundle.getBundle("msg", Locale.forLanguageTag("xx-YY")));
//        logger.l7dlog(Level.ALL, "one", new Object[]{"11", "222"}, null);


        //断言日志
//        logger.assertLog(false, "xx");


        //记录日志
//        logger.log(Level.ALL, "mmmmm");

        //快捷方法
//        logger.trace("ttt");
//        logger.debug("ddd");
//        logger.info("iii");
//        logger.warn("www");
//        logger.error("eee");
//        logger.fatal("fff");


    }

    private void info(Logger logger) {


        System.out.println("logger is " + logger);
        System.out.println("getRootLogger is " + logger.getRootLogger());
        System.out.println("getName is " + logger.getName());
        System.out.println("getParent is " + logger.getParent());
        System.out.println("getLoggerRepository is " + logger.getLoggerRepository());
        System.out.println("getResourceBundle is " + logger.getResourceBundle());
        System.out.println("getEffectiveLevel is " + logger.getEffectiveLevel());
        System.out.println("getAdditivity is " + logger.getAdditivity());
        System.out.println("getLevel is " + logger.getLevel());

        Enumeration enumeration = logger.getAllAppenders();
        while (enumeration.hasMoreElements()) {
            System.out.println("Appender is " + enumeration.nextElement());
        }


    }
}
