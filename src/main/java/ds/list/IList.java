package ds.list;

public interface IList<T extends Comparable<T>> {
    void add(T element);
    void addBefore(T elementToFind , T elementToAdd);
    void addAfter(T elementToFind , T elementTAdd);
    T getElement(T elementToFind);
    T [] getElements();
    boolean deleteElement(T elementToFind);
    boolean deleteAllElements();
}
