import java.lang.Integer;

public class MergeLists{

    public class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        if (isEmpty(lists)){
            return null;
        }

        ListNode output;
        int smallestIndex = getSmallestIndex(lists);
        output = lists[smallestIndex];
        lists[smallestIndex] = lists[smallestIndex].next;

        ListNode lastNode = output;
        while(!isEmpty(lists)){
            smallestIndex = getSmallestIndex(lists);
            lastNode.next = lists[smallestIndex];
            lastNode = lastNode.next;
            lists[smallestIndex] = lists[smallestIndex].next;
        }

        return output;
    }

    public static int getSmallestIndex(ListNode[] lists){
        int smallestVal = Integer.MAX_VALUE;
        int smallestIndex = -1;
        for(int i = 0; i < lists.length; i++){
            if (lists[i] != null && lists[i].val < smallestVal){
                smallestVal = lists[i].val;
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static boolean isEmpty(ListNode[] lists){
        for(ListNode it : lists){
            if (it != null){
                return false;
            }
        }
        return true;
    }

    public static void test(){
        ListNode myNode = new MergeLists().new ListNode(1);
        myNode.next = new MergeLists().new ListNode(4);
        myNode.next.next = new MergeLists().new ListNode(5);

        ListNode myNode2 = new MergeLists().new ListNode(1);
        myNode2.next = new MergeLists().new ListNode(3);
        myNode2.next.next = new MergeLists().new ListNode(4);

        ListNode myNode3 = new MergeLists().new ListNode(2);
        myNode3.next = new MergeLists().new ListNode(6);

        ListNode[] myArr = new ListNode[]{myNode, myNode2, myNode3};

        print(mergeKLists(myArr));
    }

    public static void print(ListNode node){
        while(node != null){
            System.out.println(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void testGetSmIndex(){
        ListNode myNode1 = new MergeLists().new ListNode(20);
        myNode1.next = new MergeLists().new ListNode(30);
        ListNode myNode2 = new MergeLists().new ListNode(10);
        myNode2.next = new MergeLists().new ListNode(13);
        ListNode[] myArr = new ListNode[]{myNode1.next.next, myNode2.next.next, myNode1.next.next, myNode2, myNode1.next};
        System.out.println(getSmallestIndex(myArr));
    }

    public static void testIsEmpty(){
        ListNode myNode1 = new MergeLists().new ListNode(2);
        myNode1.next = new MergeLists().new ListNode(3);
        ListNode myNode2 = new MergeLists().new ListNode(10);
        myNode2.next = new MergeLists().new ListNode(13);
        ListNode[] myArr = new ListNode[]{myNode1.next.next, myNode2.next.next};
        System.out.println(myArr[0] + "---------" + myArr[1]);
        System.out.println("isEmpty? : " + isEmpty(myArr));
    }
}