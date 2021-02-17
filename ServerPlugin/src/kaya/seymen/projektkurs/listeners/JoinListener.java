package kaya.seymen.projektkurs.listeners;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import kaya.seymen.projektkurs.mysql.MySQL;

public class JoinListener implements Listener 
{

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) throws Exception
	{
		//Server Meldung betreten
		Player player = event.getPlayer();
		event.setJoinMessage("§aDer Spieler §6" + player.getPlayer().getName() + "§a hat den Server betreten.");
		
		//Scoreboard
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		@SuppressWarnings("deprecation")
		Objective objective = board.registerNewObjective("abcd", "abcd");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName("§6§lWilkommen!");
		objective.getScore(" ").setScore(3);
		objective.getScore("§aHallo " + player.getName()+ "§a!").setScore(2);
		objective.getScore("§aViel Spaß auf dem Server!").setScore(1);
		player.setScoreboard(board);
		
		
		//Rang Aktualisierung
		String spielerName = event.getPlayer().getName();
		
		Connection con = MySQL.getConnection();
		PreparedStatement statement = con.prepareStatement("Select rang From benutzer Where benutzername = '" + spielerName + "';");
		ResultSet result = statement.executeQuery();
		
		if(result.next() == true)
		{
			if(result.getString("rang").equalsIgnoreCase("owner"))
			{
				player = event.getPlayer();
				player.setPlayerListName("§c§l[OWNER] §2" + spielerName);
				player.setDisplayName("§c§l[OWNER] §2" + spielerName + "§f");
			}
			else if(result.getString("rang").equalsIgnoreCase("diamond"))
			{
				player = event.getPlayer();
				player.setPlayerListName("§b§l[DIAMOND] §2" + spielerName);
				player.setDisplayName("§b§l[DIAMOND] §2" + spielerName + "§f");
			}
			else if(result.getString("rang").equalsIgnoreCase("vip+"))
			{
				player = event.getPlayer();
				player.setPlayerListName("§6§l[VIP+] §2" + spielerName);
				player.setDisplayName("§6§l[VIP+] §2" + spielerName + "§f");
			}
			else if(result.getString("rang").equalsIgnoreCase("vip"))
			{
				player = event.getPlayer();
				player.setPlayerListName("§6§l[VIP] §2" + spielerName);
				player.setDisplayName("§6§l[VIP] §2" + spielerName + "§f");
			}
		}
		else
		{
			player = event.getPlayer();
			player.setPlayerListName("§3§l[SPIELER] §2" + spielerName);
			player.setDisplayName("§3§l[SPIELER] §2" + spielerName + "§f");
		}
		
		//Einpflegung der Person in die geldDatenebank
		PreparedStatement prüfeObSpielerInGeldDatenbank = con.prepareStatement("Select spieler From geldDatenbank Where spieler = '" + spielerName + "';");
		ResultSet result2 = prüfeObSpielerInGeldDatenbank.executeQuery();
		
		if(result2.next() == false)
		{
			PreparedStatement statement2 = con.prepareStatement("Insert Into geldDatenbank (spieler, geld, verschenktesGeld) Values ('"+spielerName+"', '1000', '0');");
			statement2.executeUpdate();
		}
		
		//Einpflegung in die Informationen Datenbank und Abfrage ob der Spieler bereits die Informationen eingegeben hat
		PreparedStatement prüfeObSpielerInInformationenDatenbank = con.prepareStatement("Select ingameName From informationenDatenbank Where ingameName = '" + spielerName + "';");
		ResultSet result3 = prüfeObSpielerInInformationenDatenbank.executeQuery();
		
		if(result3.next() == false)
		{
			PreparedStatement statement2 = con.prepareStatement("Insert Into informationenDatenbank (ingameName, vorname, alterSpieler, wohnort) Values ('"+spielerName+"', '0', '0', '0' );");
			statement2.executeUpdate();
		}
		
		
	}
	
	
	
	
}
