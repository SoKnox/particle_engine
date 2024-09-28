
/*
 * Sophie Knox
 * Particle Engine 2
 * 9/28/24
 * This project creates three sublasses of particles: an alien spaceship, cow, and stars that are confined to bounce around in the screen
 * Each sublass has 10 instances and the background is moving static
 * This sub class draws the cow particles and handles their collision.
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


// RUBRIC subclass 1 (3.333%)
public class Cow extends Particle
 {

    private int cowColor;  //holds color of cow

    public Cow(float x, float y, PApplet p) 
    {
        super(x, y, p); // RUBRIC call super (1.66%)
        this.cowColor = p.color(255); //default white color
    }

    @Override
    //cow drawing
    //RUBRIC draw something diff (1.66%)
    public void display()
     {
        float x = position.x;
        float y = position.y;

        p.stroke(255); //outline
        p.strokeWeight(1);

        //Body
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

        //ear
        p.fill(0); //black
        p.ellipse(x - 25, y - 12, 12, 8); //L ear
        p.ellipse(x - 5, y - 12, 12, 8);  //R eaar

        //eyes
        p.fill(0); //black
        p.ellipse(x - 20, y - 12, 6, 6); //L
        p.ellipse(x - 10, y - 12, 6, 6); //R

        //nose
        p.fill(255, 200, 200);//pink
        p.ellipse(x - 15, y - 3, 15, 8); 

        p.noStroke(); //no more strole
    }

    //changes cows color
    public void setColor(float r, float g, float b) 
    {
        this.cowColor = p.color(r, g, b);
    }


    //RUBRIC Collison Cows (15%)
    public void checkCollision(Cow other)
     {
        //calculates position of cows between eachother. if less than 40 they reverse
        float distance = PApplet.dist(this.position.x, this.position.y, other.position.x, other.position.y);
  
        if (distance < 40) 
        { 
            this.reverse();
            other.reverse();
            this.pushAway(other.position.x, other.position.y); //made the collision more strong
            other.pushAway(this.position.x, this.position.y);
        }
        
    }
}


