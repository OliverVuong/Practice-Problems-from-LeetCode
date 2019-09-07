public class A67_AddBinary{

    public static String addBinary(String a, String b) {

        int len = a.length() >= b.length() ? a.length() : b.length();

        String output = "";
        int overflow = 0;

        for(int i = 0; i < len; i++){
            int sum = overflow + getIthDecimal(a, i) + getIthDecimal(b, i);

            if(sum == 0 || sum == 1){
                output = sum + output;
                overflow = 0;
            } else if(sum == 2){
                output = 0 + output;
                overflow = 1;
            } else if(sum == 3){
                output = 1 + output;
                overflow = 1;
            } else {
                System.out.println("error invalid sum");
            }
        }

        if(overflow == 1){
            output = 1 + output;
        }

        return output;
    }

    public static int getIthDecimal(String str, int i){
        if(i < 0 || i >= str.length()) return 0;
        return str.charAt(str.length() - 1 - i) - 48;
    }

    public static void test(){
        //System.out.println(getIthDecimal("43210", 6));
        System.out.println(addBinary("1010", "1011"));
    }
}