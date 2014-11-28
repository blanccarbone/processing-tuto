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

public class photo_video extends PApplet {

PImage b;

public void setup() {
	b = loadImage("image.jpg");
	size(b.width, b.height);
	image(b, 0, 0);

// On commence a prendre les couleurs

	int a = b.get(100, 100);
	float c = red(a);
	float d = green(a);
	float e = blue(a);

	float[] couleur_image = new float[3];
	couleur_image[0] = c;
	couleur_image[1] = d;
	couleur_image[2] = e;

	println("couleur_image: "+couleur_image);

	
}

	
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "photo_video" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
