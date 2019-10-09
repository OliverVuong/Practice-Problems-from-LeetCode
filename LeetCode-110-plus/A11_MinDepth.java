import java.util.LinkedList;

public class A11_MinDepth{

    public static int minDepth(TreeNode root) 
    {
        if(root == null) return 0;

        LinkedList<TreeNode> currLevel = new LinkedList<>();
        LinkedList<TreeNode> nextLevel = new LinkedList<>();

        nextLevel.add(root);

        int depth = 0;

        while( !nextLevel.isEmpty() )
        {
            depth++;
            currLevel = nextLevel;
            nextLevel = new LinkedList<>();

            while( !currLevel.isEmpty() )
            {
                TreeNode myNode = currLevel.poll();
                if(myNode.left != null) nextLevel.addFirst(myNode.left);
                if(myNode.right != null) nextLevel.addFirst(myNode.right);
                if(myNode.left == null && myNode.right == null) return depth;
            }
        }
        
        return depth;
    }

    public static void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        //root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        //root.right.right = new TreeNode(6);
        System.out.println(minDepth(root));
    }
}