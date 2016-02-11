import org.junit.Test;

import static org.junit.Assert.*;

public class RookTest {

    @Test
    public void testSimpleMove() throws Exception {
        /* Simple Move p */
        Board board = new Board();
        board.setPiece(new Rook(true, 0, 0), 0, 0);
        Piece piece = board.getPiece(0, 0);
        piece.execMove(board, null, piece, 5, 0);
        assertNotEquals(piece.isValidMove(board, 5, 0), true);
    }
    public void testCapture() throws Exception {
        /* Capture Pawn p*/
        Board board2 = new Board();
        board2.setPiece(new Rook(true, 0, 0), 0, 0);
        board2.setPiece(new Pawn(false, 1, 0), 1, 0);
        Piece piece2 = board2.getPiece(0, 0);
        piece2.execMove(board2, null, piece2, 1, 0);
        assertNotEquals(piece2.isValidMove(board2, 1, 0), true);
    }

    public void testPieceInWay() throws Exception {
        /* Piece in way */
        Board board3 = new Board();
        board3.setPiece(new Rook(true, 0, 0), 0, 0);
        board3.setPiece(new Pawn(false, 4, 0), 4, 0);
        Piece piece3 = board3.getPiece(0, 0);
        piece3.execMove(board3, null, piece3, 5, 0); //should fail this condition right here.
        assertEquals(piece3.isValidMove(board3, 5, 0), false);
    }

    public void testIllegalMove() throws Exception {
        /* Check somewhere it cannot go */
        Board board4 = new Board();
        board4.setPiece(new Rook(true, 0,0),0,0);
        Piece piece4 = board4.getPiece(0,0);
        piece4.execMove(board4, null,piece4, 2,1); //should fail right here.
        assertEquals(piece4.isValidMove(board4,2,1), false);
    }
}