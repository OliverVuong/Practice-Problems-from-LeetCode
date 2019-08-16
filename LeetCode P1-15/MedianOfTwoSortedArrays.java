/*
*Find the median of the two sorted arrays. The overall run time 
*complexity should be O(log (m+n)).
*/

public class MedianOfTwoSortedArrays{
    public double findMedianSortedArraysSlow(int[] nums1, int[] nums2) {
        return 2d;
    }

    //finds two indexes, one of which has exactly n numbers that are smaller than it
    //and can be found in nums1 and nums2
    public static int[] getIndexes(int n, int[] nums1, int[] nums2){

        //invalid input
        if ( n >= nums1.length + nums2.length || n < 0) {
            return new int[] {-1,-1};
        }

        int index1 = 0;
        int index2 = 0;

        while(index1 + index2 + 1 < n){

            //deal with cases we run out of numbers in one of the arrays
            if(index1 == nums1.length - 1){
                return new int[] {nums1.length - 1, n - nums1.length};
            } else if(index2 == nums2.length - 1){
                return new int[] {n - nums2.length - 1, nums2.length};
            }

            if(nums1[index1] < nums2[index2]) {
                index1++;
            } else if(nums2[index2] < nums1[index1]){
                index2++;
            }
        }

        return new int[] {index1, index2};
    }
    /*
    public static int[] getIndexesFast(int n, int[] nums1, int[] nums2){
        //invalid input
        if ( n >= nums1.length + nums2.length || n < 0) {
            return new int[] {-1,-1};
        }

        int left1 = 0;
        int right1 = nums1.length - 1;
        int mid1 = (right1 + left1) / 2;
        int onLeft1 = 0;
        int left2 = 0;
        int right2 = nums2.length - 1;
        int mid2 = (right2 + left2) / 2;
        int onLeft2 = 0;

        while(onLeft1 + onLeft2 + 1 < n){

            //deal with cases we run out of numbers in one of the arrays
            if(index1 == nums1.length - 1){
                return new int[] {nums1.length - 1, n - nums1.length};
            } else if(index2 == nums2.length - 1){
                return new int[] {n - nums2.length - 1, nums2.length};
            }

            if(nums1[index1] < nums2[index2]) {
                index1++;
            } else if(nums2[index2] < nums1[index1]){
                index2++;
            }
        }

        return new int[] {index1, index2};
    }*/


    public static int convertIndexesToVal(int[] index, int[] arr1, int[] arr2){
        return arr1[index[0]] < arr2[index[1]] ? arr2[index[1]] : arr1[index[0]];
    }

    public static void test(){
        int onLeft = 4;
        int[] input1 = {1};
        int[] input2 = {2, 3, 4, 5, 6, 7};
        int[] myArr = getIndexes(onLeft, input1, input2);
        System.out.println("First: " + myArr[0] + ", Second: " + myArr[1]);
        System.out.println("Value that has " + onLeft + " on it's left: " + convertIndexesToVal(myArr, input1, input2));
    }
}