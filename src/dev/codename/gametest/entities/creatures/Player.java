/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codename.gametest.entities.creatures;

import dev.codename.gametest.Game;
import dev.codename.gametest.Handler;
import dev.codename.gametest.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author USER
 */
public class Player extends Creature {
    
    
    public Player( Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        
        bound.x = 0;
        bound.y = 0;
        bound.width = 27;
        bound.height = 27;
    }

    @Override
    public void update() {
       getInput();
       move();
      
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
        g.drawImage(Assets.player, (int)getX(),(int)getY(), null);
        g.setColor(Color.red);
        g.fillRect((int)(x+ bound.x),(int)(y+ bound.y),bound.width,bound.height);
    }
    
    
    
}
