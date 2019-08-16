public class Container{
    public static int maxArea(int[] height){
        int maxArea = 0;
        for (int i = 0; i < height.length -  1; i++){
            for(int j = i + 1; j < height.length; j++){
                int area = findArea(i, j, height);
                if (area > maxArea){
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public static int findArea(int i, int j, int[] heights){
        int length = j - i;
        int lowestHeight  = heights[i] < heights[j] ? heights[i] : heights[j];
        return length * lowestHeight;
    }

    public static void test(){
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(findArea(1, 8, arr));
        System.out.println("max area: " + maxArea(arr));
    }
}