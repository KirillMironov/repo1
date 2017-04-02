/**
 * Created by 123 on 16.10.2016.
 */
public interface Queue {

    void offer(Object e);

    Object poll();

    Object peek();

    int size();

}
