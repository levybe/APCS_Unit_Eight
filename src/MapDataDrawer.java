import java.util.*;
import java.io.*;
import java.awt.*;

public class MapDataDrawer
{

    private int[][] grid;

    public MapDataDrawer(String filename, int rows, int cols) throws FileNotFoundException {
        // initialize grid
        grid = new int[rows][cols];
        Scanner scan = new Scanner(new File(filename));
        //read the data from the file into the grid
        for (int a = 0; a < rows; a++) {
            for (int b = 0; b < cols; b++) {
                grid[a][b] = scan.nextInt();
            }
        }
    }

    /**
     * @return the min value in the entire grid
     */
    public int findMinValue() {
        int min = grid[0][0];
        for (int a = 0; a < grid.length; a++) {
            for (int b = 0; b < grid[0].length; b++) {
                if (grid[a][b] < min) {
                    min = grid[a][b];
                }
            }
        }
        return min;
    }
    /**
     * @return the max value in the entire grid
     */
    public int findMaxValue() {
        int max = grid[0][0];
        for (int a = 0; a < grid.length; a++) {
            for (int b = 0; b < grid[0].length; b++) {
                if (grid[a][b] > max) {
                    max = grid[a][b];
                }
            }
        }
        return max;
    }

    /**
     * @param col the column of the grid to check
     * @return the index of the row with the lowest value in the given col for the grid
     */
    public  int indexOfMinInCol(int col){
        int lowest = grid[0][col];
        for (int a = 1; a < grid.length; a++) {
            if (grid[a][col] < lowest) {
                lowest = grid[a][col];
            }
        }
        return lowest;
    }

    /**
     * Draws the grid using the given Graphics object.
     * Colors should be grayscale values 0-255, scaled based on min/max values in grid
     */
    public void drawMap(Graphics g){
        int max = findMaxValue();
        int min = findMinValue();
        for (int a = 0; a < grid.length; a++) {
            for (int b = 0; b <grid[0].length; b++) {
                int color = (int) (((double) (grid[a][b] - min) / (max - min)) * 255);
                // The code above does not work, but the correct code is something similar to it.
                g.setColor(new Color(color, color, color));
                g.fillRect(b, a, 1, 1);
            }
        }
    }

    /**
     * Find a path from West-to-East starting at given row.
     * Choose a foward step out of 3 possible forward locations, using greedy method described in assignment.
     * @return the total change in elevation traveled from West-to-East
     */
    public int drawLowestElevPath(Graphics g, int row){
        g.setColor(Color.red);
        g.fillRect(0, row, 1, 1);
        int currentRow = row;
        for (int i = 0; i < grid[0].length; i++) {
            int upPathChange = 9001;
            int midPathChange = grid[currentRow][i] - grid[currentRow][i + 1];
            if (midPathChange < 0) {
                midPathChange = midPathChange * -1;
            }
            int lowPathChange = 9001;
            if (currentRow == 0) {
                lowPathChange = grid[currentRow][i] - grid[currentRow + 1][i + 1];
                if (lowPathChange < 0) {
                    lowPathChange = lowPathChange * -1;
                }
            }
            else if (currentRow == grid.length - 1) {
                upPathChange = grid[currentRow][i] - grid[currentRow - 1][i + 1];
                if (upPathChange < 0) {
                    upPathChange = upPathChange * -1;
                }
            }
            else {
                upPathChange = grid[currentRow][i] - grid[currentRow - 1][i + 1];
                if (upPathChange < 0) {
                    upPathChange = upPathChange * -1;
                }
                lowPathChange = grid[currentRow][i] - grid[currentRow + 1][i + 1];
                if (lowPathChange < 0) {
                    lowPathChange = lowPathChange * -1;
                }
            }
            if (upPathChange < midPathChange && upPathChange < lowPathChange) { // If the upper change is less than all others
                // Move up
            }
            else if (midPathChange < upPathChange && midPathChange < lowPathChange) { // If the middle change is less than all others
                // Move straight
            }
            else if (lowPathChange < upPathChange && lowPathChange < midPathChange) { // If the lower change is less than all others
                // Move down
            }
            else if (midPathChange == upPathChange || midPathChange == lowPathChange) {
                // Move straight
            }
            else {
                // Flip a coin, move in whichever direction is randomly decided
            }
        }
        return -1;
    }

    /**
     * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
     */
    public int indexOfLowestElevPath(Graphics g){
        return -1;

    }


}