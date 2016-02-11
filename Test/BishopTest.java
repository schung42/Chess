import org.junit.Test;

import static org.junit.Assert.*;

public class BishopTest {

    @Test
    public void testSimpleMove() throws Exception {
        /* Check simple Move p*/
        Board board = new Board();
        board.setPiece(new Bishop(true, 0, 0), 0, 0);
        Piece piece = board.getPiece(0, 0);
        piece.execMove(board, null, piece, 4, 4);
        assertNotEquals(piece.isValidMove(board, 4, 4), true);
    }

    @Test
    public void testCapture() throws Exception {
        /* Capture Enemy Pawn p*/
        Board board2 = new Board();
        board2.setPiece(new Bishop(true, 0, 0), 0, 0);
        board2.setPiece(new Pawn(false, 1, 1), 1, 1);
        Piece piece2 = board2.getPiece(0, 0);
        piece2.execMove(board2, null, piece2, 1, 1);
        assertNotEquals(piece2.isValidMove(board2, 1, 1), true);
    }

    @Test
    public void testPieceInWay() throws Exception {
        /* Piece in Way */
        Board board3 = new Board();
        board3.setPiece(new Bishop(true, 0, 0), 0, 0);
        board3.setPiece(new Pawn(false, 4, 4), 4, 4);
        Piece piece3 = board3.getPiece(0, 0);
        piece3.execMove(board3, null, piece3, 5, 5); //should fail right here.
        assertEquals(piece3.isValidMove(board3, 5, 5), false);
    }

    @Test
    public void testIllegalMove() throws Exception {
        /* Check somewhere it cannot go */
        Board board4 = new Board();
        board4.setPiece(new Bishop(true, 0,0),0,0);
        Piece piece4 = board4.getPiece(0,0);
        piece4.execMove(board4, null,piece4, 0,5); //should fail right here.
        assertEquals(piece4.isValidMove(board4,0,5), false);
    }


}