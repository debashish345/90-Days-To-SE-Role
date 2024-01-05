package LLD.logger.manager;

import LLD.logger.handler.AbstractLogHandler;
import LLD.logger.handler.DebugLogHandler;
import LLD.logger.handler.ErrorLogHandler;
import LLD.logger.handler.InfoLogHandler;
import LLD.logger.observer.ConsoleLogObserver;
import LLD.logger.observer.FileLogObserver;
import LLD.logger.observer.LogObserver;
import LLD.logger.observer.LogSubject;

public class LogManager {

    public static AbstractLogHandler createLogChain(){
        AbstractLogHandler info = new InfoLogHandler(1);
        AbstractLogHandler debug = new DebugLogHandler(2);
        AbstractLogHandler error = new ErrorLogHandler(3);

        info.setNextLogger(debug);
        debug.setNextLogger(error);

        return info;
    }

    public static LogSubject createLogObserver() {
        LogSubject subject = new LogSubject();
        ConsoleLogObserver consoleLogObserver = new ConsoleLogObserver();
        subject.addLogObserver(1, consoleLogObserver);
        subject.addLogObserver(2, consoleLogObserver);
        subject.addLogObserver(3, consoleLogObserver);

        FileLogObserver fileLogObserver = new FileLogObserver();
        subject.addLogObserver(2, fileLogObserver);
        subject.addLogObserver(3, fileLogObserver);

        return subject;
    }

}
