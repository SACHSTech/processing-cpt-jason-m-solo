import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

public class Sketch extends PApplet {
	
  float[] circleY = new float[25];
  
  public void settings(){
    size(300, 150);
  }

  PImage blackBg;
  PImage clapping;
  PImage gameBg;
  PImage endding2;
  Random myRandom = new Random();
  int intRandom = myRandom.nextInt(width);
  int lvlDiff;
  float circleX;
  float speed1 = 1;
  

  public void setup() {
    //background(0);
    blackBg = loadImage("C:\\Users\\majas\\github-classroom\\SACHSTech\\processing-cpt-jason-m-solo\\CPT black bg.jpg");
    clapping = loadImage("C:\\Users\\majas\\github-classroom\\SACHSTech\\processing-cpt-jason-m-solo\\CPT clapping guy.jpg");
    gameBg = loadImage("C:\\Users\\majas\\github-classroom\\SACHSTech\\processing-cpt-jason-m-solo\\CPT game bg.jpg");
    endding2 = loadImage("C:\\Users\\majas\\github-classroom\\SACHSTech\\processing-cpt-jason-m-solo\\CPT ending2.jpg");

    for(int i = 0; i < circleY.length; i++){
      circleY[i] = random(height);
    }
  }

  public void draw() {
    
    //starter screen
    image(blackBg, 0, 0);
    fill(255,0,0);
    //starter screen text
    textSize(30);
    textAlign(LEFT,TOP);
    text("Game",110,50);
    fill(0,0,204);
    textSize(20);
    text("Press c to start",90,80);
    
    //faling objects
    if(key == 'c'){
      fill(0,255,51);
      image(gameBg, 0, 0);
       for (int i = 0; i < circleY.length; i++){
      float circleX = width * i/ circleY.length;
      ellipse(circleX, circleY[i], 25, 25);
  
      circleY[i]++;
  
      if (circleY[i] > height){
        circleY[i] = 0;
      }
    }
    
    //player
    fill(GRAY);
    rect(mouseX,mouseY, 20,20);
    
    //edges
    if(mouseX >= width-20 || mouseY >= height-20 ){
      image(endding2, 0, 0);
    }

    if(mouseX <= 5 || mouseY <= 5){
      image(endding2, 0, 0);
       }
      }
    }
    
    public void keyPressed(){
    if(keyCode == ALT){
        image(gameBg, 0, 0);
      }
   }  
}