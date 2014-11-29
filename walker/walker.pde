import processing.pdf.*;

int num = 5;
float diametre = 0.3;
float fr;
Walker walk[] = new Walker[num];
boolean continuer;
PGraphicsPDF pdf;



 void setup(){
    size(800,300, P2D); // on choisi la taille du sketch 
     pdf = (PGraphicsPDF) beginRecord(PDF, "walker.pdf");
    println("Début du record");
    background(255); // on donne un fond blanc
    smooth(); // on améliore le rendu (en option)
    
    for (int i = 0; i < num; i++) {
        walk[i] = new Walker(diametre);
    }

    smooth();
}



void draw(){
    continuer = true;
    fr = map(mouseX, 0, width, 10, 200);
    frameRate(fr);
    //on choisi au hasard un mouvement pour x et y compris entre -1 et 1 

    for (int i = 0; i < num; i++) {
        walk[i].bouger();
        walk[i].collision();
        walk[i].display();
    }
}


void keyPressed(){

    if(key == 's' || key == 'S'){
        if(continuer){
            noLoop();
            continuer = !continuer;
        }else{
            loop();
            continuer= !continuer;
        }
    }    
            
    if (key == 'r') {
        endRecord();
        println("Image correctement exporté en PDF");
        exit();
    }

    if (key == 'n') {
        pdf.nextPage();
        println("Nouvelle page crée");        
    }




  
}
    

