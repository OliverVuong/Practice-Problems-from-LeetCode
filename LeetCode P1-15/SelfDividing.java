import java.util.List;
import java.util.ArrayList;

public class SelfDividing {
    public static List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = left; i <= right; i++){
            if ( isSelfDividing(i)){
                output.add(i);
            }
        }
        return output;
    }
    
    public static boolean isSelfDividing(int input){
        int consumable = input;
        while(consumable > 0){
            int remainder = consumable % 10;
            if (remainder == 0 ) return false;  //self div nums must not contain 0
            if ( input % remainder != 0 ) return false; //self div nums are be divisible by their individual digits
            consumable /= 10;
        }
        return true;
    }

    public static void test(){
        System.out.println(selfDividingNumbers(10,22));
    }
}