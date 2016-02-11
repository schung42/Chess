public class Bishop extends Piece{

    /**
     * Bishop Constructor
     * @param color
     * @param xCoord
     * @param yCoord
     */
    public Bishop(boolean color, int xCoord, int yCoord){
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
		/* Diagonal Movement */
        if(diffX != diffY){
            return false;
        }
        else if(pieceInWayDiagonal(board, toX, toY)){
            return false;
        }
        else
            return true;
    }


    /**
     * Check if collision along diagonal path
     * @param board
     * @param toX
     * @param toY
     * @return
     */
    public boolean pieceInWayDiagonal(Board board, int toX, int toY){
		
		/* if destination is larger than initial return 1 else -1 */
        int directionX = toX >xCoord ? 1 : -1;
        int directionY = toY > yCoord ? 1 : -1;
		
		/* Check if there is a piece in the path traveled */
        for(int i = 1; i < Math.abs(toX-xCoord)-1; ++i){
            if(board.checkPieceOnBoard(xCoord+i*directionX, yCoord+i*directionY)){
                return false;
            }
        }
        return true;
    }


}
