/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codename.gametest.entities.creatures;

import dev.codename.gametest.Handler;
import dev.codename.gametest.gfx.Animation;
import dev.codename.gametest.gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author USER
 */
public class Enemy extends Creature {
    //Animation
    private Animation animDown, animUp, animLeft, animRight;
    
   

    public Enemy(Handler handler, float x,float y) {
        super(handler, x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
        
        bound.x = 0;
        bound.y = 0;
        bound.width = 27;
        bound.height = 27;
        
        //Animation
        animDown = new Animation(500, Assets.enemy_down);
        animUp = new Animation (500, Assets.enemy_up);
        animLeft = new Animation (500, Assets.enemy_left);
        animRight = new Animation (500,Assets.enemy_right);
    }
    

    @Override
    public void update() {
        //animation
        animDown.update();
        animUp.update();
        animLeft.update();
        animRight.update();
        //move
        x-=speed;
        move();
        
        
    }
    
    
    
    private void aiMove(){
        xMove = 0;
        yMove = 0;
        Random ran = new Random();
        int n = ran.nextInt(3);
        if(n==0){
            yMove= -speed;
            y-=speed;
        }
        int i = ran.nextInt(3);
        if(i==1){
            yMove= speed;
            y+=speed;
        }
        if(n==2){
            xMove= -speed;
            x-=speed;
        }
        if(n==3){
            xMove= speed;
            x+=speed;
        }
        
                
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int)getX(),(int)getY(), null);
//        g.setColor(Color.red);
//        g.fillRect((int)(x+ bound.x),(int)(y+ bound.y),bound.width,bound.height);
    }
    private BufferedImage getCurrentAnimationFrame(){
        if(xMove < 0){
            return animLeft.getCurrentFrame();
        }else if (xMove > 0){
            return animRight.getCurrentFrame();
        }else if (yMove < 0){
            return animUp.getCurrentFrame();
        }else{
            return animDown.getCurrentFrame();
        }
    }
    
    
}
