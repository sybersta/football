package com.example.football.Util;

import java.text.DecimalFormat;

public class PankouUtils {
	
	public static void main(String[] args) {
		
//		System.out.println(getPosition(1.85,-0.5)-(getPosition(1.8,-1)/2.0));
		
	}
	
public static int getPosition(double masterLevel,double position,double standard){
	if(masterLevel>2.1||masterLevel<1.7){
		return -9999;
	}
	return Integer.valueOf(new DecimalFormat("#").format((11*(position/0.25)+(masterLevel-standard)/0.025)));
}


public static int getBigSmallPosition(double masterLevel,double position,double standard){
	if(masterLevel>2.1||masterLevel<1.7){
		return -9999;
	}
	return Integer.valueOf(new DecimalFormat("#").format((11*(position/0.25)+(masterLevel-standard)/0.025)));
}

//public static Double getMediumPosition(double masterLevel,double position){
//	double a=0.5;
//	if(masterLevel>1.9){
//		a=-0.5;
//	}
//	Double mediumPosition=0.25*(int)((position/2.00/0.25)+a);
//	double level=1.7;
//	double b=getPosition(1.925,-0.25)/2.0;
//	for(int i=0;i<=32;i++){
//		if( Double.valueOf(new DecimalFormat("#.0").format((11*(mediumPosition/0.25)+((level+i*0.0125)-1.925)/0.025)))==b){
//			return level+i*0.0125;
//		}
//	}
//	
//	return 0.0;
//}

//public static Double getMediumPk(double masterLevel,double position){
//	double a=0.5;
//	if(masterLevel>1.9){
//		a=-0.5;
//	}
//	Double mediumPosition=0.25*(int)((position/2.00/0.25)+a);
//	return mediumPosition;
//}

}
