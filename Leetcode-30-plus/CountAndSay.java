public class CountAndSay{
    public static String countAndSay(int n) {
        String output = "1";
        for(int i = 1; i < n; i++){
            output = getNext(output);
        }
        return output;
    }

    // 1 11 123 1223 122
    public static String getNext(String prev){
        String output = "";
        int index = 0;
        int count = 1;
        while(index < prev.length() - 1){
            if(prev.charAt(index) == prev.charAt(index + 1)){
                count++;
            } else {
                output += count;
                output += prev.charAt(index);
                count = 1;
            }
            index++;
        }

        //handle last character
        output += count;
        output += prev.charAt(index);

        return output;
    }

    public static void test(){

        System.out.println(countAndSay(4));
    }
}