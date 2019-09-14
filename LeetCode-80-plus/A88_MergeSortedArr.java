public class A88_MergeSortedArr{
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        
        //convert arr lengths to represent last indexes
        m--;
        n--;
        int writeIdx = nums1.length - 1;

        while(writeIdx > m){
            if(nums1[m] > nums2[n]){
                nums1[writeIdx] = nums1[m];
                m--;
            } else {
                nums1[writeIdx] = nums2[n];
                n--;
            }
            writeIdx--;
        }
    }

    public static void test(){
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
        print(nums1);
    }

    public static void print(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}