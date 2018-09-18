package ds.common;

import java.util.HashMap;
import java.util.Map;

public class DSException extends Exception {
    public static final String STACK_OVERFLOW_STR = "Stack is full. You can't push more elements.";
    public static final String STACK_UNDERFLOW_STR = "Stack is empty. You can't pop more elements.";
    public static final String QUEUE_OVERFLOW_STR = "Queue is full. You can't enqueue more elements.";
    public static final String QUEUE_UNDERFLOW_STR = "Queue is empty. You can't dequeue more elements.";
    public static final String LIST_EMPTY_STR = "You can't delete item from empty list.";
    public static final String LIST_ELEMENT_NOT_FOUND_STR = "Search item doesn't exist.";

    private final static Map<DSType , String> ERROR_TYPE_MAP = populateErrorType();

    public DSException(DSType dsType){
        super(ERROR_TYPE_MAP.get(dsType));
    }

    public enum DSType{
        STACK_OVERFLOW,
        STACK_UNDERFLOW,
        QUEUE_OVERFLOW,
        QUEUE_UNDERFLOW,
        LIST_EMPTY,
        LIST_ELEMENT_NOT_FOUND
    }

    private static Map<DSType , String> populateErrorType(){
        Map<DSType , String> map = new HashMap<DSType, String>();
        map.put(DSType.STACK_OVERFLOW , STACK_OVERFLOW_STR);
        map.put(DSType.STACK_UNDERFLOW , STACK_UNDERFLOW_STR);
        map.put(DSType.QUEUE_OVERFLOW , QUEUE_OVERFLOW_STR);
        map.put(DSType.QUEUE_UNDERFLOW , QUEUE_UNDERFLOW_STR);
        map.put(DSType.LIST_EMPTY , LIST_EMPTY_STR);
        map.put(DSType.LIST_ELEMENT_NOT_FOUND , LIST_ELEMENT_NOT_FOUND_STR);
        return map;
    }
}
