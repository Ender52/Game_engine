package cz.cvut.fel.pjv.stepaegoisaiemyk.sp;

import javax.swing.JFrame;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.levels.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.graphics.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.physics.Physics;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;


public class Game implements KeyListener, ActionListener {
    public static int WIDTH = 800, HEIGHT = 600;
    public static
    JFrame frame;
    public static Level level;
    public static Renderer renderer;
    Physics physics;
    Timer timer;
    int time;

    public Game() {
        frame = new JFrame();  //the window itself
        /*window mode*//**/
        frame.setSize(WIDTH + 6, HEIGHT + 28);  // size includes the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        /**/
        
        /*fullscreen mode*//*
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //this will make game fullscreen
        frame.setUndecorated(true);
        Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
        WIDTH = (int)resolution.getWidth();
        HEIGHT = (int)resolution.getHeight();
        /**/

        renderer = new Renderer();
        physics = new Physics();
        frame.addKeyListener(this);
        timer = new Timer(10, this);

        frame.setVisible(true);
        frame.add(renderer);

        level = new LevelOne();
        time = 0;
        timer.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {  //up
            level.wPressed();
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {  //down
            level.sPressed();
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {  //left
            level.aPressed();
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {  //right
            level.dPressed();
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            level.escPressed();
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            level.enterPressed();
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            level.spacePressed();
        }
        if (e.getKeyCode() == KeyEvent.VK_I) {
            level.iPressed();
        }
        if(e.getKeyCode() == KeyEvent.VK_E){
            level.ePressed();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {  //up
            level.wReleased();
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {  //down
            level.sReleased();
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {  //left
            level.aReleased();
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {  //right
            level.dReleased();
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {  //right
            level.spaceReleased();
        }
        if(e.getKeyCode() == KeyEvent.VK_E){
            level.eReleased();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        physics.run();
        renderer.repaint();
        time++;
        level.time++;
        level.removeDead();
    }

}
