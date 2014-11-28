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

public class POO extends PApplet {

// Auteur : Fabien Bonnamy
// Site web : tutoprocessing.com/random-walker
//Sketch d'apprentissage qui montre comment faire un random walker
// Un random walker est une particule qui se deplace de facon al\u00e9atoire sur l'ecran 

//On initialise toutes les variables
float positionx ,positiony, directionx, directiony;
float taille;
float fr;
int c;

 public void setup(){
    size(200,200); // on choisi la taille du sketch 
    background(255); // on donne un fond blanc
    smooth(); // on am\u00e9liore le rendu (en option)

    // on place notre future ellipse au centre de l'\u00e9ctan
    positionx = width/2;
    positiony = height/2;
}

public void draw(){
    fr = map(mouseX, 0, width, 200, 50000);
    frameRate(fr);
    //on choisi au hasard un mouvement pour x et y compris entre -1 et 1 
    directionx = PApplet.parseInt(random(-2, 2));
    directiony = PApplet.parseInt(random(-2, 2));

    // La nouvelle position de l'ellispe est \u00e9gale \u00e0 son ancienne position (x et y) + un int entre -1 et 1
    positiony = positiony + directiony;
    positionx = positionx + directionx;

    if (positionx+taille <0) {
      positionx = width+taille;
    }

    if (positionx+taille > width ) {
      positionx = 0+taille;   
    }

    if (positiony+taille <0) {
      positiony = height+taille;
    }

    if (positiony+taille > height) {
      positiony = 0+taille;
    }

    if (mousePressed) {
      taille = map(mouseY, 0, height, 2, 200);

    }else {
      taille = PApplet.parseInt(random(2, 20)); // on change la taille de l'ellispe \u00e0 chaque tour du draw pour rendre \u00e7a plus funky
    }
    smooth();
    c = color(random(0, 255));
    stroke(c);
    ellipse(positionx, positiony, taille, taille); // enfin on dessinne notre ellipse
}

public void mousePressed(){    
    smooth();
    c = color(random(0, 255));
    stroke(c);
    ellipse(positionx, positiony, taille, taille);
}

public void keyPressed(){
    if (key == 'a') {
      noLoop();
    } else {
      loop();
    }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "POO" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
