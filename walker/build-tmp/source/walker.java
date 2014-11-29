import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class walker extends PApplet {

int num = 500;
float diametre = 0.3f;
float fr;
Walker walk[] = new Walker[num];
boolean continuer;



 public void setup(){
    size(1500,800, P2D); // on choisi la taille du sketch 
    background(255); // on donne un fond blanc
    smooth(); // on am\u00e9liore le rendu (en option)
    
    for (int i = 0; i < num; i++) {
        walk[i] = new Walker(diametre);
    }

    smooth();
}



public void draw(){
    continuer = true;
    fr = map(mouseX, 0, width, 10, 6000);
    frameRate(fr);
    //on choisi au hasard un mouvement pour x et y compris entre -1 et 1 

    for (int i = 0; i < num; i++) {
        walk[i].bouger();
        walk[i].collision();
        walk[i].display();
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
        d1 = 2;
        d2 = 20;
    }

    Walker(float nDiam){
        // positionx = random((width/3), (2*(width/3)));
        // positiony = random((height/3), (2*(height/3)));

        positionx = random(0, width);
        positiony = random(0, height);
        d1 = nDiam;
        d2 = nDiam*10;
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
            


  
}
    

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "walker" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
