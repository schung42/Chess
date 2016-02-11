public class Knight extends Piece {

    /**
     * Knight Constructor
     * @param color
     * @param xCoord
     * @param yCoord
     */
    public Knight(boolean color, int xCoord, int yCoord){
        super(color, xCoord, yCoord);
    }


    /**
     * Check if valid move for Knight
     * @param board
     * @param toX
     * @param toY
     * @return
     */
    public boolean isValidMove(Board board, int toX, int toY){
        int diffX = Math.abs(xCoord - toX);
        int diffY = Math.abs(yCoord - toY);

        if(!isOnBoard(board, toX, toY)){
            return false;
        }
        if((diffX ==1 && diffY == 2) || (diffX == 2 && diffY == 1)){
            return true;
        }
        else{
            return false;
        }
    }

}
