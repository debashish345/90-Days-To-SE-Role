package LLD.logger.handler;

public class ErrorLogHandler extends AbstractLogHandler{

    public ErrorLogHandler(int logLevel) {
        this.setLogLevel(logLevel);
    }
    @Override
    protected void printLog(String msg) {
        System.out.println("ERROR " + msg);
    }
}
