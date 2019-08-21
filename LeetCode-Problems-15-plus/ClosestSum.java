import java.util.Arrays;
import java.lang.Math;
import java.util.Arrays;

public class ClosestSum{
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        for(int i = 0; i < nums.length - 2; i++){
            for (int j = i + 1; j < nums.length - 1; j++){
                for (int k = j +1; k < nums.length; k++){
                    if (Math.abs(nums[i] + nums[j] + nums[k] - target) < Math.abs(target - closestSum)){
                        closestSum = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }

        return closestSum;
    }
}