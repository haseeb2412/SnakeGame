package snakegame;
import javax.swing.*;

public class Snake extends JFrame{

    Snake() {
//        super("Sanke Game")    we can also use the super for window title
        Board b = new Board();
        add(b);
        pack();   // used to set the fram size    setSize()  setBound(x , y ,lenght ,breath);

        setLocationRelativeTo(null);   // to set the window center
        setTitle("Snake Game");
        setResizable(false);
    }

    public static void main(String[] args){
        new Snake().setVisible(true);
    }
}
