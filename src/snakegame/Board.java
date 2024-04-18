package snakegame;
import javax.swing.*;
import java.awt.*;

public class Board extends  JPanel{
    private Image apple;
    private  Image dot;
    private Image head;
    private int dots;

    private  final int DOT_SIZE = 10;     //300 * 300 = 90000 / 10 = 9000
    private final int ALL_DOTS = 9000;


    private final  int x[] = new int[ALL_DOTS];
    private final  int y[] = new int[ALL_DOTS];


    Board(){
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(300,300));

        loadImage();
    }

    public  void loadImage(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/red.png"));
        head = i1.getImage();

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icons/green.png"));
        dot = i2.getImage();

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/apple.png"));
        apple = i3.getImage();

    }


    public void initGame(){
        dots = 3;

        for (int i = 0; i < dots; i++) {
            x[i]=50;
            y[i]=50;
        }
    }
}
