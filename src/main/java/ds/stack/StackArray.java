package ds.stack;

public class StackArray<T> implements IStack<T> {
    private final T[] stackArray;
    private final int sizeOfStack;
    private int top = -1;

    public StackArray(int sizeOfStack){
        this.sizeOfStack = sizeOfStack;
        this.stackArray = (T [])new Object[sizeOfStack];
    }

    public int numberOfElementsInStack() {
        return (this.top + 1);
    }

    public void push(T element) throws StackException{
        if((this.top + 1) < this.sizeOfStack){
            this.top++;
            this.stackArray[this.top] = element;
        }else{
            throw new StackException(StackException.StackExceptionType.STACK_OVERFLOW);
        }
    }

    public T pop() throws StackException {
        if(this.top == -1){
            throw new StackException(StackException.StackExceptionType.STACK_UNDERFLOW);
        }
        this.top --;
        return this.stackArray[this.top + 1];
    }
}
