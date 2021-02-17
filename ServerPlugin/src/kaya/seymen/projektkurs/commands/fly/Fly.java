package kaya.seymen.projektkurs.commands.fly;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			
			if(player.hasPermission("tutorial.fly"))
			{
				if(args.length == 0)
				{
					
					if(player.isFlying() == false)
					{
					player.setAllowFlight(true);
					player.sendMessage("§aNun kannst du fliegen!");
					}
					else
					{
						player.setAllowFlight(false);
						player.sendMessage("§aNun kannst du nicht mehr fliegen");
					}
				}
				else if(args.length == 1)
				{
					Player target = Bukkit.getPlayer(args[0]);
					
					if(target != null)
					{

						if(target.isFlying() == false)
						{
						target.setAllowFlight(true);
						target.sendMessage("§aNun kannst du fliegen!");
						player.sendMessage(args[0] + " §akann nun fliegen!");
						}
						else if(target.isFlying() == true)
						{
							target.setAllowFlight(false);
							target.sendMessage("§aNun kannst du nicht mehr fliegen");
							player.sendMessage(args[0] + " §akann nun nicht mehr fliegen!");
						}
					}
					
					else
					{
						player.sendMessage("Der Spieler " + args[0] + " ist nicht Online.");
					}
				}
				else
				{
					player.sendMessage(ChatColor.YELLOW + "Bitte benutze /fly <SPIELER>");
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
