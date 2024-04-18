package snakegame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Board extends  JPanel implements ActionListener {
    private Image apple;
    private  Image dot;
    private Image head;
    private int dots;
    private final int RAANDOM_POSITION=20;
    private  int apply_x;
    private  int apply_y;
    private  boolean leftDirection = false;
    private  boolean rightDirection = true;

    private  final int DOT_SIZE = 10;     //300 * 300 = 90000 / 10 = 9000
    private final int ALL_DOTS = 9000;


    private final  int x[] = new int[ALL_DOTS];
    private final  int y[] = new int[ALL_DOTS];

    private Timer timer;

    Board(){
        addKeyListener(new TAdapter());
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
            x[i]=50 - i *DOT_SIZE ;  // i-50 ,2;50-dot_size = 50-10 =40 ,3 ; 50 - 2*10 = 30
            y[i]=50;
        }

        locateApple();

        timer = new Timer(140,this);
        timer.start();

    }

     public void locateApple(){
         int rand = (int)(Math.random()*RAANDOM_POSITION);   // 0 and 1 => 0.6 *20 = 12*10 =120
         apply_x = (rand * DOT_SIZE);

          rand = (int)(Math.random()*RAANDOM_POSITION);   // 0 and 1 => 0.6 *20 = 12*10 =120
         apply_y = (rand * DOT_SIZE);


     }

    public void actionPerformed(ActionEvent, e) {

    }

    private class TAdapter extends keyAdapter{

        @Override
        public  void keyPressed(KeyEvent,e){
                int key;
            key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
                
            }
        }
    }

}
