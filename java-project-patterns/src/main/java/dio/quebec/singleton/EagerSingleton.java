package dio.quebec.singleton;

public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();;
    private EagerSingleton() { super(); }
    public static EagerSingleton getInstance() { return instance; }
}
