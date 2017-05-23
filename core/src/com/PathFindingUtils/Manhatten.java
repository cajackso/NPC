package com.PathFindingUtils;

public class Manhatten
{
	Manhatten(){}
	int answer;
	public int calculate(int x, int y, int dx, int dy)
	{
	answer= Math.abs(dx-x)+Math.abs(dy-y);
	//System.out.println(x+";"+y);
	//System.out.println(answer);
	return answer;
	}
}
