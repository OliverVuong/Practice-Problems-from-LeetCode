import java.util.HashMap;

public class IntToRoman{
    public static String intToRoman(int num){
        HashMap<Integer, String> valueMap = makeMap();
        int remainder = num;
        String output = "";

        while (remainder >= 1000){
            output += "M";
            remainder -= 1000;
        }
        if ( remainder >= 900){
            output += "CM";
            remainder -= 900;
        }

        if (remainder >= 500){
            output += "D";
            remainder -= 500;
        } else if (remainder >= 400) {
            output += "CD";
            remainder -= 400;
        }

        while (remainder >= 100){
            output += "C";
            remainder -= 100;
        }
        if ( remainder >= 90){
            output += "XC";
            remainder -= 90;
        }

        if (remainder >= 50){
            output += "L";
            remainder -= 50;
        } else if (remainder >= 40) {
            output += "XL";
            remainder -= 40;
        }

        while (remainder >= 10){
            output += "X";
            remainder -= 10;
        }
        if ( remainder >= 9){
            output += "IX";
            remainder -= 9;
        }

        if (remainder >= 5){
            output += "V";
            remainder -= 5;
        } else if (remainder >= 4) {
            output += "IV";
            remainder -= 4;
        }

        while (remainder >= 1){
            output += "I";
            remainder -= 1;
        }

        return output;
    }

    public static void test(){
        System.out.println(intToRoman(1994));
    }

    public static HashMap<Integer,String> makeMap(){
        HashMap<Integer, String> output = new HashMap<>();
        output.put(1, "I");     //x3    -x1
        output.put(5, "V");     //
        output.put(10, "X");
        output.put(50, "L");
        output.put(100, "C");
        output.put(500, "D");
        output.put(1000, "M");
        return output;
    }
}