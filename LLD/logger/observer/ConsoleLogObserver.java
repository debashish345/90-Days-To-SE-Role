package LLD.logger.observer;

public class ConsoleLogObserver implements LogObserver{
    @Override
    public void log(String log) {
        System.out.println("CONSOLE OBSERVER " + log);
    }
}
