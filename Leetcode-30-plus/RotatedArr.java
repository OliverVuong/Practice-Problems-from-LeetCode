public class RotatedArr{
    public static int search(int[] nums, int target){

        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = (left + right) / 2;

            if (nums[right] == target){
                return right;
            }

            //1 2 3 4 5 6 7
            if (nums[mid] < target && nums[right] < target){
                if(nums[mid] < nums[right]){    //(7)123456
                    right = mid - 1;
                } else {    //34567(1)2
                    left = mid + 1;
                }
            } else if (nums[mid] > target && nums[right] > target) {
                if(nums[mid] > nums[right]){    //34567(1)2
                    left = mid + 1;
                } else {    //71(2)3456
                    right = mid - 1;
                }
            } else if (nums[mid] > target && nums[right] < target){ //3(4)56712
                right = mid - 1;
            } else if (nums[mid] < target && nums[right] > target){ //7123(4)56
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
    //nums[mid] > target > nums[left] > nums[mid]
    public static void test(){
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
        //{1,2,3,4,5,6,7}
        //{6,7,1,2,3,4,5}
        //{5,6,7,1,2,3,4}
        //{3,4,5,6,7,1,2}
        //{2,3,4,5,6,7,1}

    }
}