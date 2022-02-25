public class TwoDArrays {

    public static int maxValue(int[][] arr) {
        int highest = arr[0][0];
        for (int a = 0; a < arr.length; a++) {
            for (int b = 0; b < arr[a].length; b++) {
                if (arr[a][b] > highest) {
                    highest = arr[a][b];
                }
            }
        }
        return highest;
    }

    public static int sumAll(int[][] arr) {
        int count = 0;
        for (int a = 0; a < arr.length; a++) {
            for (int b = 0; b < arr[a].length; b++) {
                    count += arr[a][b];
            }
        }
        return count;
    }

    public static int[][] squareArray(int num) {
        int[][] arr = new int[num][num];
        for (int a = 1; a <= arr.length; a++) {
            for (int b = arr[0].length - 1; b >= a - 1; b--) {
                arr[a - 1][b] = 0; // Not 0, need to put some more math.
            }
        }
        return arr;
    }
}
