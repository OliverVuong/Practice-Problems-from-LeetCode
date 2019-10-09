public class A17_PopulateNextRight2{
    public static Node connect(Node root) {

        //outside while loop iterates through all levels of tree
        Node lvlIt = root;
        while(lvlIt != null)
        {
            //inside loop iterates through each node within a level
            //links all their children
            Node parentIt = lvlIt;
            Node childIt = new Node(-1);
            while(parentIt != null)
            {
                if(parentIt.left != null && parentIt.right == null){
                    childIt.next = parentIt.left;
                    childIt = parentIt.left;
                } else if(parentIt.left == null && parentIt.right != null) {
                    childIt.next = parentIt.right;
                    childIt = parentIt.right;
                } else if(parentIt.left != null && parentIt.right != null) {
                    childIt.next = parentIt.left;
                    parentIt.left.next = parentIt.right;
                    childIt = parentIt.right;
                }

                parentIt = parentIt.next;
            }

            //get leftmost node on next level
            while(lvlIt != null){
                    
                if(lvlIt.left != null) {
                    lvlIt = lvlIt.left;
                    break;
                }
                else if(lvlIt.right != null) {
                    lvlIt = lvlIt.right;
                    break;
                }

                lvlIt = lvlIt.next;
            }
            
        }
        return root;
    }

    public static void test(){

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);

        //root.left.left = new Node(4);
        root.left.right = new Node(3);

        root.right.left = new Node(6);
        root.right.right = new Node(8);

        //root.left.left.left = new Node(8);
        //root.left.left.right = new Node(9);

        root.left.right.left = new Node(4);
        //root.left.right.right = new Node(11);

        root.right.left.left = new Node(7);
        //root.right.left.right = new Node(13);

        //root.right.right.left = new Node(14);
        //root.right.right.right = new Node(15);

        connect(root);

        System.out.println("reached");
        //System.out.println(root.right.left.next.val == 7);
    }
}