package org.tfoc;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The class containing the solution to this exercise
 */
@Slf4j
public class Solution {

    public static final int ROTTEN_ORANGE = 2;
    public static final int FRESH_ORANGE = 1;
    public static final int MINUTES_DEAFULT = -1;

    public int orangesRotting(int[][] grid) {
        List<Cell> cellsRottenOranges = new ArrayList<>();
        int numTotalFreshOranges = 0;
        int numTotalRottenOranges = 0;
        int minutes = 0;

        // Buscamos todas las naranjas podridas
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == ROTTEN_ORANGE)
                    cellsRottenOranges.add(new Cell(column, row));

                if (grid[row][column] == FRESH_ORANGE)
                    numTotalFreshOranges++;
            }
        }

        while (!cellsRottenOranges.isEmpty()) {
            cellsRottenOranges = calculateNextMinuteRottenOranges(grid, cellsRottenOranges);
            numTotalRottenOranges = numTotalRottenOranges + cellsRottenOranges.size();
            if (!cellsRottenOranges.isEmpty())
                minutes++;
        }
        return numTotalRottenOranges == numTotalFreshOranges
                ? minutes : MINUTES_DEAFULT;
    }

    private List<Cell> calculateNextMinuteRottenOranges(int[][] grid, List<Cell> cellsRottenOranges) {

        List<Cell> numRottenOranges = new ArrayList<>();

        for (Cell cell : cellsRottenOranges) {
            calculate(grid, Cell.getRightCell(grid[cell.row()].length, cell), numRottenOranges);
            calculate(grid, Cell.getLeftCell(cell), numRottenOranges);
            calculate(grid, Cell.getUpCell(cell), numRottenOranges);
            calculate(grid, Cell.getDownCell(grid.length, cell), numRottenOranges);
        }
        return numRottenOranges;
    }

    private void calculate(int[][] grid, Cell cell, List<Cell> numRottenOranges) {
        if (isCellWithFreshOrange(grid, cell)) {
            numRottenOranges.add(cell);
            setCellWithRottenOrange(grid, cell);
        }
    }

    private boolean isCellWithFreshOrange(int[][] grid, Cell cell) {
        return Objects.nonNull(cell) && FRESH_ORANGE == grid[cell.row()][cell.column()];
    }

    private void setCellWithRottenOrange(int[][] grid, Cell cell) {
        if (Objects.nonNull(cell))
            grid[cell.row()][cell.column()] = ROTTEN_ORANGE;
    }
}
