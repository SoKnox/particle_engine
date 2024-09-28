/*
 * Sophie Knox
 * Particle Engine 2
 * 9/28/24
 * This project creates three sublasses of particles: an alien spaceship, cow, and stars that are confined to bounce around in the screen
 * Each sublass has 10 instances and the background is moving static
 * This class creates the beam that is used in subclass Spaceship
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

public class Beam 
{
    private PApplet p;
    private float x,y;//beam position
    private float length; //length beam
    private boolean active ; //activates beam
    private float width; //width of bottom beam

    public Beam(PApplet p,float x, float y) 
    {
        this.p = p;
        this.x =x;
        this.y = y;
        this.length = 100;//leanghth
        this.width = 40; //end width
        this.active = false; //does not show up until b is pressed
    }

    public void activate(float spaceshipX, float spaceshipY) 
    {
        this.active = true; //beam shows up when b is pressed
        this.x = spaceshipX; //updated beams position to follow ship
        this.y = spaceshipY + 120; //beam appears below ship
    }

    public void deactivate() 
    {
        this.active = false; //deactivates beam... did not get this to work
    }

    public boolean isActive() 
    {
        return active;
    }

    //draws the beam, is a trapazoid shape with transparency
    public void display() 
    {
        if (active) {
            p.fill(255, 255, 255, 100); //white transparent
            p.beginShape();
            //trapazoid
            p.vertex(x - width / 2, y); //left bottom
            p.vertex(x + width / 2, y); //right bottom
            p.vertex(x + width / 4, y - length); //top right
            p.vertex(x - width / 4, y - length); //top left
            p.endShape(PApplet.CLOSE); //closes shaoe
        }
    }
}

