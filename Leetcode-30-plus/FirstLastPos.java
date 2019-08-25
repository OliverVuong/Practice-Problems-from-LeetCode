class FirstLastPos {
    public static int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, target);
        int leftBoundary = index;
        int rightBoundary = index;

        //search left
        while(leftBoundary - 1 >= 0 && leftBoundary != -1 && nums[leftBoundary-1] == target){
            leftBoundary--;
        }

        //search right
        while(rightBoundary + 1 < nums.length && rightBoundary != -1 && nums[rightBoundary+1] == target){
            rightBoundary++;
        }

        return new int[]{leftBoundary, rightBoundary};
    }

    public static int[] searchRange2(int[] nums, int target){
        return new int[]{leftmostSearch(nums, target), rightmostSearch(nums, target)};
    }
    
    public static int binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = (left + right) / 2;

            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int leftmostSearch(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = (left + right) / 2;

            if (nums[mid] == target && (mid == 0 || nums[mid - 1] != target) ){
                return mid;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int rightmostSearch(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if (nums[mid] == target && (mid == nums.length - 1 || nums[mid+1] != target)){
                return mid;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1; 
            }
        }
        return -1;
    }

    public static void test(){
        System.out.println(leftmostSearch(new int[]{8,9,9,9,9,9,9,9}, 9));
        System.out.println(rightmostSearch(new int[]{8,9,9,9,9,9,9,9}, 9));
    }
}