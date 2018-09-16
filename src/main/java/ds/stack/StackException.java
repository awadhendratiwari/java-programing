package ds.stack;

public class StackException extends Exception {
    public static final String STACK_OVERFLOW_STR = "Stack is full. You can't push more elements.";
    public static final String STACK_UNDERFLOW_STR = "Stack is empty. You can't pop more elements.";

    enum StackExceptionType{
        STACK_OVERFLOW,
        STACK_UNDERFLOW
    }

    public StackException(StackExceptionType stackExceptionType){
        super(getExceptionString(stackExceptionType));
    }

    private static String getExceptionString(StackExceptionType stackExceptionType){
        String message;
        if(stackExceptionType == StackExceptionType.STACK_OVERFLOW){
            message = STACK_OVERFLOW_STR;
        }else{
            message = STACK_UNDERFLOW_STR;
        }

        return message;
    }
}
