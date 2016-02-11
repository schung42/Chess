import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void testGetPiece() throws Exception {
        Board board = new Board();
        board.setPiece(new Bishop(true, 0, 0), 0, 0);
        assertNotEquals(board.piece[0][0], null);
    }

    @Test
    public void testCheckPieceOnBoard() throws Exception {
        Board board = new Board();
        board.setPiece(new Bishop(true, 0,0), 0, 0);
        assertNotEquals(board.piece[0][0], null);
    }
}