package org.tfoc;

public record Cell(int column, int row) {

    public static Cell getRightCell(int n, Cell actualCell) {
        if (actualCell.column + 1 < n)
            return new Cell(actualCell.column + 1, actualCell.row);
        return null;
    }

    public static Cell getLeftCell(Cell actualCell) {
        if (actualCell.column - 1 >= 0)
            return new Cell(actualCell.column - 1, actualCell.row);
        return null;
    }

    public static Cell getUpCell(Cell actualCell) {
        if (actualCell.row - 1 >= 0)
            return new Cell(actualCell.column, actualCell.row - 1);
        return null;
    }

    public static Cell getDownCell(int m, Cell actualCell) {
        if (actualCell.row + 1 < m)
            return new Cell(actualCell.column, actualCell.row + 1);
        return null;
    }
}
