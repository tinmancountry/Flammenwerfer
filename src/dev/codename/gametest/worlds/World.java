/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codename.gametest.worlds;

import dev.codename.gametest.Game;
import dev.codename.gametest.Handler;
import dev.codename.gametest.entities.EntityManager;
import dev.codename.gametest.entities.creatures.Enemy;
import dev.codename.gametest.entities.creatures.Player;
import dev.codename.gametest.tiles.Tile;
import dev.codename.gametest.utils.Utils;
import java.awt.Graphics;

/**
 *
 * @author USER
 */
public class World {
    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;
    //Entities
    private EntityManager entityManager;
    
    public World(Handler handler, String path){
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler,0,0), new Enemy (handler,200,400),
                new Enemy (handler,300,100),new Enemy (handler,400,267));
        
        loadWorld(path);
        
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);

    }
   
    public void update(){
        getEntityManager().update();
    }
    public void render(Graphics g){
        for(int y = 0;y < height;y++){
            for(int x = 0;x < width;x++){
                getTile(x,y).render(g, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT);
                
            }
        }
        //Entities
        getEntityManager().render(g);
    }
    
    public Tile getTile(int x, int y){
        if(x < 0 || y < 0 || x >= width || y >= height)
            return Tile.dirtTile;
        
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
            return Tile.dirtTile;
        return t;
    }
    
     
    private void loadWorld(String path){
       String file = Utils.loadFileAsString(path);
       String[] tokens = file.split("\\s+");
       width = Utils.parseInt(tokens[0]);
       height = Utils.parseInt(tokens[1]);
       spawnX = Utils.parseInt(tokens[2]);
       spawnY = Utils.parseInt(tokens[3]);
       
       tiles = new int [width][height];
       for(int y = 0;y < height;y++){
           for(int x = 0;x < width;x++){
               tiles[x][y] = Utils.parseInt(tokens[(x + y * width)+4]);
           }
       }
    }

    /**
     * @return the entityManager
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }
    
}
