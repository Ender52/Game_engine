package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.levels;

import java.awt.Color;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.*;

public class LevelOne extends Level{
    public LevelOne() {  //constructor
        pause = false;
        color = Color.getHSBColor(0.66f, 0.4f, 0.5f);
        player = new Player(WIDTH / 2 - 20, HEIGHT / 2 - 20, 40, 40, 3, true, 10, 100);
        creatures.add(player);
        creatures.add(new Creature(300, 300, 15, 15, 1, true, 3, 50));
        creatures.get(1).speedX = 1;
        obstacles.add(new Obstacle(0, 0, 15, HEIGHT));
        obstacles.add(new Obstacle(WIDTH-15, 0, 15, HEIGHT));
        obstacles.add(new Obstacle(0, 0, WIDTH, 15));
        obstacles.add(new Obstacle(0, HEIGHT - 15, WIDTH, 15));
        obstacles.add(new Obstacle(200, 0, 15, 200));
        obstacles.add(new Obstacle(300, 0, 15, 200));
        obstacles.add(new Obstacle(0, 185, 200, 15));

        /*for(int i = 0; i < 100; i++){
            obstacles.add(new Obstacle(0, 185, 200, 15));
        }*/
    }
    
    @Override
    public void levelLogic(){
        Obstacle wall = obstacles.get(5);
        if(time % 4 == 0){
            if(wall.x + wall.width > WIDTH || wall.x <200){
                loop *= -1;
            }
            wall.x += loop*4;
        }
        Creature c = creatures.get(1);
        if(!c.alive){
            return;
        }
        if(c.x > 500 || c.x < 100){
            c.speedX *= -1;
        }
    }
    
}
