public class Pawn extends Piece{

    /**
     * Pawn Constructor
     * @param color
     * @param xCoord
     * @param yCoord
     */
    public Pawn(boolean color, int xCoord, int yCoord){
        super(color, xCoord, yCoord);
    }

    /**
     * Check if Move is Valid for Pawn
     * @param board
     * @param toX
     * @param toY
     * @return
     */
    public boolean isValidMove(Board board, int toX, int toY){
        int diffX = toX - xCoord;
        int diffY = toY - yCoord;
        int direction;
        int startingY;

        if(!isOnBoard(board, toX, toY)){
            return false;
        }

        if(this.getColor() == Player.black){
            direction = 1;
            startingY = 1;
        }
        else{
            direction = -1;
            startingY = 6;
        }

        if(yCoord == startingY){
			/* If at starting position it can move 2 spaces */
            if(diffX == 0 && diffY == 2 * direction){
                return true;
            }
			/* Otherwise move one space */
            else{
                if(diffX == 0 && diffY == direction){
                    return true;
                }
                else return false;
            }
        }
		/* if not starting position then only one space move allowed */
        else{
            if(diffX == 0 && diffY == direction){
                return true;
            }
            else return false;
        }

    }

}
