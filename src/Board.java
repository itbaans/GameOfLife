import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;

public class Board extends JPanel
        implements ActionListener , MouseInputListener{

    private final int B_WIDTH = 1600;
    private final int B_HEIGHT = 1600;
    private final int DELAY = 35;

    private Timer timer;
    private int key = 0;

    Square[][] squares;
    int xPlus = 0;
    int yPlus = 0;
    
    
    
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            
            int key = e.getKeyCode();
            

            if (key == KeyEvent.VK_SPACE) {
                
            }

        }

        @Override
        public void keyPressed(KeyEvent e) {

        	
            key = e.getKeyCode();

            

        }
    }

    public Board() {

        initBoard();
    }

    private void InitializeAssets() {

        squares = new Square[80][80];

        int xPlus = 0;
        int yPlus = 0;

        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[0].length; j++) {

                squares[i][j] = new Square(20, xPlus, yPlus);
                xPlus += 20;
                if(j == squares[0].length-1) xPlus = 0;
            }
            yPlus += 20;
        }
        
    }

    private void initBoard() {

    	addMouseListener( this );
    	addMouseMotionListener( this );
    	addKeyListener(new TAdapter());
        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setFocusable(true);

        InitializeAssets();
        
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[0].length; j++) {
                squares[i][j].draw(g);
                
            }
        }


        
    }

    public void check(Square[][] arr, int r, int c) {

        int neigbors = 0;

        if(c-1 >= 0) if(arr[r][c-1].getAlive()) neigbors++;
        if(r-1 >= 0) if(arr[r-1][c].getAlive()) neigbors++;
        if(c+1 < arr[0].length) if(arr[r][c+1].getAlive()) neigbors++;
        if(r+1 < arr[0].length) if(arr[r+1][c].getAlive()) neigbors++;
        if(c-1 >= 0 && r-1 >= 0) if(arr[r-1][c-1].getAlive()) neigbors++;
        if(c+1 < arr[0].length && r-1 >= 0) if(arr[r-1][c+1].getAlive()) neigbors++;
        if(r+1 < arr[0].length && c-1 >= 0) if(arr[r+1][c-1].getAlive()) neigbors++;
        if(c+1 < arr[0].length && r+1 < arr[0].length) if(arr[r+1][c+1].getAlive()) neigbors++;

        if(neigbors < 2) arr[r][c].setAlive(false);
        if(neigbors > 3) arr[r][c].setAlive(false);
        if(!arr[r][c].getAlive() && neigbors == 3) arr[r][c].setAlive(true);
        
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[0].length; j++) {
                check(squares, i, j);
            }
        }
        Toolkit.getDefaultToolkit().sync();
        repaint();
    }
    
    public void IsClicked(int x, int y)
    {
    	
    }
    

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
}
