package ds.queue;

import ds.common.DSException;

public class QueueArray<T> implements IQueue<T> {
    private final T[] queueArray;
    private final int sizeOfArray;
    private int rear = -1;
    private int front = -1;
    private int numberOfElements = 0;

    public QueueArray(int sizeOfQueue){
        this.sizeOfArray = sizeOfQueue;
        this.queueArray = (T[])new Object[sizeOfQueue];
    }

    public void enqueue(T element) throws DSException {
        if(!this.isQueueFull())
            throw new DSException(DSException.DSType.QUEUE_OVERFLOW);
        if((this.front + 1) < this.sizeOfArray){
            this.front++;
        }else{
            this.front = 0;
        }
        this.queueArray[this.front] = element;
        this.numberOfElements++;
    }

    public T dequeue() throws DSException {
        if(this.numberOfElements() == 0)
            throw new DSException(DSException.DSType.QUEUE_UNDERFLOW);
        if(this.rear + 1 < this.sizeOfArray){
            this.rear++;
        }else{
            this.rear = 0;
        }
        this.numberOfElements--;
        return this.queueArray[this.rear];
    }

    public int numberOfElements() {
        return this.numberOfElements;
    }

    private boolean isQueueFull(){
        return (this.front + 1) - (this.rear + 1) < this.sizeOfArray;
    }
}
