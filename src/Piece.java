public abstract class Piece {
    public int xCoord;
    public int yCoord;
    public boolean color;


    /**
     * Piece Constructor
     * @param color
     * @param xCoord
     * @param yCoord
     */
    public Piece(boolean color, int xCoord, int yCoord){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.color = color;
    }



    /**
     * Check if piece obstructs movement
     * @param board
     * @param toX
     * @param toY
     * @return
     */
    public boolean pieceInWay(Board board, int toX, int toY){
        return false;
    }

    /**
     * Check if Valid Move
     * @param board
     * @param toX
     * @param toY
     * @return
     */
    abstract boolean isValidMove(Board board, int toX, int toY);

    /**
     * Retrieve color of Piece
     * @return
     */
    public boolean getColor(){
        return this.color;
    }

    /**
     * Execute Move/Capture Piece
     * @param board
     * @param player
     * @param toX
     * @param toY
     */
    public void execMove(Board board, Player player,Piece piece, int toX, int toY){
        if(isOnBoard(board,toX, toY) && isValidMove(board, toX, toY)){
            board.removePiece(toX, toY);
            board.replacePiece(toX, toY, this);
        }
    }

    /**
     * Verify that piece is on board
     * @param board
     * @param toX
     * @param toY
     * @return
     */
    public boolean isOnBoard(Board board, int toX, int toY){
		/* Cannot move to position currently occupying */
        if(xCoord == toX && yCoord == toY){
            return false;
        }
		/* Prevent moving out of Board */
        if(xCoord < 0 || yCoord < 0 || xCoord > 7 ||
                yCoord > 7 || toX < 0 || toY < 0 || toX > 7 ||
                toY > 7){
            return false;
        }
        else return true;
    }


}
