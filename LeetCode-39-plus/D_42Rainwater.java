public class D_42Rainwater{
    public static int trap(int[] height) {
        int trappedWater = 0;

        for(int index = 1; index < height.length - 1; index++){

            int rightMax = 0;
            for(int rightRunner = index+1; rightRunner<height.length; rightRunner++){
                if(height[rightRunner] > rightMax){
                    rightMax = height[rightRunner];
                }
            }

            int leftMax = 0;
            for(int leftRunner = 0; leftRunner<index; leftRunner++){
                if(height[leftRunner] > leftMax){
                    leftMax = height[leftRunner];
                }
            }

            int min = rightMax < leftMax ? rightMax : leftMax;
            if (min > height[index]){
                trappedWater += min - height[index];
            }
        }

        return trappedWater;
    }

    //defunct
    public static int getTrappedWaterLeftToRight(int[] height){

        int trappedWater = 0;
        int potentialWater = 0;

        for(int leftBound = 0; leftBound < height.length - 2; leftBound++){

            for(int rightBound = leftBound + 1; rightBound < height.length; rightBound++){

                if (height[rightBound] > height[leftBound]){
                    leftBound = rightBound - 1;
                    trappedWater += potentialWater;
                    potentialWater = 0;
                    break;
                } else {
                    potentialWater += height[leftBound] - height[rightBound];
                }
            }
        }

        return trappedWater;
    }
    //defunct
    public static int getTrappedWaterRightToLeft(int[] height){

        int trappedWater = 0;
        int potentialWater = 0;

        for(int rightBound = height.length - 1; rightBound > 1; rightBound--){

            for(int leftBound = rightBound - 1; leftBound >= 0; leftBound--){

                if (height[leftBound] >= height[rightBound]){
                    rightBound = leftBound + 1;
                    trappedWater += potentialWater;
                    potentialWater = 0;
                    break;
                } else {
                    potentialWater += height[rightBound] - height[leftBound];
                }
            }
        }
        return trappedWater;
    }

    public static void test(){
        System.out.println(trap(new int[]{0,3,1,4,2,5}));
    }
}