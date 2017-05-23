package com.PathFindingUtils;
public class Node
{
	private int positionX;	
	private int positionY;
	private int type;
	private int parentX;
	private int parentY;
	private boolean playerPresent;
	private int manhattenValue;
	
	private int moveValue;
	
	public Node()
	{
	type=0;	
	playerPresent=false;
	}
	void setPositionX(int a)
	{
		this.positionX=a;
	}
	
	void setPositionY(int a)
	{
		this.positionY=a;
	}
	int getPositionX()
	{
		return this.positionX;
	}
	
	int getPositionY()
	{
		return this.positionY;
	}
	
	void setType(int type)	
	{
		this.type=type;
	}
	
	int getType()
	{
		return this.type;
	}
	
	void setParent(int x, int y)
	{
		this.parentX=x;
		this.parentY=y;
	}
	
	int getParentX()
	{
		return this.parentX;
	}
	
	int getParentY()
	{
		return this.parentY;
	}
	
	void setPlayerPresent(boolean present)
	{
		this.playerPresent=present;
	}
	
	
	boolean getPlayerPresent()
	{
		return this.playerPresent;
	}
	
	void calcManhatten(int destinationX, int destinationY)
	{
		Manhatten man = new Manhatten();
		this.manhattenValue=man.calculate(this.positionX, this.positionY, destinationX,destinationY);
	}
	
	void setMoveValue(int a)
	{
		this.moveValue=a;
	}
	
	int getMoveValue()
	{		
		return this.moveValue;
	}
	
	int getManhattenValue()
	{
		return this.manhattenValue;
	}
}
