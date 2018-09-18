package ds.stack;

import ds.common.DSException;

public class StackList<T> implements IStack<T> {
    private static class Node<T>{
        private T element;
        private Node address;
    }

    private int size = -1;
    private Node<T> top;

    public int numberOfElementsInStack() {
        return (this.size + 1);
    }

    public void push(T element) throws DSException {
        Node<T> node = this.createNode(element);
        if(this.top == null){
            this.top = node;
        }else{
            node.address = this.top;
            this.top = node;
        }
        this.size++;
    }

    public T pop() throws DSException {
        if(this.top == null){
            throw new DSException(DSException.DSType.STACK_UNDERFLOW);
        }

        T element = this.top.element;
        this.top = this.top.address;
        this.size--;
        return element;
    }

    private Node<T> createNode(T element){
        Node<T> node = new Node<T>();
        node.element = element;
        return node;
    }
}
