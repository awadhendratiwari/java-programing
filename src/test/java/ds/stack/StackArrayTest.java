package ds.stack;

import ds.common.DSException;
import org.junit.Assert;
import org.junit.Test;

public class StackArrayTest {
    @Test
    public void emptyStackOverflowTest(){
        IStack<String> stack = new StackArray<String>(0);
        try {
            stack.push("test element");
        }catch (DSException ex){
            Assert.assertEquals(DSException.STACK_OVERFLOW_STR , ex.getMessage());
        }
    }

    @Test
    public void emptyStackUnderflowTest(){
        IStack<String> stack = new StackArray<String>(0);
        try{
            stack.pop();
        }catch (DSException ex){
            Assert.assertEquals(DSException.STACK_UNDERFLOW_STR , ex.getMessage());
        }
    }

    @Test
    public void stackPullPushSizeTest(){
        IStack<String> stack = new StackArray<String>(5);
        Assert.assertEquals(0 , stack.numberOfElementsInStack());
        try {
            stack.push("first element");
            stack.push("second element");
            Assert.assertEquals(2 , stack.numberOfElementsInStack());
            stack.pop();
            Assert.assertEquals(1 , stack.numberOfElementsInStack());
            stack.pop();
            Assert.assertEquals(0 , stack.numberOfElementsInStack());
        }catch (DSException ex){
            System.out.println(ex.getMessage());
        }
    }
}
