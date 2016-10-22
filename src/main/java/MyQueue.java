/**
 * Created by 123 on 16.10.2016.
 */
public class MyQueue implements Queue {
    MyLinkedList list = new MyLinkedList();

    @Override
    public void offer(Object e) {
         list.addLast(e);
    }

    @Override
    public Object poll() {
        return list.remove(0);
    }

    @Override
    public Object peek() {
        return list.getFirst();
    }

    @Override
    public int size() {
        return list.size();
    }
}
