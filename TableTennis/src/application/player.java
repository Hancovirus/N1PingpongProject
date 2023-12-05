package application;

import java.util.ArrayList;

public class player {
	private String name;
	private String nickName;
	private int gamePlayed;
	private ArrayList<matchHistory> matchHistoryList;
	private int win;
	private int lose;
	private int pd;
	private int opponentRatingTotal;
	
	public player(int gamePlayed ,int win, int lose, int pd, String name, String nickName, int opponentRatingTotal) {
		this.win = win;
		this.lose = lose;
		this.pd = pd;
		this.gamePlayed = gamePlayed;
		this.name = name;
		this.nickName = nickName;
		this.opponentRatingTotal = opponentRatingTotal;
		matchHistoryList = new ArrayList<>();
	}
	
	public player(String name, String nickName) {
		this.win = 0;
		this.lose = 0;
		this.pd = 0;
		this.gamePlayed = 0;
		this.name = name;
		this.nickName = nickName;
		this.opponentRatingTotal = 0;
		matchHistoryList = new ArrayList<>();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getNickName() {
		return nickName;
	}
	
	public void setGamePlayed(int gamePlayed) {
		this.gamePlayed = gamePlayed;
	}
	
	public int getGamePlayed() {
		return gamePlayed;
	}
	
	public ArrayList<matchHistory> getmatchHistoryList() {
		return matchHistoryList;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public int getPd() {
		return pd;
	}

	public void setPd(int pd) {
		this.pd = pd;
	}
	
	public double getWinrate() {
		if (gamePlayed == 0) {
			return 0;
		}
		double temp = Double.valueOf(win) * 100;
		return temp/gamePlayed;
	}
	
	public void addMatchHistory(matchHistory m) {
		matchHistoryList.add(m);
	}
	
	public String matchHistoryLookUp(String opponent) {
		for(int i = matchHistoryList.size() - 1; i >= 0; --i) 
        {
        	if(matchHistoryList.get(i).getopponent().equals(opponent))
            {
                return matchHistoryList.get(i).getInfo();
            }
        }
		return "";
	}
	
	public String getInfo() {
		String ans = "";
		ans += "Name: " + name + "\n";
		ans += "NickName: " + nickName + "\n";
		ans += "Matches played: " + gamePlayed + "\n";
		ans += "Win: " + win + "\n";
		ans += "Lose: " + lose + "\n";
		ans += "PD: " + pd + "\n";
		ans += "Winrate: " + String.format("%.2f", getWinrate()) + "\n";
		ans += "Elo: " + getElo();
		return ans;
	}

	public int getElo() {
		if (gamePlayed == 0) {
			return 400;
		}
		int ans = 400 * (win - lose);
		ans += opponentRatingTotal;
		ans /= gamePlayed;
		return ans;
	}

	public int getOpponentRatingTotal() {
		return opponentRatingTotal;
	}

	public void setOpponentRatingTotal(int opponentRatingTotal) {
		this.opponentRatingTotal = opponentRatingTotal;
	}

}
