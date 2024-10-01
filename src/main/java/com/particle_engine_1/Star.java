/*
 * Sophie Knox
 * Particle Engine 3
 * 9/30/24
 * This project creates three sublasses of particles: an alien spaceship, cow, and stars that are confined to bounce around in the screen
 * This class draws star particle, creates bounding box for bullet collisons
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
 import processing.core.PConstants;
 import processing.core.PVector;
 
 public class Star extends Particle 
 {
     private float radius;
     private int points;
     private float angleOffset;
 
     public Star(float x, float y, PApplet p) 
     {
         super(x, y, p);
         this.radius = 10;  //size
         this.points = 5;   //# of points
         this.angleOffset = PConstants.TWO_PI / points;  //angle between two points
     }
 
     @Override
     public void update(float speedFactor)
      {
         super.update(speedFactor);
     }
 
     @Override
     public void display() 
     {
         p.fill(255,255,51);
         p.pushMatrix();    
         p.translate(position.x, position.y); // moves origin
         p.beginShape();
         for (int i = 0; i < points * 2; i++) 
         {
             float angle = i * angleOffset / 2;
             float r = (i % 2 == 0) ? radius : radius / 2;  // got this from processing website
             float x = PApplet.cos(angle) * r;
             float y = PApplet.sin(angle) * r;
             p.vertex(x, y);
         }
         p.endShape(PConstants.CLOSE);  
         p.popMatrix();   
     }
 
     public float getRadius() 
     {
         return radius;
     }
 
     public float[] getBounds()
      {
         return new float[] { position.x - radius, position.y - radius, radius * 2, radius * 2 };
     }
 
     //detects bullet and star collision
     public boolean checkCollision(PVector bullet)
      {
         float[] bounds = getBounds();
         float bulletX = bullet.x;
         float bulletY = bullet.y;
 
         //sees if bullet is near star
         return (bulletX > bounds[0] && bulletX < bounds[0] + bounds[2] &&  bulletY > bounds[1] && bulletY < bounds[1] + bounds[3]);
     }
 }
 
 
 