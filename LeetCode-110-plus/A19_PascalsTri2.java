import java.util.List;
import java.util.ArrayList;

public class A19_PascalsTri2{
    public static List<Integer> getRow(int rowIndex) {
        
        List<Integer> output = new ArrayList<>();
        
        for(int i = 0; i <= rowIndex; i++){
            transformIntoNext(output);
        }

        return output;
    }

    public static void transformIntoNext(List<Integer> row)
    {
        row.add(1);
        
        for(int i = row.size() - 2; i > 0; i--){
            row.set(i, row.get(i) + row.get(i - 1));
        }

    }

    public static void test(){
        List<Integer> row = getRow(3);
        for(int i = 0; i < row.size(); i++){
            System.out.print(row.get(i) + " ");
        }
        System.out.println();
    }

    /*
    1
    1 1
    1 2 1
    1 3 3 1
    1 4 6 4 1

    */
}