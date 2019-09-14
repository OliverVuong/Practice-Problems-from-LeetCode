public class A82_RemoveDups2{

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode trail = fakeHead;
        ListNode pointer = head;

        while(pointer != null){
            while(pointer.next != null && pointer.val == pointer.next.val){
                pointer = pointer.next;
            }
            if(trail.next == pointer){
                trail = trail.next;
            }
            else{
                trail.next = pointer.next;
            }
            pointer = pointer.next;
        }

        return fakeHead.next;
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