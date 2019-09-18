import java.lang.Long;
import java.util.LinkedList;

public class A98_ValidateBST{

    // Recursive method
    public static boolean isValidBST(TreeNode root) {
        return helper(root, new long[]{Long.MIN_VALUE});
    }

    public static boolean helper(TreeNode root, long[] prevVal){

        if (root == null) return true;

        return helper(root.left, prevVal) 
            && check(root, prevVal) 
            && helper(root.right, prevVal);
    }

    public static boolean check(TreeNode root, long[] prevVal){
        if(root.val <= prevVal[0]) return false;

        prevVal[0] = root.val;
        return true;
    }


    // Iterative method
    public static boolean isValidBST2(TreeNode root){
        if (root == null) return true;

        TreeNode iterator = root;
        LinkedList<TreeNode> myQueue = new LinkedList<TreeNode>();
        long prevVal = Long.MIN_VALUE;

        while(iterator != null || !myQueue.isEmpty()){

            while(iterator != null){
                myQueue.addFirst(iterator);
                iterator = iterator.left;
            }

            iterator = myQueue.poll();

            if(iterator.val <= prevVal) return false;
            else prevVal = iterator.val;

            iterator = iterator.right;
        }

        return true;
    }


    public static void test(){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        //root.left.left = new TreeNode(3);
        //root.right.right = new TreeNode(50);
        //root.getRightChild().setLeftChild(new TreeNode(13));
        //root.getRightChild().setRightChild(new TreeNode(20));

        System.out.println(isValidBST2(root));
    }
}