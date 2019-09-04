import java.util.List;
import java.util.ArrayList;

public class B51_NQueens{
    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> output = new ArrayList<>();
        char[][] board = setUpEmptyBoard(n);
        char[] possibleVals = new char[]{'.', 'Q'};

        backtrackingHelper(n, output, board, possibleVals);

        //Since this is the beginning we have no lastModRow or lastModCol
        //hence we set them as negative
        //backtrackingHelper2(n, output, board, -1, -1, 0);

        return output;
    }

    public static boolean backtrackingHelper(int n, List<List<String>> memory, char[][] board, char[] possibleVals) {
        /*
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){

                if (board[row][column] == '\0') {

                    for (char val : possibleVals) {

                        board[row][column] = val;

                        int queenCount = getQueenCount(board);
                        if(queenCount < n){
                            if (isValid(board, row, column) && backtrackingHelper(n, memory, board, possibleVals)) {
                                return true;
                            }
                        } else if (queenCount == n && isValid(board, row, column)){
                            memory.add(convert(board));
                        }
                        
                        board[row][column] = '\0';
                    }
                    return false;
                }
            }
        }*/

        return true;
    }

    public static boolean backtrackingHelper2(int n, List<List<String>> memory, char[][] board, int lastModRow, int lastModCol, int queenCount) {
        
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){

                if (row > lastModRow || (row == lastModRow && col > lastModCol)){

                    board[row][col] = 'Q';

                    if(queenCount < n && isPotentiallyValid(board) && backtrackingHelper2(n, memory, board, row, col, queenCount + 1)) {
                        return true;
                    } else if (queenCount == n && isPotentiallyValid(board) && backtrackingHelper2(n, memory, board, row, col, queenCount + 1)) {
                        memory.add(convert(board));
                        return false;
                    } else {
                        return false;
                    }

                }
            }
        }

        return true;
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
    
    public static char[][] setUpEmptyBoard2(int n){
        char[][] emptyBoard = new char[n][n];
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                emptyBoard[row][col] = '.';
            }
        }

        return emptyBoard;
    }

    //board doesn't have attacking queens, does not check queen counts
    public static boolean isPotentiallyValid(char[][] board){
        return validRows(board) && validCols(board) && validDiagonals(board);
    }

    public static boolean validRows(char[][] board){
        boolean rowHasQueen = false;
        for(int row = 0; row < board.length; row++){

            rowHasQueen = false;
            for(int col = 0; col < board.length; col++){

                if(board[row][col] == 'Q' && rowHasQueen == false){
                    rowHasQueen = true;
                } else if (board[row][col] == 'Q' && rowHasQueen == true){
                    return false;
                } else {    //board[row][col] == '.'
                    continue;
                }

            }
        }
        return true;
    }

    public static boolean validCols(char[][] board){
        boolean colHasQueen = false;
        for(int col = 0; col < board.length; col++){

            colHasQueen = false;
            for(int row = 0; row < board.length; row++){

                if(board[row][col] == 'Q' && colHasQueen == false){
                    colHasQueen = true;
                } else if (board[row][col] == 'Q' && colHasQueen == true){
                    return false;
                } else {    //board[row][col] == '.'
                    continue;
                }

            }
        }
        return true;
    }

    public static boolean validDiagonals(char[][] board){
        return validLeftDownDiagonal(board) && validUpRightDiagonal(board) && validLeftUpDiagonal(board) && validDownRightDiagonal(board);
    }

    //check all diagonals from the left side to the bottom side of the board
    //includes the middle diagonal
    public static boolean validLeftDownDiagonal(char[][] board){
        
        for(int row = 0; row < board.length - 1; row++){

            boolean diagonalHasQueen = false;
            int rowIt = row;
            int colIt = 0;
            while(rowIt < board.length){

                if(board[rowIt][colIt] == 'Q' && diagonalHasQueen == false){
                    diagonalHasQueen = true;
                } else if (board[rowIt][colIt] == 'Q' && diagonalHasQueen == true){
                    return false;
                }

                rowIt++;
                colIt++;
            }
        }
        return true;
    }

    public static boolean validUpRightDiagonal(char[][] board){
        for(int col = 1; col < board.length - 1; col++){

            boolean diagonalHasQueen = false;
            int rowIt = 0;
            int colIt = col;
            while(colIt < board.length){

                if(board[rowIt][colIt] == 'Q' && diagonalHasQueen == false){
                    diagonalHasQueen = true;
                } else if (board[rowIt][colIt] == 'Q' && diagonalHasQueen == true){
                    return false;
                }

                rowIt++;
                colIt++;
            }
        }
        return true;
    }

    public static boolean validLeftUpDiagonal(char[][] board){

        for(int row = 1; row < board.length; row++){

            boolean diagonalHasQueen = false;
            int rowIt = row;
            int colIt = 0;
            while(rowIt >= 0){

                if(board[rowIt][colIt] == 'Q' && diagonalHasQueen == false){
                    diagonalHasQueen = true;
                } else if (board[rowIt][colIt] == 'Q' && diagonalHasQueen == true){
                    return false;
                }

                rowIt--;
                colIt++;
            }
        }
        return true;
    }

    public static boolean validDownRightDiagonal(char[][] board){

        for(int col = 1; col < board.length - 1; col++){

            boolean diagonalHasQueen = false;
            int rowIt = board.length - 1;
            int colIt = col;
            while(colIt < board.length){

                if(board[rowIt][colIt] == 'Q' && diagonalHasQueen == false){
                    diagonalHasQueen = true;
                } else if (board[rowIt][colIt] == 'Q' && diagonalHasQueen == true){
                    return false;
                }

                rowIt--;
                colIt++;
            }
        }
        return true;
    }

    public static int getQueenCount(char[][] board){
        int queenCount = 0;
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board.length; col++){
                if(board[row][col] == 'Q'){
                    queenCount++;
                }
            }
        }
        return queenCount;
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