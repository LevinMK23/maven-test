package ru.learnup.feb;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FuncTest {

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(5, 5, 10)
        );
    }

    @Test
    @DisplayName("Тест суммы двух чисел")
    void testSum() {
        Func func = new Func();
        Assertions.assertEquals(10, func.sum(1, 9));
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @MethodSource("data")
    @DisplayName("Тест суммы с параметрами")
    void testSumParams(int a, int b, int expected) {
        Func func = new Func();
        Assertions.assertEquals(expected, func.sum(a, b));
    }

}
