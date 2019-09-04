import java.util.List;
import java.util.ArrayList;

public class GenParen{
    public static List<String> generateParenthesis(int n) {
        
        List<String> output = new ArrayList<String>();
        
        recursionHelper("", 0, 0, n, output);

        return output;
    }
    
    public static void recursionHelper(String buildStr, int open, int close, int max, List<String> memory){
        if (close == max){
            memory.add(buildStr);
            return;
        }

        if (open == close){
            recursionHelper(buildStr + "(", open + 1, close, max, memory);
        } else if ( open < max ){
            recursionHelper(buildStr + "(", open + 1, close, max, memory);
            recursionHelper(buildStr + ")", open, close + 1, max, memory);
        } else {    //(open == max)
            recursionHelper(buildStr + ")", open, close + 1, max, memory);
        }

    }

    public static void test(){
        print(generateParenthesis(1));
        System.out.println();
        print(generateParenthesis(2));
        System.out.println();
        print(generateParenthesis(3));
    }

    public static void print(List<String> list){
        for(String it : list){
            System.out.println(it);
        }
    }
}