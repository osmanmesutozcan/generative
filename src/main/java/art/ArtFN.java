package art;

public class ArtFN {
    public static String generate(String prefix) {
        return String.format("%s-%d", prefix, System.currentTimeMillis());
    }

    public static String generate(String prefix, String suffix) {
        return String.format("%s%s", generate(prefix), suffix);
    }
}
