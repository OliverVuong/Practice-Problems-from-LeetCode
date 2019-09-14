//LeetCode discussion has an efficient and interesting way to calculate the width
//for every height

public class A84_LargestRectangle{
    public static int largestRectangleArea(int[] heights) {

        int area = 0;

        for(int i = 0; i < heights.length; i++){

            int ithArea = largestRectangleArea(heights, i);
            if(ithArea > area){
                area = ithArea;
            }
        }
        return area;
    }

    //find the largest rectangle that can be made using bar height at a certain index
    //as the height
    public static int largestRectangleArea(int[] heights, int index){
        int height = heights[index];
        int width = 1;

        for(int leftSearch = index - 1; leftSearch >= 0; leftSearch--){
            if(heights[leftSearch] < height){
                break;
            }
            width++;
        }

        for(int rightSearch = index + 1; rightSearch < heights.length; rightSearch++){
            if(heights[rightSearch] < height){
                break;
            }
            width++;
        }

        return height * width;
    }

    //returns an array where the value saved at each index corresponds to the
    //index of the nearest height less than the height at the index
    public static int[] lessFromLeft(int[] heights){
        int[] output = new int[heights.length];
        output[0] = 0;

        return output;
    }

    public static void test(){
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
        /*
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}, 0));
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}, 1));
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}, 2));
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}, 3));
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}, 4));
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}, 5));
        */
    }
}