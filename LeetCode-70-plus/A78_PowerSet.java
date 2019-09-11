import java.util.List;
import java.util.ArrayList;

public class A78_PowerSet{
    public static List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> memory = new ArrayList<>();
        List<Integer> baseList = new ArrayList<>();

        helper(nums, 0, memory, baseList);

        return memory;
    }

    public static void helper(int[] nums, int index, List<List<Integer>> memory, List<Integer> buildUp){

        if(index >= nums.length) {
            memory.add(buildUp);
            return;
        }

        //split of one path where ith number is added
        List<Integer> split = new ArrayList<>(buildUp);
        split.add(nums[index]);
        helper(nums, index + 1, memory, split);

        //split of one path where ith number is not added
        helper(nums, index + 1, memory, buildUp);
    }

    public static void test(){
        print(subsets(new int[]{1,2,3}));
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