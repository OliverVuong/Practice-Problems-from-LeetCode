import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;

public class Test51_NQueens{

    //Set up
    char[][] emptyBoard1x1 = B51_NQueens.setUpEmptyBoard(1);
    char[][] emptyBoard5x5 = B51_NQueens.setUpEmptyBoard(5);
    char[][] board1 = createBoard1();
    char[][] board2 = createBoard2();
    char[][] board3 = createBoard3();
    char[][] board4 = createBoard4();
    char[][] board5 = createBoard5();

    @Test
    public void testGetQueenCount() {
        assertEquals(B51_NQueens.getQueenCount(emptyBoard1x1), 0);
        assertEquals(B51_NQueens.getQueenCount(emptyBoard5x5), 0);
        assertEquals(B51_NQueens.getQueenCount(board1), 2);
        assertEquals(B51_NQueens.getQueenCount(board2), 3);
        assertEquals(B51_NQueens.getQueenCount(board3), 3);
        assertEquals(B51_NQueens.getQueenCount(board4), 3);
        assertEquals(B51_NQueens.getQueenCount(board5), 8);
        //assertThat(B51_NQueens.getQueenCount(board2), is(3));
    }

    @Test
    public void testValidRows(){
        assertTrue(B51_NQueens.validRows(emptyBoard1x1));
        assertTrue(B51_NQueens.validRows(emptyBoard5x5));
        assertTrue(B51_NQueens.validRows(board1));
        assertTrue(B51_NQueens.validRows(board2));
        assertFalse(B51_NQueens.validRows(board3));
        assertTrue(B51_NQueens.validRows(board4));
        assertTrue(B51_NQueens.validRows(board5));
    }

    @Test
    public void testValidCols(){
        assertTrue(B51_NQueens.validCols(emptyBoard1x1));
        assertTrue(B51_NQueens.validCols(emptyBoard5x5));
        assertTrue(B51_NQueens.validCols(board1));
        assertFalse(B51_NQueens.validCols(board2));
        assertTrue(B51_NQueens.validCols(board3));
        assertTrue(B51_NQueens.validCols(board4));
        assertTrue(B51_NQueens.validCols(board5));
    }

    @Test
    public void testValidDiagonals(){
        assertTrue(B51_NQueens.validDiagonals(emptyBoard1x1));
        assertTrue(B51_NQueens.validDiagonals(emptyBoard5x5));
        assertFalse(B51_NQueens.validDiagonals(board1));
        assertFalse(B51_NQueens.validDiagonals(board2));
        assertFalse(B51_NQueens.validDiagonals(board3));
        assertFalse(B51_NQueens.validDiagonals(board4));
        assertTrue(B51_NQueens.validDiagonals(board5));
    }
    

    @Test
    public void testIsPotentiallyValid(){
        assertTrue(B51_NQueens.isPotentiallyValid(emptyBoard1x1));
        assertTrue(B51_NQueens.isPotentiallyValid(emptyBoard5x5));
        assertFalse(B51_NQueens.isPotentiallyValid(board1));
        assertFalse(B51_NQueens.isPotentiallyValid(board2));
        assertFalse(B51_NQueens.isPotentiallyValid(board3));
        assertFalse(B51_NQueens.isPotentiallyValid(board4));
        assertTrue(B51_NQueens.isPotentiallyValid(board5));
    }

    public static char[][] createBoard1(){
        char[][] board1 = B51_NQueens.setUpEmptyBoard(3);
        board1[0][0] = 'Q';
        board1[1][1] = 'Q';
        //xoo
        //oxo
        //ooo
        return board1;
    }

    public static char[][] createBoard2(){
        char[][] board2 = B51_NQueens.setUpEmptyBoard(4);
        board2[0][0] = 'Q';
        board2[2][0] = 'Q';
        board2[3][1] = 'Q';
        //xooo
        //oooo
        //xooo
        //oxoo
        return board2;
    }

    public static char[][] createBoard3(){
        char[][] board3 = B51_NQueens.setUpEmptyBoard(4);
        board3[0][0] = 'Q';
        board3[2][1] = 'Q';
        board3[2][2] = 'Q';
        //xooo
        //oooo
        //oxxo
        //oooo
        return board3;
    }
    
    public static char[][] createBoard4(){
        char[][] board4 = B51_NQueens.setUpEmptyBoard(4);
        board4[0][3] = 'Q';
        board4[1][2] = 'Q';
        board4[2][1] = 'Q';
        //ooox
        //ooxo
        //oxoo
        //oooo
        return board4;
    }

    public static char[][] createBoard5(){
        char[][] board5 = B51_NQueens.setUpEmptyBoard(8);
        board5[0][3] = 'Q';
        board5[1][6] = 'Q';
        board5[2][2] = 'Q';
        board5[3][7] = 'Q';
        board5[4][1] = 'Q';
        board5[5][4] = 'Q';
        board5[6][0] = 'Q';
        board5[7][5] = 'Q';
        
        //o o o x o o o o
        //o o o o o o x o
        //o o x o o o o o
        //o o o o o o o x
        //o x o o o o o o
        //o o o o x o o o
        //x o o o o o o o
        //o o o o o x o o
        return board5;
    }
}