package ds.stack;

import ds.common.DSException;

public interface IStack<T> {
    int numberOfElementsInStack();
    void push(T element) throws DSException;
    T pop() throws DSException;
}
