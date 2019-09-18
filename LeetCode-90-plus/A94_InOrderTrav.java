import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class A94_InOrderTrav{
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> memory = new ArrayList<>();
        searchRecursive(root, memory);
        return memory;
    }

    public static void searchRecursive(TreeNode myNode, List<Integer> memory){
        if(myNode == null) return;

        searchRecursive(myNode.left, memory);
        memory.add(myNode.val);
        searchRecursive(myNode.right, memory);
    }

    public static List<Integer> inorderIt(TreeNode root){

        List<Integer> memory = new ArrayList<>();

        //handle edge case of null input
        if(root == null) return memory;

        LinkedList<TreeNode> myQueue = new LinkedList<>();
        TreeNode iterator = root;

        while(iterator != null || !myQueue.isEmpty()){
            while(iterator != null){
                myQueue.addFirst(iterator);
                iterator = iterator.left;
            }
            iterator = myQueue.poll();
            memory.add(iterator.val);
            iterator = iterator.right;
        }

        return memory;
    }

    public static void test(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> myList = inorderIt(root);

        /*for(int i : myList){
            System.out.print(i + " ");
        }
        System.out.println();*/
    }
}