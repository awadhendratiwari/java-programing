package ds.list;

public final class Node<T extends Comparable<T>>{
    private T element;
    private Node<T> next;
    private Node<T> previous;

    private Node(){    }

    public T getElement(){ return this.element; }
    public void setElement(T element){ this.element = element; }

    public Node getNext(){ return this.next; }
    public void setNext(Node<T> next){ this.next = next; }

    public Node getPrevious(){ return this.previous; }
    public void setPrevious(Node<T> previous){ this.previous = previous; }

    static <T extends Comparable<T>> Node<T> getInstance(T element){
        Node<T> node = new Node<T>();
        node.setElement(element);
        return node;
    }

    @Override
    public boolean equals(Object object){
        T element = (T)object;
        return this.element.compareTo(element) == 0;
    }
}
