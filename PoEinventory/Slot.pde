void slot(int i, int j, float z1, float z2)
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
