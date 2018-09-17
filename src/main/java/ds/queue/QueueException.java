package ds.queue;

public class QueueException extends Exception {
    public static final String QUEUE_OVERFLOW_STR = "Queue is full. You can't enqueue more elements.";
    public static final String QUEUE_UNDERFLOW_STR = "Queue is empty. You can't dequeue more elements.";

    enum QueueExceptionType{
        QUEUE_OVERFLOW,
        QUEUE_UNDERFLOW
    }

    public QueueException(QueueExceptionType queueExceptionType){
        super(getMessage(queueExceptionType));
    }

    private static String getMessage(QueueExceptionType queueExceptionType){
        String message;
        if(queueExceptionType == QueueExceptionType.QUEUE_OVERFLOW){
            message = QUEUE_OVERFLOW_STR;
        }else{
            message = QUEUE_UNDERFLOW_STR;
        }
        return message;
    }
}
