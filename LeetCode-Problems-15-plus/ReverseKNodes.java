import java.lang.IndexOutOfBoundsException;
import java.util.Optional;

public class ReverseKNodes{

    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        //special cases
        if (head == null) return null;
        if (head.next == null) return head;
        if (k < 1) return head;


        ListNode[] arr = new ListNode[k];
        int headIndex = 0;
        int tailIndex = k-1;

        try {
            mapToArr(arr, head);
        } catch (IndexOutOfBoundsException e){
            //list.size < k so no work is done
            return head;
        }
        ListNode output = arr[tailIndex];
        arr[headIndex].next = arr[tailIndex].next;
        reverseDirection(arr);

        ListNode newTail = arr[headIndex];  //need to remap newTail to the next group

        Optional<ListNode> next = Optional.ofNullable(arr[headIndex].next);

        while(next.isPresent()){
            try {
                mapToArr(arr, next.get());
            } catch (IndexOutOfBoundsException e){
                //remaining nodes < k so no work needs to be done
                break;
            }

            arr[headIndex].next = arr[tailIndex].next;
            reverseDirection(arr);
            newTail.next = arr[tailIndex];
            newTail = arr[headIndex];

            next = Optional.ofNullable(arr[headIndex].next);

        }
        
        
        return output;
    }

    //map k nodes to an array so they can be reversed later
    public static void mapToArr(ListNode[] arr, ListNode head){
        Optional<ListNode> iterator = Optional.of(head);
        for (int i = 0; i < arr.length; i++){
            if(iterator.isPresent()){
                arr[i] = iterator.get();
                iterator = Optional.ofNullable(iterator.get().next);
            } else {    //iterator == null
                throw new IndexOutOfBoundsException();
            }
        }
    }

    //maps every nth node to the n-1th node if there is a n-1th node
    public static void reverseDirection(ListNode[] arr){
        for (int i = arr.length - 1; i > 0; i--){
            arr[i].next = arr[i-1];
        }
    }

    public static void test(){
        ListNode myNode = new ReverseKNodes().new ListNode(1);
        myNode.next = new ReverseKNodes().new ListNode(2);
        myNode.next.next = new ReverseKNodes().new ListNode(3);
        myNode.next.next.next = new ReverseKNodes().new ListNode(4);
        myNode.next.next.next.next = new ReverseKNodes().new ListNode(5);
        myNode.next.next.next.next.next = new ReverseKNodes().new ListNode(6);
        myNode.next.next.next.next.next.next = new ReverseKNodes().new ListNode(7);
        
        print(myNode);
        System.out.println();
        print(reverseKGroup(myNode, 3));
    }

    public static void testMapToArr(){
        ListNode myNode = new ReverseKNodes().new ListNode(1);
        myNode.next = new ReverseKNodes().new ListNode(2);
        myNode.next.next = new ReverseKNodes().new ListNode(3);
        myNode.next.next.next = new ReverseKNodes().new ListNode(4);
        myNode.next.next.next.next = new ReverseKNodes().new ListNode(5);
        myNode.next.next.next.next.next = new ReverseKNodes().new ListNode(6);

        ListNode[] myArr = new ListNode[6];

        print(myNode);
        mapToArr(myArr, myNode);
        for (ListNode it : myArr){
            System.out.print(it.val + " ");
        }
        System.out.println();
        reverseDirection(myArr);
        print(myArr[5]);
    }

    public static void print(ListNode node){
        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}