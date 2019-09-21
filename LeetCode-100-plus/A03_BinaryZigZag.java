import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class A03_BinaryZigZag {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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

                TreeNode myNode;
                
                myNode = currentLevel.poll();
                if(myNode.left != null) nextLevel.add(myNode.left);
                if(myNode.right != null) nextLevel.add(myNode.right);
                
                myList.add(myNode.val);

                
            }
            
            if(output.size() % 2 == 0){
                output.add(myList);
            } else {
                output.add(reverse(myList));
            }
            
        }

        return output;
    }
    
    public static List<Integer> reverse(List<Integer> input){
        List<Integer> output = new ArrayList<>();
        for(int i = input.size() - 1; i >= 0; i--){
            output.add(input.get(i));
        }
        return output;
    }
}