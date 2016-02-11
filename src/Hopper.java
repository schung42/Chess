public class Hopper extends Piece {

    /**
     * Hopper is a knight that moves farther
     * @param color
     * @param xCoord
     * @param yCoord
     */
    public Hopper(boolean color, int xCoord, int yCoord){
        super(color, xCoord, yCoord);
    }

    /**
     * Check if Valid Move
     * @param board
     * @param toX
     * @param toY
     * @return
     */
    public boolean isValidMove(Board board, int toX, int toY){
        int diffX = Math.abs(toX - xCoord);
        int diffY = Math.abs(toY - yCoord);

        if(!isOnBoard(board, toX, toY)){
            return false;
        }
        if((diffX ==2 && diffY == 3) || (diffX == 3 && diffY == 2)){
            return true;
        }
        else{
            return false;
        }
    }

}
