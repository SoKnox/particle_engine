/*
 * Sophie Knox
 * Particle Engine 2
 * 9/28/24
 * This project creates three sublasses of particles: an alien spaceship, cow, and stars that are confined to bounce around in the screen
 * Each sublass has 10 instances and the background is moving static
 * This class is a subclass of particle draws the star paricles and implements the white flash
 * 
 * B or b creates a beam under spaceship (new)
 * S or s turns stars white for a second (new)
 * R or r randomizes cows position (old)
 * Up and Down arrows contols speed of all particles (old)
 * 
 * Mouse released changes alien color to a random color (new)
 * Mouse dragged released star particles (old)
 * Mouse position changes cow color (old)
 * Mouse click pushes away near by particles (old)
 * 
 * Cows collide with eachother
 */

 package com.particle_engine_1;

 import processing.core.PApplet;
 
 public class Star extends Particle 
 {
     private static boolean flash = false; //tracks flash
     private static long flashStartTime = 0; // Track when the flash started
     private static final long FLASH_DURATION = 1000; //duration in millisec
 
     public Star(float x, float y, PApplet p) 
     {
         super(x,  y, p);  //RUBRIC super class (1.666%)
     }
 
     //initiate flash
     public static void startFlash() 
     {
         flash= true;
         flashStartTime =System.currentTimeMillis(); //records the flash time
     }
 
     //overdes the initial oval shape particle
     @Override
     public void display()
      {
         if (flash)
          {
             //seeds if flash duration passes
             if (System.currentTimeMillis() - flashStartTime > FLASH_DURATION)
              {
                 flash = false; //stops white flash
             } else 
             {
                 p.fill (255); //color of flash
                 p.noStroke();
             }
         } else 
         {
             p.fill(225, 225, 51);//returns back to yellow color
             p.noStroke();
         }
 
         float x = position.x;
         float y = position.y;
 
         //changed from triangle shapes put together to star
         p.beginShape();
         for (int i = 0; i < 10; i++)
          {
             float angle = PApplet.TWO_PI / 10 * i; //divides into 10 parts https://processing.org/examples/star.html
             float radius = (i % 2 == 0) ? 10 : 5; //outer larger, inner smaller
             float sx = x + PApplet.cos(angle) * radius;
             float sy = y + PApplet.sin(angle) * radius;
             p.vertex(  sx, sy);
         }
         p.endShape(PApplet.CLOSE);
     }
 }
 
 