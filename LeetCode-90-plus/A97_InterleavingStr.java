public class A97_InterleavingStr{
    public static boolean isInterleave(String s1, String s2, String s3) {

        //edge cases
        if(s1.length() == 0 && s2.length() == 0 && s3.length() == 0) return true;
        if(s1.length() + s2.length() != s3.length()) return false;

        return helper(s1, s2, s3, 0, 0, 0);
        
    }

    public static boolean helper(String s1, String s2, String s3, int idx1, int idx2, int idx3){

        //every char in s3 has been accounted for
        if(idx3 == s3.length()) return true;

        //Path 1
        //the char in s3 at idx3 can come from either s1 or s2 -> open two paths
        if (idx1 < s1.length() &&
            idx2 < s2.length() &&
            s1.charAt(idx1) == s3.charAt(idx3) && 
            s2.charAt(idx2) == s3.charAt(idx3))
        {
            return helper(s1,s2,s3,idx1 + 1, idx2, idx3 + 1) ||
                   helper(s1,s2,s3,idx1, idx2 + 1, idx3 + 1);
        }

        //Path 2
        //the char in s3 at idx3 can come from only s1
        //otherwise Path 1 would have been executed
        if (idx1 < s1.length() && 
            s1.charAt(idx1) == s3.charAt(idx3)) {
            return helper(s1,s2,s3,idx1 + 1, idx2, idx3 + 1);
        }

        //Path 3
        //the char in s3 at idx3 can come from only s2
        //otherwise Path 2 would have been executed
        if (idx2 < s2.length() && 
            s2.charAt(idx2) == s3.charAt(idx3)) {
            return helper(s1,s2,s3,idx1, idx2 + 1, idx3 + 1);
        }

        return false;
    }

    public static void test(){
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));

    }

}