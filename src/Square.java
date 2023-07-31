import java.awt.Color;
import java.awt.Graphics;

public class Square {
    
    public int x;
    public int y;
    private int length;
    private boolean alive;

    public Square(int length, int x, int y) {
        this.length = length;
        this.x = x;
        this.y = y;       
        int rand = (int)(Math.random()*100);
        if(rand < 10)
            alive = true;
        
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean getAlive() {
        return alive;
    }


    public void draw(Graphics g) {
        
        if(alive) {
            g.setColor(Color.white);
            g.fillRect(x, y, length, length);
        }

    }
}
