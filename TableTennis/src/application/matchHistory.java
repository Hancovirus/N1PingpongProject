package application;

public class matchHistory {
	private int gamePlayed;
	private String opponent;
	private int win;
	private int lose;
	private int different;
	
	public matchHistory(String opponent, int gamePlayed, int win, int lose, int different) {
		this.opponent = opponent;
		this.gamePlayed = gamePlayed;
		this.win = win;
		this.lose = lose;
		this.different = different;
	}
	
	public matchHistory(String opponent) {
		this.opponent = opponent;
		this.gamePlayed = 0;
		this.win = 0;
		this.lose = 0;
		this.different = 0;
	}
	
	public void setGamePlayed(int gamePlayed) {
		this.gamePlayed = gamePlayed;
	}
	
	public int getGamePlayed() {
		return gamePlayed;
	}
	
	public void setopponent(String opponent) {
		this.opponent = opponent;
	}
	
	public String getopponent() {
		return opponent;
	}
	
	public void setwin(int win) {
		this.win = win;
	}
	
	public int getwin() {
		return win;
	}
	
	public void setlose(int lose) {
		this.lose = lose;
	}
	
	public int getlose() {
		return lose;
	}
	
	public void setdifferent(int different) {
		this.different = different;
	}
	
	public int getdifferent() {
		return different;
	}
	
	public double getWinrate() {
		if (gamePlayed == 0) {
			return 0;
		}
		double temp = Double.valueOf(win) * 100;
		return temp/gamePlayed;
	}
	
	public String getInfo() {
		String ans = "";
		ans += "Opponent: " + opponent + "\n";
		ans += "Matches played: " + gamePlayed + "\n";
		ans += "Win: " + win + "\n";
		ans += "Lose: " + lose + "\n";
		ans += "PD: " + different + "\n";
		ans += "Winrate: " + String.format("%.2f", getWinrate());
		return ans;
	}
}
