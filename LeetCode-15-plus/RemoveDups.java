public class RemoveDups{

    public static int removeDuplicates(int[] nums){

        if (nums.length == 0) return 0;

        int writeIndex = 0;
        int readIndex = 1;

        while(readIndex < nums.length) {
            if (nums[writeIndex] == nums[readIndex]) {
                readIndex++;
            } else if (nums[writeIndex] != nums[readIndex]) {
                writeIndex++;
                nums[writeIndex] = nums[readIndex];
            }
        }

        return writeIndex + 1;
    }

    public static int removeDuplicates2(int[] nums) {

        //special cases
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;

        int writeIndex = 0;
        int readIndex = 1;
        int length = 1;

        while (readIndex < nums.length){

            //if duplicate found -> find next unique -> overwrite duplicate
            if (nums[writeIndex] == nums[readIndex]){

                //move write index to first duplication
                writeIndex++;
                //if writeIndex >= nums.length we have hit the end of the array
                if(writeIndex >= nums.length) break;
                //use while loop handle numbers being duplicated three or more times
                while(readIndex < nums.length && nums[readIndex] == nums[readIndex - 1]){
                    readIndex++;
                }
                //if readIndex >= nums.length we have hit the end of the array
                if(readIndex >= nums.length) break;

                //overwrite first duplicate number with the next unique number
                nums[writeIndex] = nums[readIndex];

            } else {
                writeIndex++;
                readIndex++;
            }

            length++;
        }
        return length;
    }
    // 1,1,2,3
    //writeIndex = 2    //readIndex = 3     //length = 2     //nums.length = 10
    public static void test(){
        int[] input = new int[]{0,1,1,2,3};
        int len = removeDuplicates(input);
        System.out.println("Length: " + len);
        for(int i = 0; i < len; i++){
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }
}