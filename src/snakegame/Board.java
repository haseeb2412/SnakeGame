package snakegame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Board extends  JPanel implements ActionListener {
    private Image apple;
    private  Image dot;
    private Image head;
    private int dots;
    private final int RAANDOM_POSITION=20;
    private  int apple_x;
    private  int apple_y;
    private  boolean leftDirection = false;
    private  boolean rightDirection = true;
    private  boolean upDirection = true;
    private  boolean downDirection = true;
    private  boolean inGame = true;

    private  final int DOT_SIZE = 10;     //300 * 300 = 90000 / 10 = 9000
    private final int ALL_DOTS = 9000;


    private final  int x[] = new int[ALL_DOTS];
    private final  int y[] = new int[ALL_DOTS];

    private Timer timer;

    Board(){
        addKeyListener(new TAdapter());
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(300,300));

        setFocusable(true);   // is used to run ketlistner if setfocusable(true)

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
         apple_x = (rand * DOT_SIZE);

          rand = (int)(Math.random()*RAANDOM_POSITION);   // 0 and 1 => 0.6 *20 = 12*10 =120
         apple_y = (rand * DOT_SIZE);


     }
    public  void checkCollision(){

        for (int i = dots; i > 0 ; i--) {
            if((i > 4) && (x[0] == x[i])  && (y[0]== y[i]) ){

            }
        }

        if (y[0] >= 300  ) {
            inGame =false;
        }

        if (x[0] >= 300  ) {
            inGame =false;
        }

        if (y[0] < 0 ) {
            inGame =false;
        }

        if (x[0] < 0  ) {
            inGame =false;
        }

        if(!inGame){
            timer.stop();
        }

        


    }

     public void  checkApple(){
        if((x[0]== apple_x ) && (y[0]==apple_y)){
            dots++;
            locateApple();
            checkCollision();
        }
     }

    public void actionPerformed(ActionEvent  e) {
        if(inGame){
            checkApple();
        }
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public  void keyPressed(KeyEvent e){
                int key;
            key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if (key == KeyEvent.VK_RIGHT && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if (key == KeyEvent.VK_UP && (!downDirection)) {
                leftDirection = false;
                upDirection = true;
                downDirection = false;
            }

            if (key == KeyEvent.VK_DOWN && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;

            }





        }
    }

}


