import java.util.Objects;

/**
 * Created by 123 on 08.10.2016.
 */
public class MyLinkedList {
    private class Node {
        Object obj;
        Node next;
        Node prev;

        @Override
        public String toString() {
            return "{" +
                    obj +
                    '}';
        }
    }

    protected Node head;
    protected Node tail;
    private int size;

    public int size() {
        return size;
    }

    public Object getFirst() {
        return head.obj;
    }

    public Object getLast() {
        return tail.obj;
    }

    public void addFirst(Object obj) {
        if (head == null) {
            Node node = new Node();
            node.obj = obj;
            head = node;
            tail = node;
            size++;
        } else {
            //это новый элемент
            Node node = new Node();
            node.obj = obj;
            head.prev = node; //Присвоить ссылку на новый узел в currentHead.prev
            node.next = head; //Присвоить ссылку на существующий узел в node.next
            head = node; //Присвоить ссылку на новый узел в head
            size++; //Увеличить size на единицу
        }
    }


}
