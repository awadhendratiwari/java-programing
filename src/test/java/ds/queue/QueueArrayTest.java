package ds.queue;

import ds.common.DSException;
import org.junit.Assert;
import org.junit.Test;

public class QueueArrayTest {
    @Test
    public void underflowQueueTest(){
        IQueue<String> queue = new QueueArray<String>(5);
        try{
            queue.dequeue();
        }catch (DSException ex){
            Assert.assertEquals(DSException.QUEUE_UNDERFLOW_STR , ex.getMessage());
        }
    }

    @Test
    public void overflowQueueTest(){
        IQueue<String> queue = new QueueArray<String>(2);
        try{
            queue.enqueue("first");
            queue.enqueue("second");
            queue.enqueue("third");
        }catch (DSException qe){
            Assert.assertEquals(DSException.QUEUE_OVERFLOW_STR , qe.getMessage());
        }
    }

    @Test
    public void queueElementsZeroTest(){
        IQueue<String> queue = new QueueArray<String>(3);
        Assert.assertEquals(0 , queue.numberOfElements());
        try{
            queue.enqueue("first");
            queue.enqueue("second");
            queue.enqueue("third");
            Assert.assertEquals(3 , queue.numberOfElements());
            queue.dequeue();
            queue.dequeue();
            Assert.assertEquals(1 , queue.numberOfElements());
            queue.enqueue("first");
            Assert.assertEquals(2 , queue.numberOfElements());
        }catch (DSException qe){
            Assert.fail(qe.getMessage());
        }
    }

    @Test
    public void queueFunctionalityTest(){
        IQueue<String> queue = new QueueArray<String>(3);
        try{
            queue.enqueue("first");
            queue.enqueue("second");
            queue.enqueue("third");
            Assert.assertEquals("first" , queue.dequeue());
            queue.enqueue("first");
            Assert.assertEquals("second" , queue.dequeue());
            Assert.assertEquals("third" , queue.dequeue());
            queue.enqueue("second");
            Assert.assertEquals("first" , queue.dequeue());
            Assert.assertEquals("second" , queue.dequeue());
        }catch (DSException qe){
            Assert.fail(qe.getMessage());
        }
    }
}
