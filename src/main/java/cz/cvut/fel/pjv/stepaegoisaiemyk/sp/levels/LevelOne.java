package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.levels;


import java.awt.Color;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids.Creature;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids.Player;

/**
 * <p>Extends Level class which is more abstract, works with txt files to generate a level</p>
 * <p>The implementation of simple AI is also here</p>
 */
public class LevelOne extends Level {
    /**
     * <p>The construction of the level one</p>
     */
    public LevelOne() {  //constructor
        pause = false;

        color = Color.getHSBColor(0.66f, 0.4f, 0.5f);
        player = new Player(1350, 1350, 40, 40, 4, true, 10, 100);

        creatures.add(player);

        loadInventory("./src/main/resources/LVL1inventory.txt");
        loadLevel("./src/main/resources/Level1.txt");
    }

    /**
     * <p>Implementaion of AI</p>
     */
    @Override
    public void levelLogic() {
        for (Creature c : creatures) {
            if (c == player) {
                continue;
            }
            if (Math.sqrt(Math.pow((c.x - player.x), 2) + Math.pow((c.y - player.y), 2)) < 150) {
                c.speedX = -c.speed * (int) Math.signum((c.x - player.x));
                c.speedY = -c.speed * (int) Math.signum((c.y - player.y));
                if (c.simpleAttackRanges.get(c.direction).intersects(player) && time % 40 == 0) {
                    c.simpleAttack(c.damage);
                }
            } else {
                c.speedX = 0;
                c.speedY = 0;
            }
        }
    }
}
