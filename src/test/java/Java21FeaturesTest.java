import org.junit.jupiter.api.Test;

import java.util.SequencedSet;

import static org.assertj.core.api.Assertions.assertThat;

class Java21FeaturesTest {

    @Test
    void sequencedCollectionWhenReversedThenGetLastElementFirst() {
        Java21Features sut = new Java21Features();

        SequencedSet<String> actual = sut.sequencedCollection();

        assertThat(actual).hasSize(3);
        SequencedSet<String> reversedActual = actual.reversed();
        assertThat(reversedActual.getFirst()).isEqualTo("last");
        assertThat(reversedActual.getLast()).isEqualTo("first");
    }

    @Test
    void sequencedCollection() {
        Java21Features sut = new Java21Features();

        SequencedSet<String> actual = sut.sequencedCollection();

        assertThat(actual).hasSize(3);
        assertThat(actual.getFirst()).isEqualTo("first");
        assertThat(actual.getLast()).isEqualTo("last");
        actual.removeFirst();
        assertThat(actual.getFirst()).isEqualTo("second");
    }

}