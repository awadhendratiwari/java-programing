package ds.queue;

public class QueueList<T> implements IQueue<T> {
    private int numberOfElements;
    private Node<T> front , rear;

    private final class Node<T>{
        private T element;
        private Node next;
        private Node previous;
    }

    public void enqueue(T element) throws QueueException {
        Node<T> node = this.getNodeInstance(element);
        if(this.front == null){
            this.front = node;
            this.rear = node;
        }else{
            this.front.next = node;
            node.previous = this.front;
            this.front = node;
        }
        this.numberOfElements++;
    }

    public T dequeue() throws QueueException {
        if(this.rear == null){
            throw new QueueException(QueueException.QueueExceptionType.QUEUE_UNDERFLOW);
        }

        T element = this.rear.element;
        if(this.rear == this.front)
        {
            this.rear = null;
            this.front = null;
        }else{
            this.rear = this.rear.next;
            this.rear.previous = null;
        }
        this.numberOfElements--;
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
