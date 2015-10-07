
/*
 * This is Pad class which defines behavior of Pad used in Game which handles ball
 *
 */

/**
 *
 * @author dinesh salve
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class Pad {

    private int dx;         //change in position of pad
    
    private int x = 220;    //current position of pad X
    private int y = 435;    //current position of pad Y
    private int width = 60; //width of pad
    private int height = 6; //height of pad
    private ArrayList bulletList;  //list of bulelts fired by weapon
    private boolean bulletPower = false; //if pad has bullet power

    public Pad() {

        bulletList = new ArrayList();
        x = 220;
        y = 435;
        width = 60;
        height = 6;

    }

    public void move() { //move pad

        x += dx;
        if (x < 1) { //if pad is near left wall
            x = 1;
        } else if (getX() > 500 - width) {  //if pad is near right wall
            x = 500 - width;
        }

    }

    private boolean fireCheck = false;
    private int LastX = 200;
    
    public void FireHack() 
    {
    	if(fireCheck) 
    	{
    		fireCheck = false;
    		  if(bulletPower)
              {
                  fire();   //fire a bullet when space is pressed
              }
    	}
    }
    
    public int getX() {
    	
    	if((PadDriver.PadDriver.GetXLeftEye() == PadDriver.NO_DATA 
    			|| PadDriver.PadDriver.GetXLeftEye() == PadDriver.NO_DATA) && !fireCheck)
    	{
    		fireCheck = true;
    		return LastX;
    	}
    	
    	
    	int NewX = 0;
    	
    	NewX += PadDriver.PadDriver.GetXLeftEye()  / 2;
    	NewX += PadDriver.PadDriver.GetXRightEye() / 2;
    	NewX -= this.width / 2;
    	NewX = NewX - NewX % 10;
    	NewX -=Game.Location.getX();
    	
    	LastX = NewX;
        return NewX;
    }

    public int getY() {
        return y;
    }

    public void setX(int newX) {
        x = newX;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int newWidth) { // change pad size
        width = newWidth;
    }

    public int getHeight() {
        return height;
    }

    public ArrayList getBullets() {
        return bulletList;
    }

    public boolean getBulletPower() {
        return bulletPower;
    }

    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), width, height);
    }
    public ArrayList<Bullet> getBulletList()
    {
        return bulletList;
    }

    public void changePad(String newType) { //change pad based on power
        if (newType.equals("makeBig")) { //got big puddle
            width = 90;
            bulletPower=false;

        }
        if (newType.equals("makeSmall")) { //got small puddle
            width = 30;
            bulletPower=false;
        }
        if (newType.equals("makeGun")) { //got weapon
            width = 60;
            bulletPower=true;
        }
    }

    public void draw(Graphics g) {
    	//draw pad on screen
    	FireHack();
    	
        if (bulletPower == false) {
            g.setColor(Color.black);
            g.fillRect(getX(), getY(), width, height);
        } else {
            g.setColor(Color.black);
            g.fillRect(getX()+ width/3 -3,getY()-height/2, width/2, height/2);
            g.fillRect(getX()+ width/2, getY()-(height/2)-4, 3, 4);
            g.fillRect(getX(), getY(), width, height);
        }
    }

    public void resetPad() { //reset pad to initial position
        x = 220;
        y = 435;
        width = 60;
        bulletPower=false;
        bulletList.clear();

    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            if(bulletPower)
            {
                fire();   //fire a bullet when space is pressed
            }
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }
    }

    public void fire() {  //fire a bullet
        
            if(bulletList.size()<3){
            Bullet b=new Bullet(getX()+(width/2), getY()-3);
            bulletList.add(b);
        }
    }



    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

    }
}
