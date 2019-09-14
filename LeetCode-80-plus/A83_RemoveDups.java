public class A83_RemoveDups{

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode lastNode = head;
        ListNode pointer = head.next;

        while(pointer != null){
            if(pointer.val == lastNode.val){
                pointer = pointer.next;
            } else {
                lastNode.next = pointer;
                pointer = pointer.next;
                lastNode = lastNode.next;
            }
        }

        lastNode.next = null;

        return head;
    }

    public static void test(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);

        ListNode.print(deleteDuplicates(head));
    }

}