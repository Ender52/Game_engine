package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.items;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.Item;

import java.awt.*;

public class Key extends Item {
    public Key(int x, int y, int width, int height, boolean taken, boolean equiped) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.taken = taken;
        this.equiped = equiped;
        color = Color.yellow;
        name = "Key";
    }
}