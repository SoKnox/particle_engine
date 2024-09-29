package com.particle_engine_1;


import processing.core.PApplet;

abstract class GameState
 {
    PApplet p;

    public GameState(PApplet p) 
    {
        this.p = p;
    }

    abstract void drawState();   
    abstract void handleInput(); 
    abstract GameState transition(); 
}
