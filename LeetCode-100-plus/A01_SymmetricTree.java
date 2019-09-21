public class A01_SymmetricTree{
    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return recursionHelper(root.left, root.right);
    }

    public static boolean recursionHelper(TreeNode q, TreeNode p){

        if(q == null && p == null) return true;
        if(q != null && p == null) return false;
        if(q == null && p != null) return false;

        return recursionHelper(q.left, p.right) && recursionHelper(q.right,p.left);
    }
}