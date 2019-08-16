import java.util.HashMap;

public class RomanToInt{
    public static int romanToInt(String s){
        int output = 0;
        HashMap<String,Integer> twoLetterMap= twoLetterMap();
        HashMap<String,Integer> oneLetterMap= oneLetterMap();

        while (s.length() > 0){
            if (s.length() > 1 && twoLetterMap.containsKey(s.substring(0, 2))){
                output += twoLetterMap.get(s.substring(0,2));
                s = s.substring(2,s.length());
            } else {
                output += oneLetterMap.get(s.substring(0,1));
                s = s.substring(1,s.length());
            }
        }
        return output;
    }

    public static HashMap<String,Integer> twoLetterMap(){
        HashMap<String, Integer> twoLetterMap = new HashMap<>();
        twoLetterMap.put("IV", 4);
        twoLetterMap.put("IX", 9);
        twoLetterMap.put("XL", 40);
        twoLetterMap.put("XC", 90);
        twoLetterMap.put("CD", 400);
        twoLetterMap.put("CM", 900);

        return twoLetterMap;
    }

    public static HashMap<String,Integer> oneLetterMap(){
        HashMap<String, Integer> oneLetterMap = new HashMap<>();
        oneLetterMap.put("I", 1);
        oneLetterMap.put("V", 5);
        oneLetterMap.put("X", 10);
        oneLetterMap.put("L", 50);
        oneLetterMap.put("C", 100);
        oneLetterMap.put("D", 500);
        oneLetterMap.put("M", 1000);
        return oneLetterMap;
    }

    public static void test(){
        System.out.println(romanToInt("III"));
    }
}