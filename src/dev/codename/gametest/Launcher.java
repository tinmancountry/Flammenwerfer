/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codename.gametest;

import dev.codename.gametest.display.Display;

/**
 *
 * @author USER
 */
public class Launcher {
        public static void main(String[] args){
            Game game = new Game("Coward Zombie", 512, 512);
            game.start();
        }
}
