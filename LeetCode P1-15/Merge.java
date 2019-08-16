public class Merge{
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){

        if(l1 == null && l2 == null) return null;
        else if (l1 == null && l2 != null) return l2;
        else if (l1 != null && l2 == null) return l1;

        ListNode firstNode = (l1.val < l2.val) ? l1 : l2;
        if(l1.val < l2.val){
            firstNode = l1;
            l1 = l1.next;
        } else {
            firstNode = l2;
            l2 = l2.next;
        }

        ListNode iterator = firstNode;

        while(l1 != null || l2 != null){
            if (l1 == null){
                iterator.next = l2;
                l2 = l2.next;
                iterator = iterator.next;
            } else if (l2 == null){
                iterator.next = l1;
                l1 = l1.next;
                iterator = iterator.next;
            } else {
                if(l1.val < l2.val){
                    iterator.next = l1;
                    l1 = l1.next;
                    iterator = iterator.next;
                } else {
                    iterator.next = l2;
                    l2 = l2.next;
                    iterator = iterator.next;
                }
            }
        }

        return firstNode;
    }

    public static void test(){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        ListNode mergedList = mergeTwoLists(l1,l2);

        print(mergedList);
    }

    public static void print(ListNode l1){
        while(l1 != null){
            System.out.print(l1.val + " ");
            l1 = l1.next;
        }
        System.out.println();
    }
}