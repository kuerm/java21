import org.junit.jupiter.api.Test;

import java.util.SequencedSet;

import static org.assertj.core.api.Assertions.assertThat;

class Java21FeaturesTest {

    @Test
    void sequencedCollection() {
        Java21Features sut = new Java21Features();

        SequencedSet<String> actual = sut.sequencedCollection();

        assertThat(actual).hasSize(2);
    }

}