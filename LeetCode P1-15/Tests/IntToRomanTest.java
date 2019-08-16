import org.junit.Test;
import org.junit.Before;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;

public class IntToRomanTest{


    @Test
    public void intToRomanTest() {
        
        assertEquals( "III", IntToRoman.intToRoman(3) );
        assertEquals( "IV", IntToRoman.intToRoman(4) );
        assertEquals( "IX", IntToRoman.intToRoman(9) );
        assertEquals( "LVIII", IntToRoman.intToRoman(58) );
        assertEquals( "MCMXCIV", IntToRoman.intToRoman(1994) );
    }

}