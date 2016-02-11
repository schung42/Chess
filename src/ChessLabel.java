import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.util.*;
import java.awt.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChessLabel extends JLabel{
    private java.util.List<Rectangle> squares = new ArrayList<Rectangle>();

    public void addSquare(int x, int y, int width, int height) {
        Rectangle rect = new Rectangle(x,y,width, height);
        squares.add(rect);
    }

    @Override
    public Dimension getSize(){
        return new Dimension(600,600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.BLUE);
        int i = 0;
        for(Rectangle rect: squares){
            invertSquareColor(g);
            g2.fillRect(rect.x,rect.y,rect.width, rect.height);
            g2.draw(rect);
            i++;
            if(i % 8 == 0){
                invertSquareColor(g);
            }
        }
    }

    public void fillBoardWithPieces(Graphics g, Board board) {
        int width = board.getWidth();
        int height = board.getHeight();

        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++) {
                Piece currentPiece = board.getPiece(x,y);
                setPiece(g, currentPiece,x,y);
            }
        }
    }

    private void setPiece(Graphics g, Piece piece, int xCoord, int yCoord){
        if(piece == null) {
            return;
        }

        String color;
        if((piece.getColor() == Player.getColor()) && (Player.getColor() == Player.BLACK)){
            color = "Black";
        }
        else{
            color = "White";
        }

        String className = piece.getClass().getSimpleName();
        String imageName = "";
        imageName = color + className;
        BufferedImage image;

        try{
            image = ImageIO.read(new File("assets/img/" + imageName +".png"));
        }
        catch (IOException ex) {
            System.exit(1);
            return;
        }

        g.drawImage(image, x*BoardLayout + 13, y*BoardLayout+13, null);
    }

    private void invertSquareColor(Graphics g) {
        if(g.getColor() == Color.BLACK) {
            g.setColor(Color.WHITE);
        }
        else{
            g.setColor(Color.BLACK);
        }
    }

}
