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
 
 
 public class Main extends PApplet 
 {
    static GameState currentState;

    public static void main(String[] args) 
    {
        PApplet.main("com.particle_engine_1.Main");
    }

    public void settings() 
    {
        size(800, 600);
    }

    public void setup()
     {
        currentState = new TitleState(this); 
    }

    public void draw() 
    {
        currentState.drawState(); 
    }

    public void keyPressed()
     {
        currentState.handleInput(); 
    }
}

 
 