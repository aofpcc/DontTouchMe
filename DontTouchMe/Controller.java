import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Controller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controller extends Actor
{
    /**
     * Act - do whatever the Controller wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
  private Characters player;
  private boolean isNotBounded;
  public Controller(Characters player){
    this.player = player;  
  }
  public void act(){/*
    if( player.getSkillFrame() > 0 || player.isDead()){
        
    }
    else if( player.getAttack() != null && Greenfoot.isKeyDown("Space") ){
        //System.out.println("Attack");
        if( player.getSkillFrame() == 0){
            player.attack();
        }
    }
    else if(Greenfoot.isKeyDown("Down")){
        //if( getDirect() != 1 )
        player.setDirect(1);
        player.setAnimation(player.getWalkingDown());
        if(canMove()){
            if( !isNotBounded ) player.walk();
            player.setIsMoving(true);
        }
    }
    else if(Greenfoot.isKeyDown("Left")){
        //if( getDirect() != 2 )
        player.setDirect(2);
        player.setAnimation(player.getWalkingLeft());
        if(canMove()){
            if( !isNotBounded ) player.walk();
            player.setIsMoving(true);
        }
    }
    
    else if(Greenfoot.isKeyDown("Up")){
        //if( getDirect() != 3 )
        player.setDirect(3);
        player.setAnimation(player.getWalkingUp());
        if(canMove()){
            if( !isNotBounded ) player.walk();
            player.setIsMoving(true);
        }
    }
    else if(Greenfoot.isKeyDown("Right")){
        //if( getDirect() != 4 )
        player.setDirect(4);
        player.setAnimation(player.getWalkingRight());
        if(canMove()){
            if( !isNotBounded ) player.walk();
            player.setIsMoving(true);
        }
    }
    else{
        player.setIsMoving(false);
       switch(player.getDirect()){
         case 1: player.setAnimation(player.getStandDown()); break;
         case 2: player.setAnimation(player.getStandLeft()); break;
         case 3: player.setAnimation(player.getStandUp()); break;
         case 4: player.setAnimation(player.getStandRight()); break;
       }
    }
    
    //Open info with button
    if(Greenfoot.isKeyDown("E"))
    {
        
    }*/
  }
  public void setIsNotBounded(boolean b){
     this.isNotBounded = b;
  }
  
  public boolean canMove(){
      return true;
      /*if( player.getDirect() == 1 ||  player.getDirect() == 3 )
          return player.nextStep() - 10 > 0 && player.nextStep() < 650;
      return player.nextStep() - 10 > 0 && player.nextStep() < 1150;*/
  }
    
} 
