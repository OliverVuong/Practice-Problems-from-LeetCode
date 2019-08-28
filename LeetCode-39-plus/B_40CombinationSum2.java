import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class B_40CombinationSum2{
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> output = new ArrayList<>();
        helperFunction(new ArrayList<Integer>(), candidates, target, output, 0);
        return output;
    }

    //not functioning currently
    public static void helperFunction(List<Integer> summands, int[] candidates, int target, List<List<Integer>> parentOutput, int index){

        for (int i = index; i < candidates.length; i++){
            
            if((i == index || candidates[i] != candidates[i-1])){

                List<Integer> newList = new ArrayList<>(summands);
                newList.add(candidates[i]);


                if (target - candidates[i] > 0){
                    helperFunction(newList, candidates, target - candidates[i], parentOutput, i + 1);
                } else if (target - candidates[i] == 0){
                    parentOutput.add(newList);
                }
            }
        }

    }

    //functioning
    public static void helperFunctionSlow(List<Integer> summands, int[] candidates, int target, List<List<Integer>> parentOutput, int index){

        for (int i = index; i < candidates.length; i++){
            
            if((i == index || candidates[i] != candidates[i-1])){

                List<Integer> newList = new ArrayList<>(summands);
                newList.add(candidates[i]);

                if (sum(newList) < target){
                    helperFunctionSlow(newList, candidates, target, parentOutput, i + 1);
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
        print(combinationSum(new int[]{1,1,2,3}, 5));
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

    // 1,1,2,5,6,7,10
    // 1 1 1 1 2 2 2 3 3 4
    
}