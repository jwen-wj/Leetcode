package pinduoduo;

/**
 * @description:
 * @author: jwen
 * @date: 2022/10/7
 */

public class SafeDoubleCheck {
    private volatile static Singleton singleton;
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (SafeDoubleCheck.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }
}

class Singleton {
    Singleton(){}
}
