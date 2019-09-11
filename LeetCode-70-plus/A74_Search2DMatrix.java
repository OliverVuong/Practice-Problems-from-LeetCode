public class A74_Search2DMatrix{
    public static boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length < 1 || matrix[0].length < 1) return false;

        //use binary search to find correct row
        int low = 0;
        int high = matrix.length - 1;
        int mid = (high + low) / 2;

        while(low <= high){
            mid = (high + low) / 2;
            if(matrix[mid][0] == target){
                return true;
            } else if(matrix[mid][0] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if(matrix[mid][0] < target){
            return searchArray(matrix[mid], target);
        } else if(mid > 0){
            return searchArray(matrix[mid - 1], target);
        } else {
            return false;
        }

    }

    public static boolean searchArray(int[] arr, int target){

        if(arr.length < 1) return false;

        int low = 0;
        int high = arr.length - 1;
        int mid = (high + low) / 2;

        while(high >= low){
            mid = (high + low) / 2;
            if(arr[mid] == target){
                return true;
            } else if(arr[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    public static void test(){
        /*int[][] myMatrix = {{1,   3,  5,  7},
                            {10, 11, 16, 20},
                            {23, 30, 34, 50}};*/

        int[][] myMatrix = {{1}};
        System.out.println(searchMatrix(myMatrix, 2));
    }
}