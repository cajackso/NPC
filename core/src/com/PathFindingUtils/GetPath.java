
package com.PathFindingUtils;

import java.util.*;
public class GetPath
{
	int c;
	Node mp[][];
	int sizeX;
	int sizeY;
    
	Node previousNode;
	Node currentCheck;

	List <Node>activeList = new ArrayList<Node>();
	List <Node>closedList = new ArrayList<Node>();
	List <Node>path = new ArrayList<Node>();
	
	int playerLocX;
	int playerLocY;
	
	int destLocX;
	int destLocY;
	
	int currentCycleHighestX;
	int currentCycleHighestY;
	int currentCycleBestScore;
	
	boolean destReached;
	
	GetPath(Node[][] mp, int sizeX, int sizeY)
	{
	
		this.currentCycleBestScore=999999;
		destReached=false;
		this.mp=mp;
		this.sizeX=sizeX;		
		this.sizeY=sizeY;
		
		locateDestination();
        locatePlayer();	
		
		this.currentCheck=mp[playerLocX][playerLocY];
		this.previousNode=currentCheck;
	    processing();
	}
	
	void processing()
	{
	while(destReached==false){	
		updateActiveList();
		moveToBestNode();   
		System.out.println("_______________________");	
	}
	
	GeneratePath();	
	}
	
	void updateActiveList()
	{	
	c=0;

		for (int a=this.currentCheck.getPositionX()-1;a<=this.currentCheck.getPositionX()+1;a++)
		{
				for (int b=this.currentCheck.getPositionY()-1;b<=this.currentCheck.getPositionY()+1;b++)
			{
				
				if(a>0 && a<sizeX && b > 0 && b <sizeY && currentCheck != mp[a][b])
				{

				c++;
		
				if(checkClosedList(mp[a][b]) != true  && mp[a][b].getType() != 9 )
				{		
		if (checkActiveList(mp[a][b]) != true)
		{
				this.activeList.add(mp[a][b]);
			this.mp[a][b].setParent(currentCheck.getPositionX(),currentCheck.getPositionY());
	}
				
				scoreNodes(a,b,c);
				identifyBestNode(a,b);
				System.out.println("checking "+c+" posX "+mp[a][b].getPositionX()+" posY "+mp[a][b].getPositionY()+" value "+mp[a][b].getMoveValue()+mp[a][b].getManhattenValue());
				if(this.destReached == false)
				{
				
				} else {
					GeneratePath();
				}
		    	}	}			
		}
		showActiveList();
		activeList.clear();
		}
		updateClosedList(this.currentCheck);
		activeList.remove(this.currentCheck);
	}
	
	void scoreNodes(int a, int b, int c)
	{
	
		if (c==1 || c==3 || c==6 || c==8)
		{
			this.mp[a][b].setMoveValue(14);
		} else {
			this.mp[a][b].setMoveValue(10);
		}
	}
	

	void showActiveList()
	{
		for(int a=0;a<activeList.size();a++)
		{
			System.out.println(a+":"+activeList.get(a).getPositionX()+":"+activeList.get(a).getPositionY());
		}
	}
	
	void locatePlayer()
	{
		for (int a=0; a<this.sizeX;a++)
		{
			for (int b=0; b<this.sizeY;b++)
			{
			
				if(this.mp[a][b].getPlayerPresent())
				{
				
					this.playerLocX=a;
					this.playerLocY=b;
					updateClosedList(this.mp[a][b]);
					return;
				}
			}
		}
	}	
		boolean checkClosedList(Node a)
		{
			
			boolean exists=false;
						
			for(int b=0; b<this.closedList.size();b++)
			{
				if(a.getPositionX()==closedList.get(b).getPositionX())
				{
					if (a.getPositionY()==closedList.get(b).getPositionY())
					{
						exists=true;
					}
				}
			}
			return exists;
		}
	
		boolean checkActiveList(Node a)
		{
			boolean exists=false;
			
			for(int  b=0;b< this.activeList.size();b++)
			{
				if(a.getPositionX()==activeList.get(b).getPositionX())
				{
					if (a.getPositionY()==activeList.get(b).getPositionY())
					{
						exists=true;
					}
				}
				
			}
			
			return exists;
		}
	
	void updateClosedList(Node a)
	{
		this.closedList.add(a);
		checkDestination(a.getPositionX(), a.getPositionY());
	//	showClosedList();
	}
	
	void showClosedList()
	{
		for (int a=0;a<closedList.size();a++)
		{
			System.out.println(a+":"+closedList.get(a).getPositionX()+":"+closedList.get(a).getPositionY());
		}
	}
	
	void identifyBestNode(int a, int b)
	{ 
	if (this.mp[a][b].getMoveValue()+this.mp[a][b].getManhattenValue()<this.currentCycleBestScore)
	{
	//	System.out.println("hayman");
		this.currentCycleHighestX=this.mp[a][b].getPositionX();
		this.currentCycleHighestY=this.mp[a][b].getPositionY();
		this.currentCycleBestScore=this.mp[a][b].getManhattenValue()+this.mp[a][b].getMoveValue();
	//	checkDestination(a,b);
	  //  updateClosedList(this.currentCheck);
	}
		
	}
	
	void moveToBestNode()
	{
		//System.out.println("prev"+previousNode.getPositionX());
		this.previousNode=currentCheck;
		System.out.println("prev2"+previousNode.getPositionX());
	//	System.out.println(this.currentCycleHighestX+"|"+this.currentCycleHighestY);
	
		this.currentCheck=mp[this.currentCycleHighestX][this.currentCycleHighestY];
		this.mp[currentCycleHighestX][currentCycleHighestY].setParent(previousNode.getPositionX(),previousNode.getPositionY());
		this.currentCycleHighestX=0;
		this.currentCycleHighestY=0;
		this.currentCycleBestScore=9999;
		System.out.println("setting "+currentCheck.getPositionX()+";"+currentCheck.getPositionY()+" parent to "+previousNode.getParentX()+";"+previousNode.getParentY());
	}
	
	void locateDestination()
	{
		for(int a=0;a<this.sizeX;a++)
		{
			for(int b=0;b<this.sizeY;b++)
			{
				if (this.mp[a][b].getType()==2)
				{
				this.destLocX=a;
				this.destLocY=b;
				return;
				}
			}
		}
	}
	
	void checkDestination(int a, int b)
	{
		if (this.mp[a][b].getType()==2)
		{
			this.destReached=true;
			System.out.println("reached");
		}
	}
	
	void GeneratePath()
	{
//	for(int a=0;a<10;a++)
//{
	
//	System.out.println(mp[4][3].getParentX());
//	System.out.println(mp[4][3].getParentY());
		while(this.currentCheck.getPlayerPresent() != true)
		{
	//		System.out.println("p");
	
			this.mp[currentCheck.getPositionX()][currentCheck.getPositionY()].setType(5);
			this.currentCheck=mp[currentCheck.getParentX()][currentCheck.getParentY()];
			//this.currentCheck.setPositionX(mp[currentCheck.getPositionX()][currentCheck.getPositionY()].getParentX());
			//this.currentCheck.setPositionY(mp[currentCheck.getPositionX()][currentCheck.getPositionY()].getParentY());
			
	     	//System.out.println("posx "+currentCheck.getPositionX());
		//	System.out.println("posy "+currentCheck.getPositionY());
	    //	System.out.println("parentx "+currentCheck.getParentX());
		//	System.out.println("parenty "+currentCheck.getParentY());
		}
	}	
//	}
	
}
