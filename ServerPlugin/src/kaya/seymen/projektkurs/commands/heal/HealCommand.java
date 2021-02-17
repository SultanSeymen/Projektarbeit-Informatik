package kaya.seymen.projektkurs.commands.heal;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor 
{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) //args ist alles was hinter dem /.. ist
	{
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			
			if(player.hasPermission("tutorial.heal"))
			{
				if(args.length == 0) //damit nichts anderes als /heal angegeben wird
				{
					player.setHealth(20);
					player.setFoodLevel(20);
					player.sendMessage("§aDu wurdest geheilt!");
				}
				else if(args.length == 1) //damit wird abgefragt ob nach dem /heal noch ein Wort kommt
				{
					Player target = Bukkit.getPlayer(args[0]);
					
					if(target != null) //prüft ob der Spieler online ist
					{
						target.setHealth(20);
						target.setFoodLevel(20);
						target.sendMessage("Du wurdest geheilt");
						player.sendMessage("Du hast den Spieler " + target.getName() + " geheilt.");
					}
					
					else
					{
						player.sendMessage("Der Spieler " + args[0] + " ist nicht auf dem Server.");
					}
				}
				else
				{
					player.sendMessage(ChatColor.YELLOW + "Bitte benutze /heal <SPIELER>");
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
