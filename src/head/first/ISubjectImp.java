package head.first;

import java.util.ArrayList;

public class ISubjectImp implements ISubject {
    private ArrayList<IObserver> observers;
    private float tmp;
    private float press;
    private float hum;

    public ISubjectImp() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        int index = observers.indexOf(observer);
        if (index >= 0) observers.remove(index);
    }

    @Override
    public void notifyAllObserver() {
        for (IObserver observer : observers) {
            observer.update(tmp, press, hum);
        }
    }
}
