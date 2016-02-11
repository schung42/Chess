import org.junit.Test;

import static org.junit.Assert.*;

public class KingTest {

    @Test
    public void testSimpleMove() throws Exception {
        Board board = new Board();
        board.setPiece(new King(true, 0, 0), 0, 0);
        Piece piece = board.getPiece(0,0);
        piece.execMove(board,null, piece, 1, 1);
        assertEquals(piece.isValidMove(board,1,1), true);
    }

    @Test public void testCapture() throws Exception {
        /* Capture Enemy Pawn p*/
        Board board2 = new Board();
        board2.setPiece(new King(true, 0, 0), 0, 0);
        board2.setPiece(new Pawn(false, 1, 1), 1, 1);
        Piece piece2 = board2.getPiece(0, 0);
        piece2.execMove(board2, null, piece2, 1, 1);
        assertEquals(piece2.isValidMove(board2, 1, 1), true);
    }

    @Test
    public void testIllegalMove() throws Exception {
        /* Check somewhere it cannot go */
        Board board4 = new Board();
        board4.setPiece(new King(true, 0,0),0,0);
        Piece piece4 = board4.getPiece(0,0);
        piece4.execMove(board4, null,piece4, 0,5); //should fail right here.
        assertEquals(piece4.isValidMove(board4,0,5), false);
    }


}