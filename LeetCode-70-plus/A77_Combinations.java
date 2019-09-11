import java.util.List;
import java.util.ArrayList;

public class A77_Combinations{
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> memory = new ArrayList<>();
        List<Integer> baseList = new ArrayList<>();

        helper(n,k,memory,baseList);

        return memory;
    }

    public static void helper(int n, int k, List<List<Integer>> memory, List<Integer> buildUp){
        int size = buildUp.size();
        if(size == k){
            memory.add(buildUp);
            return;
        }

        int lastVal;
        try{
            lastVal = buildUp.get(size - 1);
        } catch (ArrayIndexOutOfBoundsException e){
            lastVal = 0;
        }

        for(int addee = lastVal + 1; addee < n - k + 2 + size; addee++){
            List<Integer> newList = new ArrayList<>(buildUp);
            newList.add(addee);
            helper(n,k,memory,newList);
        } 

    }

    public static void test(){
        print(combine(4,2));
    }

    public static void print(List<List<Integer>> input){
        for(List<Integer> it : input){
            for(Integer val : it){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}