package pAssignment1Dhugald;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * <header><h1>Reader class</h1></header>
 * @author Dhugald Spry
 *
 *<p>This is the class that reads the CSV file into a list
 */
public class BaseReader {

	/**
	 * 
	 * @param matches
	 */
	public static void load(ArrayList<Games> matches)
	{
	String date;
	String team1;
	String team2;
	String map;
	String resultT1;
	String resultT2;
	String winner;
	String startingCT;
	String cTRoundsT1;
	String tRoundsT2;
	String tRoundsT1;
	String cTRoundsT2;
	String eventID;
	String matchID;
	String rankT1;
	String rankT2;
	String line;
	try {
		BufferedReader in = new BufferedReader(new FileReader("Last100CSGO_Matches.csv"));
		while ((line = in.readLine()) !=null) {
			String[] fields = line.split(",");
			date= fields[0];
			team1= fields[1];
			team2= fields[2];
			map= fields[3];
			resultT1= fields[4];
			resultT2= fields[5];
			winner= fields[6];
			startingCT= fields[7];
			cTRoundsT1= fields[8];
			tRoundsT2= fields[9];
			tRoundsT1= fields[10];
			cTRoundsT2= fields[11];
			eventID= fields[12];
			matchID= fields[13];
			rankT1= fields[14];
			rankT2= fields[15];
			matches.add(new Games(date, team1, team2, map, resultT1, resultT2, winner, startingCT, cTRoundsT1, tRoundsT2, tRoundsT1, cTRoundsT2, eventID, matchID, rankT1, rankT2));
		}
	}catch(IOException ex){
        System.out.println (ex.toString());
        System.out.println("Could not find file");
	}
	}
}
