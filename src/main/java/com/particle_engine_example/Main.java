/*
 * Sophie Knox
 * Particle engine
 * 9/5/24
 * This code uses processing to draw five shapes on a blue background while also tying Howdy and Hello World to console.
 */


 package com.particle_engine_example;

 import processing.core.*; //imports processing
 
 public class Main extends PApplet {
     public static void main(String[] args) {
         PApplet.main("com.processing_example.Main");
         System.out.println("Hello world!"); //prints something to console
     }
 
     public void settings() // required to set canvas size!
     {
         size(600,600); //controls how big screen size is
        
     }
 
     public void setup() //used to initialize variables/load recources
     {
         background(12,100,200); // changes background color
     }
 
     public void draw() //draw is continously repeating 
     {
         
        rect (3,4,80,90);
         
 
     }
 }