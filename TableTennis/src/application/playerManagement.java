package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class playerManagement {
	private static ArrayList<player> playerList = new ArrayList<>();
	private static ArrayList<String> playerNameList = new ArrayList<>();
	
	public void loadFromFile() {
		try {
			int i=0;
        	BufferedReader reader = new BufferedReader(new FileReader("playerList.txt"));
            String line;
            line = reader.readLine();
            String inputLine = line;
            String[] parts = inputLine.split("\t",7);
          	String name = parts[0];
          	name = name.substring(1, name.length());
            String nickName = parts[1];
            int win = Integer.parseInt(parts[2]);
            int lose = Integer.parseInt(parts[3]);
            int pd = Integer.parseInt(parts[4]);
            int gamePlayed = Integer.parseInt(parts[5]);
            int opponentRatingTotal = Integer.parseInt(parts[6]);
            player New_player = new player(gamePlayed, win, lose, pd, name, nickName, opponentRatingTotal);
            playerList.add(New_player);
            playerNameList.add(name);
            while ((line = reader.readLine()) != null) {
            	if (Character.toString(line.charAt(0)).equals("|")) {
            		i++;
	                inputLine = line;
	                parts = inputLine.split("\t",7);
	              	name = parts[0];
	              	name = name.substring(1, name.length());
	                nickName = parts[1];
	                win = Integer.parseInt(parts[2]);
	                lose = Integer.parseInt(parts[3]);
	                pd = Integer.parseInt(parts[4]);
	                gamePlayed = Integer.parseInt(parts[5]);
	                opponentRatingTotal = Integer.parseInt(parts[6]);
	                New_player = new player(gamePlayed, win, lose, pd, name, nickName, opponentRatingTotal);
	                playerList.add(New_player);
	                playerNameList.add(name);
            	} else {
            		inputLine = line;
	                parts = inputLine.split("\t",5);
	              	name = parts[0];
	                win = Integer.parseInt(parts[1]);
	                lose = Integer.parseInt(parts[2]);
	                pd = Integer.parseInt(parts[3]);
	                gamePlayed = Integer.parseInt(parts[4]);
	                matchHistory New_matchHistory = new matchHistory(name, gamePlayed, win, lose, pd);
	                playerList.get(i).addMatchHistory(New_matchHistory);
            	}
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void ExportToFile()
    {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("playerList.txt"));
            for (player p : playerList) {
                writer.write("|" + p.getName() + "\t" + p.getNickName() + "\t" 
                		+ p.getWin() + "\t" + p.getLose() + "\t" + p.getPd() + "\t" 
                		+ p.getGamePlayed() + "\t" + p.getOpponentRatingTotal() + "\n");
                for (matchHistory m : p.getmatchHistoryList()) {
                	writer.write(m.getopponent() + "\t" + m.getwin() + "\t" + m.getlose() + "\t"
                	+ m.getdifferent() + "\t" + m.getGamePlayed() + "\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void addPlayer(String name, String nickName) {
		player New_player = new player(name, nickName);
		for (player p : playerList) {
			String opponent = p.getName();
			matchHistory New_matchHistory = new matchHistory(opponent);
			New_player.addMatchHistory(New_matchHistory);
			New_matchHistory = new matchHistory(name);
			p.addMatchHistory(New_matchHistory);
		}
		playerList.add(New_player);
        playerNameList.add(name);
	}
	
	public void deletePlayer(String name) {  
        for(int i = playerList.size() - 1; i >= 0; --i) 
        {
        	if(playerList.get(i).getName().equals(name))
            {
        		playerList.remove(i);
                playerNameList.remove(i);
                for (player p : playerList) {
                	for(int j = p.getmatchHistoryList().size() - 1; j >= 0; --j) 
                    {
                    	if(p.getmatchHistoryList().get(j).getopponent().equals(name))
                        {
                    		matchHistory opponent = p.getmatchHistoryList().get(j);
                    		p.setGamePlayed(p.getGamePlayed() - opponent.getGamePlayed());
                    		p.setWin(p.getWin() - opponent.getwin());
                    		p.setLose(p.getLose() - opponent.getlose());
                    		p.setPd(p.getPd() - opponent.getdifferent());
                    		p.getmatchHistoryList().remove(j);
                        }
                    }
        		}
                System.out.println("Delete " + name + " succesfully");
                return;
            }
        }
	}
	
	public ArrayList<String> getplayerNameList() {
		return playerNameList;
	}
	
	public ArrayList<player> getplayerList() {
		return playerList;
	}
	
	public String playerLookUp(String name) {
		for(int i = playerList.size() - 1; i >= 0; --i) 
        {
        	if(playerList.get(i).getName().equals(name))
            {
                System.out.println("Find " + name + " succesfully");
                return playerList.get(i).getInfo();
            }
        }
		return "";
	}
}


