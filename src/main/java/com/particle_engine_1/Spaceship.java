/*
 * Sophie Knox
 * Particle Engine 2
 * 9/28/24
 * This project creates three sublasses of particles: an alien spaceship, cow, and stars that are confined to bounce around in the screen
 * Each sublass has 10 instances and the background is moving static
 * 
 * This class is a subclass of particle that draws spaceship with alien in it. It also tracks beam activation
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

public class Spaceship extends Particle 
{
    private int alienColor;  //holds alien color
    private Beam beam; // Beam object
    private boolean beamActive; //tracks if beam is active
    private float beamActiveTime; // Track time the beam has been active

    public Spaceship(float x, float y, PApplet p) 
    {
        super(x, y, p);  // Call the superclass constructor
        this.alienColor = p.color(124, 252, 0);  //initial alien color is green
        this.beam = new Beam(p, x, y - 10);  //position of beam initialy
        this.beamActive = false; //not active intitally
        this.beamActiveTime = 0; //itital active time
    }

    @Override
    public void display()
     {
        //spaceship position
        float x = position.x;
        float y = position.y;

        //spaceship body
        p.fill(150); //gray
        p.ellipse(x, y, 60, 20); //body

        //dome
        p.fill(100, 200,  255);  // Blue dome
        p.arc(x, y - 10, 40, 30, PApplet.PI, PApplet.TWO_PI); // dome

        //lightd
        p.fill(255,255, 0); //yellow
        p.ellipse(x - 20, y + 5, 10, 10);
        p.ellipse(x, y + 5, 10, 10);
        p.ellipse(x + 20, y + 5, 10, 10);
        
        //alien dude
        drawAlien(x, y - 10); //indise of dome
        
        //shows beam if active
        if (beamActive) 
        {
            beam.display();
            // Check if the beam should deactivate
            if (p.millis() - beamActiveTime >= 5000) 
            { //supposed to deactivate after 5 sec does not work.
                beamActive = false;
                beam.deactivate();
            }
        }
    }

    public void activateBeam() 
    {
        beamActive= true; //active beam
        beamActiveTime = p.millis(); //store time
        beam.activate(position.x, position.y - 10); //makes sure is activated
    }

    

    private void drawAlien(float x, float y)
     {
        //alien head
        p.fill(alienColor);  //color
        p.ellipse(x, y - 5, 20, 20);  //size of head

        //alien eyes
        p.fill(0); //black eyes
        p.ellipse(x - 7, y - 5, 6, 10); //L eye
        p.ellipse(x + 7, y - 5, 6, 10); //R eye
    }

    //changes alien color
    public void changeAlienColor(int newColor) 
    {

        this.alienColor = newColor;  //changesalien color
    }

    //geter
    public Beam getBeam() 
    {
        return this.beam; //returns
    }
}
