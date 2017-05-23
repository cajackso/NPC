package com.PathFindingUtils;
public class CalculateManhattenValues
{
	
	CalculateManhattenValues(){}
	
	Node[][] calc(int sizeX, int sizeY, Node[][] nds, int dstx, int dsty)
	{
	for( int a=0;a<sizeX;a++)
    {
	  for (int b=0;b<sizeY;b++)
     	{
			nds[a][b].calcManhatten(dstx,dsty);		
    	}
    }	
				
	return nds;	
	}	
}
