import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class I_47Permutations2{
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> uniquePermutations = new ArrayList<>();
        helperFunc(nums, new ArrayList<Integer>(), uniquePermutations);
        return uniquePermutations;
    }

    public static void helperFunc(int[] consume, List<Integer> build, List<List<Integer>> memory){

        if(consume.length == 0){
            memory.add(build);

        } else {
            //first val is always added
            helperFunc( remove(consume,0), permutationAdd(build, consume[0]), memory);
            //add all other unique vals to their own lists
            for(int i = 1; i < consume.length; i++){
                if (consume[i] != consume[i-1]){
                    helperFunc( remove(consume,i), permutationAdd(build, consume[i]), memory);
                }
            }
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
        print(permuteUnique(new int[]{1,1,2}));
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