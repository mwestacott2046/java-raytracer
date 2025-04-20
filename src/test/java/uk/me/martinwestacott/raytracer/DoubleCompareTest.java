package uk.me.martinwestacott.raytracer;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleCompareTest {

    @ParameterizedTest
    @MethodSource("equalsTestSource")
    public void testEquals(double a, double b, boolean expected) {
        assertEquals(expected, DoubleCompare.equal(a, b));
    }


    public static Stream<Arguments> equalsTestSource() {
        return Stream.of(
                Arguments.of(1.0, 2.0, false),
                Arguments.of(0.1234, 0.1234, true),
                Arguments.of(0.12345, 0.12345, true),
                Arguments.of(0.12345, 0.123456, true),
                Arguments.of(-0.12345, -0.123456, true),
                Arguments.of(-0.1234, -0.123456, false)
        );
    }
}