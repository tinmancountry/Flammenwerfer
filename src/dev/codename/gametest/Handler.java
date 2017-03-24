/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codename.gametest;

import dev.codename.gametest.input.KeyManager;
import dev.codename.gametest.worlds.World;

/**
 *
 * @author USER
 */
public class Handler {
    private Game game;
    private World world;
    
    public Handler(Game game){
        this.game = game;
        
    }
    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }
    public int getWidth(){
        return game.width;
        
    }
    public int getHeight(){
        return game.height;
        
    }
    

    /**
     * @return the game
     */
    public Game getGame() {
        return game;
    }

    /**
     * @param game the game to set
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * @return the world
     */
    public World getWorld() {
        return world;
    }

    /**
     * @param world the world to set
     */
    public void setWorld(World world) {
        this.world = world;
    }
}
