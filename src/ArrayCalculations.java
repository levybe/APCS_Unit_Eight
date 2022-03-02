public class ArrayCalculations {

    public static int rowSum(int[][] arr, int row) {
        int total = 0;

        if (arr.length - 1 >= row && row >= 0) {
            for (int num : arr[row]) {
                total += num;
            }
            return total;
        }
        else {
            return -1;
        }
    }

    public static int columnSum(int[][] arr, int col) {
        int total = 0;

        if (arr[0].length - 1 >= col && col >= 0) {
            for (int i = 0; i < arr.length; i++) {
                total += arr[i][col];
            }
            return total;
        }
        else {
            return -1;
        }
    }

    public static int diagonalSum(int[][] arr, int direction) {
        int total = 0;

        if (direction == 0) { // If the direction is DOWN
            for (int a = 0; a < arr.length; a++) {
                total += arr[a][a];
            }
        }
        else if (direction == 1) { // If the direction is UP
            for (int a = arr.length - 1; a >= 0; a--) {
                total += arr[a][(arr.length - 1) - a];
            }
        }
        else { // If an invalid direction is inputted
            return -1;
        }
        return total;
    }
}
