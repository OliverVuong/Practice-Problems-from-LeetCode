public class A70_ClimbingStairs{

    public int climbStairs(int n) {

        if (n == 1) return 1;

        int[] memoization = new int[n];
        memoization[0] = 1;
        memoization[1] = 2;

        for(int i = 2; i < n; i++){
            memoization[i] = memoization[i-1] + memoization[i-2];
        }
        
        return memoization[n - 1];
    }

}