package lone.wolf.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName LogUtils
 * @Description 日志工具类，封装了slf4j的常见用法，用于简化日志操作
 * @Author hechunhui
 * @Date 2018/6/15 10:26
 */
public class LogUtils {
    private final static Logger logger = LoggerFactory.getLogger(LogUtils.class);

    public static void info(String message) {
        if (logger.isInfoEnabled()) {
            logger.info(message);
        }
    }

    public static void info(String message, Throwable t) {
        if (logger.isInfoEnabled()) {
            logger.info(message, t);
        }

    }

    public static void info(String format, Object... arguments) {
        logger.info(format, arguments);
    }


    public static void debug(String message) {
        if (logger.isDebugEnabled()) {
            logger.debug(message);
        }
    }

    public static void debug(String message, Throwable t) {
        if (logger.isDebugEnabled()) {
            logger.debug(message, t);
        }

    }

    public static void debug(String format, Object... arguements) {
        logger.debug(format, arguements);
    }

    public static void warn(String message) {
        if (logger.isWarnEnabled()) {
            logger.warn(message);
        }
    }

    public static void warn(String message, Throwable t) {
        if (logger.isWarnEnabled()) {
            logger.warn(message, t);
        }
    }

    public static void warn(String format, Object... arguements) {
        logger.warn(format, arguements);
    }

    public static void error(String message) {
        if (logger.isErrorEnabled()) {
            logger.error(message);
        }
    }

    public static void error(String message, Throwable t) {
        if (logger.isErrorEnabled()) {
            logger.error(message, t);
        }
    }

    public static void error(String format, Object... arguement) {
        logger.error(format, arguement);
    }

    /**
     * 系统详细信息
     * 已开发完测试完成的系统，如果需要 再往系统中添加日志输出
     * 则使用trace 而不用Debug
     *
     * @param message 日志信息
     */
    public static void trace(String message) {
        if (logger.isTraceEnabled()) {
            logger.trace(message);
        }
    }

    public static void trace(String message, Throwable t) {
        if (logger.isTraceEnabled()) {
            logger.trace(message, t);
        }
    }

    public static void trace(String format, Object... arguements) {
        logger.trace(format, arguements);
    }


}
