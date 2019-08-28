import java.util.List;
import java.util.ArrayList;

public class A_39CombinationSum{
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        helperFunction(new ArrayList<Integer>(), candidates, target, output);
        return output;
    }

    public static void helperFunction(List<Integer> summands, int[] candidates, int target, List<List<Integer>> parentOutput){

        for (int i : candidates){
            if(summands.isEmpty() || i >= summands.get(summands.size()-1)){

                List<Integer> newList = new ArrayList<>(summands);
                newList.add(i);

                if (sum(newList) < target){
                    helperFunction(newList, candidates, target, parentOutput);
                } else if (sum(newList) == target){
                    parentOutput.add(newList);
                }
            }
        }

    }

    public static int sum(List<Integer> summands){
        if(summands.isEmpty()) return 0;
        int output = 0;
        for(Integer it : summands){
            output += it;
        }
        return output;
    }

    public static void test(){
        print(combinationSum(new int[]{2,3,5}, 8));
    }

    public static void print(List<List<Integer>> input){
        System.out.println("Lists: ");
        for(List<Integer> listIt : input){
            for(Integer integerIt : listIt){
                System.out.print(integerIt + " ");
            }
            System.out.println();
        }
    }
    
}