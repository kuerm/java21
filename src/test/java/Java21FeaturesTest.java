import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Java21FeaturesTest {

    @Test
    void recordPatterns() {
        Java21Features sut = new Java21Features();

        String actual = sut.recordPatterns();

        assertThat(actual).isEqualTo("""
                Fish details! Name: FishName[value=Salmon], Size: 30.5, Age: 3, Is Yummy? YUMMY
                Bird details! Name: Eagle, Is Flying: true
                """);
    }

}