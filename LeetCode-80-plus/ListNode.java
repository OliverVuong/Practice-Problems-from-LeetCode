public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { 
        val = x; 
    }

    public void print(){
        ListNode myNode = this;
        System.out.println(myNode.val);
        while(myNode.next != null){
            
            System.out.println(myNode.next.val);
            myNode = myNode.next;
        }
    }

    public static void print(ListNode head){
        System.out.print(head.val + " ");
        while(head.next != null){
            System.out.print(head.next.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}