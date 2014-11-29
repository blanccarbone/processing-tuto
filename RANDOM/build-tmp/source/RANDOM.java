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

public class RANDOM extends PApplet {

float trans;
public void setup() {

	size(512, 512,P3D);
	

}

public void draw() {

	trans = map(mouseX, 0, width, -20, -100);
	for (int z = 0; z < 10; ++z) {
		translate(0, 0, z*(trans));
		for (int x = 0; x < 10; ++x) {

			for (int y = 0; y < 10; ++y) {
				rect(x*40, y*40, 30, 30);
				
				
			}
		}

	}



}



  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "RANDOM" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
