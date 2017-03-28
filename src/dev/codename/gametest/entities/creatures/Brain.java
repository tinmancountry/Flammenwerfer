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

/**
 *
 * @author USER
 */
public class Brain extends Creature {
    private Animation brain;

    public Brain(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        bound.x = 0;
        bound.y = 0;
        bound.width = 27;
        bound.height = 27;
        
        //Animation
        brain = new Animation(450, Assets.brain_item);
    }

    @Override
    public void update() {
        brain.update();
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int)getX(), (int)getY(), null);
    }
    private BufferedImage getCurrentAnimationFrame(){
        if(xMove < 0){
            return brain.getCurrentFrame();
        }else if (xMove > 0){
            return brain.getCurrentFrame();
        }else if (yMove < 0){
            return brain.getCurrentFrame();
        }else{
            return brain.getCurrentFrame();
        }
    }
    
}
