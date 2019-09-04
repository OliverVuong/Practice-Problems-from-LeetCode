import java.lang.Integer;
import java.util.*;

public class PhoneToLetterComb{
    public static List<String> letterCombinations(String digits) {
        List<String> output =  new ArrayList<String>();

        permutationHelper("", digits, output);

        return output;
    }

    public static void permutationHelper(String buildUp, String consume, List<String> mainFunctionOutput){
        if (consume.length() == 0) {
            mainFunctionOutput.add(buildUp);
            return;
        }

        for ( char it : digitToLetter(consume.charAt(0)) ){
            permutationHelper(buildUp + it, consume.substring(1), mainFunctionOutput);
        }
    }

    public static char[] digitToLetter(char input){
        int digit = Integer.parseInt("" + input);
        char[][] mapTwoIndexed = new char[][]{{'a','b','c'},     //2
                                             {'d','e','f'},     //3
                                             {'g','h','i'},     //4
                                             {'j','k','l'},     //5
                                             {'m','n','o'},     //6
                                             {'p','q','r','s'}, //7
                                             {'t','u','v'},     //8
                                             {'w','x','y','z'}};//9
        if (digit < 2 || digit > 9) System.out.println("Invalid digitToLet input");
        return mapTwoIndexed[digit-2];
    }

    public static void test(){
        printList(letterCombinations("23"));
    }

    public static void printArr(char[] input){
        for(char it : input){
            System.out.print(it);
        }
        System.out.println();
    }

    public static void printList(List<String> input){
        for (String it : input){
            System.out.println(it);
        }
    }
}