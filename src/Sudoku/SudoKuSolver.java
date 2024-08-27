package Sudoku;


class SudokuSolver {

    public boolean solve(SudokuBoard board) {
        int[][] grid = board.getBoard();

        for (int row = 0; row < SudokuBoard.SIZE; row++) {
            for (int col = 0; col < SudokuBoard.SIZE; col++) {
                if (board.isCellEmpty(row, col)) {
                    for (int num = 1; num <= 9; num++) {
                        if (board.isValid(row, col, num)) {
                            board.setValue(row, col, num);

                            if (solve(board)) {
                                return true;
                            }

                            board.setValue(row, col, 0); // Backtrack
                        }
                    }
                    return false; // No valid number found, need to backtrack
                }
            }
        }
        return true; // Puzzle solved
    }
}
