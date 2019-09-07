import org.junit.Test;
import org.junit.Before;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;

public class Test61_RotateList{

    //Set up
    ListNode head1;
    ListNode head2;
    ListNode head3;
    ListNode head4;
    

    @Before
    public void setUp(){
        head1 = new ListNode(1);

        head2 = new ListNode(1);
        head2.next = new ListNode(2);

        head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(3);

        head4 = new ListNode(1);
        head4.next = new ListNode(2);
        head4.next.next = new ListNode(3);
        head4.next.next.next = new ListNode(4);
        head4.next.next.next.next = new ListNode(5);
    }


    @Test
    public void testGetLength() {
        assertEquals(A61_RotateList.getLength(head1), 1);
        assertEquals(A61_RotateList.getLength(head2), 2);
        assertEquals(A61_RotateList.getLength(head3), 3);
        assertEquals(A61_RotateList.getLength(head4), 5);

        //assertThat(A61_RotateList.getLength(head1), is(1));
    }

    @Test
    public void testGetNewTailIndex(){
        // 1
        assertEquals(A61_RotateList.getNewTailIndex(A61_RotateList.getLength(head1), 1), 0);
        assertEquals(A61_RotateList.getNewTailIndex(A61_RotateList.getLength(head1), 3), 0);

        // 1 2
        assertEquals(A61_RotateList.getNewTailIndex(A61_RotateList.getLength(head2), 0), 1);
        assertEquals(A61_RotateList.getNewTailIndex(A61_RotateList.getLength(head2), 1), 0);
        assertEquals(A61_RotateList.getNewTailIndex(A61_RotateList.getLength(head2), 2), 1);

        // 1 2 3 
        assertEquals(A61_RotateList.getNewTailIndex(A61_RotateList.getLength(head3), 0), 2);
        assertEquals(A61_RotateList.getNewTailIndex(A61_RotateList.getLength(head3), 1), 1);
        assertEquals(A61_RotateList.getNewTailIndex(A61_RotateList.getLength(head3), 2), 0);
        assertEquals(A61_RotateList.getNewTailIndex(A61_RotateList.getLength(head3), 5), 0);

        // 1 2 3 4 5 
        assertEquals(A61_RotateList.getNewTailIndex(A61_RotateList.getLength(head4), 0), 1);
        assertEquals(A61_RotateList.getNewTailIndex(A61_RotateList.getLength(head4), 1), 0);
        assertEquals(A61_RotateList.getNewTailIndex(A61_RotateList.getLength(head4), 2), 1);

    }

}