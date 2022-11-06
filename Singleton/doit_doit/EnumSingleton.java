package doit_doit;

public enum EnumSingleton {
    UNIQUE_INSTANCE;
    // 기타 필요한 필드
}

public class SingletonClient {
    public static void main(String[] args) {
        EnumSingleton singleton = EnumSingleton.UNIQUE_INSTANCE;
        // 여기서 사용
    }
}
