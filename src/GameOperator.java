
public class GameOperator {
    Board board;
    Player whitePlayer;
    Player blackPlayer;
    BoardLayout view;

    public BoardLayout getView(){
        return view;
    }

    public void setView(BoardLayout view){
        this.view = view;
    }
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getWhitePlayer(){
        return whitePlayer;
    }

    public void setWhitePlayer(Player whitePlayer){
        this.whitePlayer = whitePlayer;
    }

    public Player getBlackPlayer() {
        return blackPlayer;
    }

    public void setBlackPlayer(Player blackPlayer) {
        this.blackPlayer = blackPlayer;
    }

    public GameOperator(){
        board = new Board();
        whitePlayer = new Player(Player.WHITE);
        blackPlayer = new Player(Player.BLACK);
    }

    public String sendMove(int xCoord, int yCoord, int toX, int toY, Player player){
        String status = player.execMove(xCoord, yCoord, toX, toY, board);
    }

}
