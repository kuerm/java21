import java.util.LinkedHashSet;
import java.util.SequencedSet;

public class Java21Features {

    public SequencedSet<String> sequencedCollection() {
        SequencedSet<String> strings = new LinkedHashSet<>();

        strings.add("first");

        strings.add("second");

        return strings;
    }
}