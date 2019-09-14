public class A85_MaximalRect{
    public static int maximalRectangle(char[][] matrix) {

        if(matrix.length < 1 || matrix[0].length < 1) return 0;
        
        int[][] histograms = getHistograms(matrix);

        int area = 0;

        for(int[] histogram : histograms){
            int iteratorArea = largestRectangleArea(histogram);
            if(iteratorArea > area){
                area = iteratorArea;
            }
        }
        return area;
    }

    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < height.length; i++) {
            int p = i - 1;

            while (p >= 0 && height[p] >= height[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < height.length && height[p] >= height[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }

    public static int[][] getHistograms(char[][] matrix){
        int[][] histograms = new int[matrix.length][matrix[0].length];

        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                if(row > 0 && histograms[row - 1][col] > 0){
                    histograms[row][col] = histograms[row - 1][col] - 1;
                } else {
                    int height = 0;
                    int rowIt = row;
                    while(rowIt < matrix.length && matrix[rowIt][col] == '1' ){
                        height++;
                        rowIt++;
                    }
                    histograms[row][col] = height;
                }
            }
        }

        return histograms;
    }

    public static void test(){
        char[][] matrix = { {'1','0','1','0','0'},
                            {'1','0','1','1','1'},
                            {'1','1','1','1','1'},
                            {'1','0','0','1','0'}} ;
        print(getHistograms(matrix));
        System.out.println();
        System.out.println(maximalRectangle(matrix));
    }

    public static void print(int[][] matrix){
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}