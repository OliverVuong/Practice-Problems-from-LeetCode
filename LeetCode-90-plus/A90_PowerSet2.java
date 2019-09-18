import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class A90_PowerSet2{
    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> memory = new ArrayList<>();
        List<Integer> emptySet = new ArrayList<>();

        powerSet(nums, 0, memory, emptySet, true);

        return memory;
    }

    public static void powerSet(int[] nums, int i, List<List<Integer>> memory, List<Integer> buildUp, boolean prevAdded){

        if(i == nums.length) {
            memory.add(buildUp);
            return;
        }

        //add nums[i] to the set
        //EXCEPT IF: nums[i] == nums[i-1] && nums[i-1] was NOT prevAdded
        //this is to prevent duplicates
        if(prevAdded || nums[i] != nums[i-1]){
            List<Integer> copy = new ArrayList<>(buildUp);
            copy.add(nums[i]);
            powerSet(nums, i + 1, memory, copy, true);
        }
        
        //don't add nums[i] val to the set
        powerSet(nums, i + 1, memory, buildUp, false);
    }

    public static void test(){
        print(subsetsWithDup(new int[]{1,2,2}));
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