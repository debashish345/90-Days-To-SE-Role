package LLD.logger.domain;

import LLD.logger.handler.AbstractLogHandler;
import LLD.logger.manager.LogManager;
import LLD.logger.observer.LogSubject;

import java.io.Serializable;

/*
* Singleton Logger Class
* */
public class Logger implements Cloneable, Serializable {
    private static volatile Logger INSTANCE;
    private static volatile AbstractLogHandler LOG_MANAGER;
    private static volatile LogSubject LOG_SUBJECT;
    private Logger() {
    }

    /*
    * Singleton Logger Object
    * */
    public static Logger getLogger() {
        if (INSTANCE == null) {
            synchronized (Logger.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Logger();
                    LOG_MANAGER = LogManager.createLogChain();
                    LOG_SUBJECT = LogManager.createLogObserver();
                }
            }
        }
        return INSTANCE;
    }

    /*
    * Restrict object creation using clone()
    * */
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    /*
    * Restrict new object creation using Serialization
    * */
    protected Object readResolve() {
        return INSTANCE;
    }

    public static void info(String msg) {
        log(1, msg);
    }


    public static void debug(String msg) {
        log(2, msg);
    }


    public static void error(String msg) {
        log(3, msg);
    }

    private static void log(int level, String msg) {
        LOG_MANAGER.logMessage(level, msg);
        LOG_SUBJECT.notifyAllObservers(level, msg);
    }

}
