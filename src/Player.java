public class Player {
    static boolean color;
    boolean inCheck;
    public static final boolean WHITE = true;
    public static final boolean BLACK = false;

    /**
     * Constructor Player
     * @param color
     */
    public Player(boolean color){
        Player.color = color;
        inCheck = false;
    }

    /**
     * Get Color
     * @return
     */
    public static boolean getColor(){
        return color;
    }

    public String execMove(int xCoord, int yCoord, int toX, int toY, Piece piece){
        return piece.execMove(board, )
    }


}

