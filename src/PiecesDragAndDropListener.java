import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

public class PiecesDragAndDropListener implements MouseListener, MouseMotionListener {
    private List<ChessLabel> pieces;
    private BoardLayout chessGui;

    private ChessLabel dragPiece;
    private int dragOffsetX;
    private int dragOffsetY;

    public PiecesDragAndDropListener(List<ChessLabel> pieces, BoardLayout chessGui){
        this.pieces = pieces;
        this.chessGui = chessGui;
    }

    @Override
    public void mousePressed(MouseEvent evt){
        int x = evt.getPoint().x;
        int y = evt.getPoint().y;

        /* Find which piece to move; check from to bottom */
        for(int i = this.pieces.size()-1; i >= 0; i--){
            ChessLabel piece = this.pieces.get(i);

            if(mouseOverPiece(piece,x,y)){
                /*Calculate offset */
                this.dragOffsetX = x - piece.getX();
                this.dragOffsetY = y - piece.getY();
                this.dragPiece = piece;
                break;
            }
        }

        if(this.dragPiece != null){
            this.pieces.remove(this.dragPiece);
            this.pieces.add(this.dragPiece);
        }
    }


    /*Check if mouse over this piece */
    private boolean mouseOverPiece(ChessLabel piece, int x, int y){
        return piece.getX() <= x && piece.getY() <= y;
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        this.dragPiece = null;
    }

    public void mouseDragged(MouseEvent evt) {
        if(this.dragPiece != null) {
            //this.dragPiece.setX(evt.getPoint().x - this.dragOffsetX);
            //this.dragPiece.setY(evt.getPoint().y - this.dragOffsetY);
            this.chessGui.repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {}

    @Override
    public void mouseEntered(MouseEvent arg0) {}

    @Override
    public void mouseExited(MouseEvent arg0) {}

    @Override
    public void mouseMoved(MouseEvent arg0) {}
}
