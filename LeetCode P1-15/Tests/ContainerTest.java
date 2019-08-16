import org.junit.Test;
import org.junit.Before;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;

public class ContainerTest{


    @Test
    public void maxWaterTest() {
        
        assertEquals( 2, Container.max(new int[]{-1,2,1,-4}, 1) );
    }

}