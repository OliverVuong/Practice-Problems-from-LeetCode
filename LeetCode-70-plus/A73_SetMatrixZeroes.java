public class A73_SetMatrixZeroes{
    public static void setZeroes(int[][] matrix) {

        int height = matrix.length;
        int width = matrix[0].length;

        //check if first row or first col need to be zeroed
        boolean zeroFirstRow = false;
        boolean zeroFirstCol = false;
        for(int row = 0; row < height; row++){
            if(matrix[row][0] == 0){
                zeroFirstCol = true;
            }
        }
        for(int col = 0; col < width; col++){
            if(matrix[0][col] == 0){
                zeroFirstRow = true;
            }
        }
        
        //mark all rows and cols that need to be zeroed
        //by labeling the first entry zero
        for(int row = 1; row < height; row++){
            for(int col = 1; col < width; col++){
                if(matrix[row][col] == 0){
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        //zero out rows with a leading zero except for the first row
        for(int row = 1; row < height; row++){
            if(matrix[row][0] == 0){
                for(int col = 1; col < width; col++){
                    matrix[row][col] = 0;
                }
            }
        }

        //zero out cols with a leading zero except for the col row
        for(int col = 1; col < width; col++){
            if(matrix[0][col] == 0){
                for(int row = 1; row < height; row++){
                    matrix[row][col] = 0;
                }
            }
        }

        //zero out the first row and col if needed
        if(zeroFirstCol){
            for(int row = 0; row < height; row++){
                matrix[row][0] = 0;
            }
        }
        if(zeroFirstRow){
            for(int col = 0; col < width; col++){
                matrix[0][col] = 0;
            }
        }
    }

    public static void test(){
        int[][] myMatrix = {{0,1,3,4},
                            {1,4,5,2},
                            {1,3,7,5}};
        print(myMatrix);
        System.out.println();
        setZeroes(myMatrix);
        print(myMatrix);
    }

    public static void print(int[][] matrix){
        for(int[] row : matrix){
            for(int val : row){
                System.out.printf("%2d ", val);
            }
            System.out.println();
        }
    }
}