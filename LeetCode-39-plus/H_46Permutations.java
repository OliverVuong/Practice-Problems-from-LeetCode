import java.util.List;
import java.util.ArrayList;

public class H_46Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        helperFunc(nums, new ArrayList<>(), output);

        return output;
    }

    public static void helperFunc(int[] consume, List<Integer> build, List<List<Integer>> memory){

        if(consume.length == 0){
            memory.add(build);
        }
        
        for(int i = 0; i < consume.length; i++){
            helperFunc(remove(consume, i), permutationAdd(build, consume[i]), memory);
        }
    }

    public static List<Integer> permutationAdd(List<Integer> build, int addee){
        List<Integer> output = new ArrayList<>();
        for(Integer it : build){
            output.add(it);
        }
        output.add(addee);
        return output;
    }

    public static int[] remove(int[]arr, int index){
        int[] output = new int[arr.length - 1];
        for(int i = 0; i < index; i++){
            output[i] = arr[i];
        }
        for(int j = index + 1; j < arr.length; j++){
            output[j - 1] = arr[j];
        }
        return output;
    }

    public static void test(){
        print(permute(new int[]{1,2,3}));
    }
    public static void print(List<List<Integer>> input){
        System.out.println("Lists: ");
        for(List<Integer> myList : input){
            for(Integer it : myList){
                System.out.print(it + " ");
            }
            System.out.println();
        }
    }
}