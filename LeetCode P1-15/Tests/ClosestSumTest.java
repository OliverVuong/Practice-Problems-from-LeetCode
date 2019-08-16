import org.junit.Test;
import org.junit.Before;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;

public class ClosestSumTest{


    @Test
    public void closestSumTest() {
        
        assertEquals( 1, ClosestSum.maxArea(new int[]{1,1}) );
        assertEquals( 1, ClosestSum.maxArea(new int[]{1,2}) );
        assertEquals( 1, ClosestSum.maxArea(new int[]{1,2}) );
        assertEquals( 49, ClosestSum.maxArea(new int[]{1,8,6,2,5,4,8,3,7}) );
    }

}