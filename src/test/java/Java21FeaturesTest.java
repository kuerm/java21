import org.junit.jupiter.api.Test;

import java.util.SequencedSet;

class Java21FeaturesTest {

    @Test
    void sequencedCollection() {
        SequencedSet<String> strings = new Java21Features().sequencedCollection();

        assert strings.size() == 2;
    }

}