package LLD.logger.handler;

public class InfoLogHandler extends AbstractLogHandler {
    public InfoLogHandler() {}

    public InfoLogHandler(int logLevel) {
        this.setLogLevel(logLevel);
    }
    @Override
    protected void printLog(String msg) {
        System.out.println("INFO " + msg);
    }
}
