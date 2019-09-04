import java.util.List;
import java.util.ArrayList;

public class B54_SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> output = new ArrayList<>();
        if(matrix.length == 0) return output;

        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;

        //add all complete outer spirals
        while(startRow < endRow && startCol < endCol){

            //add top row except for the last element
            for(int col = startCol; col < endCol; col++){
                output.add(matrix[startRow][col]);
            }
            //add right column except for the last element
            for(int row = startRow; row < endRow; row++){
                output.add(matrix[row][endCol]);
            }
            //add bottom row except for the last element
            for(int col = endCol; col > startCol ; col--){
                output.add(matrix[endRow][col]);
            }
            //add left column except for the last element
            for(int row = endRow; row > startRow; row--){
                output.add(matrix[row][startCol]);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        //after handling all outer complete spirals handle leftovers
        //remainder must be empty, single ele, single row, or single col

        //handle single element
        if (startRow == endRow && startCol == endCol){
            output.add(matrix[startRow][startCol]);
        //handle single col
        } else if(startRow == endRow){
            for(int col = startCol; col <= endCol; col++){
                output.add(matrix[startRow][col]);
            }
        //handle single row
        } else if(startCol == endCol) {
            for(int row = startRow; row <= endRow; row++){
                output.add(matrix[row][endCol]);
            }
        }

        return output;
        
    }

    public static void test(){

        //[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]
        //[1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10,10,6]
        int[][] myMatrix = new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
        };

        List<Integer> myList = spiralOrder(myMatrix);
        for(Integer it : myList){
            System.out.print(it + " ");
        }
    }
}