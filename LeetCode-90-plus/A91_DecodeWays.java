public class A91_DecodeWays{
    public static int numDecodings(String s){
        
        if(s.charAt(0) == '0') return 0;
        int[] count = {0};

        int[] intArr = new int[s.length()];
        char[] charArr = s.toCharArray();
        for(int i = 0; i < intArr.length; i++){
            intArr[i] = charArr[i] - '0';
        }

        helper(intArr, 0, count);

        return count[0];
    }

    public static void helper(int[] arr, int i, int[] count){

        if(i >= arr.length) {
            count[0]++;
            return;
        }

        if( i < arr.length - 1 && 
            ( (arr[i] == 1) || (arr[i] == 2 && arr[i+1] <= 6) ) ){

            helper(arr, i + 2, count);
        }
        
        if( arr[i] > 0){
            helper(arr, i + 1, count);
        }
    }

    public static void test(){
        System.out.println(numDecodings("0"));
        System.out.println(numDecodings("00"));
        System.out.println(numDecodings("10"));
        System.out.println(numDecodings("33333"));
        System.out.println(numDecodings("2222"));
        System.out.println(numDecodings("6"));
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("226"));
    }
}