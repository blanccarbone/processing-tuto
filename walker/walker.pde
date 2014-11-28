// Auteur : Fabien Bonnamy
// Site web : tutoprocessing.com/random-walker
//Sketch d'apprentissage qui montre comment faire un random walker
// Un random walker est une particule qui se deplace de facon aléatoire sur l'ecran 

//On initialise toutes les variables
float positionx ,positiony, directionx, directiony;
float taille;
float fr;
color c;

 void setup(){
    size(200,200); // on choisi la taille du sketch 
    background(255); // on donne un fond blanc
    smooth(); // on améliore le rendu (en option)

    // on place notre future ellipse au centre de l'éctan
    positionx = width/2;
    positiony = height/2;
}

void draw(){
    fr = map(mouseX, 0, width, 200, 50000);
    frameRate(fr);
    //on choisi au hasard un mouvement pour x et y compris entre -1 et 1 
    directionx = int(random(-2, 2));
    directiony = int(random(-2, 2));

    // La nouvelle position de l'ellispe est égale à son ancienne position (x et y) + un int entre -1 et 1
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
      taille = int(random(2, 20)); // on change la taille de l'ellispe à chaque tour du draw pour rendre ça plus funky
    }
    smooth();
    c = color(random(0, 255));
    stroke(c);
    ellipse(positionx, positiony, taille, taille); // enfin on dessinne notre ellipse
}

void mousePressed(){    
    smooth();
    c = color(random(0, 255));
    stroke(c);
    ellipse(positionx, positiony, taille, taille);
}

void keyPressed(){
    if (key == 'a') {
      noLoop();
    } else {
      loop();
    }
}
