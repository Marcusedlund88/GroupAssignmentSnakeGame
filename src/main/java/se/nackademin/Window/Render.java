package se.nackademin.Window;

import se.nackademin.game.GameComponent;

import java.awt.*;

public class Render {

    private GameComponent c;

    public Render(GameComponent c) {

        Graphics g = c.getWindow().getCanvas().getGraphics();
    }
    public void drawGrid(Graphics g, int noGrids, int width, int height){

        for (int i = 0; i < noGrids; i++) {
            g.setColor(Color.black);
            g.drawLine(i*width/noGrids,0,i*width/noGrids, height);
        }
        for (int i = 0; i < noGrids; i++) {
            g.setColor(Color.black);
            g.drawLine(0,i*height/noGrids,width, i*height/noGrids);
        }
    }
    public void drawRectangle(Graphics g, int xPos, int yPos, int noGrids, int width, int height){

        g.setColor(Color.BLACK);
        g.fillRect(xPos,yPos,width/noGrids,height/noGrids);

    }
}