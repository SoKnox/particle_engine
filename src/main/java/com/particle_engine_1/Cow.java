/*
 * Sophie Knox
 * Particle Engine 3
 * 9/30/24
 * This project creates three sublasses of particles: an alien spaceship, cow, and stars that are confined to bounce around in the screen
 * This abstract class draws the cow and handles their collisions
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

//RUBRIC subclass 1 (1.666%)
public class Cow extends Particle 
{
    private int cowColor;  //holds cow color (not needed in this)

    public Cow(float x, float y, PApplet p)
     {
        super(x, y, p); //super class construtor
        this.cowColor = p.color(255); //default color of cow  
    }

    @Override
    //cow drawing
    public void display() 
    {
        float x = position.x;
        float y = position.y;

        p.stroke(255); //outline
        p.strokeWeight(1);

        //body
        p.fill(cowColor);
        p.rect(x - 20, y, 40, 20);

        //legs
        p.rect(x - 15, y + 20, 5, 10);
        p.rect(x + 10, y + 20, 5, 10);

        //spots
        p.fill(0);  //black
        p.ellipse(x - 10, y + 5, 5, 5);
        p.ellipse(x + 10, y + 5, 8, 8);

        //head
        p.fill(cowColor);
        p.ellipse(x - 15, y - 10, 20, 20);

        //ears
        p.fill(0); //black
        p.ellipse(x - 25, y - 12, 12, 8); //L
        p.ellipse(x - 5, y - 12, 12, 8);  //R

        //eyes
        p.fill(0); //black
        p.ellipse(x - 20, y - 12, 6, 6); //L
        p.ellipse(x - 10, y - 12, 6, 6); //R

        //nose
        p.fill(255, 200, 200); //pink
        p.ellipse(x - 15, y - 3, 15, 8);

        p.noStroke(); //no more stroke
    }

    //updates cows position
    @Override
    public void update(float speedFactor)
     {
        super.update(speedFactor); //parent class
    }

    //collison with other cow RUBRIC Self collision 5%
    public void checkCollision(Cow other) 
    {
        float distance = PApplet.dist(this.position.x, this.position.y, other.position.x, other.position.y);
        if (distance < 40) 
        {
            this.reverse();
            other.reverse();
        }
    }

    //reverse cow velocity
    public void reverse() 
    {
        velocity.mult(-1);
    }

    //bounding box of cow for collison with bullet
    public float[] getBounds() 
    {
        return new float[] { position.x - 20, position.y, 40, 20 };
    }
}



 
