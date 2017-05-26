package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.graphics.objectRenderers.ObjectRenderer;
import java.awt.Rectangle;
/**
 * <p>An abstract class that unifies all the objects in the game by the way they are rendered</p>
 * 
 */
public abstract class IngameObject extends Rectangle{
    public ObjectRenderer or;
}
