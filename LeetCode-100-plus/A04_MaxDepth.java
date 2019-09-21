public class A04_MaxDepth{
    public static int maxDepth(TreeNode root) {
        return getDepth(root, 0);
    }

    public static int getDepth(TreeNode root, int depth){

        if(root == null) return depth;
        if(root.left == null && root.right == null) return depth + 1;

        int leftDepth = getDepth(root.left, depth + 1);
        int rightDepth = getDepth(root.right, depth + 1);

        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }


    public static int maxDepth2(TreeNode root){
        if(root == null) return 0;
        return 1 + max(maxDepth2(root.left), maxDepth2(root.right));
    }

    public static int max(int a, int b){
        return a > b ? a : b;
    }

    public static void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        //root.right = new TreeNode(2);
        //root.left.left = new TreeNode(3);
        //root.left.right = new TreeNode(4);
        //root.right.left = new TreeNode(5);
        //root.right.right = new TreeNode(6);

        System.out.println(maxDepth2(root));
    }
}