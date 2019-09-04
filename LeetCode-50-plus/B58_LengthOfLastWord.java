public class B58_LengthOfLastWord{

    public static int lengthOfLastWord(String s) {

        int indexOfSpace = -1;
        char[] seq = s.toCharArray();
        int lastIndex = seq.length - 1;

        //get rid of trailing spaces
        for(int i = lastIndex; i >= 0; i--){
            if ( seq[i] == ' '){
                lastIndex--;
            } else {
                break;
            }
        }

        for(int i = lastIndex; i >= 0; i--){
            if ( seq[i] == ' '){
                indexOfSpace = i;
                break;
            }
        }

        return lastIndex - indexOfSpace;
    }

    public static void test(){
        System.out.println(lengthOfLastWord(" "));
        System.out.println(lengthOfLastWord("      "));
        System.out.println(lengthOfLastWord("Hello, World"));
        System.out.println(lengthOfLastWord("    "));
        System.out.println(lengthOfLastWord("a"));
        System.out.println(lengthOfLastWord("a "));
        System.out.println(lengthOfLastWord("aaaa"));
    }
}