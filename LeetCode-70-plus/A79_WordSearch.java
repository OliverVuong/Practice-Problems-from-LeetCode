public class A79_WordSearch{
    public static boolean exist(char[][] board, String word) {

        if(word.length() == 0) return true;
        if(board.length < 1 || board[0].length < 1) return false;

        char[] wordArr = word.toCharArray();

        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                if(isWord(board, wordArr, row, col, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isWord(char[][] board, char[] word, int row, int col, int i){

        if(i >= word.length) return true;
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;
        if(board[row][col] != word[i]) return false;

        char tempStorage = board[row][col];
        board[row][col] = '!';

        boolean potentiallyIsWord = isWord(board, word, row + 1, col, i + 1) ||
                                    isWord(board, word, row - 1, col, i + 1) ||
                                    isWord(board, word, row, col + 1, i + 1) ||
                                    isWord(board, word, row, col - 1, i + 1);

        board[row][col] = tempStorage;

        return potentiallyIsWord;

    }

    public static void test(){
        char[][] board = {{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}};

        System.out.println(exist(board,"ABCCED"));
    }
}