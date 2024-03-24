package org.tfoc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Slf4j
class SolutionTest {

    private static Stream<Arguments> provideGrid() {
        return Stream.of(
                Arguments.of(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}, 4),
                Arguments.of(new int[][]{{0, 2}}, 0),
                Arguments.of(new int[][]{{1, 1, 1}, {1, 2, 1}, {1, 1, 1}}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("provideGrid")
    void testSolution(int[][] grid, int expected) {
        Solution solution = new Solution();

        int i = solution.orangesRotting(grid);

        Assertions.assertEquals(expected, i);
    }

}