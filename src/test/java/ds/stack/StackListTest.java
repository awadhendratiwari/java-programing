package ds.stack;

import ds.common.DSException;
import org.junit.Assert;
import org.junit.Test;

public class StackListTest {
    @Test
    public void underflowStackTest(){
        StackList<String> stackList = new StackList<String>();
        try{
            stackList.pop();
        }catch (DSException ex){
            Assert.assertEquals(DSException.STACK_UNDERFLOW_STR , ex.getMessage());
        }
    }

    @Test
    public void emptyStackSizeTest(){
        StackList<String> stackList = new StackList<String>();
        Assert.assertEquals(0 , stackList.numberOfElementsInStack());
    }

    @Test
    public void pullPushSizeStackTest(){
        StackList<String> stackList = new StackList<String>();
        try{
            stackList.push("first");
            stackList.push("second");
            Assert.assertEquals(2 , stackList.numberOfElementsInStack());
            Assert.assertEquals("second" , stackList.pop());
            Assert.assertEquals(1 , stackList.numberOfElementsInStack());
        }catch (DSException exception){
            System.out.println(exception.getMessage());
        }
    }
}
