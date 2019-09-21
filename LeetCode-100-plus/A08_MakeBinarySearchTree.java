public class A08_MakeBinarySearchTree{

    public static TreeNode sortedArrayToBST(int[] nums) 
    {
        if(nums.length < 1) return null;

        TreeNode root = helper(nums, 0 , nums.length - 1);
        return root;
    }

    public static TreeNode helper(int[] nums, int start, int end)
    {
        if(start > end) return null;

        int mid = (start + end) / 2;
        TreeNode myNode = new TreeNode(nums[mid]);
        myNode.left = helper(nums, start, mid - 1);
        myNode.right = helper(nums, mid + 1, end);
        return myNode;
    }

    public static void test(){
        int[] myArr = new int[]{-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(myArr);
        System.out.println(root);
        System.out.println(root.left);
        System.out.println(root.right);
        System.out.println(root.left.right);
    }
}