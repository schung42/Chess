import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



public class BoardLayout extends JFrame{
    GridLayout boardView = new GridLayout(8,8);
    SquareButton[][] buttons = new SquareButton[8][8];
    GameOperator operator;
    int xCoord, yCoord, toX, toY;

    public BoardLayout(String name, GameOperator operator ) {
        super(name);
        xCoord = -1;
        yCoord = -1;
        toX = -1;
        toY = -1;

        this.operator = operator;
        setResizable(false);
        this.InitGUI();
    }

    public void InitGUI() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addComponentsToPane(this.getContentPane());
        this.pack();
        this.setVisible(true);
    }

    public void addComponentsToPane(final Container pane) {
        JPanel squaresPanel = new JPanel();
        squaresPanel.setLayout(boardView);
        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(2,2));

        Dimension buttonSize = new Dimension(275,175);
        squaresPanel.setPreferredSize(new Dimension((int) (buttonSize.getWidth() * 2.5), (int) (buttonSize.getHeight() * 3.5)));

        int i = 0;
        Color color = Color.WHITE;
        for(int x = 0; x <8; x++){
            for(int y = 0; y<8; y++){
                SquareButton button = new SquareButton(x,y);
                button.setBackground(color);
                squaresPanel.add(button);
                color = invertSquareColor(color);
                i++;
                if(i % 8 == 0) {
                    color = invertSquareColor(color);
                }
                buttons[x][y] =button;
                buttons[x][y].addActionListener(e(x,y));

                Image image = null;
                Board board = operator.getBoard();
                Piece piece = board.getPiece(x,y);
                if(piece != null) {
                    image = getImage(piece);
                    button.setIcon(new ImageIcon(image));
                }

            }
        }
    }

    private Color invertSquareColor(Color color) {
        if(color.equals(Color.BLACK)){
            return Color.WHITE;
        }
        else{
            return Color.BLACK;
        }
    }

    private ActionListener e(final int i, final int j) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(xCoord == -1 && yCoord == -1) {
                    xCoord = i;
                    yCoord = j;
                    buttons[i][j].setBackground(Color.YELLOW);
                }
                else{
                    toX = i;
                    toY = j;
                    if ((xCoord %2 ==0 && yCoord%2 == 0) || (xCoord %2 ==1 && yCoord%2 == 1)){
                        buttons[xCoord][yCoord].setBackground(Color.WHITE);
                    }
                    else{
                        buttons[xCoord][yCoord].setBackground(Color.BLACK);
                    }
                    xCoord = -1;
                    yCoord = -1;
                    toX = -1;
                    toY = -1;
                }
            }
        };
    }

    public void setPiece(int xCoord, int yCoord, Piece piece){
        BufferedImage image = getImage(piece);
        if(image == null){
            buttons[xCoord][yCoord].setIcon(null);
        }
        else{
            buttons[xCoord][yCoord].setIcon(new ImageIcon(image));
        }
    }

    public BufferedImage getImage(Piece piece){
        if(piece == null){
            return null;
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
            image = null;
            System.exit(1);
        }
        return image;
    }



}
