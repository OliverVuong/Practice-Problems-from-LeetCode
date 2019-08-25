import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SubstringConcat{
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> output = new ArrayList<>();
        if(s.isEmpty() || words.length == 0) return output;
        List<String> permutations = getPermutations(words);
        String[] permutationsArr = permutations.toArray(new String[0]);
        int permuLen = permutations.get(0).length();

        for(int i = 0; i <= s.length() - permuLen; i++){
            if(binarySearch(permutationsArr, s.substring(i, i + permuLen))){
                output.add(i);
            }
        }
        return output;
    }

    public static List<String> getPermutations(String[] words){
        List<String> permutations = new ArrayList<>();
        Arrays.sort(words);
        List<String> consume = new ArrayList<>();
        for(String it : words){
            consume.add(it);
        }
        getPermutationsHelp("", consume, permutations);
        return permutations;
    }

    public static void getPermutationsHelp(String build, List<String> consume, List<String> memory){
        if (consume.isEmpty()) memory.add(build);

        for (int i = 0; i < consume.size(); i++){
            List<String> myCopy = new ArrayList<>(consume);
            String myEle = myCopy.remove(i);
            getPermutationsHelp(build + myEle, myCopy, memory);
        }
    }

    public static void test(){
        String[] myArr = new String[]{"foo", "bar"};
        printList2(findSubstring("barfoothefoobar", myArr));
    }

    public static void printList(List<String> input){
        for (String it : input){
            System.out.println(it);
        }
    }
    public static void printList2(List<Integer> input){
        for (Integer it : input){
            System.out.print(it + " ");
        }
        System.out.println();
    }

    public static boolean binarySearch(String[] a, String x) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (a[mid].compareTo(x) < 0) {
                low = mid + 1;
            } else if (a[mid].compareTo(x) > 0) {
                high = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}