package ds.queue;

public class QueueArray<T> implements IQueue<T> {
    private final T[] queueArray;
    private final int sizeOfArray;
    private int enqueueIndex = -1;
    private int dequeueIndex = -1;

    public QueueArray(int sizeOfQueue){
        this.sizeOfArray = sizeOfQueue;
        this.queueArray = (T[])new Object[sizeOfQueue];
    }

    public void enqueue(T element) throws QueueException {

    }

    public T dequeue() throws QueueException {
        return null;
    }

    public int numberOfElements() {
        return 0;
    }
}
