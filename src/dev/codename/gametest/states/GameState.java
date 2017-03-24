/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codename.gametest.states;

import dev.codename.gametest.Game;
import dev.codename.gametest.Handler;
import dev.codename.gametest.entities.creatures.Player;
import dev.codename.gametest.gfx.Assets;
import dev.codename.gametest.tiles.Tile;
import dev.codename.gametest.worlds.World;
import java.awt.Graphics;

/**
 *
 * @author USER
 */
public class GameState extends State {
    
    private Player player;
    private World world;
    
    public GameState(Handler handler){
        super(handler);
        world = new World(handler,"Res/World/world1.txt");
        handler.setWorld(world);
        player = new Player(handler,100, 100);
        
        
        
    }



    @Override
    public void update() {
        world.update();
        player.update();
       
        
    }

    @Override
    public void render(Graphics g) {
       world.render(g);
       player.render(g);
       
    }
    
}
