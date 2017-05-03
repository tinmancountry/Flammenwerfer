/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codename.gametest.states;

import dev.codename.gametest.Handler;
import dev.codename.gametest.worlds.World;
import java.awt.Graphics;
import java.util.Timer;

/**
 *
 * @author USER
 */
public class GameState extends State {
    
   
    private World world;
    static Timer timer;
    
    
    
    public GameState(Handler handler){
        super(handler);
        world = new World(handler,"Res/World/world1.txt");
        handler.setWorld(world); 
        timer = new Timer();
        
        
        
    }



    @Override
    public void update() {
        world.update();
        
        
       
        
    }

    @Override
    public void render(Graphics g) {
       world.render(g);
       
       
    }
    
}
