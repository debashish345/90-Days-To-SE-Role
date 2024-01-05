package LLD.logger.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogSubject {
    private Map<Integer, List<LogObserver>> observers = new HashMap<>();

    public void addLogObserver(int level, LogObserver observer) {
        List<LogObserver> observerList = observers.getOrDefault(level, new ArrayList<>());
        observerList.add(observer);
        observers.put(level, observerList);
    }

    public void notifyAllObservers(int level, String msg){
        for (LogObserver obs : observers.get(level)) {
            obs.log(msg);
        }
    }
}
