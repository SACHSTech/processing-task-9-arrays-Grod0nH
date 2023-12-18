/*
 * This program is a game of showflake dodging game
 * @author: Grod0nH
 */




import processing.core.PApplet;
import processing.core.PImage;


public class Sketch extends PApplet {
  //Mutiple different coords put into the array
  float fltSnowflakeY[] = new float[35];
  float fltSnowflakeX[] = new float[35];
  //Importing the pictures
  PImage snowBackground;
  PImage snowflake;
  //Boolean for WASD keys
  boolean wPressed = false;
  boolean aPressed = false;
  boolean sPressed = false;
  boolean dPressed = false;
  //Player icon location
  float fltplayerX = 500;
  float fltplayerY = 800;
  //Player health
  int intHealth = 3;


  
  
	
  public void settings() {
    size(1000, 1000);
  }

 
  public void setup() {
    snowBackground = loadImage("snowbackground.png");
    snowflake = loadImage("image-removebg-preview (1).png");

    //Making the location of the snowflake random
    for (int i = 0; i < fltSnowflakeY.length; i++) {
      fltSnowflakeY[i] = random(height);
    }
     for (int i = 0; i < fltSnowflakeX.length; i++) {
      fltSnowflakeX[i] = random(width);
    }
  }

 
  public void draw() {
    
    if (intHealth > 0) {

      image(snowBackground, 0, 0);
      // checks the hp of the player left and prints out the needed squares
      if (intHealth == 3) {

        fill(255,0,0);
        rect(8,8,25,25);
        rect(48,8,25,25);
        rect(88,8,25,25);

      } else if (intHealth == 2) {

        fill(255,0,0);
        rect(8,8,25,25);
        rect(48,8,25,25);
        
        
      } else if (intHealth == 1) {

        fill(255,0,0);
        rect(8,8,25,25);
      }
          //Draws the amount of snowflakes that are in the array. 
        for (int i = 0; i < fltSnowflakeY.length; i++) {
          image(snowflake,fltSnowflakeX[i], fltSnowflakeY[i], 100,100);

          if (dist(fltplayerX, fltplayerY,fltSnowflakeX[i],fltSnowflakeY[i]) <= 50) {

            // decresaes the health by 1 and sends the snowflake back up to the top to prevent the player from instnatly dieing 
            intHealth -= 1;
            fltSnowflakeY[i] = 0;
  
          }

      //Speeds up or slows down the snowflake
        if(keyCode == DOWN){
          fltSnowflakeY[i]+=5;
          fltSnowflakeX[i]++;
        }
        else if(keyCode == UP){
          fltSnowflakeY[i]+=2;
        }
        else{
          fltSnowflakeY[i]+=3;
        }
        //Makes sure that the snowflakes that hit the edges of the screen will be redrawn
        if (fltSnowflakeY[i] > height) {
          fltSnowflakeY[i] = 0;
        }
        else if(fltSnowflakeX[i] > width){
          fltSnowflakeX[i] = 0;
        } 
     }
    
        //Player Movement
        if (wPressed) {
          fltplayerY-=2;
        }
        if (sPressed) {
          fltplayerY+=2;
        }
        if (aPressed) {
          fltplayerX-=2;
        }
        if (dPressed) {
          fltplayerX+=2;
        }
        fill(0,150, 255);
        ellipse(fltplayerX, fltplayerY, 50, 50);
        }
     //This make the background black so the game is over   
    else{
      background(0);
    }
  }

    //This will make the snowfalkes disappear when
    public void mousePressed(){
      for (int i = 0; i < 35; i++) {
        if (dist((float) mouseX, (float) mouseY, fltSnowflakeX[i], fltSnowflakeY[i]) < 80) {
          fltSnowflakeY[i] = 0;
        }
      }
    }
  
  
  //Methods to keep track of if the WASD keys are pressed
  public void keyPressed() {
    if (key == 'w') {
      wPressed = true;
    }
    else if (key == 's') {
      sPressed = true;
    }
    else if (key == 'a') {
      aPressed = true;
    }
    else if (key == 'd') {
      dPressed = true;
    }
  }
  //Method to update when the key is released
   public void keyReleased() {
    if (key == 'w') {
      wPressed = false;
    }
    else if (key == 's') {
      sPressed = false;
    }
    else if (key == 'a') {
      aPressed = false;
    }
    else if (key == 'd') {
      dPressed = false;
    }
  }
}