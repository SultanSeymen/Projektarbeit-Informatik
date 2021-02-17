package kaya.seymen.projektkurs.commands.party;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import kaya.seymen.projektkurs.main.Main;

public class PartyCommand implements CommandExecutor
{

	private int taskID;
	
	public boolean onCommand(CommandSender sender, Command command, String lable, String[] args) 
	{
		if(sender instanceof Player)
		{	
			taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
			int countdown = 5;
				
				@Override
				public void run() 
				{

					if(countdown <= 0)
					{
						Bukkit.broadcastMessage("§6§lDIE PARTY BEGINNT!");
						Bukkit.getScheduler().cancelTask(taskID);
						return;
					}
					Bukkit.broadcastMessage("§7Die Party startet in §6" + countdown + " Sekunden§7.");
					countdown--;
					
				}
			}, 0, 20);
		}
		
		
		return false;
	}

}
