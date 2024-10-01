
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
 * spacebar shoots bullets
 * IF YOU CANT BEAT GAME, CHANGE STAR # TO 1 IN PLAYSTATE
 * 
 * 
 * Cows collide with eachother
 */

//RUBRIC encapsulation 10%
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
        currentState = new TitleState(this); //starts with title state
    }

    @Override
    public void draw() 
    {
        //clear the background
        background(0); 

        currentState.drawState();
        if (currentState instanceof PlayState) 
        {
            ((PlayState) currentState).update(); //updates game elements
        }
    }

    @Override
    public void keyPressed() 
    {
        currentState.handleInput(); //imput handleing during different states
    }
}

 