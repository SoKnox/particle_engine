/*
 * Sophie Knox
 * Particle Engine 3
 * 9/30/24
 * This project creates three sublasses of particles: an alien spaceship, cow, and stars that are confined to bounce around in the screen
 * This class creates the first title image and handles key functions
 * 
 * I am attempting extra credit
 * Goal of game: Shoot all the stars. Each star shot is a point. If you shoot a cow you automatically loose.
 * Left and right arrows contol spaceship's x position
 * spacebar shoots bullet
 * IF YOU CANT BEAT GAME, CHANGE STAR # TO 1 IN PLAYSTATE
 * 
 * 
 * Cows collide with eachother
 */



 package com.particle_engine_1;

 import processing.core.PApplet;
 
 public class TitleState extends GameState 
 {
     public TitleState(PApplet p) 
     {
         super(p);
     }
 
     @Override
     void drawState()
      {
         p.background(0);
         p.fill(255);
         p.textAlign(PApplet.CENTER);
         p.textSize(32);
         p.text("Alien Shooter Game", p.width / 2, p.height / 2);
         p.textSize(16);
         p.text(
     "Shoot all the stars. Each star shot is a point. If you shoot a cow you lose.\n" +
     "* Left and right arrows control spaceship's x position\n" +
     "* Spacebar shoots bullets.\n" +
     "* Press 'P' to Play", 
     p.width / 2, 
     p.height / 2 + 40
 );
 
     }
 
     @Override
     void handleInput() 
     {
         if (p.keyPressed && p.key == 'p') 
         {
             Main.currentState = new PlayState(p);
         } 
     }
 
     @Override
     GameState transition() 
     {
         return this;
     }
 }
 