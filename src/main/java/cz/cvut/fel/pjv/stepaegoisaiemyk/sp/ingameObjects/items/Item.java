package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.items;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.graphics.objectRenderers.ItemRenderer;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.IngameObject;
import java.awt.*;


public class Item extends IngameObject {
    public boolean taken = false;
    public boolean equiped = false;
    public String name = "Item";
    public Color color = Color.black;
    
    public Item(){
        or = new ItemRenderer("/sprites/items");
    }
}
