package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.graphics.objectRenderers;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.IngameObject;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
/**
 * <p>An abstract class defining a single abstract method</p>
 * <p>It unifies rendering processes of different IngameObject's so thay can be called in one cyckle</p>
 * 
 */
public abstract class ObjectRenderer {
    public abstract void paintObject(IngameObject io, Graphics g, ImageObserver o);
}
