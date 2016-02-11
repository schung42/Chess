import org.junit.Test;

import static org.junit.Assert.*;

public class JuggernautTest {

    @Test
    public void testSimpleMove() throws Exception {
        /* Simple Move p*/
        Board board = new Board();
        board.setPiece(new Juggernaut(true, 0, 0), 0, 0);
        Piece piece = board.getPiece(0, 0);
        piece.execMove(board, null, piece, 0, 4);
        assertEquals(piece.isValidMove(board, 0, 4), true);
    }

    @Test
    public void testCapture() throws Exception {
        Board board2 = new Board();
        board2.setPiece(new Juggernaut(true, 0, 0), 0, 0);
        board2.setPiece(new Pawn(false, 1, 0), 1, 0);
        Piece piece2 = board2.getPiece(0, 0);
        piece2.execMove(board2, null, piece2, 1, 0);
        assertEquals(piece2.isValidMove(board2, 1, 0), true);
    }

    @Test
    public void testCaptureThroughPiece() throws Exception {
        Board board3 = new Board();
        board3.setPiece(new Juggernaut(true, 0, 0), 0, 0);
        board3.setPiece(new Pawn(false, 1, 0), 1, 0);
        board3.setPiece(new Pawn(false, 2, 0), 2, 0);
        Piece piece3 = board3.getPiece(0, 0);
        piece3.execMove(board3, null, piece3, 2, 0);
        assertEquals(piece3.isValidMove(board3, 2, 0), true);
    }

    @Test
    public void testIllegalMove() throws Exception {
        /* try to go somewhere it cannot go */
        Board board4 = new Board();
        board4.setPiece(new Juggernaut(true, 0,0),0,0);
        Piece piece4 = board4.getPiece(0,0);
        piece4.execMove(board4, null,piece4, 2,1); //should fail right here.
        assertEquals(piece4.isValidMove(board4,2,1), false);
    }



}