package Exercise1;

public class LoggerTest {
    public static void main(String[] args) {
        
        Logger logger1 = Logger.getInstance();
        logger1.log("First log message");

        Logger logger2 = Logger.getInstance();
        logger2.log("Second log message");
        
        System.out.println("Are logger1 and logger2 the same instance? " + (logger1 == logger2));
        
        Runnable runnable = () -> {
            Logger threadLogger = Logger.getInstance();
            threadLogger.log("Log message from " + Thread.currentThread().getName());
        };
        
        Thread thread1 = new Thread(runnable, "Thread-1");
        Thread thread2 = new Thread(runnable, "Thread-2");
        
        thread1.start();
        thread2.start();
    }
}