import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Java21FeaturesTest {

    private static Stream<Arguments> provideArgumentsForPlainSwitch() {
        return Stream.of(
                Arguments.of(Java21Features.Dog.of("Max"), "dog Max"),
                Arguments.of(Java21Features.Cat.of("Tom"), "cat Tom"),
                Arguments.of(Java21Features.Mouse.of("Jerry"), "mouse")
        );
    }

    private static Stream<Arguments> provideArgumentsForPlainSwitchWithDefault() {
        return Stream.of(
                Arguments.of(Java21Features.Dog.of("Max"), "dog Max"),
                Arguments.of(Java21Features.Cat.of("Tom"), "cat Tom"),
                Arguments.of(42, "int 42"),
                Arguments.of("some text dadada", "unknown")
        );
    }

    private static Stream<Arguments> provideArgumentsForPlainSwitchWithNull() {
        return Stream.of(
                Arguments.of(Java21Features.Dog.of("Max"), "dog Max"),
                Arguments.of(Java21Features.Cat.of("Tom"), "cat Tom"),
                Arguments.of(null, "null"),
                Arguments.of(42, "unknown")
        );
    }

    private static Stream<Arguments> provideArgumentsForPlainSwitchWithCondition() {
        return Stream.of(
                Arguments.of(Java21Features.Dog.of("Rex"), "Kommissar Rex"),
                Arguments.of(Java21Features.Dog.of("Max"), "dog Max"),
                Arguments.of(Java21Features.Cat.of("Tom"), "cat Tom"),
                Arguments.of(Java21Features.Mouse.of("Jerry"), "mouse")
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForPlainSwitch")
    void plainSwitch(Java21Features.Animal animal, String expected) {
        Java21Features sut = new Java21Features();

        String actual = sut.plainSwitch(animal);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForPlainSwitchWithDefault")
    void plainSwitchWithDefault(Object object, String expected) {
        Java21Features sut = new Java21Features();

        String actual = sut.plainSwitchWithDefault(object);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForPlainSwitchWithNull")
    void plainSwitchWithNull(Object object, String expected) {
        Java21Features sut = new Java21Features();

        String actual = sut.plainSwitchWithNull(object);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForPlainSwitchWithCondition")
    void plainSwitchWithCondition(Java21Features.Animal animal, String expected) {
        Java21Features sut = new Java21Features();

        String actual = sut.plainSwitchWithCondition(animal);

        assertThat(actual).isEqualTo(expected);
    }
}