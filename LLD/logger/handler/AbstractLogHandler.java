package LLD.logger.handler;

public abstract class AbstractLogHandler {
    private Integer LOG_LEVEL;
    private AbstractLogHandler nextLogger;

    protected void setLogLevel(Integer level) {
        this.LOG_LEVEL  = level;
    }

    public void setNextLogger(AbstractLogHandler logger) {
        this.nextLogger = logger;
    }

    public void logMessage(Integer level, String msg) {
        if (level == LOG_LEVEL) {
            printLog(msg);
        }

        if (nextLogger != null) {
            nextLogger.logMessage(level, msg);
        }
    }

    protected abstract void printLog(String msg);
}
