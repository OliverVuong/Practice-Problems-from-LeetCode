public class A66_PlusOne{

    public static int[] plusOne(int[] digits) {

        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        
        //special case 9999
        int[] output = new int[digits.length + 1];
        output[0] = 1;
        return output;
    }

    public static void test(){
        int[] digits = {9,9,9,0,9};
        for(int iterator : plusOne(digits)){
            System.out.printf("%d ", iterator);
        }
        System.out.println();
    }

}