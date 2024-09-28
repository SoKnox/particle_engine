/*
 * Sophie Knox
 * Particle Engine 2
 * 9/28/24
 * This project creates three sublasses of particles: an alien spaceship, cow, and stars that are confined to bounce around in the screen
 * Each sublass has 10 instances and the background is moving static
 * This class is the abstract class of particle. It uses an ellipse to create particles, but the particles are overriden in the sublasses
 
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

import processing.core.PVector;
import processing.core.PApplet;

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

    public void setColor(float r, float g, float b) 
    {
        p.fill(r, g, b); //fills color of objects
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

    //pushes particle away from mouse click
    public void pushAway(float mouseX, float mouseY) 
    {
        PVector mousePosition = new PVector(mouseX, mouseY);
        PVector force = PVector.sub(position, mousePosition);  //vector of mouse and particle
        force.normalize();  //gets direction
        force.mult(5); //push force
        velocity.add(force);  //applies force to velocity
    }
}
