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
        player = new Player(WIDTH / 2 - 20, HEIGHT / 2 - 20, 40, 40, 4, true, 10, 100);

        creatures.add(player);

        loadInventory("./src/main/resources/LVL1inventory.txt");
        loadLevel("./src/main/resources/Level1.txt");
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
    }
}
