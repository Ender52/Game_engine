package semestralproject;

import java.awt.Color;
import java.awt.Rectangle;

public class Obstacle extends Rectangle{
    Rectangle obstacle;
    Color color = Color.LIGHT_GRAY;

    public Obstacle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        obstacle = new Rectangle(x, y, width, height);
    }
    
}
