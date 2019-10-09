import java.util.List;
import java.util.ArrayList;

public class A18_PascalsTri{
    public static List<List<Integer>> generate(int row){

        List<List<Integer>> output = new ArrayList<>();

        //edge case
        if(row < 1) return output;

        //generate first row
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        output.add(firstRow);

        for(int rowID = 2; rowID <=row; rowID++){
            
            List<Integer> nextRow = new ArrayList<>();
            List<Integer> currentRow = output.get(rowID - 2);
            nextRow.add(1);
            for(int i = 0; i < currentRow.size() - 1; i++){
                nextRow.add(currentRow.get(i) + currentRow.get(i + 1));
            }
            nextRow.add(1);
            output.add(nextRow);
        }

        return output;
    }

    public static void test(){
        print(generate(5));
    }

    public static void print(List<List<Integer>> input){
        for(List<Integer> listIt : input){
            for(int i = 0; i < listIt.size(); i++){
                System.out.print(listIt.get(i) + " ");
            }
            System.out.println();
        }
    }
}