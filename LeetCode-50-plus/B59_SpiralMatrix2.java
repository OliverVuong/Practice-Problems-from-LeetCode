public class B59_SpiralMatrix2{

    public static int[][] generateMatrix(int n) {

        int[][] output = new int[n][n];

        int topRowID = 0;
        int bottomRowID = n - 1;
        int leftColID = 0;
        int rightColID = n - 1;

        int value = 1;

        while(topRowID <= bottomRowID){

            //populate topRow entirely
            for(int col = leftColID; col <= rightColID; col++){
                output[topRowID][col] = value;
                value++;
            }
            
            //populate rightCol except for first AND last element
            for(int row = topRowID + 1; row < bottomRowID; row++){
                output[row][rightColID] = value;
                value++;
            }

            //populate bottomRow except for last element
            for(int col = rightColID; col > leftColID; col--){
                output[bottomRowID][col] = value;
                value++;
            }

            //populate leftCol except for last element
            for(int row = bottomRowID; row > topRowID; row--){
                output[row][leftColID] = value;
                value++;
            }

            topRowID++;
            bottomRowID--;
            leftColID++;
            rightColID--;

        }

        return output;
    }

    public static void test(){
        printMatrix(generateMatrix(2));
        System.out.println();
        printMatrix(generateMatrix(3));
        System.out.println();
        printMatrix(generateMatrix(4));

    }

    public static void printMatrix(int[][] matrix){
        for(int[] row : matrix){
            for(int it : row){
                System.out.print(it + " ");
            }
            System.out.println();
        }
    }
}