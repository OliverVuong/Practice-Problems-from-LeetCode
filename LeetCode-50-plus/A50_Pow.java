public class A50_Pow{
    public static double myPow(double x, int n){

        boolean posExponent = (n > 0) ? true : false;
        int exponent = (n > 0) ? n : -n;
        double partialProduct = 1d;
        double base = x;

        while (exponent > 0){
            if(exponent % 2 == 0){  //divisible by 2
                base *= base;
                exponent = exponent / 2;
            } else {    //not divisible by 2
                partialProduct *= base;
                exponent--;
            }
        }

        return posExponent ? partialProduct : 1 / partialProduct;
    }

    public static void test(){
        System.out.println(myPow(2, -2147483648));
    }
}