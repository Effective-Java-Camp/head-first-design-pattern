package dont_do_that;

public class Singleton {
    private static Singleton uniqueInstance;

    // 기타 인스턴스 변수

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    // 기타 메소드
}
