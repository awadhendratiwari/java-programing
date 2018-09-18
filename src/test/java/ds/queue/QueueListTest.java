package ds.queue;

import ds.common.DSException;
import org.junit.Assert;
import org.junit.Test;

public class QueueListTest {
    @Test
    public void underflowQueueTest(){
        IQueue<String> queue = new QueueList<String>();
        try {
            queue.dequeue();
        }catch (DSException qe){
            Assert.assertEquals(DSException.QUEUE_UNDERFLOW_STR , qe.getMessage());
        }
    }

    @Test
    public void queueSizeTest(){
        IQueue<String> queue = new QueueList<String>();
        Assert.assertEquals(0 , queue.numberOfElements());
        try{
            queue.enqueue("first");
            queue.enqueue("second");
            Assert.assertEquals(2 , queue.numberOfElements());
            queue.dequeue();
            Assert.assertEquals(1 , queue.numberOfElements());
        }catch (DSException qe){
            Assert.fail(qe.getMessage());
        }
    }

    @Test
    public void queueFunctionalityTest(){
        IQueue<String> queue = new QueueList<String>();
        try{
            queue.enqueue("first");
            queue.enqueue("second");
            Assert.assertEquals("first" , queue.dequeue());
            Assert.assertEquals("second" , queue.dequeue());
        }catch (DSException qe){
            Assert.fail(qe.getMessage());
        }
    }
}
