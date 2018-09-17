package ds.queue;

public class QueueList<T> implements IQueue<T> {
    private int numberOfElements;
    private Node<T> front , rear;

    private final class Node<T>{
        private T element;
        private Node address;
    }

    public void enqueue(T element) throws QueueException {
        Node<T> node = this.getNodeInstance(element);
        if(this.front == null){
            this.front = node;
            this.rear = node;
        }else{
            node.address = this.front;
            this.front = node;
        }
        this.numberOfElements++;
    }

    public T dequeue() throws QueueException {
        if(this.rear == null){
            throw new QueueException(QueueException.QueueExceptionType.QUEUE_UNDERFLOW);
        }

        T element = this.rear.element;
        this.rear = this.rear.address;
        return element;
    }

    public int numberOfElements() {
        return this.numberOfElements;
    }

    private Node<T> getNodeInstance(T element){
        Node<T> node = new Node<T>();
        node.element = element;
        return node;
    }
}
