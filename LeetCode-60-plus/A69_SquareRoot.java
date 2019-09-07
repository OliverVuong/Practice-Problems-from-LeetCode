public class A69_SquareRoot{
    public static int mySqrt(int x) {

        //modified binary search
        int left = 1;
        int right = (x / 2) + 1;

        while (left <= right){

            int mid = (left + right) / 2;

            if( (double) mid * mid == x){
                return mid;
            } else if((double) mid * mid > x && (double) (mid-1) * (mid-1) <= x){
                return mid - 1;
            } else if((double) mid * mid > x){
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return 0;
    }

    //slow
    public static int mySqrtSlow(int x) {

        for(double i = 1d; i - 1 <= x / 2; i++){
            if (i * i == x){
                return (int)i;
            } else if (i * i > x){
                return (int)i - 1;
            }
        }
        return 0;
    }

    public static void test(){
        System.out.println(mySqrt(8));
    }
}