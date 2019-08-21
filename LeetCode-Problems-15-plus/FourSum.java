import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(nums.length < 4) return output;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 3; i++){

            if ( i != 0 && nums[i] == nums[i-1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++){
                
                if(j != i + 1 && nums[j] == nums[j-1]) continue;
                
                int k = j + 1;
                int l = nums.length - 1;
                
                while (k < l){

                    int sum = nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target){
                        output.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                        l--;
                    } else if (sum < target){
                        k++;
                    } else  { //sum > target
                        l--;
                    }

                    while (k < l && k != j+1 && nums[k] == nums[k-1]) k++;
                    while (k < l && l != nums.length - 1 && nums[l] == nums[l+1]) l--; 
                }
                
            }
        }
        return output;
    }

    public static void test(){
        int[] nums = new int[]{1,-2,-5,-4,-3,3,3,5};
        //-5 -4 -3 -2 1 3 3 5  
        print(fourSum(nums, -11));
    }

    public static void print(List<List<Integer>> input){
        System.out.println("Set:");
        for (List<Integer> it : input){
            System.out.println(it);
        }
    }

    public static void print(int[] input){
        for (int i : input){
            System.out.print(i + " ");
        }
    }
}