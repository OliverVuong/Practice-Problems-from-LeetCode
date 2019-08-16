public class Atoi{
    public static int myAtoi(String str) {

        str = handleWhiteSpace(str);

        //handle invalid input
        //if(str.subString(0,0).equals("[+-1-9]"));

        int sign = getSignModifier(str);
        str = handleSignModfier(str);


        return 0;
    }

    public static String handleWhiteSpace(String str){
        while (str.charAt(0) == ' ') {
            str = str.substring(1,str.length());
        }
        return str;
    }

    public static int getSignModifier(String str){
        if(str.charAt(0) == '-'){
            return -1;
        } else {
            return 1;
        }
    }

    public static String handleSignModfier(String str){
        if (str.charAt(0) == '-'){
            return str.substring(1,str.length());
        } else {
            return str;
        }
    }

    public static void test(){
        System.out.println(handleWhiteSpace("   Without"));
        System.out.println(handleWhiteSpace("  asdf  Without"));
        System.out.println(handleWhiteSpace("asdf     ut"));
    }
}