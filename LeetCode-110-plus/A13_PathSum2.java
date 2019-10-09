import java.util.List;
import java.util.ArrayList;

public class A13_PathSum2{
    
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> output = new ArrayList<>();
        traversal(root, sum, 0, output, new ArrayList<>());
        return output;
    }

    public static void traversal(TreeNode root, int sum, int partialSum, List<List<Integer>> memory, List<Integer> build)
    {
        if (root != null)
        {
            build.add(root.val);
            partialSum += root.val;

            if(root.left == null && root.right == null && partialSum == sum){
                memory.add(build);
            }

            traversal(root.left, sum, partialSum, memory, new ArrayList<>(build));
            traversal(root.right, sum, partialSum, memory, new ArrayList<>(build));
        }
    }

    public static void test(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        //root.left.left = new TreeNode(3);
        //root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(-1);
        //root.right.right = new TreeNode(6);
        print(pathSum(root, 4));
    }

    public static void print(List<List<Integer>> input){
        System.out.println("Number of Paths: " + input.size());

        for(List<Integer> list : input){
            for(int it : list){
                System.out.print(it + " ");
            }
            System.out.println();
        }
    }
}