package dio.quebec.singleton;

public class HolderSingleton {
    private static class InstanceHolder {
        public static final HolderSingleton instance = new HolderSingleton();
    }
    private HolderSingleton() {
        super();
    }
    public static HolderSingleton getInstance() {
        return InstanceHolder.instance;
    }
}
