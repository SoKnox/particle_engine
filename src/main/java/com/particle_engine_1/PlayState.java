
/*
 * Sophie Knox
 * Particle Engine 3
 * 9/30/24
 * This project creates three sublasses of particles: an alien spaceship, cow, and stars that are confined to bounce around in the screen
 * This PlayState class handles what hapens when you start playing and the game controls.
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
 import java.util.ArrayList;
 import processing.core.PVector;
 
 public class PlayState extends GameState 
 {
     private ArrayList<Particle> particles;
     private ArrayList<Cow> cows;
     private Spaceship spaceship;
     private int score;
 
     public PlayState(PApplet p)
      {
         super(p);
         particles = new ArrayList<>();
         cows = new ArrayList<>();
         spaceship = new Spaceship(p.width / 2, p.height - 50, p);
         score = 0;
 
         //adds stars CHANGE 17 TO 1 IF YOU CANT BEAT THE GAME
         for (int i = 0; i < 17; i++) 
         {
             particles.add(new Star(p.random(p.width), p.random(p.height), p));
         }
 
         //adds cows
         for (int i = 0; i < 3; i++) 
         {
             cows.add(new Cow(p.random(p.width), p.random(p.height), p));
         }
     }
 
     public void update()
      {
         //updates particles
         for (Particle particle : particles) 
         {
             particle.update(spaceship.getSpeedFactor());
         }
 
         //updates cows and cow collisions
         for (Cow cow : cows)
          {
             cow.update(spaceship.getSpeedFactor());
         }
         checkCowCollisions();
 
         //updates spaceship with bullets
         spaceship.handleInput();
         spaceship.updateBullets(spaceship.getSpeedFactor());  
 
         //bullet star collisions, if happens adds point to score and star is removed
         for (int i = spaceship.getBullets().size() - 1; i >= 0; i--) 
         {
             PVector bullet = spaceship.getBullets().get(i);
             float[] bulletBounds = new float[] { bullet.x - 2.5f, bullet.y - 2.5f, 5, 5 };
 
             for (int j = particles.size() - 1; j >= 0; j--) 
             {
                 Particle particle = particles.get(j);
                 if (particle instanceof Star) 
                 {
                     Star star = (Star) particle;
                     float[] starBounds = star.getBounds();
 
                     if (isBoundingBoxCollision(bulletBounds, starBounds))
                      {
                         spaceship.getBullets().remove(i);  //does not work
                         particles.remove(j);  //remove star
                         score++;  //adds to score
                         break;
                     }
                 }
             }
         }
 
         //bullet-cow collisions
         for (int i = spaceship.getBullets().size() - 1; i >= 0; i--)
          {
             PVector bullet = spaceship.getBullets().get(i);
             float[] bulletBounds = new float[] { bullet.x - 1.5f, bullet.y - 1.5f, 5, 5 };
 
             for (Cow cow : cows) 
             {
                 float[] cowBounds = cow.getBounds();
 
                 if (isBoundingBoxCollision(bulletBounds, cowBounds)) 
                 {
                     spaceship.getBullets().remove(i);  // Remove the bullet
                     Main.currentState = new CreditState(p, false, score);  //trannsition to credit lose
                     return;
                 }
             }
         }
 
         //if all stars are hit, player wins
         if (particles.isEmpty()) 
         {
             Main.currentState = new CreditState(p, true, score);  //transition to credit win
         }
     }
 
     //displays particles and score board
     public void display() 
     {
         for (Particle particle : particles)
          {
             particle.display();
         }
 
         for (Cow cow : cows) 
         {
             cow.display();
         }
 
         spaceship.display();
 
         p.fill(255);
         p.text("Score: " + score, 40, 20);
     }
 
     //bounding box for collision for star and bullet
     private boolean isBoundingBoxCollision(float[] box1, float[] box2)
      {
         // box = [x, y, width, height]
         float x1 = box1[0], y1 = box1[1], w1 = box1[2], h1 = box1[3];
         float x2 = box2[0], y2 = box2[1], w2 = box2[2], h2 = box2[3];
 
         return (x1 < x2 + w2 &&
                 x1 + w1 > x2 &&
                 y1 < y2 + h2 &&
                 y1 + h1 > y2);
     }
 
     //cow collisions
     private void checkCowCollisions() 
     {
         for (int i = 0; i < cows.size(); i++) 
         {
             for (int j = i + 1; j < cows.size(); j++)
              {
                 cows.get(i).checkCollision(cows.get(j));
             }
         }
     }
 
     @Override
     //space bar shoots
     void handleInput()
      {
         if (p.keyPressed && p.key == ' ') 
         {
             spaceship.shoot();
         }
     }
 
     @Override
     GameState transition() 
     {
         return this;
 
     }
 
     @Override
     void drawState() 
     {
         update();
         display();
     }
 }
 
 
 