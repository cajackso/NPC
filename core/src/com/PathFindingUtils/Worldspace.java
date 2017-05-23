package com.PathFindingUtils;

import java.awt.*;
;public class Worldspace
{
	
	
	Map mp= new Map(20,20);
	private Player pl = new Player();
	
	Worldspace(){};
	
	void MainLoop(){
	
		mp.clearMap();
		mp.creatWall("h",4,4,17,4);
	//	mp.creatWall("h",2,7,19,7);
	//	mp.creatWall("h",0,9,18,9);
	//	mp.creatWall("h",2,10,19,10);
		pl.setPosition(5,1);
		pl.setDestination(5,14);
		mp.logPlayerAtNode(pl.getPosX(),pl.geyPosY());
		mp.logDestinationAtNode(pl.getDestX(),pl.getDestY());
		mp.CalculateManhattenValues(pl.getDestX(),pl.getDestY());
		mp.showMap();
		mp.generatePath();
		mp.showMap();
	    
	}
}
