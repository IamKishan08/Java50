import java.util.Arrays;

public class rotateby90 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

       // rotateMatrix(matrix);
        rotateMatrixAnti(matrix);


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }

    //clockwise
    private static void rotateMatrix(int[][] matrix) {
        // Transpose
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // reverse Row
        for (int i = 0; i < len; i++) {
            int start = 0;
            int end = len -1;
            while (start<end){
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }
    private static void rotateMatrixAnti(int[][] matrix) {
        // Transpose
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // reverse Row
        for (int i = 0; i < len; i++) {
            int start = 0;
            int end = len-1;
            while (start<end){
                int temp = matrix[start][i];
                matrix[start][i] = matrix[end][i];
                matrix[end][i] = temp;
                start++;
                end--;
            }
        }
    }

}
