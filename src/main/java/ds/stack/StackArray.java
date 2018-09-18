package ds.stack;

import ds.common.DSException;

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

    public void push(T element) throws DSException{
        if((this.top + 1) < this.sizeOfStack){
            this.top++;
            this.stackArray[this.top] = element;
        }else{
            throw new DSException(DSException.DSType.STACK_OVERFLOW);
        }
    }

    public T pop() throws DSException {
        if(this.top == -1){
            throw new DSException(DSException.DSType.STACK_UNDERFLOW);
        }
        this.top --;
        return this.stackArray[this.top + 1];
    }
}
