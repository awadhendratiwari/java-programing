package ds.list;

import ds.common.DSException;

public class SingleLinkedList<T extends Comparable<T>>
        implements IList<T> {
    private Node<T> head , tail;
    private Node<T> current , previous;
    private int numberOfElements = 0;

    public void add(T element) {
        Node<T> node = Node.getInstance(element);
        if(this.head == null){
            this.head = this.tail = node;
        }else{
            this.tail.setNext(node);
            this.tail = node;
        }
        this.numberOfElements++;
    }

    public void add(T [] elements) {
        for(T current : elements){
            this.add(current);
        }
    }

    public void addBefore(T elementToFind, T elementToAdd) throws DSException {
        boolean result = this.findElement(elementToFind);
        if(result){
            Node<T> node = Node.getInstance(elementToAdd);
            if(this.current == this.head){
                node.setNext(this.head);
                this.head = node;
            }else {
                node.setNext(this.current);
                this.previous.setNext(node);
            }
        }
        this.disposeTempNode();
        if(!result){
            throw new DSException(DSException.DSType.LIST_ELEMENT_NOT_FOUND);
        }
    }

    public void addAfter(T elementToFind, T elementToAdd) throws DSException {
        boolean result = this.findElement(elementToFind);
        if(result){
            Node<T> node = Node.getInstance(elementToAdd);
            if(this.current == this.tail){
                this.current.setNext(node);
                this.tail = this.current;
            }else{
                node.setNext(this.current.getNext());
                this.current.setNext(node);
            }
        }
        this.disposeTempNode();
        if(!result){
            throw new DSException(DSException.DSType.LIST_ELEMENT_NOT_FOUND);
        }
    }

    public Node<T> getElementNode(T elementToFind) {
        Node<T> node = null;
        boolean result = this.findElement(elementToFind);
        if(result){
            node = this.current;
        }
        this.disposeTempNode();
        return node;
    }

    public T[] getElements() {
        this.current = this.head;
        final T [] tempArray = (T[]) new Object[this.numberOfElements];
        int index = -1;
        while (this.current != null){
            index++;
            tempArray[index] = this.current.getElement();
            this.current = this.current.getNext();
        }
        this.disposeTempNode();
        return tempArray;
    }

    public int getNumberOfElements(){
        return this.numberOfElements;
    }

    public boolean findElement(T elementToFind) {
        boolean result =false;
        this.current = this.head;
        this.previous = null;
        while(this.current != null){
            if(this.current.equals(elementToFind)){
                result = true;
                break;
            }
            this.previous = this.current;
            this.current = this.current.getNext();
        }
        return result;
    }

    public boolean deleteElement(T elementToFind) {
        boolean result = this.findElement(elementToFind);
        if(result){
            if(this.current == this.head){
                this.head = this.head.getNext();
            }else if(this.current.getNext() == null){
                this.previous.setNext(null);
            }else{
                this.previous.setNext(this.current.getNext());
            }
            this.numberOfElements--;
        }
        this.disposeTempNode();
        return result;
    }

    public boolean deleteAllElements() {
        boolean result = false;
        if(this.numberOfElements > 0){
            this.numberOfElements = 0;
            this.head = null;
        }
        return result;
    }

    private void disposeTempNode(){
        this.current = this.previous = null;
    }
}
