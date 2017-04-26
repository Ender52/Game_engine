package semestralproject;

import javax.swing.JFrame;

public class Start{
    public static Level level;
    public static int WIDTH = 500, HEIGHT = 500;
    public static JFrame frame;
    public static boolean pause = false;
    static Renderer renderer = new Renderer();
    public static void main(String[] args) {
        frame = new JFrame();  //the window itself
        frame.setSize(WIDTH+6, HEIGHT+28);  // size includes the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.add(renderer);
        level = new LevelOne();
        
    }

    public static void pause(){
        level.turnOff();
        level.timer.stop();
        level = new Level();
        resume();
    }
    
    public static void resume(){
        level.timer.start();
    }
    
}