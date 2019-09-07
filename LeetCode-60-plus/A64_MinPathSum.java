public class A64_MinPathSum {

    public static int minPathSum(int[][] grid) {
        int rowCt = grid.length;
        int colCt = grid[0].length;

        //populate top row
        for(int colIt = 1; colIt < colCt; colIt++){
            grid[0][colIt] += grid[0][colIt - 1];
        }

        //populate left col
        for(int rowIt = 1; rowIt < rowCt; rowIt++){
            grid[rowIt][0] += grid[rowIt - 1][0];
        }

        //populate rest
        for(int rowIt = 1; rowIt < rowCt; rowIt++){
            for(int colIt = 1; colIt < colCt; colIt++){

                int pathAbove = grid[rowIt - 1][colIt];
                int pathLeft = grid[rowIt][colIt - 1];

                grid[rowIt][colIt] +=  pathAbove <  pathLeft ? pathAbove : pathLeft;
            }
        }

        return grid[rowCt - 1][colCt - 1];
    }

    public static void test(){
        int[][] myGrid = {{1,3,1},
                          {1,5,1},
                          {4,2,1}};
        print(myGrid);
        minPathSum(myGrid);
        print(myGrid);
    }

    public static void print(int[][] obstacleGrid){
        for(int[] row : obstacleGrid){
            for(int col : row){
                System.out.printf("%d ", col);
            }
            System.out.println();
        }
        System.out.println();
    }
}