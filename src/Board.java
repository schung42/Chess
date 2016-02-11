public class Board {
    protected int width;
    protected int height;

    protected Piece [][] piece = new Piece[8][8];

    /**
     * Retrieve the width of the board
     *@return
     */
    public int getWidth(){
        return width;
    }

    /**
     * Retrieve the height of the board
     * @return
     */
    public int getHeight(){
        return height;
    }

    /**
     * Set the width of the board
     * @param width
     */
    public void setWidth(int width){
        this.width = width;
    }

    /**
     * Set the height of the board
     * @param height
     */
    public void setHeight(int height){
        this.height = height;
    }

    /**
     * Return the piece at this coordinate
     *
     * @param xCoord
     * @param yCoord
     * @return
     */
    public Piece getPiece(int xCoord, int yCoord){
        return piece[xCoord][yCoord];
    }

    /**
     * Placing a piece on the board at a coordinate
     *
     * @param newPiece
     * @param xCoord
     * @param yCoord
     */
    public void setPiece(Piece newPiece, int xCoord, int yCoord){
        if(checkPieceOnBoard(xCoord, yCoord) == false){
            piece[xCoord][yCoord] = newPiece;
        }
    }


    /**
     * Check if a piece exists on board at coordinate
     *
     * @param xCoord
     * @param yCoord
     * @return
     */
    public boolean checkPieceOnBoard(int xCoord, int yCoord){
        if(this.getPiece(xCoord, yCoord) != null){
            return true;
        }
        return false;
    }


    /**
     * Set the piece at this XY coordinate to be null
     *
     * @param xCoord
     * @param yCoord
     */
    public void removePiece(int xCoord, int yCoord){
        this.piece[xCoord][yCoord] = null;
    }

    /* Replace the piece at that coordinate with current piece*/
    public void replacePiece(int toX, int toY, Piece piece){
        Piece replacingPiece = getPiece(piece.xCoord, piece.yCoord);
        this.piece[toX][toY] = replacingPiece;
    }


}
