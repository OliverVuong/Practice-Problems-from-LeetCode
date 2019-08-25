public class SearchInsertPos{
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int closestMatchIndex = 0;
        int mid = 0;

        while (left <= right){
            mid = (left + right) / 2;
            if (nums[mid] > target){
                right = mid - 1;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {    //muns[mid] == target
                return mid;
            }
        }
        return (nums[mid] > target) ? mid : mid + 1;
    }

    public static int searchInsert2(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            if (nums[i] >= target) return i;
        }
        return nums.length;
    }

    public static void test(){
        System.out.println(searchInsert(new int[]{1,3,5,6} ,7));
    }
}