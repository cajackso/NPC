package com.PathFindingUtils;

import java.util.*;

public class Map
{
	private CalculateManhattenValues calc;
	private Node [][] map;
	private int sizeX;
    private	int sizeY;
	private final int WALL=9;
	private final int PRESENT=1;
	private final int DEST=2;
	GetPath gp;
	
	Map(int x, int y){	
	 this.map= new Node[x][y];
		this.sizeX=x;
		this.sizeY=y;
		calc = new CalculateManhattenValues();
		
		for (int a=0;a<sizeX;a++)
		{
			for( int b=0;b<sizeY; b++)
			{
				this.map[a][b]= new Node();
				this.map[a][b].setPositionX(a);
				this.map[a][b].setPositionY(b);
			}
		}
		
		
	}
	
	void generatePath()
	{
		 gp= new GetPath(this.map,this.sizeX,this.sizeY);	
	}
	
	public void clearMap(){
		for (int a=0;a<sizeX;a++)
		{
			for (int b=0;b<sizeY;b++)
			{

				this.map[a][b].setType(0);
			}
		}
	}
	void creatWall(String hOrV, int fromX, int fromY, int toX, int toY)
	{
		if (hOrV=="h")
		{
			
			for(int a=fromX;a<=toX;a++)
			{
				
			this.map[a][fromY].setType(this.WALL);
			}
			
		} else if(hOrV=="v")
		{
			for (int b=fromY;b==toY;b++)
			{
				this.map[fromX][b].setType(this.WALL);
			}
		}
	}
	

void showMap()
{
	String row ="";
	for(int a=0;a<sizeY;a++)
	{
		for (int b=0;b<sizeX;b++)
		{
		row +=  this.map[b][a].getType();
		//row += this.map[a][b].manhattenValue;
		}
		System.out.println(row);
		row="";
	}
	
}

void logPlayerAtNode(int x, int y)
{
	this.map[x][y].setType(this.PRESENT);
	this.map[x][y].setPlayerPresent(true);
	
}

void logDestinationAtNode(int x, int y)
{
	this.map[x][y].setType(this.DEST);
}

void CalculateManhattenValues(int dstX, int dstY)
{
	this.map=calc.calc(this.sizeX,this.sizeX,map, dstX,dstY);
}
}


