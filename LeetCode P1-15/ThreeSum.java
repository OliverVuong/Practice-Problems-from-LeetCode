import java.util.*;

public class ThreeSum{

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> listOfLists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] > 0) break;
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] / 2 > -nums[j]) break;
                int inverse = -(nums[i] + nums[j]);
                int index = binarySearch(nums, inverse);
                if (index != -1 && index != i && index != j){ //index == -1 means no inverse was found
                    listOfLists.add(Arrays.asList(nums[i],nums[j],nums[index]));
                }
            }
        }

        return removeDups(listOfLists);
    }

    public static List<List<Integer>> removeDups(List<List<Integer>> input) {
        for (List<Integer> iterator : input){
            Collections.sort(iterator);
        }
        
        for ( int i = input.size() - 1; i > 0; i--){
            for (int j = i - 1; j >= 0; j--){
                if (equals(input.get(i), input.get(j))){
                    input.remove(i);
                    break;
                }
            }
        }
        return input;
    }

    public static boolean equals(List<Integer> a, List<Integer> b){
        for (int i = 0; i < a.size(); i++){
            if (a.get(i) != b.get(i)){
                return false;
            }
        }
        return true;
    }

    public static int binarySearch(int[] arr, int x){
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while(low <= high){
            mid = (high + low ) / 2;
            if (arr[mid] < x) {
                low = mid + 1;
            } else if (arr[mid] > x) {
                high = mid -1;
            } else {
                return mid;
            }
        }

        return -1;  //Error
    }

    public static void test(){
        //print(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        //print(threeSum(new int[]{-2,0,0,2,2}));
        //print(threeSum(new int[]{0,0,0}));
        //print(threeSum(new int[]{1,2,-2,-1}));
    }

    public static void print(List<List<Integer>> input){
        for(List<Integer> iterator : input){
            System.out.println(iterator);
        }
    }
}