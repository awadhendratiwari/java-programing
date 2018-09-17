package ds.queue;

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

    public void enqueue(T element) throws QueueException {
        if(!this.isQueueEmpty())
            throw new QueueException(QueueException.QueueExceptionType.QUEUE_OVERFLOW);
        this.front++;
        if((this.front + 1) < this.sizeOfArray){
            this.front++;
        }else{
            this.front = 0;
        }
        this.queueArray[this.front] = element;
        this.numberOfElements++;
    }

    public T dequeue() throws QueueException {
        if(this.front == this.rear)
            throw new QueueException(QueueException.QueueExceptionType.QUEUE_UNDERFLOW);
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

    private boolean isQueueEmpty(){
        return (this.front + 1 - this.rear + 1) < this.sizeOfArray;
    }
}
