import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Stack;

public class SudokuGUI extends JFrame {
    private static final int SIZE = 9;
    private static final int SUBGRID = 3;
    private static final int EMPTY = 0;

    private int[][] board;
    private final Stack<int[][]> history;
    private final JTextField[][] cells;
    private boolean isGameActive;

    public SudokuGUI() {
        board = new int[SIZE][SIZE];
        history = new Stack<>();
        cells = new JTextField[SIZE][SIZE];
        isGameActive = false;

        initializeBoard();
        initializeGUI();
    }

    private void initializeBoard() {
        fillDiagonalSubgrids();
        fillRemaining(0, SUBGRID);
        removeDigits(); // This makes the puzzle solvable by the user
    }

    private void fillDiagonalSubgrids() {
        for (int i = 0; i < SIZE; i += SUBGRID) {
            fillSubgrid(i, i);
        }
    }

    private void fillSubgrid(int row, int col) {
        Random random = new Random();
        boolean[] used = new boolean[SIZE + 1];

        for (int r = 0; r < SUBGRID; r++) {
            for (int c = 0; c < SUBGRID; c++) {
                int num;
                do {
                    num = random.nextInt(SIZE) + 1;
                } while (used[num]);
                used[num] = true;
                board[row + r][col + c] = num;
            }
        }
    }

    private boolean fillRemaining(int row, int col) {
        if (col >= SIZE && row < SIZE - 1) {
            row++;
            col = 0;
        }
        if (row >= SIZE && col >= SIZE) {
            return true;
        }

        if (row < SUBGRID) {
            if (col < SUBGRID) {
                col = SUBGRID;
            }
        } else if (row < SIZE - SUBGRID) {
            if (col == (row / SUBGRID) * SUBGRID) {
                col += SUBGRID;
            }
        } else {
            if (col == SIZE - SUBGRID) {
                row++;
                col = 0;
                if (row >= SIZE) {
                    return true;
                }
            }
        }

        for (int num = 1; num <= SIZE; num++) {
            if (isValidMove(num, row, col)) {
                board[row][col] = num;
                if (fillRemaining(row, col + 1)) {
                    return true;
                }
                board[row][col] = EMPTY;
            }
        }

        return false;
    }

    private void removeDigits() {
        Random random = new Random();
        int count = 40; // Number of digits to remove to create the puzzle

        while (count != 0) {
            int cellId = random.nextInt(SIZE * SIZE);
            int row = cellId / SIZE;
            int col = cellId % SIZE;

            if (board[row][col] != EMPTY) {
                board[row][col] = EMPTY;
                count--;
            }
        }
    }

    private void initializeGUI() {
        setTitle("Sudoku");
        setLayout(new BorderLayout());
        JPanel boardPanel = new JPanel(new GridLayout(SIZE, SIZE));

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                cells[row][col] = new JTextField();
                cells[row][col].setHorizontalAlignment(JTextField.CENTER);
                if (board[row][col] != EMPTY) {
                    cells[row][col].setText(String.valueOf(board[row][col]));
                    cells[row][col].setEditable(false);
                    cells[row][col].setBackground(Color.LIGHT_GRAY);
                } else {
                    cells[row][col].setText("");
                }
                boardPanel.add(cells[row][col]);
            }
        }

        JPanel controlPanel = new JPanel();
        JButton undoButton = new JButton("Undo");
        JButton solveButton = new JButton("Solve");
        JButton newGameButton = new JButton("New Game");
        JButton endGameButton = new JButton("End Game");

        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                undo();
                updateBoard();
            }
        });

        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (solveSudoku()) {
                    updateBoard();
                    JOptionPane.showMessageDialog(null, "Sudoku Solved!");
                    endGame();
                } else {
                    JOptionPane.showMessageDialog(null, "Unsolvable Sudoku!");
                }
            }
        });

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        endGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endGame();
            }
        });

        controlPanel.add(undoButton);
        controlPanel.add(solveButton);
        controlPanel.add(newGameButton);
        controlPanel.add(endGameButton);

        add(boardPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private boolean isValidMove(int num, int row, int col) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        int subRow = row - row % SUBGRID;
        int subCol = col - col % SUBGRID;
        for (int i = 0; i < SUBGRID; i++) {
            for (int j = 0; j < SUBGRID; j++) {
                if (board[subRow + i][subCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean solveSudoku() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) {
                    for (int num = 1; num <= SIZE; num++) {
                        if (isValidMove(num, row, col)) {
                            board[row][col] = num;
                            if (solveSudoku()) {
                                return true;
                            } else {
                                board[row][col] = EMPTY;
                            }
                        }
                    }
                    return false; // No valid number found, backtrack
                }
            }
        }
        return true; // Solved
    }

    private void saveState() {
        int[][] copy = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            copy[i] = board[i].clone();
        }
        history.push(copy);
    }

    private void undo() {
        if (!history.isEmpty()) {
            board = history.pop();
        } else {
            JOptionPane.showMessageDialog(null, "No more moves to undo!");
        }
    }

    private void updateBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] != EMPTY) {
                    cells[row][col].setText(String.valueOf(board[row][col]));
                    cells[row][col].setEditable(false);
                } else {
                    cells[row][col].setText("");
                    cells[row][col].setEditable(true);
                }
            }
        }
    }

    public void startGame() {
        initializeBoard();
        history.clear();
        isGameActive = true;
        updateBoard();
        JOptionPane.showMessageDialog(null, "New game started!");
    }

    public void endGame() {
        isGameActive = false;
        JOptionPane.showMessageDialog(null, "Game ended.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SudokuGUI();
            }
        });
    }
}
