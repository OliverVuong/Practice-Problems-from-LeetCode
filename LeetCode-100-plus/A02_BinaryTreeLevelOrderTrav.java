import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class A02_BinaryTreeLevelOrderTrav{
    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> output = new ArrayList<List<Integer>>();

        if (root == null) return output;

        LinkedList<TreeNode> currentLevel = new LinkedList<>();
        LinkedList<TreeNode> nextLevel = new LinkedList<>();
        
        nextLevel.addFirst(root);

        while(!nextLevel.isEmpty()){

            currentLevel = nextLevel;
            nextLevel = new LinkedList<>();
            List<Integer> myList = new ArrayList<>();

            while(!currentLevel.isEmpty()){

                TreeNode myNode = currentLevel.poll();
                myList.add(myNode.val);

                if(myNode.left != null) nextLevel.add(myNode.left);
                if(myNode.right != null) nextLevel.add(myNode.right);
            }

            output.add(myList);
        }

        return output;
    }

    public static void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        for(List<Integer> level : levelOrder(root)){
            for(int val : level){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}