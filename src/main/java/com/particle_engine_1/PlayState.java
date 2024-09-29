package com.particle_engine_1;
import processing.core.PApplet;
import java.util.ArrayList;

class PlayState extends GameState 
{
    ArrayList<Particle> particles;
    ArrayList<Cow> cows;
    Mouse mouse;

    public PlayState(PApplet p) 
    {
        super(p);
        
        particles = new ArrayList<>();
        cows = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            particles.add(new Star(p.random(p.width), p.random(p.height), p));
            particles.add(new Spaceship(p.random(p.width), p.random(p.height), p));
            Cow cow = new Cow(p.random(p.width), p.random(p.height), p);
            particles.add(cow);
            cows.add(cow);
        }
        mouse = new Mouse(p, particles, cows, 1, 200);
    }

    @Override
    void drawState() 
    {
        p.background(0);
       
        for (Particle particle : particles) 
        {
            particle.update(1);
            particle.display();
        }

        // Handle cow collisions
        for (int i = 0; i < cows.size(); i++) 
        {

            for (int j = i + 1; j < cows.size(); j++) 
            {
                cows.get(i).checkCollision(cows.get(j));
            }
        }
    }

    @Override
    void handleInput()
     {
        // Handle mouse and keyboard input specific to the play state
        mouse.update();
        if (p.keyPressed && p.key == 'q')
         {
            Main.currentState = new TitleState(p); // Transition to TitleState if 'Q' is pressed
        }
    }

    @Override
    GameState transition() 
    {
        return this;
    }
}

class CreditState extends GameState 
{
    public CreditState(PApplet p)
     {
        super(p);

    }

    @Override
    void drawState() 
    {
        p.background(0);
        p.fill(255);
        p.textAlign(PApplet.CENTER);
        p.textSize(24);
        p.text("Credits", p.width / 2, p.height / 2 - 20);
        p.textSize(16);
        p.text("Game by Sophie Knox", p.width / 2, p.height / 2 + 20);
        p.text("Press 'T' to go back to Title", p.width / 2, p.height / 2 + 60);
    }

    @Override
    void handleInput()
     {
        if (p.keyPressed && p.key == 't')
         {
            Main.currentState = new TitleState(p); 
        }
    }

    @Override
    GameState transition() 
    {
        return this;
    }

    
}
