/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class RemoveNNode {
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode output = head;

        //partialList is size n+1 so we can map the n+1th node to the n-1th node
        ListNode[] partialList = new ListNode[n+1];
        
        //Setup partial list
        ListNode iterator = head;
        for (int i = 0; i < n+1; i++){
            partialList[i] = iterator;
            try {
                iterator = iterator.next;
            } catch (NullPointerException e) {
                //special case where head node is removed
                //removing headNode causes partialList.length > wholeList.length
                //resulting in NullPointerException during partialList setup
                return head.next;
            }
        }
        
        //Move partialList to the end of the input list
        int headIndex = 0;
        int tailIndex = getTailIndex(headIndex, n);
        while(partialList[tailIndex].next != null){
            partialList[headIndex] = partialList[tailIndex].next;
            headIndex = getNextHeadIndex(headIndex, n);
            tailIndex = getTailIndex(headIndex, n);
        }
        
        //remap nodes to skip Nth node from the end
        partialList[headIndex].next = partialList[headIndex].next.next;
        
        return output;
    }
    
    public static int getTailIndex(int headIndex, int n){
        if (headIndex == 0) return n;
        return headIndex - 1;
    }
    
    public static int getNextHeadIndex(int headIndex, int n){
        if (headIndex == n) return 0;
        return headIndex + 1;
    }

    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    public static void test(){
        ListNode myNode = new RemoveNNode().new ListNode(1);
        myNode.next = new RemoveNNode().new ListNode(2);
        myNode.next.next = new RemoveNNode().new ListNode(3);
        myNode.next.next.next = new RemoveNNode().new ListNode(4);
        myNode.next.next.next.next = new RemoveNNode().new ListNode(5);

        print(myNode);
        print(removeNthFromEnd(myNode, 5));
        //removeNthFromEnd(myNode, 4);
        //print(myNode);
    }

    public static void print(ListNode node){
        while(node != null){
            System.out.println(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}