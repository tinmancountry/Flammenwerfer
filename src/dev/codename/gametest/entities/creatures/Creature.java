/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codename.gametest.entities.creatures;

import dev.codename.gametest.Game;
import dev.codename.gametest.Handler;
import dev.codename.gametest.entities.Entity;
import dev.codename.gametest.states.State;
import dev.codename.gametest.tiles.Tile;

/**
 *
 * @author USER
 */
public abstract class Creature extends Entity {
    
    public static final int DEFAULT_HEALTH = 3;
    public static final float DEFAULT_SPEED = 3.0f; 
    public static final int DEFAULT_CREATURE_WIDTH = 32,
                            DEFAULT_CREATURE_HEIGHT = 32;
    
    
    protected int health;
    protected float speed;
    protected float xMove;
    protected float yMove;
    protected int score;
    
    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y,width,height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }
    public void move(){
        moveX();
        moveY();
        damageX();
        damageY();
        System.out.println(health);     
    }
    public void score(){
        scoreX();
        scoreY();
        System.out.println(score);
    }
    public void scoreX(){
        if(xMove > 0){//MOving Right
            int tx = (int)(x + xMove + bound.x + bound.width) / Tile.TILEWIDTH;
            if(!scoreWithTile(tx, (int) (y+bound.y)/ Tile.TILEHEIGHT) &&
                    !scoreWithTile(tx, (int) (y + bound.y + bound.height)/ Tile.TILEHEIGHT)){
                score=score;
            }else{
                
                score= score + 1;
                System.out.println(score);
            }
        }else if (xMove < 0){//Moving Left
            int tx = (int)(x + xMove + bound.x ) / Tile.TILEWIDTH;
            if(!scoreWithTile(tx, (int) (y+bound.y)/ Tile.TILEHEIGHT) &&
                    !damageWithTile(tx, (int) (y + bound.y + bound.height)/ Tile.TILEHEIGHT)){
               score=score;
            }else{
                score= score + 1;
                System.out.println(score);
            }
        }
    }
    public void scoreY(){
        if(yMove < 0){//Moving Up
            int ty =(int)(y+ yMove+ bound.y)/Tile.TILEHEIGHT;
            
            if (!scoreWithTile((int)(x+ bound.x)/Tile.TILEWIDTH,ty)&&
                    !scoreWithTile((int)(x+ bound.x+ bound.width)/Tile.TILEWIDTH,ty)){
                score=score;
            }else{
                score= score + 1;
                System.out.println(score);
            }
        }else if(yMove >0){//Moving Down
           int ty =(int)(y+ yMove+ bound.y+ bound.height)/Tile.TILEHEIGHT;
            
            if (!scoreWithTile((int)(x+ bound.x)/Tile.TILEWIDTH,ty)&&
                    !scoreWithTile((int)(x+ bound.x+ bound.width)/Tile.TILEWIDTH,ty)){
                score=score;
            } else{
                score= score + 1;
                System.out.println(score);
            }
        }
    }
    
    public void damageX(){
        if(xMove > 0){//MOving Right
            int tx = (int)(x + xMove + bound.x + bound.width) / Tile.TILEWIDTH;
            if(!damageWithTile(tx, (int) (y+bound.y)/ Tile.TILEHEIGHT) &&
                    !damageWithTile(tx, (int) (y + bound.y + bound.height)/ Tile.TILEHEIGHT)){
                health=health;
            }else{
                x = tx * Tile.TILEWIDTH - bound.x - bound.width - 1;
                health= health - 1;
                System.out.println(health);
            }
        }else if (xMove < 0){//Moving Left
            int tx = (int)(x + xMove + bound.x ) / Tile.TILEWIDTH;
            if(!damageWithTile(tx, (int) (y+bound.y)/ Tile.TILEHEIGHT) &&
                    !damageWithTile(tx, (int) (y + bound.y + bound.height)/ Tile.TILEHEIGHT)){
               health=health;
            }else{
                health= health - 1;
                System.out.println(health);
            }
        }
    }
    public void damageY(){
        if(yMove < 0){//Moving Up
            int ty =(int)(y+ yMove+ bound.y)/Tile.TILEHEIGHT;
            
            if (!damageWithTile((int)(x+ bound.x)/Tile.TILEWIDTH,ty)&&
                    !damageWithTile((int)(x+ bound.x+ bound.width)/Tile.TILEWIDTH,ty)){
                health=health;
            }else{
                health= health - 1;
                System.out.println(health);
            }
        }else if(yMove >0){//Moving Down
           int ty =(int)(y+ yMove+ bound.y+ bound.height)/Tile.TILEHEIGHT;
            
            if (!damageWithTile((int)(x+ bound.x)/Tile.TILEWIDTH,ty)&&
                    !damageWithTile((int)(x+ bound.x+ bound.width)/Tile.TILEWIDTH,ty)){
                health=health;
            } else{
                health= health - 1;
                System.out.println(health);
            }
        }
    }
    
    public void moveX(){
        if(xMove > 0){//MOving Right
            int tx = (int)(x + xMove + bound.x + bound.width) / Tile.TILEWIDTH;
            if(!collisionWithTile(tx, (int) (y+bound.y)/ Tile.TILEHEIGHT) &&
                    !collisionWithTile(tx, (int) (y + bound.y + bound.height)/ Tile.TILEHEIGHT)){
                x += xMove;
            }else{
                x = tx * Tile.TILEWIDTH - bound.x - bound.width - 1;
            }
        }else if (xMove < 0){//Moving Left
            int tx = (int)(x + xMove + bound.x ) / Tile.TILEWIDTH;
            if(!collisionWithTile(tx, (int) (y+bound.y)/ Tile.TILEHEIGHT) &&
                    !collisionWithTile(tx, (int) (y + bound.y + bound.height)/ Tile.TILEHEIGHT)){
               x += xMove;
            }else{
                x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bound.x;
            }
        }
    }
    
    
   
    
    public void moveY(){
        if(yMove < 0){//Moving Up
            int ty =(int)(y+ yMove+ bound.y)/Tile.TILEHEIGHT;
            
            if (!collisionWithTile((int)(x+ bound.x)/Tile.TILEWIDTH,ty)&&
                    !collisionWithTile((int)(x+ bound.x+ bound.width)/Tile.TILEWIDTH,ty)){
                y+=yMove;
            }else{
                y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bound.y;
            }
        }else if(yMove >0){//Moving Down
           int ty =(int)(y+ yMove+ bound.y+ bound.height)/Tile.TILEHEIGHT;
            
            if (!collisionWithTile((int)(x+ bound.x)/Tile.TILEWIDTH,ty)&&
                    !collisionWithTile((int)(x+ bound.x+ bound.width)/Tile.TILEWIDTH,ty)){
                y+=yMove;
            } else{
                y = ty* Tile.TILEHEIGHT - bound.y - bound.height - 1;
            }
        }
    }
    protected boolean collisionWithTile(int x, int y){
        return handler.getWorld().getTile(x, y).isSolid();
    }
    protected boolean damageWithTile(int x, int y){
        return handler.getWorld().getTile(x, y).isDamaging();
    }
    protected boolean scoreWithTile(int x, int y){
        return handler.getWorld().getTile(x, y).isPoint();
    }
 

   
         
         
    public int getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * @return the speed
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     * @return the xMove
     */
    public float getxMove() {
        return xMove;
    }

    /**
     * @param xMove the xMove to set
     */
    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    /**
     * @return the yMove
     */
    public float getyMove() {
        return yMove;
    }

    /**
     * @param yMove the yMove to set
     */
    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
    
    
    
    
}
