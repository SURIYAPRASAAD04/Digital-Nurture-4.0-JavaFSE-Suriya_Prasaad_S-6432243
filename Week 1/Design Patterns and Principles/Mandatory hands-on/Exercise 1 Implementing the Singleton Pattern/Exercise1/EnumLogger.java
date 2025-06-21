package Exercise1;

public enum EnumLogger {
    
    INSTANCE;
    
    public void log(String message) {
        System.out.println("ENUM LOGGER: " + message);
    }
    
   
}
