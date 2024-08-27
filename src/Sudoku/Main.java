package Sudoku;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SudokuBoard board = new SudokuBoard();

        // Example board initialization (0 means empty cells)
        int[][] initialBoard = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        board = new SudokuBoard(initialBoard);

        SudokuSolver solver = new SudokuSolver();
        if (solver.solve(board)) {
            System.out.println("Sudoku solved:");
            board.printBoard();
        } else {
            System.out.println("No solution exists.");
        }
    }
}
