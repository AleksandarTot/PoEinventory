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

public class PoEinventory extends PApplet {

int check;
int provera;
Item potion, sword, bow, shield;
int[] [] inventory = {
    {0,0,0},
    {0,0,0},
    {0,0,0}
  };

public void setup()
{
  
  provera = 0;
  check = 0;
  potion = new Item (100,100,50,50,0,255,0,1);
  sword = new Item (100,175,50,100,255,0,0,2);
  bow = new Item (175,112,50,150,255,255,0,3);
  shield = new Item (112,300,100,100,0,0,255,4);
}

public void draw()
{
  background(0);
  stroke(255);
  strokeWeight(2);
  line(300,100,300,400);
  strokeWeight(2);
  line(400,100,400,400);
  strokeWeight(2);
  line(500,100,500,400);
  strokeWeight(2);
  line(600,100,600,400);
  strokeWeight(2);
  line(300,100,600,100);
  strokeWeight(2);
  line(300,200,600,200);
  strokeWeight(2);
  line(300,300,600,300);
  strokeWeight(2);
  line(300,400,600,400);
  noStroke();
  shield.crtaj();
  bow.crtaj();
  sword.crtaj();
  potion.crtaj();
  potion.pokupi();
  sword.pokupi();
  bow.pokupi();
  shield.pokupi();
}

public void mouseReleased()
{
  switch (check)
  {
    case 1:
      potion.spusti();
    case 2:
      sword.spusti(); 
    case 3:
      bow.spusti();
    case 4:
      shield.spusti();
  }  
}
public void deslot(int i, int j, float z1, float z2)
{
    inventory[i][j]=0;
    if(z1>50 && z2>50)
    {
      inventory[i][j+1]=0;
      inventory[i+1][j]=0;
      inventory[i+1][j+1]=0;
    }
    else if(z1>100)
    {
      inventory[i][j+1]=0;
      inventory[i][j+2]=0;
    }
    else if(z2>100)
    {
      inventory[i+1][j]=0;
      inventory[i+2][j]=0;
    }
    else if(z1>50)
    {
      inventory[i][j+1]=0;
    }
    else if(z2>50)
    {
      inventory[i+1][j]=0;
    }
}
boolean klik;
class Item 
{
  float x;
  float y;
  float z1;
  float z2;
  float startx;
  float starty;
  float r;
  float g;
  float b;
  float a;
  int id;
  int inv1;
  int inv2;
  boolean off;
  int flip;
  Item (float _x,float _y, float _z1, float _z2, float _r, float _g, float _b, int _id)
  {
    x=_x;
    y=_y;
    z1=_z1;
    z2=_z2;
    r=_r;
    g=_g;
    b=_b;
    id=_id;
    startx=_x;
    starty=_y;
    flip=69;
  }
  public void crtaj ()
  {
    fill(r,g,b);
    rect(x,y,z1,z2);
  }
  public void pokupi()
  {
    if (mouseX>=x && mouseX<=x+z1 && mouseY>=y && mouseY<=y+z2 && mousePressed==true && (provera==0 || provera==id))
    {
      if (off==true)
      {
        z1=z1/2;
        z2=z2/2;
        deslot(inv1,inv2,z1,z2);
        off=false;
      }
      if (keyPressed && klik==false)
      {
        a=z1;
        z1=z2;
        z2=a;
        klik=true;
        flip=flip*(-1);
      }
      x=mouseX-25;
      y=mouseY-25;
      provera=id;
      check=id;
    }
    else if (mousePressed==false)
    {
      provera=0;
    }
  }
  public void spusti()
  {
    if (mouseX>300 && mouseY>100 && mouseX<600 && mouseY<400){
    if (mouseX>=300 && mouseX<=400 && mouseY>=100 && mouseY<=200 && test(0,0,z1,z2)==true && check==id)
      {
        slot(0,0,z1,z2);
        inv1=0;
        inv2=0;
        x=300;
        y=100;
        z1=z1*2;
        z2=z2*2;
        off=true;
        check=0;
      } 
      else if (mouseX>=400 && mouseX<=500 && mouseY>=100 && mouseY<=200 && z1<=100 && test(0,1,z1,z2)==true && check==id)
      {
        slot(0,1,z1,z2);
        inv1=0;
        inv2=1;
        x=400;
        y=100;
        z1=z1*2;
        z2=z2*2;
        off=true;
        check=0;
      }
      else if (mouseX>=500 && mouseX<=600 && mouseY>=100 && mouseY<=200 && z1<=50 && test(0,2,z1,z2)==true && check==id)
      {
        slot(0,2,z1,z2);
        inv1=0;
        inv2=2;
        x=500;
        y=100;
        z1=z1*2;
        z2=z2*2;
        off=true;
        check=0;
      }
      else if (mouseX>=300 && mouseX<=400 && mouseY>=200 && mouseY<=300 && z2<=100 && test(1,0,z1,z2)==true && check==id)
      {
        slot(1,0,z1,z2);
        inv1=1;
        inv2=0;
        x=300;
        y=200;
        z1=z1*2;
        z2=z2*2;
        off=true;
        check=0;
      }
      else if (mouseX>=400 && mouseX<=500 && mouseY>=200 && mouseY<=300 && z1<=100 && z2<=100 && test(1,1,z1,z2)==true && check==id)
      {
        slot(1,1,z1,z2);
        inv1=1;
        inv2=1;
        x=400;
        y=200;
        z1=z1*2;
        z2=z2*2;
        off=true;
        check=0;
      }
      else if (mouseX>=500 && mouseX<=600 && mouseY>=200 && mouseY<=300 && z1<=50 && z2<=100 && test(1,2,z1,z2)==true && check==id)
      {
        slot(1,2,z1,z2);
        inv1=1;
        inv2=2;
        x=500;
        y=200;
        z1=z1*2;
        z2=z2*2;
        off=true;
        check=0;
      }
      else if (mouseX>=300 && mouseX<=400 && mouseY>=300 && mouseY<=400 && z2<=50 && test(2,0,z1,z2)==true && check==id)
      {
        slot(2,0,z1,z2);
        inv1=2;
        inv2=0;
        x=300;
        y=300;
        z1=z1*2;
        z2=z2*2;
        off=true;
        check=0;
      }
      else if (mouseX>=400 && mouseX<=500 && mouseY>=300 && mouseY<=400 && z2<=50 && z1<=100 && test(2,1,z1,z2)==true && check==id)
      {
        slot(2,1,z1,z2);
        inv1=2;
        inv2=1;
        x=400;
        y=300;
        z1=z1*2;
        z2=z2*2;
        off=true;
        check=0;
      }
      else if (mouseX>=500 && mouseX<=600 && mouseY>=300 && mouseY<=400 && z2<=50 && z1<=50 && test(2,2,z1,z2)==true && check==id)
      {
        slot(2,2,z1,z2);
        inv1=2;
        inv2=2;
        x=500;
        y=300;
        z1=z1*2;
        z2=z2*2;
        off=true;
        check=0;
      }
      else if (off==false && check==id)
      {
        if (flip<0)
        {
        a=z1;
        z1=z2;
        z2=a;
        flip=flip*(-1);
        }
        x=startx;
        y=starty;
      }
    }
  }
}
public void keyReleased() {
  klik = false;
}
public void slot(int i, int j, float z1, float z2)
{
    inventory[i][j]=1;
    if(z1>50 && z2>50)
    {
      inventory[i][j+1]=1;
      inventory[i+1][j]=1;
      inventory[i+1][j+1]=1;
    }
    else if(z1>100)
    {
      inventory[i][j+1]=1;
      inventory[i][j+2]=1;
    }
    else if(z2>100)
    {
      inventory[i+1][j]=1;
      inventory[i+2][j]=1;
    }
    else if(z1>50)
    {
      inventory[i][j+1]=1;
    }
    else if(z2>50)
    {
      inventory[i+1][j]=1;
    }
}
public boolean test (int i,int j,float z1,float z2)
{
  if (inventory[i][j]==1)
  {
    return false;
  }
  else if (z1>50 && z2>50 && inventory[i+1][j+1]==1)
  {
    return false;
  }
  else if (z1>100 && inventory[i][j+2]==1)
  {
    return false;
  }
  else if (z2>100 && inventory[i+2][j]==1)
  {
    return false;
  }
  else if (z1>50 && inventory[i][j+1]==1)
  {
    return false;
  }
  else if (z2>50 && inventory[i+1][j]==1)
  {
    return false;
  }
  else return true;
}
  public void settings() {  size(700,500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PoEinventory" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
