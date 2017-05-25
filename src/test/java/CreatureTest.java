import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids.Creature;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.levels.Level;
import static org.junit.Assert.*;
import org.junit.*;

public class CreatureTest {
    @Test
    public void TestGotHit()
    {
        Level l = new Level();
        Creature c = new Creature(300, 300, 15, 15, 1, true, 3, 100,"/sprites/player");
        c.gotHit(10);
        int result = c.getHealth();
        assertTrue("The creature with 100 health, that got hit by 10 damage should have 90 health, not  " + result, result == 90);
    }
}
