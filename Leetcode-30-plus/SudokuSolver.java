public class SudokuSolver{

    public static void solveSudoku(char[][] board) {
        solve(board);
    }

    public static boolean solve(char[][] board) {
        for(int row = 0; row < 9; row++){
            for (int col = 0; col < 9; col++){
                if(board[row][col] == '.'){
                    for(int i = 1; i <= 9; i++){
                        board[row][col] = (char) ('0' + i);;
                        if(ValidSudoku.isValidSudoku(board) && solve(board)){
                            return true;
                        }
                        board[row][col] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
    