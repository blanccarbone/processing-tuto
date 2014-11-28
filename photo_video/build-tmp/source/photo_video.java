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

int c = color(0);
float x = 0.0f;
float y = 100;
float speed = 1;


public void setup() {
	size(200, 200);

}

public void draw() {
	background(255);
	move();
	display();	
}


public void move(){
	x += speed;
	if (x > width) {
		x=0;
	}
}

public void display(){
	fill(c);
	rect(x, y, 30, 10);
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
