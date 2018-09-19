package ds.list;

import ds.common.DSException;
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
        Assert.assertEquals(0 , list.getElements().size());
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
        Assert.assertEquals("first" , list.getElements().get(0));
        Assert.assertEquals("fifth" , list.getElements().get(4));
        Assert.assertEquals(true , list.findElement("third"));
    }

    @Test
    public void addFunctionalityTest(){
        IList<String> list = new SingleLinkedList<String>();
        list.add("first");
        list.add("second");
        Assert.assertEquals(2 , list.getNumberOfElements());
        list.add("third");
        Assert.assertEquals(3 , list.getNumberOfElements());
    }

    @Test
    public void addAfterBeforeFindTest(){
        IList<String> list = new SingleLinkedList<String>();
        list.add("first");
        list.add("second");
        try {
            list.addBefore("second", "third");
            Assert.assertEquals("third" , list.getElements().get(1));
            Assert.assertEquals(3 , list.getNumberOfElements());
            list.addAfter("second" , "fourth");
            Assert.assertEquals(4 , list.getNumberOfElements());
            Assert.assertEquals("fourth" , list.getElements().get(3));
        }catch (DSException ex){
            Assert.fail(ex.getMessage());
        }
    }

    @Test
    public void addAfterBeforeExceptionTest(){
        IList<String> list = new SingleLinkedList<String>();
        list.add("first");
        list.add("second");
        try{
            list.addAfter("third" , "fourth");
        }catch (DSException ex){
            Assert.assertEquals(DSException.LIST_ELEMENT_NOT_FOUND_STR , ex.getMessage());
        }

        try{
            list.addBefore("third" , "fourth");
        }catch (DSException ex){
            Assert.assertEquals(DSException.LIST_ELEMENT_NOT_FOUND_STR , ex.getMessage());
        }
    }

    @Test
    public void findElementInSingleLinkedListTest(){
        IList<String> list = new SingleLinkedList<String>();
        list.add("first");
        list.add("second");

        Assert.assertEquals(true , list.findElement("first"));
        Assert.assertEquals(false , list.findElement("fourth"));
    }
}
