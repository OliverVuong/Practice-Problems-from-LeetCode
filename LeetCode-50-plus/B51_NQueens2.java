import java.util.List;
import java.util.ArrayList;

public class B51_NQueens2{
    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> output = new ArrayList<>();
        char[][] board = setUpEmptyBoard(n);
        char[] possibleVals = new char[]{'.', 'Q'};


        return output;
    }

    public static void backtrack(char[][] board, List<List<String>> memory, char[] possibleVals){

    }

    public static char[][] setUpEmptyBoard(int n){
        char[][] emptyBoard = new char[n][n];
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                emptyBoard[row][col] = '\0';
            }
        }

        return emptyBoard;
    }

    public static boolean isValidPlacement(int row, int col, char[][] board){
        if(board[row][col] == 'Q') return false;

        //check row
        for(int rowIt = 0; rowIt < board.length; rowIt++){
            if (rowIt == row) continue;
            if(board[rowIt][col] == 'Q') return false;
        }

        //check col
        for(int colIt = 0; colIt < board.length; colIt++){
            if (colIt == col) continue;
            if(board[row][colIt] == 'Q') return false;
        }

        //check up left diagonal
        int rowIt = row - 1;
        int colIt = col - 1;
        while(rowIt > 0 && colIt > 0){
            if(board[rowIt][colIt] == 'Q'){
                return false;
            }
            rowIt--;
            colIt--;
        }

        //check down left diagonal
        rowIt = row + 1;
        colIt = col - 1;
        while(rowIt < board.length && colIt > 0){
            if(board[rowIt][colIt] == 'Q'){
                return false;
            }
            rowIt++;
            colIt--;
        }

        //check up right diagonal
        rowIt = row - 1;
        colIt = col + 1;
        while(rowIt > 0 && colIt < board.length){
            if(board[rowIt][colIt] == 'Q'){
                return false;
            }
            rowIt--;
            colIt++;
        }

        //check down right diagonal
        rowIt = row + 1;
        colIt = col + 1;
        while(rowIt < board.length && colIt  < board.length){
            if(board[rowIt][colIt] == 'Q'){
                return false;
            }
            rowIt++;
            colIt++;
        }

        return true;
    }

    //convert char[][] to List<string> board
    public static List<String> convert(char[][] inputBoard){
        List<String> output = new ArrayList<>();
        for(int row = 0; row < inputBoard.length; row++){
            output.add(new String(inputBoard[row]));
        }
        return output;
    }

    public static void test(){
        List<List<String>> boards = solveNQueens(4);
        for(List<String> board : boards){
            printBoard(board);
            System.out.println();
        }
    }

    public static void printBoard(List<String> input){
        for(String row : input){
            System.out.println(row);
        }
    }

}