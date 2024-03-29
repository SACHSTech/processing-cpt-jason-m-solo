import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

public class Sketch extends PApplet {
	
  float[] circleY = new float[25];
  
  public void settings(){
    size(300, 150);         
  }

//golbal variables
PImage blackBg;
PImage clapping;
PImage gameBg;
PImage endding2;
PImage jump;
PImage gameBg2;
PImage endding4;
PImage bg4;
PImage lose;
Random myRandom = new Random();
int intRandom = myRandom.nextInt(width);
int lvlDiff = 0;
float circleX;
float speed1 = 1;
int ballCount = 10;
boolean gameTrueFalse = false;

float[] x = new float[ballCount];
float[] y = new float[ballCount];
float[] xSpeed = new float[ballCount];
float[] ySpeed = new float[ballCount];
float[] size = new float[ballCount];
float[] r = new float[ballCount];
float[] g = new float[ballCount];
float[] b = new float[ballCount];


float bouncingRectX = 50;
float bouncingRectY = 50;
float bouncingRectWidth = 20;
float bouncingRectHeight = 20;
float bouncingRectSpeedX = 2;
float bouncingRectSpeedY = 1;

/**
 * load images and set up information
 */
  public void setup() {
    //load images
    blackBg = loadImage("C:\\Users\\majas\\github-classroom\\SACHSTech\\processing-cpt-jason-m-solo\\CPT black bg.jpg");
    clapping = loadImage("C:\\Users\\majas\\github-classroom\\SACHSTech\\processing-cpt-jason-m-solo\\CPT clapping guy.jpg");
    gameBg = loadImage("C:\\Users\\majas\\github-classroom\\SACHSTech\\processing-cpt-jason-m-solo\\CPT game bg.jpg");
    endding2 = loadImage("C:\\Users\\majas\\github-classroom\\SACHSTech\\processing-cpt-jason-m-solo\\CPT ending2.jpg");
    jump = loadImage("C:\\Users\\majas\\github-classroom\\SACHSTech\\processing-cpt-jason-m-solo\\CPT jump.jpg");
    gameBg2 = loadImage("C:\\Users\\majas\\github-classroom\\SACHSTech\\processing-cpt-jason-m-solo\\CPT gamebg2.jpg");
    endding4 = loadImage("C:\\Users\\majas\\github-classroom\\SACHSTech\\processing-cpt-jason-m-solo\\endding4.jpg");
    bg4 = loadImage("C:\\Users\\majas\\github-classroom\\SACHSTech\\processing-cpt-jason-m-solo\\bg4.jpg");
    lose = loadImage("C:\\Users\\majas\\github-classroom\\SACHSTech\\processing-cpt-jason-m-solo\\Cpt lose.jpg");
   
    for(int i = 0; i < circleY.length; i++){
      circleY[i] = random(height);
    }

    for(int i = 0; i < ballCount; i++){
      x[i] = random(width);
      y[i] = random(height);
      xSpeed[i] = random(-5, 5);
      ySpeed[i] = random(-5, 5);
      size[i] = random(5, 20);
      r[i] = random(256);
      g[i] = random(256);
      b[i] = random(256);
    }
  }
  
