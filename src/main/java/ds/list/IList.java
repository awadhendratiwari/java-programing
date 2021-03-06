package ds.list;

import ds.common.DSException;

import java.util.List;

public interface IList<T extends Comparable<T>> {
    void add(T element);
    void add(T [] elements);
    void addBefore(T elementToFind , T elementToAdd) throws DSException;
    void addAfter(T elementToFind , T elementToAdd) throws DSException;
    Node<T> getElementNode(T elementToFind);
    List<T> getElements();
    int getNumberOfElements();
    boolean findElement(T elementToFind);
    boolean deleteElement(T elementToFind);
    boolean deleteAllElements();
}
