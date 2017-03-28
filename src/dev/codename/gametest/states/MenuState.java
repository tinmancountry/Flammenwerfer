/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codename.gametest.states;

import dev.codename.gametest.Game;
import dev.codename.gametest.Handler;
import dev.codename.gametest.gfx.Assets;
import dev.codename.gametest.gfx.ImageLoader;
import dev.codename.gametest.ui.ClickListener;
import dev.codename.gametest.ui.UIImageButton;
import dev.codename.gametest.ui.UIManager;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author USER
 */
public class MenuState extends State {
    
    private UIManager uiManager;
    private BufferedImage wallpaper;
    
    public MenuState(Handler handler){
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);
        wallpaper = ImageLoader.loadImage("/Texture/zombie.png");
        
        uiManager.addObject(new UIImageButton(220,200,128,64, Assets.btn_start, new ClickListener(){
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));
        
    }

    @Override
    public void update() {
        uiManager.update();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(wallpaper, 0, 0,576,576, null);
        uiManager.render(g);
    }
    
}
