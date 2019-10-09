import java.util.LinkedList;

public class A16_PopulateNextRight{

    public static void connect(Node root) 
    {
        Node level_start = root;
        while(level_start != null)
        {
            Node cur = level_start;
            while(cur != null){
                if(cur.left != null) cur.left.next = cur.right;
                if(cur.right != null && cur.next != null) cur.right.next = cur.next.left;
                
                cur=cur.next;
            }
            level_start=level_start.left;
        }
    }

    public static void connectPractice(Node root) 
    {
        //outside while loop iterates through all levels of the tree giving the leftmost val
        Node lvlIt = root;
        while(lvlIt != null)
        {
            //inside loop iterates through each node within a level and links all their children
            Node nodeIt = lvlIt;
            while(nodeIt != null)
            {
                if(nodeIt.left != null) nodeIt.left.next = nodeIt.right;
                    
                if(nodeIt.right != null && nodeIt.next != null) nodeIt.right.next = nodeIt.next.left;

                nodeIt = nodeIt.next;
            }

            lvlIt = lvlIt.left;
        }

    }

    public static Node connect2(Node root) {

        traverse(root);

        return root;
    }

    public static void traverse(Node root){
        if(root != null){
            System.out.println(root.val);
            connectChildren(root);
            traverse(root.left);
            traverse(root.right);
        }
    }

    public static void connectChildren(Node root){

        if(root == null) return;
        if(root.left == null) return;

        root.left.next = root.right;

        if(root.left.left == null) return;

        root.left.right.next = root.right.left;
    }

    public static Node connect3(Node root) {

        LinkedList<Node> currentRow = new LinkedList<>();
        LinkedList<Node> nextRow = new LinkedList<>();

        nextRow.addFirst(root);

        while(!nextRow.isEmpty()){

            currentRow = nextRow;
            nextRow = new LinkedList<>();

            Node myNode = currentRow.poll();
            while(!currentRow.isEmpty()){
                if(myNode.left != null) nextRow.add(myNode.left);
                if(myNode.right != null) nextRow.add(myNode.right);
                if (currentRow.peek() != null){
                    myNode.next = currentRow.peek();
                }
                myNode = currentRow.poll();
            }
        }
        return root;
    }

    public static void test(){

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);

        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);

        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);

        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        connect(root);

        //System.out.println(root.right.left.next.val == 7);
        //System.out.println(root.right.right.next == null);

        /*System.out.println(root.next == null);
        System.out.println(root.left.next.val == 3);
        System.out.println(root.right.next == null);
        System.out.println(root.left.left.next.val == 5);
        System.out.println(root.left.right.next.val == 6);
        System.out.println(root.right.left.next.val == 7);
        System.out.println(root.right.right.next == null);

        System.out.println(root.left.left.left.next.val == 9);
        System.out.println(root.left.left.right.next.val == 10);
        
        System.out.println(root.left.right.left.next.val == 11);*/
        System.out.println(root.left.right.right.next != null);
        //System.out.println(root.left.right.right.next.val == 12);
        
        //System.out.println(root.right.left.left.next.val == 13);
        //System.out.println(root.right.left.right.next.val == 14);
        
        //System.out.println(root.right.right.left.next.val == 15);
        //System.out.println(root.right.right.right.next == null);

    }
}