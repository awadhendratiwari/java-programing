package ds.list;

import org.junit.Assert;
import org.junit.Test;

public final class SingleLinkedListTest {
    @Test
    public void deleteItemEmptyListTest(){
        IList<String> list = new SingleLinkedList<String>();
        Assert.assertEquals(false , list.deleteElement("fake element"));
    }

    @Test
    public void deleteAllItemEmptyListTest(){
        IList<String> list = new SingleLinkedList<String>();
        Assert.assertEquals(false , list.deleteAllElements());
    }

    @Test
    public void numberOfElementsInEmptyListTest(){
        IList<String> list = new SingleLinkedList<String>();
        Assert.assertEquals(0 , list.getNumberOfElements());
    }

    @Test
    public void findElementInEmptyListTest(){
        IList<String> list = new SingleLinkedList<String>();
        Assert.assertEquals(false , list.findElement("fake element"));
    }

    @Test
    public void getNodeInEmptyListTest(){
        IList<String> list = new SingleLinkedList<String>();
        Assert.assertNull(list.getElementNode("fake element"));
    }

    @Test
    public void getElementsInEmptyListTest(){
        IList<String> list = new SingleLinkedList<String>();
        Assert.assertEquals(0 , list.getElements().length);
    }

    @Test
    public void addAllElementsInListTest(){
        IList<String> list = new SingleLinkedList<String>();
        list.add(new String[]{
                "first",
                "second",
                "third",
                "fourth",
                "fifth"
        });

        Assert.assertEquals(5 , list.getNumberOfElements());
        Assert.assertEquals("first" , list.getElements()[0]);
        Assert.assertEquals("fifth" , list.getElements()[4]);
        Assert.assertEquals(true , list.findElement("third"));
    }
}
