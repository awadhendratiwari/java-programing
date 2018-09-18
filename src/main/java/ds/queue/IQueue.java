package ds.queue;

import ds.common.DSException;

public interface IQueue<T> {
    void enqueue(T element) throws DSException;
    T dequeue() throws DSException;
    int numberOfElements();
}
