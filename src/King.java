public class King extends Piece{

    /**
     * King Constructor
     * @param color
     * @param xCoord
     * @param yCoord
     */
    public King(boolean color, int xCoord, int yCoord){
        super(color, xCoord, yCoord);
    }

    /**
     * Check if Valid Move for King
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
        if(diffX > 1 || diffY > 1){
            return false;
        }
        else return true;
    }


}
