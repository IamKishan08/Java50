package Sudoku;

public class SudokuBoard {
    public static final int SIZE = 9;
    //private static final int SIZE = 9;
    private int[][] board;

    public SudokuBoard() {
        board = new int[SIZE][SIZE];
    }

    public SudokuBoard(int[][] board) {
        this.board = board;
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public void setValue(int row, int col, int value) {
        board[row][col] = value;
    }

    public boolean isCellEmpty(int row, int col) {
        return board[row][col] == 0;
    }

    public boolean isValid(int row, int col, int value) {
        // Check row
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }

        // Check 3x3 box
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
