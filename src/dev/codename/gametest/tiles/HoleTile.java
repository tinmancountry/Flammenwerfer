/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codename.gametest.tiles;

import dev.codename.gametest.gfx.Assets;

/**
 *
 * @author USER
 */
public class HoleTile extends Tile {
    
    public HoleTile(int id) {
        super(Assets.hole, id);
    }
    
    @Override
    public boolean isDamaging(){
        return true;
    }
    
 
    
}
