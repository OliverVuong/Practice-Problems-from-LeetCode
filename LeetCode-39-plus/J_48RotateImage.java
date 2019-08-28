public class J_48RotateImage{
    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        int verticalCutOff = len / 2;
        int horizontalCutOff = (len % 2 == 0) ? len / 2 : len / 2 + 1;

        for(int row = 0; row < verticalCutOff; row++){
            for(int col = 0; col < horizontalCutOff; col++){

                //save top left value for later
                int temp = matrix[row][col];

                //move bottom left val to top left
                matrix[row][col] = matrix[len - 1 - col][row];

                //move bottom right val to bottom left
                matrix[len - 1 - col][row] = matrix[len - 1 - row][len - 1 - col];

                //move top right val to bottom right
                matrix[len - 1 - row][len - 1 - col] = matrix[col][len - 1 - row];

                //move *saved* top left val to top right
                matrix[col][len - 1 - row] = temp;
            }
        }
    }

    public static void test(){
        /*int[][] matrix = {{10,11,12,13},
                          {14,15,16,17},
                          {18,19,20,21},
                          {22,23,24,25}};*/
        int[][] matrix = {{1,2,3},
                          {4,5,6},
                          {7,8,9}};
        print(matrix);
        rotate(matrix);
        System.out.println();
        print(matrix);
    }

    public static void print(int[][] input){
        for(int row = 0; row < input.length; row++){
            for(int col = 0; col < input.length; col++){
                System.out.print(input[row][col] + " ");
            }
            System.out.println();
        }
    }
}