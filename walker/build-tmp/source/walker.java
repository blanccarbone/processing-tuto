import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.pdf.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class walker extends PApplet {



ArrayList<Walker> walk;
int nbwalk;



float diametre = 0.3f;
float fr;
boolean continuer;
PGraphicsPDF pdf;



 public void setup(){
    size(800,500, P2D); // on choisi la taille du sketch 
     pdf = (PGraphicsPDF) beginRecord(PDF, "walker-test.pdf");
    println("D\u00e9but du record");
    background(255); // on donne un fond blanc
    smooth(); // on am\u00e9liore le rendu (en option)

    nbwalk = 0;
    walk = new ArrayList<Walker>();
    for (int i=0; i<nbwalk; i++){
        walk.add(new Walker());
    }

    frameRate(400);
    

}



public void draw(){
    continuer = true;
    for (int i=0; i<walk.size(); i++){
        Walker w = walk.get(i);
        w.bouger();
        w.collision();
        w.display();

    }

}


public void keyPressed(){

    if(key == 's' || key == 'S'){
        if(continuer){
            noLoop();
            continuer = !continuer;
        }else{
            loop();
            continuer= !continuer;
        }
    }    
            
    if (key == 'r') {
        endRecord();
        println("Image correctement export\u00e9 en PDF");
        exit();
    }


    if (key == 'n') {
        walk.add(new Walker(mouseX, mouseY));
        println("Nouvelle particule ajout\u00e9e");        
        }

    if (key == 'b') {
        walk.add(new Walker());
        println("Nouvelle particule random ajout\u00e9e");        
        }        

    if (key == 'd') {
        background(255);        
        }
}







  
    
class Walker{
    //On initialise toutes les variables
    float positionx ,positiony, directionx, directiony;
    float d1, d2;
    float taille;
    float fr;
    int c;

    Walker(){
        positionx = random(0, width);
        positiony = random(0, height);        
        d1 = 1;
        d2 = 10;
    }

    Walker(float mouse1, float mouse2){
        positionx = mouse1;
        positiony = mouse2;
        d1 = 1;
        d2 = 10;

    }

    public void bouger(){
        directionx = PApplet.parseInt(random(-2, 2));
        directiony = PApplet.parseInt(random(-2, 2));
        // La nouvelle position de l'ellispe est \u00e9gale \u00e0 son ancienne position (x et y) + un int entre -1 et 1
        positiony = positiony + directiony;
        positionx = positionx + directionx;
    }


    public void collision(){
        if (positionx <0) {
          positionx = width;
        }

        if (positionx > width ) {
          positionx = 0;   
        }

        if (positiony <0) {
          positiony = height;
        }

        if (positiony > height) {
          positiony = 0;
        }
    }


    public void display(){
        c = color(random(0, 255));
        taille = PApplet.parseInt(random(d1, d2));
        stroke(c);

        if(keyPressed){
            if(key == '+')
                d1 += 0.5f;
            if(key == '-')
                d1 -= 0.5f;
        }

        if(mousePressed){
            d1 = map(mouseY, 0, height, 0.5f, 200);
        }

        ellipse(positionx, positiony, taille, taille); // enfin on dessinne notre ellipse
    }


    

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "walker" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
