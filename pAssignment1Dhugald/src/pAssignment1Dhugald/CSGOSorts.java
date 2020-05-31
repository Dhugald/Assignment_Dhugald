package pAssignment1Dhugald;

import java.util.ArrayList;

public class CSGOSorts {

	public static ArrayList<Games> matches;
	
	public CSGOSorts(ArrayList<Games>matches) {

		
	}
	public static Object RankT1(ArrayList<Games> matches) {
		Object[] Order = new Object[matches.size()];
		int min = 999;
		String temp;
		for(Games item:matches) {
			for (int i = 0; i < 99; i++) {
			Object[] object = new Object[16];
			object[0]=  matches.get(i).getDate();
			object[1]=  matches.get(i).getTeam1();
			object[2]=  matches.get(i).getTeam2();
			object[3]=  matches.get(i).getMap();
			object[4]=  matches.get(i).getResultT1();
			object[5]=  matches.get(i).getResultT2();
			object[6]=  matches.get(i).getWinner();
			object[7]=  matches.get(i).getStartingCT();
			object[8]=  matches.get(i).getCTRoundsT1();
			object[9]=  matches.get(i).getTRoundsT2();
			object[10]= matches.get(i).getTRoundsT1();
			object[11]= matches.get(i).getCTRoundsT2();
			object[12]= matches.get(i).getEventID();
			object[13]= matches.get(i).getMatchID();
			object[14]= matches.get(i).getRankT1();
			object[15]= matches.get(i).getRankT2();
			if (min = Integer.parseInt()) {
				temp = item.getRankT1();
				min = Integer.parseInt(temp);
				
			}
			}
		}
				
				
		return Order;
	}

}


//item.getRankT1().equals(min)