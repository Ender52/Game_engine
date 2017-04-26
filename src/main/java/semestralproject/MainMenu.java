package semestralproject;


import java.awt.Color;
import java.awt.Font;

public class MainMenu extends IngameMenu{
    IngameButton buttonLevel1;
    public MainMenu(int x, int y, int width, int height) {
        super(x, y, width, height);
        Start.frame.addKeyListener(this);
        color = Color.getHSBColor(0f, 0f, 0.7f);
        Font font = new Font("Arial", 1, 35);
        buttonLevel1 = new IngameButton();
        buttons.add(buttonLevel1);
        buttonLevel1.x = x + 10;
        buttonLevel1.y = y + 10;
        buttonLevel1.width = width - 20;
        buttonLevel1.height = 60;
        buttonLevel1.color = Color.getHSBColor(0.66f, 0.4f, 0.5f);
        buttonLevel1.fontColor = Color.getHSBColor(0.5f, 0.6f, 0.7f);
        buttonLevel1.font = font;
        buttonLevel1.name = "Level 1";
        buttonLevel1.fontX = x + 15;
        buttonLevel1.fontY = y + 15 + 35;
        buttonLevel1.positionInList = position;
        buttonLevel1.activeColor = buttonLevel1.color.brighter();
        buttonLevel1.positionInList = buttons.size();
        buttonLevel1.fontColorActive = buttonLevel1.fontColor.brighter();
        
    }

}
