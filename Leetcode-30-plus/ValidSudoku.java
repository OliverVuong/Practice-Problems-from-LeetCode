import java.util.Set;
import java.util.HashSet;

public class ValidSudoku{
    public static boolean isValidSudoku(char[][] board) {
        return validRows(board) && validColumns(board) && validSquares(board);
    }

    public static boolean validRows(char[][] board){
        Set<Character> memory = new HashSet<>();
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board.length; col++){
                if(memory.contains(board[row][col])){
                    return false;
                }
                if(board[row][col] == '.'){
                    continue;
                }
                memory.add(board[row][col]);
            }
            memory.clear();
        }
        return true;
    }

    public static boolean validColumns(char[][] board){
        Set<Character> memory = new HashSet<>();
        for(int col = 0; col < board.length; col++){
            for(int row = 0; row < board.length; row++){
                if(memory.contains(board[row][col])){
                    return false;
                }
                if(board[row][col] == '.'){
                    continue;
                }
                memory.add(board[row][col]);
            }
            memory.clear();
        }
        return true;
    }

    public static boolean validSquare(char[][] board, int rowOffset, int colOffset){
        Set<Character> memory = new HashSet<>();
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                System.out.println(row + " " + col + ": " + board[row + rowOffset][col + colOffset]);
                if(memory.contains(board[row + rowOffset][col + colOffset])){
                    return false;
                }
                if(board[row + rowOffset][col + colOffset] == '.'){
                    continue;
                }
                memory.add(board[row + rowOffset][col + colOffset]);
            }
        }
        return true;
    }

    public static boolean validSquares(char[][] board){
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                if(!validSquare(board, 3 * row, 3 * col)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void test(){
        char[][] matrix = new char[][]{ {'.','.','.','.','5','.','.','1','.'},
                                        {'.','4','.','3','.','.','.','.','.'},
                                        {'.','.','.','.','.','3','.','.','1'},
                                        {'8','.','.','.','.','.','.','2','.'},
                                        {'.','.','2','.','7','.','.','.','.'},
                                        {'.','1','5','.','.','.','.','.','.'},
                                        {'.','.','.','.','.','2','.','.','.'},
                                        {'.','2','.','9','.','.','.','.','.'},
                                        {'.','.','4','.','.','.','.','.','.'} };
        //System.out.println(validRows(matrix));
        //System.out.println(validColumns(matrix));
        System.out.println(validSquare(matrix,0,3));
    }
    /*
    [" "," "," ",  " ","5"," ",  " ","1"," "],
    [" ","4"," ",  "3"," "," ",  " "," "," "],
    [" "," "," ",  " "," ","3",  " "," ","1"],

    ["8"," "," ",  " "," "," ",  " ","2"," "],
    [" "," ","2",  " ","7"," ",  " "," "," "],
    [" ","1","5",  " "," "," ",  " "," "," "],

    [" "," "," ",  " "," ","2",  " "," "," "]
    [" ","2"," ",  "9"," "," ",  " "," "," "]
    [" "," ","4",  " "," "," ",  " "," "," "]

    

    {{'.','.','.','.','5','.','.','1','.'},
    {'.','4','.','3','.','.','.','.','.'},
    {'.','.','.','.','.','3','.','.','1'},
    {'8','.','.','.','.','.','.','2','.'},
    {'.','.','2','.','7','.','.','.','.'},
    {'.','1','5','.','.','.','.','.','.'},
    {'.','.','.','.','.','2','.','.','.'},
    {'.','2','.','9','.','.','.','.','.'},
    {'.','.','4','.','.','.','.','.','.'}}

    */

}