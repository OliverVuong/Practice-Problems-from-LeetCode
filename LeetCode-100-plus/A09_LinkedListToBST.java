public class A09_LinkedListToBST{

    public static TreeNode sortedListToBST(ListNode head) 
    {
        int len = getLength(head);
        if(len < 1) return null;

        TreeNode root = helper(head, 0 , len - 1);
        return root;
    }

    public static TreeNode helper(ListNode head, int start, int end)
    {
        if(start > end) return null;

        int mid = (start + end) / 2;
        TreeNode myNode = new TreeNode(getIthNode(head, mid).val);
        myNode.left = helper(head, start, mid - 1);
        myNode.right = helper(head, mid + 1, end);
        return myNode;
    }

    public static int getLength(ListNode head){
        int len = 0;
        ListNode iterator = head;
        while(iterator != null){
            len++;
            iterator = iterator.next;
        }
        return len;
    }

    public static ListNode getIthNode(ListNode head, int i){
        ListNode iterator = head;
        while(i > 0){
            i--;
            iterator = iterator.next;
        }
        return iterator;
    }

    public static TreeNode sortedArrayToBST2(ListNode head) 
    {
        return sortedArrayToBST2(convert(head));
    }    
    
    public static TreeNode sortedArrayToBST2(int[] nums) 
    {
        if(nums.length < 1) return null;

        TreeNode root = helper2(nums, 0 , nums.length - 1);
        return root;
    }

    public static TreeNode helper2(int[] nums, int start, int end)
    {
        if(start > end) return null;

        int mid = (start + end) / 2;
        TreeNode myNode = new TreeNode(nums[mid]);
        myNode.left = helper2(nums, start, mid - 1);
        myNode.right = helper2(nums, mid + 1, end);
        return myNode;
    }

    public static int[] convert(ListNode head)
    {
        int len = getLength(head);
        int[] output = new int[len];
        ListNode iterator = head;

        for(int i = 0; i < len; i++){
            output[i] = iterator.val;
            iterator = iterator.next;
        }

        return output;
    }

    public static void test(){
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        System.out.println(getIthNode(head, 0));

        //TreeNode head = sortedListToBST(head);
        //System.out.println(head);
        //System.out.println(head.left);
        //System.out.println(head.right);
        //System.out.println(head.left.right);
    }
}