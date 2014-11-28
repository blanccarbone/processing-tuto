PImage b;

void setup() {
	b = loadImage("image.jpg");
	size(b.width, b.height);
	image(b, 0, 0);

// On commence a prendre les couleurs

	color a = b.get(100, 100);
	float c = red(a);
	float d = green(a);
	float e = blue(a);

	float[] couleur_image = new float[3];
	couleur_image[0] = c;
	couleur_image[1] = d;
	couleur_image[2] = e;

	println("couleur_image: "+couleur_image);

	
}

	
