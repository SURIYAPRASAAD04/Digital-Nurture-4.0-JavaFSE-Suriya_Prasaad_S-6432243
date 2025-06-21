package Exercise1;

public class Logger {
   
    private static Logger instance;
    
   
    private Logger() {
       
        System.out.println("Logger instance created");
    }
    
 
    public static Logger getInstance() {
       
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    
   
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
    
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton instance cannot be cloned");
    }
    
    
    protected Object readResolve() {
        return instance;
    }
}
