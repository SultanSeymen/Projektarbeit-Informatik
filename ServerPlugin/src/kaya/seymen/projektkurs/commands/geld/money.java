package kaya.seymen.projektkurs.commands.geld;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import kaya.seymen.projektkurs.mysql.MySQL;

public class money implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			
			if(player.hasPermission("tutorial.money"))
			{
				try {
					Connection con = MySQL.getConnection();
					PreparedStatement statement = con.prepareStatement("Select geld From geldDatenbank Where spieler = '" + player.getName() + "'");
					ResultSet result = statement.executeQuery();
					
					if(result.next() == true)
					{
						player.sendMessage("§6Du hast §2" + result.getInt("geld") + "€ §6auf der Bank.");
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}	
			else
			{
				player.sendMessage(ChatColor.YELLOW + "Bitte benutze /givemoney <Spieler> <Betrag>");
			}
		}
		else
		{
			sender.sendMessage("Dieses Kommando darfst du nicht benutzen!");
		}
		return false;
	
	}

	
}
