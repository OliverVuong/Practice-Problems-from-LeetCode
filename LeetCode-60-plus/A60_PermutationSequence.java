public class A60_PermutationSequence{

    public static String getPermutation(int n, int k) {

        //validate input
        int max = 1;
        for(int factor = n; factor > 0; factor--){
            max *= factor;
        }
        if(k > max || k <= 0) return "0";

        //create smallest permutation
        char[] permutation = new char[n];
        for(int i = 0; i < n; i++){
            permutation[i] = (char)(i + 1 + '0');
        }

        //create memory devices to save data during recursion
        int[] count = {1};
        String[] kthPermutation = {"0"};

        permutation("", new String(permutation), count, k, kthPermutation);

        return kthPermutation[0];
    }

    public static void permutation(String build, String consume, int[] count, int k, String[] kth){

        //guard: kth permutation has already been found
        if(count[0] > k) return;

        int len = consume.length();

        if(len == 0){
            if(count[0] == k){
                System.out.println(kth);
                kth[0] = build;
                System.out.println(kth);
                count[0]++;
                return;
            } else {
                count[0]++;
            }
            
        } else {

            for(int i = 0; i < len; i++){
                permutation(build + consume.charAt(i), consume.substring(0,i) + consume.substring(i+1, len), count, k, kth);
            }

        }

    }

    /*
    old section of code
        System.out.println("ct: " + count[0] + "   " + build);
        int len = consume.length();

        if(len == 0){
            if(count[0] == k){
                System.out.println("executed");
                return build;
            } else {
                System.out.printf("Branch %d finished.\n", count[0]);
                count[0]++;
            }
        } else {
            for(int i = 0; i < len; i++){
                permutation(build + consume.charAt(i), consume.substring(0,i) + consume.substring(i+1, len), count, k, kth);
            }
        }
        return "0";
    */

    public static void test(){
        System.out.println(getPermutation(4, 9));
    }

}