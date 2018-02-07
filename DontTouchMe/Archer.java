import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Archer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Archer extends Characters
{
    /**
     * Act - do whatever the Archer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Animation walkingDown;
    private Animation walkingLeft;
    private Animation walkingUp;
    private Animation walkingRight;

    private Animation standDown;
    private Animation standLeft;
    private Animation standUp;
    private Animation standRight;
    
    //private Animation attackAnimation;

    
    public Archer(String name, int x, int y){
      super( name, 10, 500 , x, y);
      
      walkingDown = new Animation( "characters/player/walkingDown", 8, getX(), getY() );
      walkingLeft = new Animation( "characters/player/walkingLeft", 8, getX(), getY() );
      walkingUp = new Animation( "characters/player/walkingUp", 8, getX(), getY() );
      walkingRight =  new Animation( "characters/player/walkingRight", 8, getX(), getY());
    
      standDown = new Animation( "characters/player/standDown", 1, getX(), getY() );
      standUp = new Animation( "characters/player/standUp", 1, getX(), getY() );
      standLeft = new Animation( "characters/player/standLeft", 1, getX(), getY() );
      standRight = new Animation( "characters/player/standRight", 1, getX(), getY());
      
      
      setAnimation( standDown );
      setImage( standDown.getFrame() );
      
    }  

  public Animation getWalkingDown(){
    return walkingDown;
  }
  public Animation getWalkingLeft(){
    return walkingLeft;
  }
  public Animation getWalkingUp(){
    return walkingUp;
  }
  public Animation getWalkingRight(){
    return walkingRight;
  }
  
  
  public Animation getStandDown(){
    return standDown;
  }
  public Animation getStandLeft(){
    return standLeft;
  }
  public Animation getStandUp(){
    return standUp;
  }
  public Animation getStandRight(){
    return standRight;
  } 

}
