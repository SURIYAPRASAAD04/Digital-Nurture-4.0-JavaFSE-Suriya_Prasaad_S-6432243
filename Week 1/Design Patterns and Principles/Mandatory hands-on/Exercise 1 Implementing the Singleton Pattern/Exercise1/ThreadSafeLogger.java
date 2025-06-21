package Exercise1;

public class ThreadSafeLogger {
   
    private static volatile ThreadSafeLogger instance;
    
    private ThreadSafeLogger() {
        System.out.println("ThreadSafeLogger instance created");
    }
    
    
    public static ThreadSafeLogger getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeLogger.class) {
                if (instance == null) {
                    instance = new ThreadSafeLogger();
                }
            }
        }
        return instance;
    }
    
    public void log(String message) {
        System.out.println("THREAD-SAFE LOG: " + message);
    }
}
