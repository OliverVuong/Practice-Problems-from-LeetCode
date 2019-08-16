public class LongestPalindrome{

    public static String longestPalindrome(String input){
        char[] inputArr = input.toCharArray();

        //iterate through all possible stringLengths
        //start with the longest possible stringLength 
        //which is the length of whole stringLen
        //end with 1
        for(int stringLen = inputArr.length; stringLen > 0; stringLen--){

            //iterate through all possible starting indexes
            for(int startIndx = 0; startIndx <= inputArr.length - stringLen; startIndx++){
                if(isPalindrome(inputArr, startIndx, startIndx + stringLen)){
                    return input.substring(startIndx, startIndx + stringLen);
                }
            }
        }
        return "";
    }

    public static boolean isPalindrome(String input){
        for(int i = 0; i < input.length() / 2; i++){
            if(input.charAt(i) != input.charAt(input.length() - (1 + i))){
                return false;
            }
        }
        return true;
    }

    //checks that 
    public static boolean isPalindrome(char[] input, int beg, int end) {
        for(int i = beg; i < (beg + end) / 2; i++){
            if(input[i] != input[end - (1 + i - beg)]){
                return false;
            }
        }
        return true;
    }

    public static void test(){
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("bbbb"));
        System.out.println(longestPalindrome("b"));
        System.out.println(longestPalindrome("ddaba"));
        System.out.println(longestPalindrome("cccdd"));
    }

    public static void testIsPalindrome(){
        System.out.println("true: " + isPalindrome("abba"));
        System.out.println("true: " + isPalindrome("a"));
        System.out.println("true: " + isPalindrome("abcba"));
        System.out.println("false: " + isPalindrome("babad"));
        System.out.println(longestPalindrome("abbba"));
        System.out.println("true: " + isPalindrome("abba".toCharArray(), 0, 4));
        System.out.println("true: " + isPalindrome("zabbao".toCharArray(), 1, 5));
        System.out.println("true: " + isPalindrome("abcdefghabbao".toCharArray(), 8, 12));
        System.out.println("false: " + isPalindrome("abcdefghabbao".toCharArray(), 7, 11));
        System.out.println("true: " + isPalindrome("zabbaabcdefg".toCharArray(), 1, 5));
        System.out.println("false: " + isPalindrome("zabbaabcdefg".toCharArray(), 2, 6));
        System.out.println("true: " + isPalindrome("ztabbapo".toCharArray(), 2, 6));
        System.out.println("true: " + isPalindrome("trashabba".toCharArray(), 5, 9));
    }
}