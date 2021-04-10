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
  void crtaj ()
  {
    fill(r,g,b);
    rect(x,y,z1,z2);
  }
  void pokupi()
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
  void spusti()
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
void keyReleased() {
  klik = false;
}
