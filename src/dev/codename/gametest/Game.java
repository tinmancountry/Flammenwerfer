package dev.codename.gametest;

import dev.codename.gametest.display.Display;
import dev.codename.gametest.gfx.Assets;
import dev.codename.gametest.gfx.ImageLoader;
import dev.codename.gametest.gfx.SpriteSheet;
import dev.codename.gametest.input.KeyManager;
import dev.codename.gametest.input.MouseManager;
import dev.codename.gametest.states.GameState;
import dev.codename.gametest.states.MenuState;
import dev.codename.gametest.states.OverState;
import dev.codename.gametest.states.State;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Game implements Runnable {
    
    private Display display;
    public int width, height;
    private boolean running = false;
    public String title;
    
    private BufferStrategy bs;
    private Graphics g;
    
    //state
    public State gameState;
    public State menuState;
    public State overState;
    //input
    private KeyManager keyManager;
    private MouseManager mouseManager;
    //Handler
    private Handler handler;
    
  
    
    
    private Thread thread;
    
    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();

    }
    
    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();
        handler = new Handler(this);
                
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        overState = new OverState(handler);
        State.setState(menuState);
     
    }
    
    private void update(){
        keyManager.update();
        
        if(State.getState() != null)
            State.getState().update();
    }
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        // clear screen
        g.clearRect(0, 0, width, height);
        //Draw Here!)

        if(State.getState() != null)
            State.getState().render(g);
        
        //Draw End!
        bs.show();
        g.dispose();
    }
    public void run(){
        
        init();
        
        int fps = 60;
        double timePerUpdate = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        
        
        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerUpdate;
            lastTime = now;
            
            if(delta >= 1){
              update();
              render();
              delta--;
            }      
        }
        stop();
        
    }
    
    public KeyManager getKeyManager(){
        return keyManager;
    }
    public MouseManager getMouseManager(){
        return mouseManager;
    }
    
    

    
    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
