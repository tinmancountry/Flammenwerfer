/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codename.gametest.entities.creatures;

import dev.codename.gametest.Game;
import dev.codename.gametest.Handler;
import dev.codename.gametest.entities.EntityManager;
import dev.codename.gametest.gfx.Animation;
import dev.codename.gametest.gfx.Assets;
import dev.codename.gametest.states.State;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author USER
 */
public class Player extends Creature {
    
    //Animation
    private Animation animDown, animUp, animLeft, animRight;
    
    public Player( Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        
        bound.x = 0;
        bound.y = 0;
        bound.width = 27;
        bound.height = 27;
        
        //Animation
        animDown = new Animation(500, Assets.player_down);
        animUp = new Animation (500, Assets.player_up);
        animLeft = new Animation (500, Assets.player_left);
        animRight = new Animation (500,Assets.player_right);
    }
    private EntityManager entityManager;
    public void death(){
        if (health==0){
            State.setState(handler.getGame());
            
        }
    }

    @Override
    public void update() {
        //animation
        animDown.update();
        animUp.update();
        animLeft.update();
        animRight.update();
        //movement  
        getInput();
        move();
        death();
      
    }
    private void getInput(){
        xMove = 0;
        yMove = 0;
        
        if(handler.getKeyManager().up)
            yMove = -speed;
        if(handler.getKeyManager().down)
            yMove =  speed;
        if(handler.getKeyManager().left)
            xMove = -speed;
        if(handler.getKeyManager().right)
            xMove =  speed;
            
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
