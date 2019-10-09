public class A10_BalancedBinTree{
    public static boolean isBalanced(TreeNode root) {

        if( root == null) return true;

        int diff = getHeight(root.left) - getHeight(root.right);
        if ( diff > 1 || diff < -1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);   
    }

    public static int getHeight(TreeNode root)
    {
        if (root == null) return 0;
        
        return 1 + (getHeight(root.left) > getHeight(root.right) ? getHeight(root.left) : getHeight(root.right));
    }

    public static boolean isBalancedEfficient(TreeNode root){
        if(root != null){
            isBalancedEfficient(root.left);
            isBalancedEfficient(root.right);
            
        }
    }

    public static void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        //root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        //root.left.right = new TreeNode(4);
        //root.right.left = new TreeNode(5);
        //root.right.right = new TreeNode(6);
        System.out.println(isBalanced(root));
    }
}