import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids.Creature;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids.Player;

import static org.junit.Assert.*;

import org.junit.*;

public class Testing {
    Game g = new Game();

    @Test
    public void TestGotHit() {
        Player p = new Player(0, 0, 0, 0, 0, true, 0, 100);
        p.gotHit(10);
        int result = p.getHealth();
        assertTrue("The creature with 100 health, that got hit by 10 damage should have 90 health, not  " + result, result == 90);
    }

    @Test
    public void TestDie() {
        Player p = new Player(0, 0, 0, 0, 0, true, 0, 10);
        p.die();
        boolean result = p.alive;
        assertTrue("The player that died, should not be alive. That's not " + result, !result);
    }
}
