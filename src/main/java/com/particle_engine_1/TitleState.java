package com.particle_engine_1;
import processing.core.PApplet;

class TitleState extends GameState
 {
    public TitleState(PApplet p) 
    {
        super(p);
    }

    @Override
    void drawState()
     {
        p.background(0);
        p.textAlign(PApplet.CENTER);
        p.fill(255);
        p.textSize(32);
        p.text("Particle Engine Game", p.width / 2, p.height / 2);
        p.textSize(16);
        p.text("Press 'P' to Play", p.width / 2, p.height / 2 + 40);
        p.text("Press 'C' for Credits", p.width / 2, p.height / 2 + 80);
    }

    @Override
    void handleInput() 
    {
        
        if (p.keyPressed) {
            if (p.key == 'p' || p.key == 'P') 
            {
                Main.currentState = new PlayState(p);
            } else if (p.key == 'c' || p.key == 'C') 
            {
                Main.currentState = new CreditState(p);
            }
        }
    }

    @Override
    GameState transition() 
    {
        return this; 
    }
}
