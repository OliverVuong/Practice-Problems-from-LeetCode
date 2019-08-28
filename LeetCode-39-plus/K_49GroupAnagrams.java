import java.util.List;
import java.util.ArrayList;

public class K_49GroupAnagrams{
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>();
        List<int[]> uniqueFingerprints = new ArrayList<>();

        for(String it : strs){

            int[] fingerprintIt = convertToFingerprint(it);
            int duplicateIndex = findFprint(uniqueFingerprints, fingerprintIt);

            if (duplicateIndex == -1){  //found a unique string
                uniqueFingerprints.add(fingerprintIt);
                output.add(new ArrayList<>());
                output.get(output.size() - 1).add(it);
            } else {    //found an anagram
                output.get(duplicateIndex).add(it);
            }
        }

        return output;
    }

    public static int[] convertToFingerprint(String input){
        int[] charMap = new int[26];

        for(char it : input.toCharArray()){
            charMap[it - 97]++;
        }
        
        return charMap;
    }

    public static boolean equalFingerprints(int[] fPrint1, int[] fPrint2){
        if(fPrint1.length != 26 || fPrint2.length != 26) return false;

        for(int i = 0; i < 26; i++){
            if(fPrint1[i] != fPrint2[i]){
                return false;
            }
        }

        return true;
    }

    public static int findFprint(List<int[]> fPrintList, int[] fingerprint){
        for(int i = 0; i < fPrintList.size(); i++){
            if(equalFingerprints(fPrintList.get(i), fingerprint)){
                return i;
            }
        }
        return -1;
    }

    public static void print(int[] fingerprint){
        for(int it : fingerprint){
            System.out.print(it + " ");
        }
    }

    public static void test(){
        List<List<String>> output = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for(List<String> anagrams : output){
            for(String it : anagrams){
                System.out.print(it + " ");
            }
            System.out.println();
        }
    }

    public static void test2(){
        char myChar = 'a';
        System.out.println('a' - 97);
        System.out.println('b' - 97);
        System.out.println('z' - 97);
        System.out.println(equalFingerprints(convertToFingerprint("input"),convertToFingerprint("intup")));
    }
}