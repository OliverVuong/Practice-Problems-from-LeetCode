import org.junit.Test;
import org.junit.Before;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;

public class LongestPalindromeTest{


    @Test
    public void longestPalindrome() {
        
        assertEquals( "bab", LongestPalindrome.longestPalindrome("babda") );
        assertEquals( "bb", LongestPalindrome.longestPalindrome("cbbd") );
    }

}