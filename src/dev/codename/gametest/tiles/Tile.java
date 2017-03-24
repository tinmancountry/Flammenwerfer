/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codename.gametest.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author USER
 */
public class Tile {
    //STATIC STUFF HERE
    
    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile stoneTile = new StoneTile (1);
    public static Tile dirtTile = new DirtTile(2);
    public static Tile holeTile = new HoleTile(3);
    
    //CLASS
    public static final int TILEWIDTH = 32, TILEHEIGHT = 32;
    protected BufferedImage texture;
    protected final int id;
    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;
        
        tiles[id] = this;
    }
    
    public void update(){
        
    }
    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }
    
    public boolean isSolid(){
        return false;
    }
    
    public int getId(){
        return id;
    }
}
