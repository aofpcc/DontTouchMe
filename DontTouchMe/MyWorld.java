import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private int height;
    private int width;
    private int bgSize;
    private Floor[] bg;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        // width , height
        super(600, 400, 1, false);
        
        width = getWidth();
        height = getHeight();
        
        bgSize = 32;
        int w, h;
        h = height/bgSize + 5;
        w = width/bgSize + 5;
        bg = new Floor[w*h];

        // set floor 
        for(int i = 0; i < w; ++i){
            for(int j = 0; j < h; ++j){
                bg[i+j] = new Floor("backgrounds/floor/typeA/00", bgSize, i*bgSize, j*bgSize );
                addObject( bg[i+j] , bg[i+j].getX(), bg[i+j].getY() );
            }
        }
        Greenfoot.setSpeed(48);
        
        //controller = new Controller(player);
        //addObject(controller, -100, -100);
        
        //UI 
        //addObject(new InfoButton(), width-30, 30); 
        /*
        for(int i = 0; i < 15; ++i){
            Skeleton test = new Skeleton( new Vector2(100 + i*30, 100 + i*30), new Vector2( 75, 80 ) );
            test.setHpBar( new HealthBar(test) );
            addObject(test, test.getPosition().getX(), test.getPosition().getY());
            addObject( test.getHpBar(), test.getPosition().getX(), test.getPosition().getY()-(test.getSize().getY()/2) );
        }*/
        
        //setPaintOrder( GameUI.class, HealthBar.class );
    }
    
    public void act(){
      /*
      try{ 
          ServerConnector.get();
      }catch(Exception e){
        System.out.println(e);
      }*/
      //Greenfoot.stop();
    }
}
