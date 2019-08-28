import java.util.Set;
import java.util.HashSet;

public class G_45JumpGame{
    public static int jump(int[] nums) {

        //tracks the quickest number of jumps to get to an index
        int[] leastNumJumps = new int[nums.length];
        fill(leastNumJumps, nums.length - 1);

        DFS(nums,0,0,leastNumJumps);

        return leastNumJumps[nums.length - 1];
    }

    public static void DFS(int[] arr, int index, int jumps, int[] leastNumJumps){

        if (index >= arr.length) return;
        if (jumps >= leastNumJumps[index]) return;

        //record number of jumps
        if(jumps < leastNumJumps[index]){
            leastNumJumps[index] = jumps;
        }

        for(int i = arr[index]; i > 0 ; i--){
            DFS(arr, index + i, jumps + 1, leastNumJumps);
        }
    }

    public static void fill(int[] arr, int val){
        for(int i = 0; i < arr.length; i++){
            arr[i] = val;
        }
    }

    

    public static void test(){
        System.out.println("Number of jumps: " + jump(new int[]{2,3,1,1,4}));
    }

    //dump the visited array
    //add another array variable to DFS that tracks the lowest number of jumps to get to each index
    //if it took more jumps to get to the array than we have in the array we break
    //else we update the array with the new lowest number of jumps
}