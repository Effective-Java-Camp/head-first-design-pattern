package doit_doit;

public class DclSingleton {
    private volatile static DclSingleton uniqueInstance;

    private DclSingleton() {}

    public static DclSingleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (DclSingleton.class) {
                uniqueInstance = new DclSingleton();
            }
        }
        return uniqueInstance;
    }
}