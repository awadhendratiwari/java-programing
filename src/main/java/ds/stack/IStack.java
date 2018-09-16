package ds.stack;

public interface IStack<T> {
    int numberOfElementsInStack();
    void push(T element) throws StackException;
    T pop() throws StackException;
}
