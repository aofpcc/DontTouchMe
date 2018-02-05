import greenfoot.*;
/**
 * Write a description of class Animation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Animation
{
    private int currentFrame;
    private int allFrames;
    private String nameSprite;
    private GreenfootImage[] sprites;
    public Animation(String name, int allFrames, int width, int height){
        this.allFrames = allFrames;
        nameSprite = name;
        sprites = new GreenfootImage[allFrames];
        currentFrame = -1;
        for(int i = 0; i < allFrames; ++i){
          sprites[i] = new GreenfootImage(name+i+".png");
          sprites[i].scale(width, height);
        }
    }
    
    public void nextFrame(){
        currentFrame++;
        if(currentFrame == allFrames ) currentFrame = 0;
    }
    
    public GreenfootImage getFrame(){
      nextFrame();
      return sprites[currentFrame];
    }
    
    public int getAllFrames(){
      return allFrames;
    }
}
