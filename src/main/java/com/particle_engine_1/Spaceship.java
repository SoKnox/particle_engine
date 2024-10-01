/*
 * Sophie Knox
 * Particle Engine 3
 * 9/30/24
 * This project creates three sublasses of particles: an alien spaceship, cow, and stars that are confined to bounce around in the screen
 * This subclass controls/draws spaceship and bullets
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
 import processing.core.PVector;
 
 import java.util.ArrayList;
 
 public class Spaceship extends Particle 
 {
     private int alienColor;
     private ArrayList<PVector> bullets; //stores bullets as vectors
     private float speedFactor; //controls speed
 
     public Spaceship(float x, float y, PApplet p) 
     {
         super(x, y, p); 
         this.alienColor = p.color(124, 252, 0);
         this.bullets = new ArrayList<>();
         this.speedFactor = 1.5f; //speed
     }
 
     @Override
     public void display()
      {
         // spaceship body
         float x = position.x;
         float y = position.y;
 
         p.fill(150);
         p.ellipse(x, y, 60, 20);
 
         p.fill(100, 200, 255);
         p.arc(x, y - 10, 40, 30, PApplet.PI, PApplet.TWO_PI); // dome
 
         //lights
         p.fill(255, 255, 0);
         p.ellipse(x - 20, y + 5, 10, 10); // L
         p.ellipse(x, y + 5, 10, 10);      // C
         p.ellipse(x + 20, y + 5, 10, 10); // R
 
         drawAlien(x, y - 10); //alien
 
         //bullets
         for (PVector bullet : bullets) 
         {
             p.fill(255,30,30);  //red
             p.ellipse(bullet.x, bullet.y, 5, 5);  //small circle
         }
     }
 
     private void drawAlien(float x, float y) 
     {
         // head
         p.fill(alienColor); //color
         p.ellipse(x, y - 5, 20, 20); 
 
         //eyes
         p.fill(0); //black
         p.ellipse(x - 7, y - 5, 6, 10); // L
         p.ellipse(x + 7, y - 5, 6, 10); // R
     }
 
     public void shoot()
      {
         //makes new bullet and adds to list
         PVector newBullet = new PVector(position.x, position.y - 10);
         bullets.add(newBullet);
     }
 
     public void updateBullets(float speedFactor)
      {
         for (int i = bullets.size() - 1; i >= 0; i--) 
         {
             PVector bullet = bullets.get(i);
             bullet.y -= speedFactor;  //bullet moves up
 
             if (bullet.y < 0) {
                 bullets.remove(i);  //remove if off screen
             }
         }
     }
 
     //spaceship movement and shooting
     public void handleInput() 
     {
         if (p.keyPressed) {
             if (p.keyCode == PApplet.LEFT)
              {
                 position.x -= 5;
             } else if (p.keyCode == PApplet.RIGHT) 
             {
                 position.x += 5;
             }
 
             if (p.key == ' ') 
             {
                 shoot(); //spacebar shoots
             }
         }
     }
 
     public ArrayList<PVector> getBullets() 
     {
         return bullets;
     }
 
     public void keyPressed(PlayState playState)
      {
        
         if (playState.p.key == ' ') 
         {
             shoot(); 
         }
     }
 
     
     public float getSpeedFactor() 
     {
         return speedFactor; 
     }
 
     
     public PVector getPosition() 
     {
         return position;
     }
 
     
 }
 