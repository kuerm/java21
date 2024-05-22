import java.util.LinkedHashSet;
import java.util.Set;

public class Java21Features {

    public Set<String> sequencedCollection() {
        Set<String> strings = new LinkedHashSet<>();

        strings.add("first");

        strings.add("second");

        return strings;
    }
}