public class Juggernaut extends Piece {

    /**
     * Juggernaut Rook without collisions
     * @param color
     * @param xCoord
     * @param yCoord
     */
    public Juggernaut(boolean color, int xCoord, int yCoord) {
        super(color, xCoord, yCoord);
    }

    /**
     * Check if Valid Move
     * @param board
     * @param toX
     * @param toY
     * @return
     */
    public boolean isValidMove(Board board, int toX, int toY) {
        int diffX = Math.abs(toX - xCoord);
        int diffY = Math.abs(toY - yCoord);

        if (!isOnBoard(board, toX, toY)) {
            return false;
        }
        /* Rook Movement without collisions */
        if((diffX == 0 || diffY == 0)){
            return true;
        }
        else return false;
    }
}
