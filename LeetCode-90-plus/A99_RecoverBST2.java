import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

//one pass iterative solution attempt
//constant space one pass recursive solution attempt

public class A99_RecoverBST2{


    //Runtime: 25 ms
    //Memory Usage: 35.8 MB
    public static void recoverTree(TreeNode root) {
        
        LinkedList<TreeNode> myQueue = new LinkedList<>();
        TreeNode iterator = root;
        TreeNode prev = null;
        TreeNode firstSwapped = null;
        TreeNode afterFirstSwapped = null;
        TreeNode secondSwapped = null;

        boolean foundFirst = false;

        while(iterator != null || !myQueue.isEmpty()){
            while(iterator != null){
                myQueue.addFirst(iterator);
                iterator = iterator.left;
            }
            iterator = myQueue.poll();

            ////////Testing
            System.out.println("Iterator val: " + iterator.val);
            if(prev != null) System.out.println(prev.val); else System.out.println("no prev");
            System.out.println();


            if(prev != null)
            {
                //searching for first out of place value
                //save the node that comes immediately after the first out of place val in an inorder traversal order
                //we do this because two adjacent nodes being swapped is a special case
                if(!foundFirst && prev.val > iterator.val ){
                    firstSwapped = prev;
                    afterFirstSwapped = iterator;
                    foundFirst = true;
                    System.out.println("firstSwapped: " + firstSwapped.val);
                    System.out.println("afterFirstSwapped: " + afterFirstSwapped.val + "\n");
  
                //search for second out of place val
                } else if (prev.val > iterator.val){
                    secondSwapped = iterator;
                    System.out.println("secondSwapped: " + secondSwapped.val + "\n");
                    break;
                }
            }
            prev = iterator;

            iterator = iterator.right;
        }

        int temp = firstSwapped.val;
        firstSwapped.val = secondSwapped == null ? afterFirstSwapped.val : secondSwapped.val;

        if (secondSwapped == null){
            afterFirstSwapped.val = temp;
        } else {
            secondSwapped.val = temp;
        }
    }

    //Runtime: 24 ms
    //Memory Usage: 37.5 MB
    public static void recoverTreeRecursion(TreeNode root) {

        //memory[0] = prev, 1 = firstSwapped, 2 = afterFirstSwapped, 3 = secondSwapped
        TreeNode[] memory = new TreeNode[4];

        //index table
        int prev = 0;
        int firstSwap = 1;
        int afterFirstSwap = 2;
        int secondSwap = 3;

        recursion(root, memory);

        int temp = memory[firstSwap].val;

        if (memory[secondSwap] == null){
            memory[firstSwap].val = memory[afterFirstSwap].val;
            memory[afterFirstSwap].val = temp;
        } else {
            memory[firstSwap].val = memory[secondSwap].val;
            memory[secondSwap].val = temp;
        }
    }

    public static void recursion(TreeNode iterator, TreeNode[] memory){

        //index table
        int prev = 0;
        int firstSwap = 1;
        int afterFirstSwap = 2;
        int secondSwap = 3;

        if(iterator != null)
        {
            recursion(iterator.left, memory);

            if(memory[prev] != null)
            {
                //searching for first out of place value
                //save the node that comes immediately after the first out of place val in an inorder traversal order
                //we do this because two adjacent nodes being swapped is a special case
                if(memory[firstSwap] == null && memory[prev].val > iterator.val ){
                    memory[firstSwap] = memory[prev];
                    memory[afterFirstSwap] = iterator;
  
                //search for second out of place val
                } else if (memory[prev].val > iterator.val){
                    memory[secondSwap] = iterator;
                    return;
                }
            }
            memory[prev] = iterator;

            recursion(iterator.right, memory);
        }
    }

    public static void test(){
        //3 2 1 4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);


        //root.right = new TreeNode(3);
        //root.right.right = new TreeNode(4);
        //root.right.right.right = new TreeNode(5);
        //root.right.right.right.right = new TreeNode(6);

        TreeNode.printTree(root);
        System.out.println();
        recoverTreeRecursion(root);
        System.out.println();
        TreeNode.printTree(root);

    }
}