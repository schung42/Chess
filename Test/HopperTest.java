import org.junit.Test;

import static org.junit.Assert.*;

public class HopperTest {

    @Test
    public void testSimpleMove() throws Exception {
         /* Simple Move */
        Board board = new Board();
        board.setPiece(new Hopper(true, 0, 0), 0, 0);
        Piece piece = board.getPiece(0, 0);
        piece.execMove(board, null, piece, 3, 2);
        assertEquals(piece.isValidMove(board, 3, 2), true);
    }

    @Test
    public void testCapture() throws Exception {
        /* Capture */
        Board board2 = new Board();
        board2.setPiece(new Hopper(true, 0,0), 0,0);
        board2.setPiece(new Pawn(false, 3,2),3,2);
        Piece piece2 = board2.getPiece(0,0);
        piece2.execMove(board2,null,piece2,0,0);
        assertEquals(piece2.isValidMove(board2, 3,2), true);
    }

    public void testIllegalMove() throws Exception {
        /* Check somewhere it cannot go */
        Board board4 = new Board();
        board4.setPiece(new Hopper(true, 0, 0), 0, 0);
        Piece piece4 = board4.getPiece(0, 0);
        piece4.execMove(board4, null, piece4, 0, 5); //should fail right here.
        assertEquals(piece4.isValidMove(board4, 0, 5), false);
    }

}