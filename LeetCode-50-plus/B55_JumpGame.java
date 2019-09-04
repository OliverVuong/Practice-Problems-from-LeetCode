import java.util.Optional;

public class B55_JumpGame {
    public static boolean canJump(int[] nums) {

        //The only way to fail is to get stuck on a zero

        Optional<Integer> zeroIndex = Optional.empty();

        for(int index = nums.length - 2; index >= 0; index--){

            if(nums[index] == 0 && !zeroIndex.isPresent()){
                zeroIndex = Optional.of(index);
                continue;
            }

            if(zeroIndex.isPresent() && nums[index] + index > zeroIndex.get()){
                zeroIndex = Optional.empty();
            }

        }

        return !zeroIndex.isPresent();
    }

    public static void test(){
        System.out.println(canJump(new int[]{0,1}));
        System.out.println(canJump(new int[]{1,0}));
        System.out.println(canJump(new int[]{2,0,1}));
        System.out.println(canJump(new int[]{1,0,1}));
        System.out.println(canJump(new int[]{3,2,1,0,1}));
    }
}