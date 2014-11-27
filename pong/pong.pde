int x,y,deplacementX,deplacementY,w,z;

void setup() {
	size(400, 400);
	z=60;
	w=15;
	deplacementY=-3;
	deplacementX=6;
	y=200;
	x=200;

	
}

void draw() {
	nettoyer();
	dessiner();
	bouger();
	rebondir();
}


void nettoyer(){
	background(0);
}

void dessiner(){
	// Dessin du plateau
	fill(255);
	rect(w, z, 25, 85);

	// Dessin de la balle
	smooth();
	fill(255);
	ellipse(x, y, 20, 20);
	line(200, 0, 200, 400);
}

void bouger(){
	// Deplacement de la balle
	x+=deplacementX;
	y+=deplacementY;

	// Deplacement du plateau
	z=mouseY;

}	

void rebondir(){
	if (x > width-10 && deplacementX > 0) {
		deplacementX = -deplacementX;
	}


	if (y > width-10 && deplacementY > 0) {
		deplacementY = -deplacementY;
	}

	 if (y < 10 && deplacementY < 10) 
	 {
	   deplacementY = abs(deplacementY); // rendre positive cette valeur
	 }

	// Rebomdir sur le plateau
	if (x<w+35 && y<z+85 && y>z) {
		deplacementX=-deplacementX;
	}

	if(x < 10){
		noLoop();
		println("GAME OVER");
		println("Pour lancer une nouvelle partie appuyer sur la touche n");

	}


}

void keyPressed(){
	if (key == 'n' || key == 'N') {
		x = y = 200;
		deplacementX = -deplacementX;
		loop();
	}else {
		
	}
}