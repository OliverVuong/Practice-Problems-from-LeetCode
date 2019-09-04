public class RemoveElement{
    public static int removeElement(int[] nums, int val){

        if (nums.length == 0) return 0;

        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if (nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    //2 2 2 3 2 4 2 2
    public static void test(){
        int[] input = new int[]{3,2,2,3};
        int len = removeElement(input, 2);
        System.out.println("Length: " + len);
        for(int i = 0; i < len; i++){
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }
}