public class A15_DirectSubSequence {
    public static int numDistinct(String s, String t) {
        int count[] = {0};

        for(int i = 0; i <= s.length() - t.length(); i++){
            DFS(s.toCharArray(), i, t.toCharArray(), 0, count);
        }//DFS(s.toCharArray(), 0, t.toCharArray(), 0, count);
        
        return count[0];
    }

    public static void DFS(char[] s, int sID, char[] t, int tID, int[] count){
        //System.out.printf("sID: %d, tID: %d\n", sID, tID);
        //System.out.println("reached");
        //not enough letters left in s to complete subsequence
        if(s.length - sID < t.length - tID){
            return;
        }

        if(s[sID] != t[tID]) return;
        
        if(tID == t.length - 1 && t[tID] == s[sID]) {
            count[0]++;
            return;
        }

        //System.out.println("Start of Loop:");
        //System.out.printf("sID: %d, t.length: %d, tID: %d\n", sID,  t.length, tID);
        for(int i = 1; i <= s.length - t.length + tID + 1; i++){
            //System.out.println("i: " + i);
            DFS(s, sID + i, t, tID + 1, count);
        }
        //System.out.println("End of Loop\n");
    }

    public static int numDistinct2(String s, String t) {

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int[][] matrix = new int[tArr.length + 1][sArr.length + 1];

        for(int col = 0; col < sArr.length + 1; col++){
            matrix[0][col] = 1;
        }

        for(int row = 1; row < tArr.length + 1; row++){
            matrix[row][0] = 0;
        }

        for(int row = 1; row < tArr.length + 1; row++){
            for(int col = 1; col < sArr.length + 1; col++){
                //System.out.println( "COL:" + col + " --ROW: " + row);
                if(sArr[col - 1] == tArr[row - 1]){
                    matrix[row][col] = matrix[row][col - 1] + matrix[row - 1][col - 1];
                } else {
                    matrix[row][col] = matrix[row][col - 1];
                }
            }
        }

        //print(matrix);
        
        return matrix[tArr.length][sArr.length];
    }

    public static void test(){
        //System.out.println(numDistinct2("a","a"));
        //System.out.println(numDistinct2("a","b"));
        //System.out.println(numDistinct2("ace","ace"));

        //System.out.println(numDistinct2("aa","a"));
        //System.out.println(numDistinct2("ab","b"));
        //System.out.println(numDistinct2("rabbbit","rabbit"));
        //System.out.println(numDistinct2("babgbag","bag"));
        System.out.println(numDistinct2("babbag","bag"));
        //System.out.println(numDistinct2("aaa","aa"));
    }

    public static void print(int[][] matrix){
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    /*
        - a a b a
    -   1 1 1 1 1
    a   0 1 2 2 3
    b   0 0 0 2 2
    a   0 0 0 0 2

      - a a a
    - 1 1 1 1
    a 0 1 2 3
    a 0 0 
    */
}