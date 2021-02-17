package kaya.seymen.projektkurs.commands.informationenSpieler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import kaya.seymen.projektkurs.mysql.MySQL;

public class info implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			
			if(player.hasPermission("tutorial.info"))
			{
				try {
					Connection con = MySQL.getConnection();
					PreparedStatement statement = con.prepareStatement("Select * From informationenDatenbank where ingameName = '" + args[0] + "'");
					ResultSet result = statement.executeQuery();
					if(result.next() == true)
					{
						int id = result.getInt("id");
						String ingameName = result.getString("ingameName");
						String vorname = result.getString("vorname");
						int alterSpieler = result.getInt("alterSpieler");
						String wohnort = result.getString("wohnort");
						player.sendMessage("§6Der Spieler §2" + ingameName + "§6 hat die ID §2" + id + "§6. Der Name von §2" + ingameName + "§6 lautet §2" + vorname + "§6 und §2"
						+ vorname + "§6 ist §2" + alterSpieler + "§6 Jahre alt. §2" + vorname + "§6 kommt aus §2" + wohnort + "§6.");	
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
			else
			{
				player.sendMessage(ChatColor.YELLOW + "Bitte benutze /informationenEintragen <Vorname> <Alter> <Wohnort>");
			}
		}
		else
		{
			sender.sendMessage("Dieses Kommando darfst du nicht benutzen!");
		}
		return false;
	}
}
