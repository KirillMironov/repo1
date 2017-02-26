package collections;

/**
 * Created by kmiro on 25.02.2017.
 */
public class RingBuffer {
    int head = -1;
    int tail = 0;

    private String[] buffer;

    public RingBuffer(int size) {
        buffer = new String[size];
    }

    public void write(String s) {
        if (head == tail) {
            throw new IllegalStateException();
        }

        buffer[tail] = s;

        if (head == -1) {
            head = 0;
        }

        tail++;

        if (tail > buffer.length - 1) {
            tail = 0;
        }
    }

    public String read() {
        String s = buffer[head];
        head++;
        return s;
    }

}
