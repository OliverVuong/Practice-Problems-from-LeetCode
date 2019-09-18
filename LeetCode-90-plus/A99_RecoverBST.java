import java.util.List;
import java.util.ArrayList;

public class A99_RecoverBST{

    //two pass constant memory solution
    //48ms 38.3mb
    public static void recoverTree(TreeNode root) {
        
        List<Integer> orderedList = inOrderTravList(root);
        int[] swappedPair = getSwappedPair(orderedList);
        fixTree(root, swappedPair);
    }

    public static List<Integer> inOrderTravList (TreeNode root){
        List<Integer> memory = new ArrayList<>();
        recursionHelper(root, memory);
        return memory;
    }

    private static void recursionHelper(TreeNode node, List<Integer> memory){
        if(node == null) return;

        recursionHelper(node.left, memory);
        memory.add(node.val);
        recursionHelper(node.right, memory);
    }

    public static int[]  getSwappedPair(List<Integer> orderedList){

        int[] swappedPair = new int[2];
        
        int i = 0;

        while(orderedList.get(i) < orderedList.get(i+1)){
            i++;
        }
        swappedPair[0] = orderedList.get(i);

        int j = i + 2;

        //handle case where list[i] was not swapped with list[i+1]
        while(j < orderedList.size()){
            if(orderedList.get(j - 1) > orderedList.get(j)){
                swappedPair[1] = orderedList.get(j);
                return swappedPair;
            }
            j++;
        }
        
        //handle case where list[i] was not swapped with list[i+1]
        swappedPair[1] = orderedList.get(i + 1);
        
        return swappedPair;
    }

    public static void fixTree(TreeNode root, int[] swappedPair){
        fixTreeHelper(root, root,swappedPair);
    }

    private static void fixTreeHelper(TreeNode root, TreeNode myNode, int[]swappedPair){

        if(myNode == null) return;

        fixTreeHelper(root, myNode.left, swappedPair);

        if(myNode.val == swappedPair[0]){
            myNode.val = swappedPair[1];
        } else if(myNode.val == swappedPair[1]){
            myNode.val = swappedPair[0];
        }
        System.out.println();

        fixTreeHelper(root, myNode.right, swappedPair);
    }


    public static void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        //root.left.left = new TreeNode(3);
        //root.right.right = new TreeNode(50);
        //root.getRightChild().setLeftChild(new TreeNode(13));
        //root.getRightChild().setRightChild(new TreeNode(20));

        TreeNode.printTree(root);
        System.out.println();
        recoverTree(root);
        System.out.println();
        TreeNode.printTree(root);

    }
}