public class ZigZagConversion{

    public static int getNextX(int x, int y, int rows){

        if (rows == 1) return x + 1;

        //if x is in a downward moving row
        if( x % (rows - 1) == 0 ) {

            //if y is not in the last row x stays the same
            if ( y < (rows-1) ){
                return x;

            //if y is in the last row x moves to the right (and y moves up)
            } else {
                return x + 1;
            }
        }
        //if x is not in a downward moving row we move right
        return x + 1;
    }

    public static int getNextY(int x, int y, int rows) {

        if (rows == 1) return 0;

        //if x is in a downward moving row
        if( x % (rows - 1) == 0 ) {

            //if y is not in the last row nextCoord moves down
            if ( y < (rows-1) ){
                return y + 1;

            //if y is in the last row nextCoord moves up and right
            } else {
                return y - 1;
            }
        }
        //if x is not in a downward moving nextCoord moves up and right
        return y - 1;
    }

    public static int howManyColumns(String s, int rows){

        if (rows == 1) return s.length();

        int columns = 0;
        int remainingLetters = s.length();

        final int repeatingPatternLength = rows - 1;
        final int lettersPerPattern = rows + rows - 2;

        columns += (remainingLetters / lettersPerPattern) * repeatingPatternLength;
        remainingLetters -= (remainingLetters / lettersPerPattern) * lettersPerPattern;
        columns += remainingLetters < rows ? 1 : 1 + remainingLetters - rows;

        return columns;
    }

    public static String convert(String s, int numRows){
        int columns = howManyColumns(s,numRows);
        char[][] arr = new char[columns][numRows];

        int oldX = 0;
        int oldY = 0;

        int newX = 0;
        int newY = 0;

        arr[newX][newY] = s.charAt(0);

        for(int i = 1; i < s.length(); i++){

            newX = getNextX(oldX, oldY, numRows);
            newY = getNextY(oldX, oldY, numRows);
            arr[newX][newY] = s.charAt(i);

            oldX = newX;
            oldY = newY;
        }

        String output = "";

        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < columns; j++){
                output += arr[j][i];
            }
        }

        return output;
    }

    public static void test(){
        /*
        System.out.println("x,y: (" + getNextX(0, 0, 4) + ", " + getNextY(0, 0, 4) + ")");
        System.out.println("x,y: (" + getNextX(0, 1, 4) + ", " + getNextY(0, 1, 4) + ")");
        System.out.println("x,y: (" + getNextX(0, 2, 4) + ", " + getNextY(0, 2, 4) + ")");
        System.out.println("x,y: (" + getNextX(0, 3, 4) + ", " + getNextY(0, 3, 4) + ")");
        System.out.println("x,y: (" + getNextX(1, 2, 4) + ", " + getNextY(1, 2, 4) + ")");
        System.out.println("x,y: (" + getNextX(2, 1, 4) + ", " + getNextY(2, 1, 4) + ")");
        System.out.println("x,y: (" + getNextX(3, 0, 4) + ", " + getNextY(3, 0, 4) + ")");
        */
        //System.out.println("Final: " + howManyColumns("PAYPALISHIRING", 3));

        System.out.println(convert("PAYPALISHIRING", 4));

    }

    /*
    public static getNextCoordinate(XYcoordinate coord, int rows){
        if(coord.x % (rows - 1) == 0){
            if(coord.y < rows){
                return XYcoordinate(x, y + 1);
            } else {
                return XYcoordinate(x + 1, 0);
            }
        } else {
            int newY = rows - (coord.x % (rows-1));
            return XYcoordinate(x + 1, newY);
        }
    }

    public class XYcoordinate{
        public int x;
        public int y;
        public XYcoordinate (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    */
}