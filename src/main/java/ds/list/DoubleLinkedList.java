package ds.list;

import ds.common.DSException;

import java.util.ArrayList;
import java.util.List;

public class DoubleLinkedList<T extends Comparable<T>>
        implements IList<T>{
    private Node<T> head , tail;
    private Node<T> current , previous;
    private int numberOfElements;

    @Override
    public void add(T element) {
        Node<T> node = Node.getInstance(element);
        if(this.head == null){
            this.head = this.tail = node;
        }else{
            this.tail.setNext(node);
            node.setPrevious(this.tail);
            this.tail = node;
        }
        this.numberOfElements++;
    }

    @Override
    public void add(T[] elements) {
         for(T element : elements){
             this.add(element);
         }
    }

    @Override
    public void addBefore(T elementToFind, T elementToAdd) throws DSException {
        if(!this.findElement(elementToFind)){
            throw new DSException(DSException.DSType.LIST_ELEMENT_NOT_FOUND);
        }
        Node<T> node = Node.getInstance(elementToAdd);
        if(this.current == this.head){
            node.setNext(this.head);
            this.head.setPrevious(node);
            this.head = node;
        }else if(this.current == this.tail){
            node.setPrevious(this.current.getPrevious());
            node.setNext(this.current);
            this.current.setPrevious(node);
        }else{
            node.setPrevious(this.current.getPrevious());
            node.setNext(this.current);
            this.current.getPrevious().setNext(node);
        }
        this.numberOfElements++;
        this.disposeTempNode();
    }

    @Override
    public void addAfter(T elementToFind, T elementToAdd) throws DSException {
        if(!this.findElement(elementToFind)){
            throw new DSException(DSException.DSType.LIST_ELEMENT_NOT_FOUND);
        }
        Node<T> node = Node.getInstance(elementToAdd);
        if(this.current != this.head && this.current != this.tail){
            node.setPrevious(this.current);
            node.setNext(this.current.getNext());
            this.current.setNext(node);
        }else{
            this.tail.setNext(node);
            node.setPrevious(this.tail);
            this.tail = node;
        }
        this.numberOfElements++;
        this.disposeTempNode();
    }

    @Override
    public Node<T> getElementNode(T elementToFind) {
        Node<T> result;
        this.findElement(elementToFind);
        result = this.current;
        this.disposeTempNode();
        return result;
    }

    @Override
    public List<T> getElements() {
        ArrayList<T> list = new ArrayList<>();
        this.current = this.head;
        while(this.current != null){
            list.add(this.current.getElement());
            this.current = this.current.getNext();
        }
        this.disposeTempNode();
        return list;
    }

    @Override
    public int getNumberOfElements() {
        return this.numberOfElements;
    }

    @Override
    public boolean findElement(T elementToFind) {
        boolean result = false;
        this.current = this.head;
        while(this.current != null){
            if(this.current.equals(elementToFind)){
                result = true;
                break;
            }
            this.current = this.current.getNext();
        }
        return result;
    }

    @Override
    public boolean deleteElement(T elementToFind) {
        boolean result = this.findElement(elementToFind);
        if(result){
            if(this.current == this.head && this.current == this.tail){
                this.head = this.tail = null;
            }else if(this.current == this.head){
                this.head = this.head.getNext();
                this.head.setPrevious(null);
            }else if(this.current == this.tail){
                this.tail = this.tail.getPrevious();
                this.tail.setNext(null);
            }else{
                this.previous.setNext(this.current.getNext());
                this.current.getNext().setPrevious(this.previous);
            }
            this.numberOfElements--;
            result = true;
        }
        this.disposeTempNode();
        return result;
    }

    @Override
    public boolean deleteAllElements() {
        boolean result = false;
        if(this.head != null) {
            this.head = this.tail = null;
            this.disposeTempNode();
            this.numberOfElements = 0;
        }
        return result;
    }

    private void disposeTempNode(){
        this.current = this.previous = null;
    }
}
