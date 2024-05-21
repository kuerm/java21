import java.util.LinkedHashSet;
import java.util.SequencedSet;

public class Java21Features {


    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public SequencedSet<String> sequencedCollection() {
        SequencedSet<String> strings = new LinkedHashSet<>();

        strings.add("first");

        strings.add("second");

        return strings;
    }
}