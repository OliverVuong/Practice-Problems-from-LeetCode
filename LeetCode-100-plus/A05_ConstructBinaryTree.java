import java.util.LinkedList;

public class A05_ConstructBinaryTree{

    /*public static TreeNode buildTree(int[] preorder, int[] inorder) {

        TreeNode root = new TreeNode(preorder[0]);

        LinkedList<TreeNode> queue = new LinkedList<>();

        TreeNode fakeParent = new TreeNode(0);

        TreeNode iterator = fakeParent;

        int preID = 0;
        int inID = 0;

        while(inID < inorder.length)
        {
            //add left child of iterator, and it's left child until we reach an
            //element that doesn't have a left child
            while(preID < preorder.length)
            {
                iterator.left = new TreeNode(preorder[preID]);
                iterator = iterator.left;
                queue.addFirst(iterator);

                preID++;
                if(preorder[preID] == inorder[inID]) { break; }
            }

            //walk back up the tree using the queue
            //stop when inorder[id] matches preorder[id]
            //that's the TreeNode that has a right child
            while(!queue.isEmpty() && queue.peek().val == inorder[inID])
            {
                iterator = queue.poll();
                inID++;
            }

            if(preID < preorder.length)
            {
                iterator.right = new TreeNode(preorder[preID]);
                preID++;
                inID++;
            }
        }

        return fakeParent.left;
        
    }*/

    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        //if(preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode current = root;

        int preID = 1;
        int inID = 0;

        boolean walkDown = true;

        LinkedList<TreeNode> parentQueue = new LinkedList<>();
        parentQueue.add(current);


        while (preID < preorder.length || inID < inorder.length){
            // add left children
            while(walkDown){

                if(preorder[preID] == inorder[inID]) walkDown = false;

                current.left = new TreeNode(preorder[preID]);
                current = current.left;
                parentQueue.add(current);
                preID++;
            }

            System.out.printf("inID: %d, preID: %d\n", inID, preID);

            // find correct place and insert right child
            while(!walkDown){

                if(parentQueue.isEmpty() || inID >= inorder.length) break;

                if(inorder[inID + 1] == preorder[preID]){
                    current.right = new TreeNode(inorder[inID + 1]);
                    inID++;
                    current = current.right;
                    parentQueue.pollLast();
                    walkDown = true;
                } else {
                    parentQueue.pollLast();
                    current = parentQueue.peekLast();
                    inID++;
                }
            }

            if(preID == preorder.length && preorder[preID] == inorder[inID - 1]) { 
                break;
            }
        }

        

        return root;
    }

    public static TreeNode buildTree3(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        popChildNodes(root, preorder, inorder, 1, 0);
        return root;
    }

    public static void popChildNodes(TreeNode parent, int[] preorder, int[] inorder, int preStart, int inStart){

    }
    
    public static void test(){
        int[] preorder = {1,2,3,4,5};
        int[] inorder = {4,3,5,2,1};
        TreeNode root = buildTree2(preorder,inorder);
        System.out.printf("Expect 1: %d\n", root.val);
        System.out.printf("Expect 2: %d\n", root.left.val);
        System.out.printf("Expect 3: %d\n", root.left.left.val);
        System.out.printf("Expect 4: %d\n", root.left.left.left.val);
        System.out.printf("Expect 5: %d\n", root.left.left.right.val);

        //System.out.printf("Expect true: %b\n", root.left != null);
        //System.out.printf("Expect true: %b\n", root.left.left == null);
        //System.out.printf("Expect 20: %d\n", root.right.val);
        
        //System.out.printf("Expect true: %b\n", root.right.left != null);
        //System.out.printf("Expect 20: %d\n", root.right.left.val);
    }
}