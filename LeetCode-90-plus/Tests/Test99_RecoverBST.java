import org.junit.Test;
import org.junit.Before;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Integer;

public class Test99_RecoverBST{

    TreeNode root;

    @Before
    public void setUp(){
        root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(50);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(11);
    }


    @Test
    public void testInOrderTravList() {
        
        List<Integer> myList = A99_RecoverBST.inOrderTravList(root);
        assertEquals( 3, (int) myList.get(0) );
        assertEquals( 5, (int) myList.get(1) );
        assertEquals( 7, (int) myList.get(2) );
        assertEquals( 10, (int) myList.get(3) );
        assertEquals( 11, (int) myList.get(4) );
        assertEquals( 15, (int) myList.get(5) );
        assertEquals( 50, (int) myList.get(6) );
    }

    @Test
    public void testGetSwappedPair() {

        int[] myArr = new int[]{1,2,6,4,5,3,7};
        List<Integer> orderedList = new ArrayList<>();
        for(int i : myArr) orderedList.add(i);

        int[] swappedPair = A99_RecoverBST.getSwappedPair(orderedList);
        
        assertEquals( swappedPair.length, 2);
        assertEquals( 6, (int) swappedPair[0]);
        assertEquals( 3, (int) swappedPair[1]);


        int[] myArr2 = new int[]{2,1,3};
        List<Integer> orderedList2 = new ArrayList<>();
        for(int i : myArr2) orderedList2.add(i);

        int[] swappedPair2 = A99_RecoverBST.getSwappedPair(orderedList2);
        
        assertEquals( swappedPair2.length, 2);
        assertEquals( 2, (int) swappedPair2[0]);
        assertEquals( 1, (int) swappedPair2[1]);
    }

}