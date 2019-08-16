import java.util.HashSet;

public class ThreeSum2{

    //public static List<List<Integer>> threeSum(int[] nums) {
    //   HashSet<Tuple> allTuples = generateTuples(nums);
    //}

    public class Tuple{
        public int a; 
        public int b;
        public Tuple(int input1, int input2){
            if (input1 < input2){
                this.a = input1;
                this.b = input2;
            } else {
                this.a = input2;
                this.b = input1;
            }
        }
        @Override
        public boolean equals(Object object) {
            if (object == null) {
                return false;
            }
            if (getClass() != object.getClass()) {
                return false;
            }

            Tuple compared = (Tuple) object;
            if (this.a != compared.a) {
                return false;
            }
            if (this.b != compared.b) {
                return false;
            }

            return true;
        }
        public int hashCode() {
            return a * 31 + b;
        }
    }

    public class Triple{
        public int a;
        public int b;
        public int c;
        public Triple(Tuple input, int c){
            if (c < input.a){
                this.a = c;
                this.b = input.a;
                this.c = input.b;
            } else if ( c < input.b){
                this.a = input.a;
                this.b = c;
                this.c = input.b;               
            } else {
                this.a = input.a;
                this.b = input.b;
                this.c = c;
            }
        }
        @Override
        public int hashCode(){
            return this.a * 31 + this.b * 31 + this.c;
        }
    }

    public static void test(){
        Tuple myTuple = new ThreeSum2().new Tuple(10, -30);
        System.out.println(myTuple.a + " " + myTuple.b);
        Tuple myTuple2 = new ThreeSum2().new Tuple(10, -30);
        System.out.println(myTuple2.a + " " + myTuple2.b);
        System.out.println(myTuple.equals(myTuple2));
        Triple myTriple = new ThreeSum2().new Triple(myTuple, -60);
        System.out.println(myTriple.a + " " + myTriple.b + " " + myTriple.c);
    }
}