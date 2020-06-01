package pAssignment1Dhugald;

import java.time.LocalDate;
/**
 * <Header><h1>Games class</h1></header>
 * 
 * @author Dhugald Spry
 *
 *
 *
 */
public class Games implements Comparable<Games>{
	private String date;
	private String team1;
	private String team2;
	private String map;
	private String resultT1;
	private String resultT2;
	private String winner;
	private String startingCT;
	private String cTRoundsT1;
	private String tRoundsT2;
	private String tRoundsT1;
	private String cTRoundsT2;
	private String eventID;
	private String matchID;
	private String rankT1;
	private String rankT2;
	
	public Games(String date, String team1, String team2, String map, String resultT1, String resultT2, String winner, String startingCT, String cTRoundsT1, String tRoundsT2, String tRoundsT1, String cTRoundsT2, String eventID, String matchID, String rankT1, String rankT2) {
		this.date = date;
		this.team1 = team1;
		this.team2 = team2;
		this.map = map;
		this.resultT1 = resultT1;
		this.resultT2 = resultT2;
		this.winner = winner;
		this.startingCT= startingCT;
		this.cTRoundsT1 = cTRoundsT1;
		this.tRoundsT2 = tRoundsT2;
		this.tRoundsT1= tRoundsT1;
		this.cTRoundsT2 = cTRoundsT2;
		this.eventID = eventID;
		this.matchID = matchID;
		this.rankT1 = rankT1;
		this.rankT2 = rankT2;
	}
	
	public void setDate(String date)				{this.date = date;}
	public void setTeam1(String team1)				{this.team1 = team1;}
	public void setTeam2(String team2)				{this.team2 = team2;}
	public void setMap(String map)					{this.map = map;}
	public void setResultT1(String resultT1)		{this.resultT1=resultT1;}
	public void setResultT2(String resultT2)		{this.resultT2 = resultT2;}
	public void setWinner(String winner) 			{this.winner = winner;}
	public void setStartingCT(String startingCT)	{this.startingCT = startingCT;}
	public void setCTRoundsT1(String cTRoundsT1)	{this.cTRoundsT1 = cTRoundsT1;}
	public void setTRoundsT2(String tRoundsT2)		{this.tRoundsT2 = tRoundsT2;}
	public void setTRoundsT1(String tRoundsT1)		{this.tRoundsT1 = tRoundsT1;}
	public void setCTRoundsT2(String cTRoundsT2)	{this.cTRoundsT2 = cTRoundsT2;}
	public void setEventID(String eventID)			{this.eventID = eventID;}
	public void setMatchID(String matchID)			{this.matchID = matchID;}
	public void setRankT1(String rankT1)			{this.rankT1 = rankT1;}
	public void setRankT2(String rankT2)			{this.rankT2 = rankT2;}

	
	
	public String getDate() 	 {return date;}
	public String getTeam1()	 {return team1;}
	public String getTeam2()	 {return team2;}
	public String getMap()		 {return map;}
	public String getResultT1()	 {return resultT1;}
	public String getResultT2()	 {return resultT2;}
	public String getWinner()	 {return winner;}
	public String getStartingCT(){return startingCT;}
	public String getCTRoundsT1(){return cTRoundsT1;}
	public String getTRoundsT2() {return tRoundsT2;}
	public String getTRoundsT1() {return tRoundsT1;}
	public String getCTRoundsT2(){return cTRoundsT2;}
	public String getEventID()	 {return eventID;}
	public String getMatchID()	 {return matchID;}
	public String getRankT1()	 {return rankT1;}
	public String getRankT2()	 {return rankT2;}
	
	
	@Override
	public int compareTo(Games game1) {
		return team1.compareTo(game1.getTeam1());
	}
}
