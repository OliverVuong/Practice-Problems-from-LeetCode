public class A12_PathSum{

    public static boolean hasPathSum(TreeNode root, int sum) 
    {
        return traverseAndSum(root,sum);
    }

    //traverses the tree using in order traversal
    //as it traverses it adds the parents sum to their children
    public static boolean traverseAndSum(TreeNode myNode, int sum){

        if(myNode != null) {

            updateChildren(myNode);

            //check if node has children
            if(myNode.left == null && myNode.right == null){
                if(myNode.val == sum) return true;
                else return false;
            }

            return traverseAndSum(myNode.left, sum) || traverseAndSum(myNode.right, sum);
        }

        return false;
    }

    public static void updateChildren(TreeNode myNode){
        if(myNode.left != null) myNode.left.val += myNode.val;
        if(myNode.right != null) myNode.right.val += myNode.val;
    }

    public static void test(){
        TreeNode root = new TreeNode(3);
        //root.left = new TreeNode(1);
        //root.right = new TreeNode(2);
        //root.left.left = new TreeNode(3);
        //root.left.right = new TreeNode(4);
        //root.right.left = new TreeNode(5);
        //root.right.right = new TreeNode(6);
        System.out.println(hasPathSum(root, 3));
    }
}