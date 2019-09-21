public class A00_SameTree{
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        
        return recursionHelper(p,q);
    }

    public static boolean recursionHelper(TreeNode nodeP, TreeNode nodeQ){

        if(nodeP == null && nodeQ == null) return true;
        if(nodeP != null && nodeQ == null) return false;
        if(nodeP == null && nodeQ != null) return false;
        if(nodeP != null && nodeQ != null && nodeP.val != nodeQ.val) return false;

        return recursionHelper(nodeP.left, nodeQ.right) &&
                recursionHelper(nodeP.right, nodeQ.left);
    }
}