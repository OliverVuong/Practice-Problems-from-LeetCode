import java.util.Map;
import java.util.HashMap;

public class A87_ScrambleString{
    public static boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        if(s1.length() == 1) return s1.equals(s2);
        if(s1.equals(s2)) return true;

        if(s1.length() % 2 == 0 ){
            return isScrambleEven(s1,s2);
        }else {
            return isScrambleOdd(s1,s2);
        }
    }

    //handles odds vs evens
    public static boolean isScrambleBoth(String s1, String s2){
        if(s1.length() % 2 == 0 ){
            return isScrambleEven(s1,s2);
        }else {
            return isScrambleOdd(s1,s2);
        }
    }

    //checks if an even length string is a scramble
    public static boolean isScrambleEven(String s1, String s2){

        int myLen = s1.length();

        if(s1.equals(s2)) return true;
        if(myLen == 2) return s1.charAt(0) == s2.charAt(1) && s1.charAt(1) == s2.charAt(0);

        return isScrambleBoth(s1.substring(0, myLen / 2), s2.substring(0, myLen / 2)) 
            && isScrambleBoth(s1.substring(myLen / 2), s2.substring(myLen / 2));
    }

    //checks if an odd length string is a scramble 012 201 120
    //1 23 -> 23 1 or 32 1
    public static boolean isScrambleOdd(String s1, String s2){

        int myLen = s1.length();

        if(s1.equals(s2)) return true;

        if(s1.length() == 3){
            
            return isAnagram(s1, s2);

        } else {
            return isScrambleBoth(s1.substring(0, myLen / 2), s2.substring(0, myLen / 2)) 
                && isScrambleBoth(s1.substring(myLen / 2), s2.substring(myLen / 2));
        }
    }

    public static boolean isAnagram(String s1, String s2){
        
        Map<Character,Integer> wordCount = new HashMap<>();

        for(char letter : s1.toCharArray()){
            wordCount.put(letter, wordCount.getOrDefault(letter, 0) + 1);
        }
        for(char letter : s2.toCharArray()){
            wordCount.put(letter, wordCount.getOrDefault(letter, 0) - 1);
        }

        for (char letter : wordCount.keySet() ) {
            if(wordCount.get(letter) != 0){
                return false;
            }
        }

        return true;
    }

    public static void test(){
        //System.out.println(isScramble("great", "rgeat"));
        //System.out.println(isScramble("abcde", "caebd"));
        //System.out.println(isScramble("abb", "bba"));
        //System.out.println(isScramble("abb", "bba"));
        //System.out.println(isScrambleEven("1234", "2134"));
        //System.out.println(isScrambleEven("1234", "2143"));
        //System.out.println(isScrambleEven("1234", "1243"));
        System.out.println(isAnagram("abb", "bba"));
        System.out.println(isAnagram("abb", "bab"));
    }

}

/*
class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        if(s1.length() == 1) return s1.equals(s2);
        if(s1.equals(s2)) return true;

        if(s1.length() % 2 == 0 ){
            return isScrambleEven(s1,s2);
        }else {
            return isScrambleOdd(s1,s2);
        }
    }

    //checks if an even length string is a scramble
    public static boolean isScrambleEven(String s1, String s2){

        if(s1.length() != s2.length()) {
            System.out.println("Error string lengths do not match");
            return false;
        }

        for(int i = 0; i < s1.length() - 1; i += 2){
            if(s1.charAt(i) != s2.charAt(i+1) || s1.charAt(i+1) != s2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    //checks if an odd length string is a scramble
    public static boolean isScrambleOdd(String s1, String s2){

        if(s1.length() != s2.length()) {
            System.out.println("Error string lengths do not match");
            return false;
        }

        if(s1.length() == 3){
            if(s1.equals(s2)){
                return true;
            } else if (s1.charAt(0) == s2.charAt(2) 
                    && s1.charAt(1) == s2.charAt(1)
                    && s1.charAt(2) == s2.charAt(0)){
                return true;
            } else {
                return false;
            }
        } else {
            return isScrambleEven(s1.substring(0, s1.length() / 2), s2.substring(0, s1.length() / 2))
                    && isScrambleOdd(s1.substring(s1.length() / 2), s2.substring(s1.length() / 2));
        }
    }
}
*/