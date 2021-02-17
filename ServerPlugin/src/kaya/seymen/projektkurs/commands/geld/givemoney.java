package kaya.seymen.projektkurs.commands.geld;

import java.sql.Connection;
import java.sql.Statement;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import kaya.seymen.projektkurs.mysql.MySQL;

public class givemoney implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			
			if(player.hasPermission("tutorial.givemoney"))
			{
				try 
				{
					Connection con = MySQL.getConnection();
					Statement s = con.createStatement();
					String verschenktesGeld = args[1];
					String spielerDerDasGeldBekommt = args[0];
					if(!player.getName().equals(spielerDerDasGeldBekommt))
					{
						String s1 = "Update geldDatenbank SET geld = geld - '"+ verschenktesGeld + "' Where spieler = '" + player.getName() + "';";
						String s2 = "Update geldDatenbank SET geld = geld + '"+ verschenktesGeld + "' Where spieler = '" + spielerDerDasGeldBekommt + "';";
						String s3 = "Update geldDatenbank SET verschenktesGeld = verschenktesGeld + '" + verschenktesGeld + "' Where spieler = '" + player.getName() + "';";
						s.addBatch(s1);
						s.addBatch(s2);
						s.addBatch(s3);
						s.executeBatch();
						player.sendMessage("§6Dem Spieler §2" + args[0] + "§6 wurden §2" + args[1] + "€ §6überwiesen.");
					}
					else
					{
						player.sendMessage("§5Du darfst dir kein Geld schenken.");
					}

				} catch (Exception e) 
				{
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
