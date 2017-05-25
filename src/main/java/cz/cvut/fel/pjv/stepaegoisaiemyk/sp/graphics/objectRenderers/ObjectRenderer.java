package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.graphics.objectRenderers;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.IngameObject;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

public abstract class ObjectRenderer {
    public abstract void paintObject(IngameObject io, Graphics g, ImageObserver o);
}
