
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

 import processing.core.PVector;
 import processing.core.PApplet;
 
 //RUBRIC 10% superclass with abstract
 
 public abstract class Particle 
 {
     PVector position;
     PVector velocity;
     PApplet p;
 
     public Particle(float x, float y, PApplet p) 
     {  //PApplet constructor
         this.p = p;
         position = new PVector(x, y);
         velocity = PVector.random2D(); //random initial velocity
     }
 
     public void update(float speedFactor) 
     {
         position.add(PVector.mult(velocity, speedFactor));
 
         //bouncing at edge of screen
         if (position.x < 0 ||position.x > p.width) 
         {
             velocity.x *= -1;
         }
         if (position.y < 0 || position.y > p.height) 
         {
             velocity.y *=-1;
         }
     }
 
     public void setPosition(float x, float y) 
     {
         position.set(x, y); //sets position of objects
     }
 
     public void display() 
     {
         p.ellipse(position.x, position.y, 10, 10);  //defaukt shape that is overriden in subclasses
     }
 
     //reverses velocity
     public void reverse() 
     {
         velocity.mult(-1);
     }
 
 }
 