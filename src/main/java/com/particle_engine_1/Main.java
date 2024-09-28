/*
 * Sophie Knox
 * Particle Engine 2
 * 9/28/24
 * This project creates three sublasses of particles: an alien spaceship, cow, and stars that are confined to bounce around in the screen
 * Each sublass has 10 instances and the background is moving static
 * This is the main class. It updates and draws the final product.
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
 import java.util.ArrayList;
 
 public class Main extends PApplet
  {
     public static void main(String[] args) 
     {
         PApplet.main("com.particle_engine_1.Main");
     }
 
     ArrayList<Particle> particles; //RUBRIC arrayList (5%)
     ArrayList<Cow> cows; //handles cow collision
     float speedFactor = 1; //controls spped
     float influenceRadius = 200; //radius of particles affectsed when mouse clicked
     Mouse mouse; //handles mouse funtions
 
     public void settings() 
     {
         size(800, 600);//size
     }
 
     public void setup()
      {
         particles =  new ArrayList<>();
         cows  = new ArrayList<>();
 
         //RUBRIC instances (5%) I use a loop
         for (int i = 0; i < 10; i++) {
             particles.add(new Star(random(width), random(height), this));
             particles.add(new Spaceship(random(width), random(height), this));
             Cow cow = new Cow(random(width), random(height), this);
             particles.add(cow);
             cows.add(cow);
         }
 
         mouse = new Mouse(this, particles, cows, speedFactor, influenceRadius);
     }
 
    public void draw()
     {
    background(0);

    // Static stars backbround
    for (int i = 0; i < 100; i++)
     {
        float x= random(width);
        float y = random(height);
        stroke(255);
        point(x, y);
    }

    //updates/displays particles
    for (Particle p : particles) {
        p.update(speedFactor);
        p.display();
    }

    //handles cow collision
    for (int i = 0; i < cows.size(); i++) {
        for (int j = i + 1; j < cows.size(); j++) {
            cows.get(i).checkCollision(cows.get(j));
        }
    }

    //updates mouse class
    mouse.update(); 
}

 
    
 
 
     
     public void mousePressed()
      {
         mouse.mousePressed(); 
     }
 
     public void mouseMoved()
      {
         mouse.mouseMoved(); 
     }
 
     public void mouseDragged() 
     {
         mouse.mouseDragged();
     }
 
     public void mouseReleased() 
     {
         mouse.mouseReleased(); 
     }
 
     public void keyPressed() 
     {
         mouse.keyPressed(); 
         speedFactor =mouse.getSpeedFactor();
     }
 }
 