/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codename.gametest.entities;

import dev.codename.gametest.Handler;
import dev.codename.gametest.entities.creatures.Brain;
import dev.codename.gametest.entities.creatures.Enemy;
import dev.codename.gametest.entities.creatures.Player;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class EntityManager {
    private Handler handler;
    private Player player;
    private Enemy enemy1, enemy2, enemy3;
    private Brain brain;
    private ArrayList<Entity> entities;
    public EntityManager(Handler handler, Player player, Enemy enemy1,Enemy enemy2, Enemy enemy3, Brain brain){
        this.handler = handler;
        this.player = player;
        this.enemy1 = enemy1;
        this.enemy2 = enemy2;
        this.enemy3 = enemy3;
        this.brain = brain;
        entities = new ArrayList<Entity>();
        addEntity(player);
        addEntity(enemy1);
        addEntity(enemy2);
        addEntity(enemy3);
        addEntity(brain);
        
    }
    public void update(){
        for(int i = 0;i < entities.size();i++){
            Entity e = entities.get(i);
            e.update();
        }
        
    }
    public void render(Graphics g){
        for (Entity e : entities){
            e.render(g);
        }
        
    }
    public void addEntity(Entity e){
        entities.add(e);
    }

    /**
     * @return the handler
     */
    public Handler getHandler() {
        return handler;
    }

    /**
     * @param handler the handler to set
     */
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * @return the entities
     */
    public ArrayList<Entity> getEntities() {
        return entities;
    }

    /**
     * @param entities the entities to set
     */
    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    /**
     * @return the enemy
     */
    public Enemy getEnemy1() {
        return enemy1;
    }

    /**
     * @param enemy the enemy to set
     */
    public void setEnemy1(Enemy enemy) {
        this.enemy1 = enemy1;
    }

    /**
     * @return the enemy2
     */
    public Enemy getEnemy2() {
        return enemy2;
    }

    /**
     * @param enemy2 the enemy2 to set
     */
    public void setEnemy2(Enemy enemy2) {
        this.enemy2 = enemy2;
    }

    /**
     * @return the enemy3
     */
    public Enemy getEnemy3() {
        return enemy3;
    }

    /**
     * @param enemy3 the enemy3 to set
     */
    public void setEnemy3(Enemy enemy3) {
        this.enemy3 = enemy3;
    }
    
}
