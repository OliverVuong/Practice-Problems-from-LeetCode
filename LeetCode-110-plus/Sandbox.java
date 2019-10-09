public class Sandbox{
    public static void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        postorderTrav(root);
    }

    public static void postorderTrav(TreeNode root){
        if (root == null) return;

        postorderTrav(root.left);
        postorderTrav(root.right);
        System.out.println(root.val);
    }
}