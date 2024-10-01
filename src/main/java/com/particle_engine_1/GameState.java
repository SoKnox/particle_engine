
/*
 * Sophie Knox
 * Particle Engine 3
 * 9/30/24
 * This project creates three sublasses of particles: an alien spaceship, cow, and stars that are confined to bounce around in the screen
 * This abstract class handles the spaceship, cow and stars
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
 
 abstract class GameState 
 {
     PApplet p;
 
     public GameState(PApplet p) 
     {
         this.p = p;
     }
 //RUBRIC 10% controller
     abstract void drawState();   // displays currenr state
     abstract void handleInput(); //key and mouse control
     abstract GameState transition(); //transition logic
 }
 