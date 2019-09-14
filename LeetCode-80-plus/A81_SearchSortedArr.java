public class A81_SearchSortedArr{
    public static boolean search(int[] nums, int target) {
        return rotatedSearch(nums,target,0, nums.length - 1);
    }

    public static boolean rotatedSearch(int[] nums, int target, int low, int high){

        if (high >= low){
            int mid = (high + low) / 2;
            if(nums[mid] == target) return true;

            //1 2 3 4 5 6 7
            if(low != high && nums[low] == nums[high]){
                if(rotatedSearch(nums,target,low,mid) || rotatedSearch(nums,target,mid + 1, high)){
                    return true;
                }
            } else if (nums[mid] < target && nums[high] < target){
                if(nums[mid] <= nums[high]){    //(7)123456
                    return rotatedSearch(nums, target, low, mid - 1);
                } else {    //34567(1)2
                    return rotatedSearch(nums, target, mid + 1, high);
                }
            } else if (nums[mid] > target && nums[high] > target) {
                if(nums[mid] > nums[high]){    //34567(1)2
                    return rotatedSearch(nums, target, mid + 1, high);
                } else {    //71(2)3456
                    return rotatedSearch(nums, target, low, mid - 1);
                }
            } else if (nums[mid] > target && nums[high] < target){ //3(4)56712
                return rotatedSearch(nums, target, low, mid - 1);
            } else if (nums[mid] < target && nums[high] > target){ //7123(4)56
                return rotatedSearch(nums, target, mid + 1, high);
            } else {
                return true;
            }
        }
        
        return false;
    }

    public static boolean binarySearch(int[] nums, int target, int low, int high){

        if (high >= low){
            int mid = (high + low) / 2;
            if(nums[mid] == target) return true;

            if(nums[mid] > target){
                return binarySearch(nums, target, low, mid - 1);
            } else {
                return binarySearch(nums, target, mid + 1, high);
            }
        }
        
        return false;
    }

    public static void test(){
        //System.out.println(search(new int[]{2,3,0,0,1,1,1,1,1,1}, 1));
        //System.out.println(search(new int[]{1,1,1,1,1,2,1,1}, 2));
        
        System.out.println(search(new int[]{3,1,1}, 3));
    }
}