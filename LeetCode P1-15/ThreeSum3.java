import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum3{
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> threeSumList = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++){

            if (nums[i] > 0) break;
            if ( i > 0 && nums[i] == nums[i-1]) continue;

            int inverse = -nums[i];
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k){
                if (nums[j] + nums[k] == inverse){
                    threeSumList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while ( j < k && nums[j] == nums[j-1] ) j++;     //skip duplicates
                    while ( k < j && nums[k] == nums[k-1] ) k++;
                } else if (nums[j] + nums[k] < inverse) {
                    j++;
                } else { //nums[j] + nums[k] > inverse
                    k--;
                }
            }
        }

        return threeSumList;
    }

    public static void test(){
        //print(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        //print(threeSum(new int[]{-2,0,0,2,2}));
        print(threeSum(new int[]{0,0,0}));
        //print(threeSum(new int[]{1,2,-2,-1}));
    }

    public static void print(List<List<Integer>> input){
        for(List<Integer> iterator : input){
            System.out.println(iterator);
        }
    }
}