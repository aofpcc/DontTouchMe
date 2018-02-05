import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends Actor
{
    /**
     * Act - do whatever the Floor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // size should be equals
    private int x;
    private int y;
    private GreenfootImage image;
    public Floor(String namePath, int size, int x, int y){
        image = new GreenfootImage(namePath+ ".png");
        this.x = x;
        this.y = y;
        //image.scale( size, size );
        setImage( image );
    }
    public void setPosition(int x, int y){
      this.x = x;
      this.y = y;
    }
    public int getX(){
      return x;
    }
    public int getY(){
      return y;
    }
}
