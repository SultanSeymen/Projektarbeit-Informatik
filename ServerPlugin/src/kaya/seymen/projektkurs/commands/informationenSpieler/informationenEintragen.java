package kaya.seymen.projektkurs.commands.informationenSpieler;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import kaya.seymen.projektkurs.mysql.MySQL;

public class informationenEintragen implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			
			if(player.hasPermission("tutorial.informationeneintragen"))
			{
				try {
					Connection con = MySQL.getConnection();
					PreparedStatement statement = con.prepareStatement("Update informationenDatenbank set vorname = '" + args[0] + "', alterSpieler = '" + args[1] + "'"
							+ ", wohnort = '" + args[2] + "' Where ingameName = '" + player.getName() + "'");
					player.sendMessage("§6Deine Informationen wurden in der Datenbank aktualisiert. Dein Name lautet §2'" + args[0] + "'§6. Du bist §2'" + args[1] + "'§6 Jahre alt und du wohnst in §2'" + args[2] + "'§6.");
					statement.executeUpdate();
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
