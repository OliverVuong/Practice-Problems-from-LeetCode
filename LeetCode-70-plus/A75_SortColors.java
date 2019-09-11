public class A75_SortColors{
    public static void sortColors(int[] nums) {

        int index = 0;
        //when we find a zero place at at this index
        int pointer0 = 0;
        //when we find a two place at at this index
        int pointer2 = nums.length - 1;

        while(index <= pointer2){
            if(nums[index] == 0){
                nums[index] = nums[pointer0];
                nums[pointer0] = 0;
                pointer0++;
                index++;
            }else if(nums[index] == 2){
                nums[index] = nums[pointer2];
                nums[pointer2] = 2;
                pointer2--;
            } else {
                index++;
            }
        }
        
    }

    public static void test(){
        int[] myArr= new int[]{0,0,0,1,1,2,0,2,0,2,2};
        printArr(myArr);
        sortColors(myArr);
        printArr(myArr);
    }

    public static void printArr(int[] myArr){
        for(int it : myArr){
            System.out.print(it + " ");
        }
        System.out.println();
    }
}