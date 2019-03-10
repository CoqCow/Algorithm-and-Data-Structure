package head.first;

import java.util.HashMap;
import java.util.HashSet;

public class IObserverImp implements IObserver {

    private ISubject subject;

    public IObserverImp(ISubject subject) {
        this.subject = subject;
        subject.registerObserver(this);
        HashMap hashMap=new HashMap();
     }

    @Override
    public void update(float tmp, float press, float hum) {
        System.out.println("dfdsf");
    }
}
