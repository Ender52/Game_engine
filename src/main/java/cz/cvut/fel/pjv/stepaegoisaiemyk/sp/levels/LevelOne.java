package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.levels;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game;
import java.awt.Color;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.items.Key;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids.Creature;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids.Door;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids.Obstacle;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids.Player;

public class LevelOne extends Level {
    /**
     * <p>The construction of the level one</p>
     */
    public LevelOne() {  //constructor
        pause = false;

        color = Color.getHSBColor(0.66f, 0.4f, 0.5f);
        player = new Player(WIDTH / 2 - 20, HEIGHT / 2 - 20, 40, 40, 3, true, 10, 100);

        creatures.add(player);
        creatures.add(new Creature(300, 300, 15, 15, 1, true, 3, 50));
        creatures.get(1).speedX = 0;

        obstacles.add(new Obstacle(0, 0, 15, HEIGHT));              //left wall
        obstacles.add(new Obstacle(WIDTH - 15, 0, 15, HEIGHT / 2 - 25));       //right wall
        obstacles.add(new Obstacle(0, 0, WIDTH, 15));               //top wall
        obstacles.add(new Obstacle(0, HEIGHT - 15, WIDTH, 15));     //bottom wall
        obstacles.add(new Obstacle(200, 0, 15, 200));           //right obs
        obstacles.add(new Obstacle(300, 0, 15, 200));           //moving obs
        obstacles.add(new Obstacle(0, 185, 200, 15));           //bottom obs
        obstacles.add(new Obstacle(WIDTH - 15, HEIGHT / 2 + 25, 15, HEIGHT / 2 - 25));  //right wall

        obstacles.add(new Door(WIDTH - 15, HEIGHT / 2 - 25, 15, 50));


        items.add(new Key(400, 400, 15, 15, false, false));
        items.add(new Key(450, 450, 15, 15, false, false));
        items.add(new Key(500, 500, 15, 15, false, false));
        items.add(new Key(550, 550, 15, 15, false, false));
        items.add(new Key(350, 350, 15, 15, false, false));


        player.inventory.add(new Key(1,1,1,1,true, false));

        //items.add(new Key(WIDTH/2-20, HEIGHT/2-20, 15, 15, false, false)); //was trying to add item before loading level, need help

        /*for(int i = 0; i < 100; i++){
            obstacles.add(new Obstacle(0, 185, 200, 15));
        }*/
    }

    /**
     * <p>TBD</p>
     */
    @Override
    public void levelLogic() {
        Obstacle wall = obstacles.get(5);
        if (time % 4 == 0) {
            if (wall.x + wall.width > WIDTH || wall.x < 200) {
                loop *= -1;
            }
            wall.x += loop * 4;
        }

        /*Creature c = creatures.get(1);
        if(!c.alive){
            return;
        }
        if(c.x > 500 || c.x < 100){
            c.speedX *= -1;
        }*/
    }

}
