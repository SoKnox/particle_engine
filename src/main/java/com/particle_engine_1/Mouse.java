/*
 * Sophie Knox
 * Particle Engine 2
 * 9/28/24
 * This project creates three sublasses of particles: an alien spaceship, cow, and stars that are confined to bounce around in the screen
 * Each sublass has 10 instances and the background is moving static
 * This class controls all the mouse and key board functions listed below:
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

import processing.core.*;
import java.util.ArrayList;

public class Mouse 
{
    PApplet  p;
    ArrayList<Particle> particles;
    ArrayList<Cow> cows;
    ArrayList<Star> stars;
    float speedFactor;
    float influenceRadius;

    public Mouse(PApplet p, ArrayList<Particle> particles, ArrayList<Cow> cows, float speedFactor, float influenceRadius) 
    {
        this.p = p;
        this.particles = particles;
        this.cows = cows;
        this.speedFactor = speedFactor;
        this.influenceRadius = influenceRadius;
    }

    //old mouse function was the extra credit I did previously
    public void mousePressed() 
    {
        //pushes/reversed particles near mouse when pressed
        for (Particle s : particles)
         {
            float distance = PApplet.dist(p.mouseX, p.mouseY, s.position.x, s.position.y);
            if (distance < influenceRadius) 
            {
                s.reverse();
                s.pushAway(p.mouseX, p.mouseY);
            }
        }
    }

    //RUBRIC old mouse function cow changes color depending on mouse position (3.333%)
    public void mouseMoved()
     {
        for (Cow s : cows)
         {
            s.setColor(
                PApplet.map(p.mouseX, 0, p.width, 0, 255), // mouse x changes red
                PApplet.map(p.mouseY, 0, p.height, 0, 255),  //mouse y changes green
                255  // Blue is constant
            );
        }
    }

    //RUBRIC old mouse function adds stars when dragged (3.333%)
    public void mouseDragged() 
    {
        particles.add(new Star(p.mouseX, p.mouseY, p));
    }

    //RUBRIC NEW mouse function Changes alien color to random (3.333%)
    public void mouseReleased() 
    {
        for (Particle s : particles) 
        {
            if (s instanceof Spaceship) 
            {
                //changes to random color
                int newColor = p.color(p.random(255), p.random(255), p.random(255));
                ((Spaceship) s).changeAlienColor(newColor);
            }
        }
    }

    //tracks if b is pressed
    private boolean isBPressed = false;

   

    //RUBRIC key press (10% total)
    //New s turns stars white for a sec, b places beam under ship
    //old r randomizes cow position, up and down arrow for speed of all particles
    public void keyPressed() 
    {
        //RUBRIC old key pressed (COW) r randomizes cow position
        if (p.key == 'r' || p.key == 'R') 
        {
            for (Cow s : cows) 
            {
                s.setPosition(p.random(p.width), p.random(p.height));
            }
        }

        //up arrow increases speed (old)
        if (p.keyCode == PApplet.UP) 
        {
        
            speedFactor += 0.5;
        }

        //down arrow decreases speed (old)
        if (p.keyCode == PApplet.DOWN) 
        {
            speedFactor = PApplet.max(0.5f, speedFactor - 0.5f);
        }

        //RUBRIC NEW key pressed (STAR) if s is pressed, the star turns white for a sec (3.333%)
        if (p.key == 's' || p.key == 'S') 
        {
            Star.startFlash(); // Trigger the flash in the Star class
        }

        //RUBRIC NEW if key pressed (SHIP), beam appears under ship (3.333%)
        if (p.key == 'b' || p.key == 'B') 
        {
            isBPressed = true; //activates beam
        }
    }

    //updates mouse pressed
    public void update() 
    {
        if (isBPressed) 
        {
            for (Particle s : particles)
             {
                if (s instanceof Spaceship) 
                {
                    ((Spaceship) s).activateBeam();
                }
            }
        }
    }

    //getter for speed
    public float  getSpeedFactor() 
    {
        return speedFactor;//returns speedr
    }
}

