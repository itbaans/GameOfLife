import java.awt.Color;
import java.awt.Graphics;

public class Myframe {

    private int height = 400;
    private int width = 400;
    private int x = 0;
    private int y = 0;

    public void drawFrame(Graphics g) {
        
        g.setColor(Color.black);
        g.fillRect(x, y, width, height);
    }
    
}
