import processing.pdf.*;

ArrayList<Walker> walk;
int nbwalk;



float diametre = 0.3;
float fr;
boolean continuer;
PGraphicsPDF pdf;



 void setup(){
    size(800,500, P2D); // on choisi la taille du sketch 
     pdf = (PGraphicsPDF) beginRecord(PDF, "walker-test.pdf");
    println("Début du record");
    background(255); // on donne un fond blanc
    smooth(); // on améliore le rendu (en option)

    nbwalk = 0;
    walk = new ArrayList<Walker>();
    for (int i=0; i<nbwalk; i++){
        walk.add(new Walker());
    }

    frameRate(400);
    

}



void draw(){
    continuer = true;
    for (int i=0; i<walk.size(); i++){
        Walker w = walk.get(i);
        w.bouger();
        w.collision();
        w.display();

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
        walk.add(new Walker(mouseX, mouseY));
        println("Nouvelle particule ajoutée");        
        }

    if (key == 'b') {
        walk.add(new Walker());
        println("Nouvelle particule random ajoutée");        
        }        

    if (key == 'd') {
        background(255);        
        }
}







  
    
