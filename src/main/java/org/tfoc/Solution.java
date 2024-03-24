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

    public int orangesRotting(int[][] grid) {

        List<Cell> cells = new ArrayList<>();
        int numTotalFreshOranges = 0;
        int numTotalRottenOranges = 0;

        int total = 0;

        // Buscamos todas las naranjas podridas
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == 2)
                    cells.add(new Cell(column, row));

                if (grid[row][column] == 1)
                    numTotalFreshOranges++;

            }
        }

        while (!cells.isEmpty()) {
            cells = calculateNextMinute(grid, cells);
            numTotalRottenOranges = numTotalRottenOranges + cells.size();
            if (!cells.isEmpty())
                total++;
        }


        return numTotalRottenOranges == numTotalFreshOranges
                ? total : -1;
    }

    public boolean isCellWithFreshOrange(int[][] grid, Cell cell) {
        return Objects.nonNull(cell) && grid[cell.row][cell.column] == 1;
    }

    public void setCellWithRottenOrange(int[][] grid, Cell cell) {
        grid[cell.row][cell.column] = 2;
    }

    public List<Cell> calculateNextMinute(int[][] grid, List<Cell> cellsRottenOranges) {

        List<Cell> numRottenOranges = new ArrayList<>();

        for (Cell cell : cellsRottenOranges) {

            Cell rightCell = getRightCell(grid[cell.row].length, cell);
            if (isCellWithFreshOrange(grid, rightCell)) {
                numRottenOranges.add(rightCell);
                setCellWithRottenOrange(grid, rightCell);
            }

            Cell leftCell = getLeftCell(cell);
            if (isCellWithFreshOrange(grid, leftCell)) {
                numRottenOranges.add(leftCell);
                setCellWithRottenOrange(grid, leftCell);
            }

            Cell upCell = getUpCell(cell);
            if (isCellWithFreshOrange(grid, upCell)) {
                numRottenOranges.add(upCell);
                setCellWithRottenOrange(grid, upCell);
            }

            Cell downCell = getDownCell(grid.length, cell);
            if (isCellWithFreshOrange(grid, downCell)) {
                numRottenOranges.add(downCell);
                setCellWithRottenOrange(grid, downCell);
            }

        }

        return numRottenOranges;

    }


    public Cell getRightCell(int n, Cell actualCell) {
        if (actualCell.column + 1 < n)
            return new Cell(actualCell.column + 1, actualCell.row);

        return null;
    }

    public Cell getLeftCell(Cell actualCell) {
        if (actualCell.column - 1 >= 0)
            return new Cell(actualCell.column - 1, actualCell.row);
        return null;
    }

    public Cell getUpCell(Cell actualCell) {
        if (actualCell.row - 1 >= 0)
            return new Cell(actualCell.column, actualCell.row - 1);
        return null;
    }

    public Cell getDownCell(int m, Cell actualCell) {
        if (actualCell.row + 1 < m)
            return new Cell(actualCell.column, actualCell.row + 1);
        return null;
    }

    public record Cell(int column, int row) {
    }

}
