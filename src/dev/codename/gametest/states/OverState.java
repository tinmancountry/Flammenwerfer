/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codename.gametest.states;

import dev.codename.gametest.Handler;
import dev.codename.gametest.gfx.ImageLoader;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author USER
 */
public class OverState extends State{
    private BufferedImage wallpaper;

    public OverState(Handler handler) {
        super(handler);
        wallpaper = ImageLoader.loadImage("/Texture/go.jpg");
    }

    @Override
    public void update() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(wallpaper, 0, 0,576,576, null);
    }
    
}
