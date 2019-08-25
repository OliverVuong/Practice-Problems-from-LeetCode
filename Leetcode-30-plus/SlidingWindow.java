import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class SlidingWindow{

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> output = new ArrayList<Integer>();
        Set<String> myWords = new HashSet<String>(Arrays.asList(words));
        int concatLength = words[0].length() * words.length;

        for (int i = 0; i < s.length() - concatLength; i++){
            
        }
        return output;
    }

    public static void test(){

    }
}