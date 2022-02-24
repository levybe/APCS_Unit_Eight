public class FourByFour {
    public static void main(String [] args) {
//code to define an initially empty int 2D array, minimum size 4x4
        int[][] list = new int[4][4];
//code to output all original values
        for (int row = 0; row < list.length; row++) {
            for (int col = 0; col < list[0].length; col++) {
                System.out.print(list[row][col] + " ");
            }
            System.out.println("");
        }

//code to change half the values to even positive numbers
        for (int row = 0; row < list.length; row++) {
            for (int col = 0; col < list[0].length / 2; col++) {
                list[row][col] = 2;
            }
        }

//and the other half to negative odd numbers
        for (int row = 0; row < list.length; row++) {
            for (int col = 3; col >= list[0].length / 2; col--) {
                list[row][col] = -1;
            }
        }

//code to output a blank line separating output sets
        System.out.println("");
//code to output all array elements
        for (int row = 0; row < list.length; row++) {
            for (int col = 0; col < list[0].length; col++) {
                System.out.print(list[row][col] + " ");
            }
            System.out.println("");
        }
    }
}

