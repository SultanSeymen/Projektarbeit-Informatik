package kaya.seymen.projektkurs.commands.gamemode;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode3 implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			
			if(player.hasPermission("tutorial.gm3"))
			{
				if(args.length == 0)
				{
					player.setGameMode(GameMode.SPECTATOR);
					player.sendMessage("Du wurdest in den Gamemode 3 gesetzt.");
					
					//setze ihn auf gm3
				}
				else if(args.length == 1)
				{
					Player target = Bukkit.getPlayer(args[0]);
					
					if(target != null)
					{
						target.setGameMode(GameMode.SPECTATOR); //setze target auf gm3
						target.sendMessage("Du wurdest in den Gamemode 3 gesetzt.");
					}
					
					else
					{
						player.sendMessage("Der Spieler" + args[0] + " ist nicht Online.");
					}
				}
				else
				{
					player.sendMessage(ChatColor.YELLOW + "Bitte benutze /gm3 <SPIELER>");
				}
			}
			
			else
			{
				player.sendMessage(ChatColor.RED + "Dazu hast du keine Rechte!");
			}
		}
		
		else
		{
			sender.sendMessage("Dieses Kommando darfst du nur als Spieler benutzen!");
		}
		
		
		return false;
	}

	
	
}
