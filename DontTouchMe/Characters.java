import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Characters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Characters extends Actor
{
    /**
     * Act - do whatever the Characters wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Animation anim;
    private int skillFrame;
    private String name;
    private double atk;
    private double hp;
    private double maxHp;
    private boolean isMoving;
    private int direct = 1;
    private boolean isDead;
    
    private int animDelay = 0;
    
    private int x, y; // position
    private int speed = 4;
    
    public Characters( String name, double atk, double maxHp, int x, int y){
      this.name = name;
      this.atk  = atk;
      this.hp   = maxHp;
      this.maxHp = maxHp;
      this.x = x;
      this.y = y;
    }
    
    public void act() 
    {
        if( animDelay++ >= 6){
          setImage( anim.getFrame() );
          animDelay = 0;
        }
    }
    public void setAnimation(Animation x){
      anim = x;
    }
    public Animation getAnimation(){
      return anim;
    }
    public void setIsMoving(boolean m){
      this.isMoving = m;
    }
    public int getSkillFrame(){
      return skillFrame;
    }
    public void setDirect(int d){
      direct = d;
    }
    public int getDirect(){
      return direct;
    }
    public boolean isDead(){
      return hp - 0<= 0.01;
    }
    public void walk(){
      switch( direct ){
          case 1:
            y += speed;
            break;
          case 2:
            x -= speed;
            break;
          case 3:
            y -= speed;
            break;
          case 4:
            x += speed;
            break;
      }
      setLocation( x, y);
      setXY( x, y );
   }
   public void setXY(int x, int y){
     this.x = x;
     this.y = y;
   }
   public int getX(){
     return x; 
   }
   public int getY(){
     return y; 
   }
   
   public String getName(){
     return name; 
   }
   public int getHp(){
     return (int)hp; 
   }
   public int getMaxHp(){
     return (int)maxHp; 
   }
}
