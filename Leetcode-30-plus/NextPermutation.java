public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int index = nums.length - 1;

        while (index > 0) {
            if (nums[index] > nums[index-1]){
                if (index == nums.length - 1){
                    int temp = nums[index];
                    nums[index] = nums[index-1];
                    nums[index-1] = temp;
                } else {
                    
                }
            }
            index--;
        }
    }

    public static void test(){
        int[] arr = new int[]{1,2,999,4,6,5};
        nextPermutation(arr);
        print(arr);
    }

    //reverses elements between index to arr.length - 1
    public static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void print(int[] nums){
        for(Integer i : nums){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}