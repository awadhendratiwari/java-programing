package ds.list;

import ds.common.DSException;

import java.util.ArrayList;
import java.util.List;

/*
* This class represents doubly circular linked list.
* In doubly circular linked list next address of last node points to the first node
* and previous address of first node points to the next node. 
* */
public class CircularLinkedList<T extends Comparable<T>>
        implements IList<T>{

    private Node<T> head , tail;
    private Node<T> current , previous;
    private int numberOfElements = 0;

    @Override
    public void add(T element) {
        Node<T> node = Node.getInstance(element);
        if(this.head == null){
            node.setNext(node);
            node.setPrevious(node);
            this.head = this.tail = node;
        }else{
            node.setNext(this.tail.getNext());
            node.setPrevious(this.tail);
            this.head.setPrevious(node);
            this.tail.setNext(node);
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
        boolean result = this.findElement(elementToFind);
        if(!result){
            throw new DSException(DSException.DSType.LIST_ELEMENT_NOT_FOUND);
        }
        Node<T> node = Node.getInstance(elementToAdd);
        if(this.current == this.head){
            node.setNext(this.head);
            node.setPrevious(this.tail);
            this.head.setPrevious(node);
            this.tail.setNext(node);
            this.head = node;
        }else if(this.current == this.tail){
            node.setPrevious(this.tail);
            node.setNext(this.head);
            this.tail.setNext(node);
            this.head.setPrevious(node);
            this.tail = node;
        }else{
            node.setPrevious(this.current.getPrevious());
            node.setNext(this.current);
            this.current.getPrevious().setNext(node);
            this.current.setPrevious(node);
        }
        this.numberOfElements++;
        this.disposeTempNode();
    }

    @Override
    public void addAfter(T elementToFind, T elementToAdd) throws DSException {
        boolean result = this.findElement(elementToFind);
        if(!result){
            throw new DSException(DSException.DSType.LIST_ELEMENT_NOT_FOUND);
        }
        Node<T> node = Node.getInstance(elementToAdd);
        if(this.current == this.head && this.current == this.tail){
            node.setNext(this.head);
            node.setPrevious(this.head);
            this.head.setNext(node);
            this.head.setPrevious(node);
            this.tail = node;
        }else if(this.current == this.head){
            node.setPrevious(this.head);
            node.setNext(this.head.getNext());
            this.head.getNext().setPrevious(node);
            this.head.setNext(node);
        }else if(this.current == this.tail){
            node.setNext(this.head);
            node.setPrevious(this.tail);
            this.tail.setNext(node);
            this.head.setPrevious(node);
            this.tail = node;
        }else{
            node.setPrevious(this.current);
            node.setNext(this.current.getNext());
            this.current.getNext().setPrevious(node);
            this.current.setNext(node);
        }
        this.numberOfElements++;
        this.disposeTempNode();
    }

    @Override
    public Node<T> getElementNode(T elementToFind) {
        this.findElement(elementToFind);
        Node<T> temp = this.current;
        this.disposeTempNode();
        return temp;
    }

    @Override
    public List<T> getElements() {
        List<T> elements = new ArrayList<>();
        this.current = this.head;
        if(this.current != null){
            do{
                elements.add(this.current.getElement());
                this.current = this.current.getNext();
            }while(this.current != this.current.getNext());
        }
        this.disposeTempNode();
        return elements;
    }

    @Override
    public int getNumberOfElements() {
        return this.numberOfElements;
    }

    @Override
    public boolean findElement(T elementToFind) {
        boolean result = false;
        if(this.head != null){
            this.current = this.head;
            do{
                if(this.current.equals(elementToFind)){
                    result = true;
                    break;
                }
            }while (this.current.getNext() != this.current);
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
                this.tail.setNext(this.current.getNext());
                this.current.getNext().setPrevious(this.tail);
                this.head = this.current.getNext();
            }else if(this.current == this.tail){
                this.tail.getPrevious().setNext(this.head);
                this.head.setPrevious(this.tail.getPrevious());
                this.tail = this.current.getPrevious();
            }else{
                this.current.getPrevious().setNext(this.current.getNext());
                this.current.getNext().setPrevious(this.current.getPrevious());
            }
            this.numberOfElements--;
        }
        this.disposeTempNode();
        return result;
    }

    @Override
    public boolean deleteAllElements() {
        boolean result = false;
        if(this.head != null && this.tail != null){
            this.head = this.tail = null;
            result = true;
            this.numberOfElements = 0;
        }
        return result;
    }

    private void disposeTempNode(){
        this.current = this.previous = null;
    }
}
