package com.PathFindingUtils;


public class Player
{
	private int x;
	private int y;
	
	private int destX;
	private int destY;
	
	Player(){}
	
	void setPosition(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	
	 void setDestination(int x, int y)
	 {
		 this.destX=x;
		 this.destY=y;
	 }
	 
	 int getPosX()
	 {
		 return this.x;
	 }
	 
	 int geyPosY()
	 {
		 return this.y;
	 }
	 
	 int getDestX()
	 {
		 return this.destX;
	 }
	 
	 int getDestY()
	 {
		 return this.destY;
	 }
}
