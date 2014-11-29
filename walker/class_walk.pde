class Walker{
    //On initialise toutes les variables
    float positionx ,positiony, directionx, directiony;
    float d1, d2;
    float taille;
    float fr;
    color c;

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

    void bouger(){
        directionx = int(random(-2, 2));
        directiony = int(random(-2, 2));
        // La nouvelle position de l'ellispe est égale à son ancienne position (x et y) + un int entre -1 et 1
        positiony = positiony + directiony;
        positionx = positionx + directionx;
    }


    void collision(){
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


    void display(){
        c = color(random(0, 255));
        taille = int(random(d1, d2));
        stroke(c);

        if(keyPressed){
            if(key == '+')
                d1 += 0.5;
            if(key == '-')
                d1 -= 0.5;
        }

        if(mousePressed){
            d1 = map(mouseY, 0, height, 0.5, 200);
        }

        ellipse(positionx, positiony, taille, taille); // enfin on dessinne notre ellipse
    }
    

}
