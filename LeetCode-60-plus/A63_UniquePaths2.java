public class A63_UniquePaths2{

    //DP problem
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int rowCount = obstacleGrid[0].length;
        int colCount = obstacleGrid.length;

        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Number of ways of reaching the starting cell = 1.
        obstacleGrid[0][0] = 1;

        // Filling the values for the first column
        for (int i = 1; i < rowCount; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        // Filling the values for the first row
        for (int i = 1; i < colCount; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        return obstacleGrid[rowCount][colCount];
    }

    public static void test(){
        int[][] obstacleGrid = {{0,0,0,0},
                                {0,0,0,0},
                                {0,0,0,0},
                                {0,0,0,0}};
        print(obstacleGrid);
    }

    public static void print(int[][] obstacleGrid){
        for(int[] row : obstacleGrid){
            for(int col : row){
                System.out.printf("%d ", col);
            }
            System.out.println();
        }
    }
}