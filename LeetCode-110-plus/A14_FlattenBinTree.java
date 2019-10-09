import java.util.LinkedList;

public class A14_FlattenBinTree{

    //not in the specified order
    public static void flatten(TreeNode root) {
        TreeNode end;

        while(root != null){
            if(root.left != null){
                end = getEndOfList(root);
                end.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    //end of list is the rightmost child
    //aka a right child whose parents, grandparents etc. are all right children
    public static TreeNode getEndOfList(TreeNode myNode){
        while(myNode.right != null){
            myNode = myNode.right;
        }
        return myNode;
    }

    //Runtime: 6 ms
    //Memory Usage: 40.2 MB
    public static void flatten2(TreeNode root){
        LinkedList<TreeNode> myQueue = new LinkedList<>();

        while(root != null || !myQueue.isEmpty()){
            if(root.left != null){
                if(root.right != null) myQueue.addFirst(root.right);
                root.right = root.left;
                root.left = null;
            } else if (!myQueue.isEmpty() && root.right == null){    //root.left == null
                root.right = myQueue.poll();
            }
            root = root.right;
        }
    }

    public static void test(){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        //root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        //root.right.left = new TreeNode(6);
        //root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(4);

        flatten2(root);
        while(root != null){
            if(root.left != null){
                System.out.println("not flattened");
                break;
            }
            System.out.println(root.val);
            root = root.right;
        }
        System.out.println("End of test");
    }
}