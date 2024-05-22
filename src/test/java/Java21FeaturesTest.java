import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class Java21FeaturesTest {

    @Test
    void sequencedCollection() {
        Java21Features sut = new Java21Features();

        Set<String> actual = sut.sequencedCollection();

        assertThat(actual).hasSize(2);
    }

}