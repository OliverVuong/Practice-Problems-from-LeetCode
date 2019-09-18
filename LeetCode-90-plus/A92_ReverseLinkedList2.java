public class A92_ReverseLinkedList2{

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        if(m == n) return head;
        if(m == 1) return reverseUpTo(head, n);

        ListNode iterator = head;
        int count = 1;
        while(count < m - 1){
            iterator = iterator.next;
            count++;
        }
        iterator.next = reverseUpTo(iterator.next, n - m + 1);
        return head;
    }

    public static ListNode reverseUpTo(ListNode head, int i){

        if(i == 1) return head;
        if(head == null) return head;
        ListNode iterator = head;
        if(iterator.next == null) return head;
        
        ListNode nextNode = iterator.next;
        if(nextNode.next == null){
            nextNode.next = head;
            head.next = null;
            return nextNode;
        }

        ListNode nextNextNode = nextNode.next;

        int count = 1;
        
        while(nextNextNode != null && count < i){
            nextNode.next = iterator;
            iterator = nextNode;
            nextNode = nextNextNode;
            nextNextNode = nextNextNode.next;
            count++;
        }

        //handle edge case where i == list.length
        if(count < i){
            nextNode.next = iterator;
            head.next = null;
            return nextNode;
        }

        head.next = nextNode;

        return iterator;
    }

    public static ListNode reverseList(ListNode head) {

        if(head == null) return head;
        ListNode iterator = head;
        if(iterator.next == null) return head;
        
        ListNode nextNode = iterator.next;
        if(nextNode.next == null){
            nextNode.next = head;
            head.next = null;
            return nextNode;
        }

        ListNode nextNextNode = nextNode.next;
        
        while(nextNextNode != null){
            nextNode.next = iterator;
            iterator = nextNode;
            nextNode = nextNextNode;
            nextNextNode = nextNextNode.next;
        }

        nextNode.next = iterator;
        head.next = null;

        return nextNode;
    }

    public static void test(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode.print(head);

        //ListNode.print(reverseUpTo(head, 3));

        ListNode.print(reverseBetween(head, 3, 4));
    }
}