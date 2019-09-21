public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    @Override
    public String toString(){return "Val: " + this.val;}

    public static void printTree(TreeNode root){
        printHelper(root);
        System.out.println();
    }

    private static void printHelper(TreeNode myNode){
        if(myNode == null) return;

        printHelper(myNode.left);
        System.out.print(myNode.val + " ");
        printHelper(myNode.right);
    }
}