package LLD.logger.handler;

public class DebugLogHandler extends AbstractLogHandler {
    public DebugLogHandler(Integer logLevel) {
        this.setLogLevel(logLevel);
    }

    @Override
    protected void printLog(String msg) {
        System.out.println("DEBUG " + msg);
    }
}
