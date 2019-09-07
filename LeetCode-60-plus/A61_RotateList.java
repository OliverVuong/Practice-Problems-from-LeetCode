public class A61_RotateList{

    public static ListNode rotateRight(ListNode head, int k) {

        if(head == null) return head;
        
        int len = getLength(head);
        int newTailIndex = getNewTailIndex(len, k);
        ListNode tail = getTail(head);

        //remap tail;
        tail.next = head;

        //get a pointer to the newTail node
        ListNode newTail = head;
        for(int i = 0; i < newTailIndex; i++){
            newTail = newTail.next;
        }

        //get a pointer to the newHead
        ListNode newHead = newTail.next;

        //remap newTail.next
        newTail.next =  null;
        
        return newHead;
    }

    public static int getLength(ListNode head){
        int len = 1;
        ListNode iterator = head;

        while(iterator.next != null){
            iterator = iterator.next;
            len++;
        }

        return len;
    }

    public static ListNode getTail(ListNode head){
        ListNode iterator = head;
        while(iterator.next != null){
            iterator = iterator.next;
        }
        return iterator;
    }

    //returns the index of the node that would be the end of the
    //list after the shift   1 2 3 4 5 
    public static int getNewTailIndex(int length, int shift){
        return length - 1 - (shift % length);
    }

    public static void test(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = rotateRight(head, 6);

        print(head);
    }

    public static void print(ListNode head){
        System.out.print(head.val + " ");
        while(head.next != null){
            System.out.print(head.next.val + " ");
            head = head.next;
        }
    }

}