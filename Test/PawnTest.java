import org.junit.Test;

import static org.junit.Assert.*;

public class PawnTest {

    @Test
    public void testSimpleMove() throws Exception {
        /* Simple Move */
        Board board = new Board();
        board.setPiece(new Pawn(true, 0, 0), 0, 0);
        Piece piece = board.getPiece(0,0);
        piece.execMove(board,null, piece, 0, 1);
        assertNotEquals(piece.isValidMove(board, 0,1), true);
    }

    @Test
    public void testCapture() throws Exception {
        /* Capture Enemy Pawn p*/
        Board board2 = new Board();
        board2.setPiece(new Pawn(true, 0, 0), 0, 0);
        board2.setPiece(new Pawn(false, 1, 1), 1, 1);
        Piece piece2 = board2.getPiece(0, 0);
        piece2.execMove(board2, null, piece2, 1, 1);
        assertEquals(piece2.isValidMove(board2, 1, 1), false);
    }

    @Test
    public void testFirstMove() throws Exception {
        /* Check if first move move 2 p*/
        Board board3 = new Board();
        board3.setPiece(new Pawn(true, 1, 1), 1, 1);
        Piece piece3 = board3.getPiece(1,1);
        piece3.execMove(board3, null, piece3, 3,1);
        assertEquals(piece3.isValidMove(board3, 3,1), false);
    }


}