int check;
int provera;
Item potion, sword, bow, shield;
int[] [] inventory = {
    {0,0,0},
    {0,0,0},
    {0,0,0}
  };

void setup()
{
  size(700,500);
  provera = 0;
  check = 0;
  potion = new Item (100,100,50,50,0,255,0,1);
  sword = new Item (100,175,50,100,255,0,0,2);
  bow = new Item (175,112,50,150,255,255,0,3);
  shield = new Item (112,300,100,100,0,0,255,4);
}

void draw()
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

void mouseReleased()
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