  /**
   * moving parts of the game
   */
  public void draw(){
    //starter screen
    image(blackBg, 0, 0);
    fill(255,0,0);
    //starter screen text
    textSize(30);
    textAlign(LEFT,TOP);
    text("Game",110,50);
    fill(0,0,204);
    textSize(20);
    text("Press 'c' to start",90,80);
    fill(255,255,204);
    textSize(15);
    text("Chase the balls!!1!",95,100);
    
    
    //faling objects
    if(key == 'c'){
      fill(0,255,51);
      image(gameBg, 0, 0);
      
      //snowfall
      fill(255,255,255);
      for (int i = 0; i < circleY.length; i++) {
        float circleX = width * i / circleY.length;
        ellipse(circleX, circleY[i], 5, 5);
    
        circleY[i]++;
    
        if (circleY[i] > height) {
          circleY[i] = 0;
        }
      }
    // lvl1
     for(int i = 0; i < ballCount; i++){

      x[i] += xSpeed[i];
      if(x[i] < 0 || x[i] > width){
        xSpeed[i] *= -0.95;
      }
     
      y[i] += ySpeed[i];
      if(y[i] < 0 || y[i] > height){
        ySpeed[i] *= -0.95;
      }
  
      fill(r[i], g[i], b[i]);
      ellipse(x[i], y[i], size[i], size[i]);
      
      //circle edge 
      if((int)x[i] > mouseX && (int)x[i] < mouseX + 20){
        if((int)y[i] > mouseY && (int)y[i] < mouseY + 10){
          image(clapping, 0, 0);
          lvlDiff++;
        }
     
    //edge detection
    if( mouseY >= height-20){
     image(endding2, 0, 0);
     lvlDiff = lvlDiff--;
    }
    if( mouseX >= 280){
     image(endding2, 0, 0);
     lvlDiff = lvlDiff--;
    }
    if(mouseX <= 5 || mouseY <= 5){
      image(endding2, 0, 0);
      lvlDiff = lvlDiff--;
       }
      }
    }
   
    //player
    fill(1);
    rect(mouseX,mouseY, 20,10);

    //lvl2
    if(lvlDiff>15){
      image(gameBg2, 0, 0);
        
      //snowfall
        fill(0,245,55);
      for (int i = 0; i < circleY.length; i++) {
        float circleX = width * i / circleY.length;
        ellipse(circleX, circleY[i], 10, 10);
    
        circleY[i]++;
    
        if (circleY[i] > height) {
          circleY[i] = 0;
        }
      }

     for(int i = 0; i < ballCount; i++){

      x[i] += xSpeed[i];
      if(x[i] < 0 || x[i] > width){
        xSpeed[i] *= -1.1;
      }
  
      y[i] += ySpeed[i];
      if(y[i] < 0 || y[i] > height){
        ySpeed[i] *= -1.1;
      }
  
      fill(r[i], g[i], b[i]);
      ellipse(x[i], y[i], size[i], size[i]);

      if((int)x[i] > mouseX && (int)x[i] < mouseX + 20){
        if((int)y[i] > mouseY && (int)y[i] < mouseY + 10){
          image(clapping, 0, 0);
        }
      }
    }

    //edge detection
    if( mouseY >= height-20){
     image(endding2, 0, 0);
     lvlDiff = lvlDiff--;
    }
    if( mouseX >= 280){
 image(endding2, 0, 0);
     lvlDiff = lvlDiff--;
    }
    if(mouseX <= 5 || mouseY <= 5){
      image(endding2, 0, 0);
      lvlDiff = lvlDiff--;
       }
    }
  
  //player
    fill(1);
    rect(mouseX,mouseY, 20,10);
    }
    
  //lvl3
    if(lvlDiff>35){
      image(bg4, 0, 0);
        
      //snowfall
        fill(0,2,25);
      for (int i = 0; i < circleY.length; i++) {
        float circleX = width * i / circleY.length;
        ellipse(circleX, circleY[i], 13, 13);
    
        circleY[i]++;
    
        if (circleY[i] > height) {
          circleY[i] = 0;
        }
      }
        for(int i = 0; i < ballCount; i++){

      x[i] += xSpeed[i];
      if(x[i] < 0 || x[i] > width){
        xSpeed[i] *= -1.16;
      }
  
      y[i] += ySpeed[i];
      if(y[i] < 0 || y[i] > height){
        ySpeed[i] *= -1.16;
      }
  
      fill(r[i], g[i], b[i]);
      ellipse(x[i], y[i], size[i], size[i]);

      if((int)x[i] > mouseX && (int)x[i] < mouseX + 20){
        if((int)y[i] > mouseY && (int)y[i] < mouseY + 10){
          image(clapping, 0, 0);
        }
      
      }
      //edges
  if( mouseY >= height-20 ){
     image(endding2, 0, 0);
     lvlDiff = lvlDiff--;
    }
    if( mouseX >= 280){
 image(endding2, 0, 0);
     lvlDiff = lvlDiff--;
    }
    if(mouseX <= 5 || mouseY <= 5){
      image(endding2, 0, 0);
      lvlDiff = lvlDiff--;
       }
    }
      
    //player
    fill(1);
    rect(mouseX,mouseY, 20,10);
    
    //good ending
    if(lvlDiff >= 45){
      image(blackBg, 0, 0);
        image(endding4, 40,-30);
    }
  }
}
/**
 * short cut to victory
 */
public void keyPressed(){
  if(keyCode == UP){
   gameTrueFalse = true;
   if(gameTrueFalse = true ){
    lvlDiff = 47;
   }
  }
}
}
  
