package doit_doit;

public class SynchronizedSingleton {
    private static SynchronizedSingleton uniqueInstance = new SynchronizedSingleton();

    private SynchronizedSingleton() {
    }

    public static SynchronizedSingleton getInstance() {
        return uniqueInstance;
    }
}