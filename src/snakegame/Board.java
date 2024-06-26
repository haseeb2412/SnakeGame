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

        setFocusable(true);   // is used to run keylistner if setfocusable(true)
    requestFocusInWindow();
        loadImage();
        initGame();
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

    public  void move(){
        for (int i = dots; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }
        if(rightDirection){
            x[0] +=  DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }
        if(downDirection){
            y[0] +=  DOT_SIZE;
        }
    }

     public void  checkApple(){
        if((x[0]== apple_x ) && (y[0]==apple_y)){
            dots++;
            locateApple();
            checkCollision();
            move();
        }
     }

     public void paintComponent(Graphics g){
        super.paintComponent(g);

        draw(g);
     }


    public void gameOver(Graphics g){
        String msg = "Game Over";
        Font font = new Font("SAN_SERIF",Font.BOLD,14);
        FontMetrics metrics = getFontMetrics(font);
        int x = (getWidth() - metrics.stringWidth(msg)) / 2;
        int y = getHeight() / 2;
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString(msg, x, y);
    }


    public void draw(Graphics g){
        if(inGame){
            g.drawImage(apple,apple_x,apple_y,DOT_SIZE,DOT_SIZE,this);

            for (int z = 0; z < dots; z++) {
                if (z == 0 ) {
                    g.drawImage(head,x[z],y[z],DOT_SIZE,DOT_SIZE,this);
                }else{
                    g.drawImage(dot,x[z],y[z],DOT_SIZE,DOT_SIZE,this);


                }
            }
            Toolkit.getDefaultToolkit().sync();
        }else{
            gameOver(g);
        }

     }



    public void actionPerformed(ActionEvent  e) {
        if(inGame){
            checkApple();
            checkCollision();
            move();
        }
        repaint();  // change when the component look change
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


