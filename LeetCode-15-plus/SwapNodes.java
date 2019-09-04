public class SwapNodes{
    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    public static ListNode swapPairs(ListNode head) {

        //handle special case list.length = 1
        if (head == null) return null;
        if (head.next == null) return head;

        //swap first pair
        ListNode leading = head;
        ListNode trailing = head.next;
        leading.next = trailing.next;
        trailing.next = leading;

        ListNode output = trailing;

        //move leading and trailing nodes to next pair
        try{
            leading = leading.next;
            trailing = leading.next;
        //if we catch a nullexcpt -> (unswappedNodesCount < 2) -> done
        } catch (NullPointerException e){
            return output;
        }


        //loop over rest of list
        //take care of odd number of nodes
        ListNode lagging = head;
        while(leading != null && trailing != null){
            //swap pair
            leading.next = trailing.next;
            trailing.next = leading;
            lagging.next = trailing;
            lagging = leading;
            try{
                leading = leading.next;
                trailing = leading.next;
            //if we catch a nullexcpt -> (unswappedNodesCount < 2) -> done
            } catch (NullPointerException e){
                return output;
            }
        }

        //return second node as new head of the list
        return output;
    }

    public static void test(){
        ListNode myNode = new SwapNodes().new ListNode(1);
        myNode.next = new SwapNodes().new ListNode(2);
        myNode.next.next = new SwapNodes().new ListNode(3);
        myNode.next.next.next = new SwapNodes().new ListNode(4);
        myNode.next.next.next.next = new SwapNodes().new ListNode(5);
        myNode.next.next.next.next.next = new SwapNodes().new ListNode(6);

        print(myNode);
        System.out.println();
        print(swapPairs(myNode));
        //System.out.println(swapPairs(myNode));
        //print(swapPairs(myNode));
    }

    public static void print(ListNode node){
        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}