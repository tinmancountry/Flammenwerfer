/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codename.gametest.gfx;

import com.sun.prism.Texture;
import java.awt.image.BufferedImage;

/**
 *
 * @author USER
 */
public class Assets {
    private static final int width=32, height=32;
    
    public static BufferedImage  dirt, wall, stone, hole, enemy,brain;
    public static BufferedImage[] player_down, player_up, player_left, player_right; 
    public static BufferedImage[] enemy_down, enemy_up, enemy_left, enemy_right;
    public static BufferedImage[] btn_start;
    public static BufferedImage[] brain_item;
    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/Texture/sheet.png"));
        enemy_up = new BufferedImage[2];
        enemy_down = new BufferedImage[2];
        enemy_left = new BufferedImage[2];
        enemy_right = new BufferedImage[2];
        brain_item = new BufferedImage[2];
        brain_item[0] = sheet.crop(width*2, width, width, height);
        brain_item[1] = sheet.crop(width, 0, width, height);
        enemy_down[0] = sheet.crop(width *4, 0, width, height);
        enemy_down[1] = sheet.crop(width *5, 0, width, height);
        enemy_up[0] = sheet.crop(width *6, 0, width, height);
        enemy_up[1] = sheet.crop(width *7, 0, width, height);
        enemy_left[0] = sheet.crop(width *6, height, width, height);
        enemy_left[1] = sheet.crop(width *7, height, width, height);
        enemy_right[0] = sheet.crop(width *4, height, width, height);
        enemy_right[1] = sheet.crop(width *5, height, width, height);
                
        
        
        
        btn_start = new BufferedImage[2];
        btn_start[0] = sheet.crop(width * 6, height*4, width*2, height);
        btn_start[1] = sheet.crop(width * 6, height*5, width*2, height);
        player_down = new BufferedImage[2];
        player_down[0] = sheet.crop(width * 4, height*2, width, height);
        player_down[1] = sheet.crop(width * 5, height*2, width, height);
        player_up = new BufferedImage[2];
        player_up[0] = sheet.crop(width * 6, height*2, width, height);
        player_up[1] = sheet.crop(width * 7, height*2, width, height);
        player_left = new BufferedImage[2];
        player_left[0] = sheet.crop(width * 6, height*3, width, height);
        player_left[1] = sheet.crop(width * 7, height*3, width, height);
        player_right = new BufferedImage[2];
        player_right[0] = sheet.crop(width * 4, height*3, width, height);
        player_right[1] = sheet.crop(width * 5, height*3, width, height);
        
        
        dirt = sheet.crop(width, 0, width, height);
        wall = sheet.crop(width * 3, 0, width, height);
        stone = sheet.crop(0, height * 2, width, height);
        hole = sheet.crop(width * 3, height, width, height);
        enemy = sheet.crop(width * 4, 0, width, height);
    }
}
