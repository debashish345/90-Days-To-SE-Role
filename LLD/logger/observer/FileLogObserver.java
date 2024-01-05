package LLD.logger.observer;

public class FileLogObserver implements LogObserver{
    @Override
    public void log(String log) {
        System.out.println("FILE OBSERVER " + log);
    }
}
