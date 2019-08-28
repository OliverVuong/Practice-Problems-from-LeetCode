import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Arrays;

public class C_41SmallestMissingPos{
    public static int firstMissingPositive(int[] nums) {
        int[] valuePresent = new int[nums.length + 2];
        for (int i : nums){
            if (0 < i && i < valuePresent.length){
                valuePresent[i] = 1;
            }
        }
        for (int i = 1; i < valuePresent.length; i++){
            if (valuePresent[i] == 0){
                return i;
            }
        }
        return 1;
    }

    public static void test(){
        System.out.println(firstMissingPositive(new int[]{1}));
        System.out.println("Reached");
    }

}