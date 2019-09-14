public class A80_RemoveDups{
    public static int removeDuplicates(int[] nums) {
        
        if(nums.length == 0) return 0;
        if(nums.length < 3) return nums.length;

        int writeIndex = 1;
        int readIndex = 2;

        while(readIndex < nums.length){
            if(nums[writeIndex - 1] != nums[readIndex] ) {
                writeIndex++;
                nums[writeIndex] = nums[readIndex];
            }
            readIndex++;
        }

        return writeIndex + 1;
    }

    public static void test(){
        int[] arr = new int[]{1,1,1,2,2,3};
        System.out.println(removeDuplicates(arr));
        for(int it : arr){
            System.out.println(it);
        }
    }
}