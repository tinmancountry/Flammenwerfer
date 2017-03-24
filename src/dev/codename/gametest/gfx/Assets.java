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
    
    public static BufferedImage player, dirt, grass, stone, hole, enemy,brain;
    
    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/Texture/sheet.png"));
        
        player = sheet.crop(width * 4, height * 2, width, height);
        dirt = sheet.crop(width, 0, width, height);
        grass = sheet.crop(width * 2, 0, width, height);
        stone = sheet.crop(0, height * 2, width, height);
        hole = sheet.crop(width * 3, height, width, height);
        enemy = sheet.crop(width * 4, 0, width, height);
        brain = sheet.crop(width * 2, height, width, height);
    }
}
