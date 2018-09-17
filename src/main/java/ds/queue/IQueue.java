package ds.queue;

public interface IQueue<T> {
    void enqueue(T element) throws QueueException;
    T dequeue() throws QueueException;
    int numberOfElements();
}
