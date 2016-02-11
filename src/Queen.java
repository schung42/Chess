public class Queen extends Piece {

    /**
     * Queen Constructor
     * @param color
     * @param xCoord
     * @param yCoord
     */
    public Queen(boolean color, int xCoord, int yCoord){
        super(color, xCoord, yCoord);
    }

    /**
     * Validate Queen move
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
        if((diffX == 0 || diffY == 0) && !pieceInWayStraight(board, toX, toY) &&
                !pieceInWayDiagonal(board, toX, toY)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Use Rook Rules for collisions
     * @param board
     * @param toX
     * @param toY
     * @return
     */
    public boolean pieceInWayStraight(Board board, int toX, int toY){
        int directionX = toX > xCoord ? 1 : -1;
        int directionY = toY > yCoord ? 1 : -1;
		
		/* If moving vertically, check if anything in the path*/
        if(xCoord - toX == 0){
            for(int i = 1; i < Math.abs(toX-xCoord)-1; ++i){
                if(board.checkPieceOnBoard(xCoord, yCoord + i*directionY)){
                    return false;
                }
            }
        }
		
		/*if moving horizontally, check if anything in path*/
        if(yCoord - toY == 0){
            for(int i = 1; i< Math.abs(toY-yCoord)-1; ++i){
                if(board.checkPieceOnBoard(xCoord +i*directionX, yCoord)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Reuse Bishop rules for collisions
     * @param board
     * @param toX
     * @param toY
     * @return
     */
    /* Reuse Bishop rules for piece in way */
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
