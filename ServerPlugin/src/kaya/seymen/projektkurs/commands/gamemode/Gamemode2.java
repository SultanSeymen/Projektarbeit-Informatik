package kaya.seymen.projektkurs.commands.gamemode;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode2 implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			
			if(player.hasPermission("tutorial.gm2"))
			{
				if(args.length == 0)
				{
					player.setGameMode(GameMode.ADVENTURE);
					player.sendMessage("Du wurdest in den Gamemode 2 gesetzt.");
					
					//setze ihn auf gm2
				}
				else if(args.length == 1)
				{
					Player target = Bukkit.getPlayer(args[0]);
					
					if(target != null)
					{
						target.setGameMode(GameMode.ADVENTURE); //setze target auf gm2
						target.sendMessage("Du wurdest in den Gamemode 2 gesetzt.");
					}
					
					else
					{
						player.sendMessage("Der Spieler" + args[0] + " ist nicht Online.");
					}
				}
				else
				{
					player.sendMessage(ChatColor.YELLOW + "Bitte benutze /gm2 <SPIELER>");
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
