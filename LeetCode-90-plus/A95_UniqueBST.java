import java.util.List;
import java.util.ArrayList;

public class A95_UniqueBST{

    //Brute force approach
    //generate all possible orders that values can be added to a BST
    //write a function that checks if two trees are identical
    //get rid of duplicates

    //more efficient approach
    // 1 generate all possible distinct base trees
    // 2 call a recursive function on each base tree
    //      3 this recursive function should:
    //      4 for each tree find all valid leftChild vals including null and generate each
    //      5 for each tree find all valid rightChild vals including null and generate each
    // 6 call the recursive function on each child
    public static List<TreeNode> generateTrees(int n) {
        return new ArrayList<>();
    }

    public static void helper(int start, int end, List<TreeNode> memory){

    }

}