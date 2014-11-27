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

public class PONG extends PApplet {

int x,y,deplacementX,deplacementY,w,z;

public void setup() {
	size(400, 400);
	z=60;
	w=15;
	deplacementY=-3;
	deplacementX=6;
	y=200;
	x=200;

	
}

public void draw() {
	nettoyer();
	dessiner();
	bouger();
	rebondir();
}


public void nettoyer(){
	background(0);
}

public void dessiner(){
	// Dessin du plateau
	fill(255);
	rect(w, z, 25, 85);

	// Dessin de la balle
	smooth();
	fill(255);
	ellipse(x, y, 20, 20);
	line(200, 0, 200, 400);
}

public void bouger(){
	// Deplacement de la balle
	x+=deplacementX;
	y+=deplacementY;

	// Deplacement du plateau
	z=mouseY;

}	

public void rebondir(){

	// Rebondir sur le mur
	if (x > width-10 && deplacementX > 0) {
		deplacementX = -deplacementX;
	}


	if (y > width-10 && deplacementY > 0) {
		deplacementY = -deplacementY;
	}

	if (y < 10 && deplacementY < 0) {
		deplacementY = -deplacementY;
	}



	// Rebomdir sur le plateau
	if (x<w+35 && y<z+85 && y>z) {
		deplacementX=-deplacementX;
	}

	if(x < 10){
		noLoop();
		println("GAME OVER");
	}


}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PONG" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
