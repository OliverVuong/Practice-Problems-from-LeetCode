public class B53_MaxSubArray{

    public static int maxSubArray(int[] nums){

        int maxSum = nums[0];
        int partialSum = 0;

        for(int start = 0; start < nums.length; start++){
            partialSum = 0;
            for(int iterator = start; iterator < nums.length; iterator++){

                if(partialSum + nums[iterator] < nums[iterator]) break;

                partialSum += nums[iterator];
                if(partialSum > maxSum){
                    maxSum = partialSum;
                }
            }
        }

        return maxSum;
    }

    /*
    public static int maxSubArrayIncorrect(int[] nums) {

        int LRLsum = nums[0];   //start left move right go back left
        int maxRightBound = 0;
        int pointerSum = nums[0];

        for(int rightBound = 1; rightBound < nums.length; rightBound++){
            pointerSum += nums[rightBound];
            if(pointerSum >= LRLsum){
                maxRightBound = rightBound;
                LRLsum = pointerSum;
            }
        }

        LRLsum =  nums[maxRightBound];
        pointerSum = nums[maxRightBound];
        int maxLeftBound = nums.length - 1;

        for(int leftBound = maxRightBound - 1; leftBound >= 0; leftBound--){
            pointerSum += nums[leftBound];
            if(pointerSum >= LRLsum){
                maxLeftBound = leftBound;
                LRLsum = pointerSum;
            }
        }

        int RLRsum = nums[nums.length - 1];   //start left move right go back left
        maxRightBound = nums.length - 1;
        pointerSum = nums[nums.length - 1];

        for(int rightBound = 1; rightBound < nums.length; rightBound++){
            pointerSum += nums[rightBound];
            if(pointerSum >= RLRsum){
                maxRightBound = rightBound;
                RLRsum = pointerSum;
            }
        }

        RLRsum =  nums[maxRightBound];
        pointerSum = nums[maxRightBound];
        maxLeftBound = nums.length - 1;

        for(int leftBound = maxRightBound - 1; leftBound >= 0; leftBound--){
            pointerSum += nums[leftBound];
            if(pointerSum >= RLRsum){
                maxLeftBound = leftBound;
                RLRsum = pointerSum;
            }
        }
        return LRLsum > RLRsum ? LRLsum : RLRsum;
    }
    */

    public static void test(){
        System.out.println(maxSubArray(new int[]{-2,1}));
        System.out.println(maxSubArray(new int[]{-2,-1}));
        System.out.println(maxSubArray(new int[]{-2,-1,-3}));
        System.out.println(maxSubArray(new int[]{-9,-9,1,-9,-9}));
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}