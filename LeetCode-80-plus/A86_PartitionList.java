public class A86_PartitionList{
    public static ListNode partition(ListNode head, int x) {

        if(head == null) return head;
        
        ListNode bigHead = null;
        ListNode bigEnd = null;
        ListNode smallHead = null;
        ListNode smallEnd = null;
        ListNode iterator = head;

        //1 4 3 2 5 2
        while(iterator != null){

            //add iterator to smallList
            if (iterator.val < x){
                
                //if smallList does not exist create it
                if(smallHead == null){
                    smallHead = iterator;
                    smallEnd = iterator;
                //if smallList is only one element big
                } else if(smallHead == smallEnd){
                    smallHead.next = iterator;
                    smallEnd = iterator;
                //if smallList exist attach iterator to the end
                } else {
                    smallEnd.next = iterator;
                    smallEnd = smallEnd.next;
                }

            //add iterator to bigList
            } else {

                //if bigList does not exist create it
                if(bigHead == null){
                    bigHead = iterator;
                    bigEnd = iterator;
                //if bigList is only one element big
                } else if(bigHead == bigEnd){
                    bigHead.next = iterator;
                    bigEnd = iterator;
                //if bigList exist attach iterator to the end
                } else {
                    bigEnd.next = iterator;
                    bigEnd = bigEnd.next;
                }
            }

            iterator = iterator.next;
        }

        if (bigEnd != null) bigEnd.next = null;

        if(smallHead != null){
            smallEnd.next = bigHead;
            return smallHead;
        } else {
            return bigHead;
        }
    }

    public static void test(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        ListNode.print(head);
        System.out.println();
        ListNode.print(partition(head, 3));
    }
}