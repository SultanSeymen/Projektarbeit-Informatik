package kaya.seymen.projektkurs.commands.notiz;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kaya.seymen.projektkurs.mysql.MySQL;

public class Notiz implements CommandExecutor
{
	String name, öffentlichkeit, notizName, notiz;
	
	// args 0 öffentlichkeit
	// args 1 notizName
	// args 2 notiz

	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{	
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			
			name = player.getName();
			
			if(player.hasPermission("tutorial.notiz"))
			{

				if(args.length > 2 || args.length < 2)
				{
					player.sendMessage("§6Bitte gebe den Kommand /notiz <Öffentlichkeit> <Notizname> <Notiz> ein!");
				}

				
				if(args[1] != null)
				{
					notizName = args[1];
				}
				else
				{
					player.sendMessage("§6Bitte gebe den Kommand /notiz <Öffentlichkeit> <Notizname> <Notiz> ein!");
				}

				
				if(args[2] != null)
				{
					notiz = args[2];
				}
				else
				{
					player.sendMessage("§6Bitte gebe den Kommand /notiz <Öffentlichkeit> <Notizname> <Notiz> ein!");
				}
				
				
				if(args[0].equalsIgnoreCase("public"))
				{
					öffentlichkeit = "public";
					try {
						Connection connection;
						connection = MySQL.getConnection();
						PreparedStatement statement = connection.prepareStatement("Insert into notiz values ('"+ name +"' '"+ öffentlichkeit + "' '"+ notizName +"' '"+ notiz + "';");
						player.sendMessage(name + öffentlichkeit + notizName + notiz);
						name = "";
						öffentlichkeit = "";
						notizName = "";
						notiz = "";
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if (args[0].equalsIgnoreCase("private"))
				{
					öffentlichkeit = "private";
					try {
						Connection connection;
						connection = MySQL.getConnection();
						PreparedStatement statement = connection.prepareStatement("INSERT INTO notiz (spielerName, öffentlichkeit, notizName, notiz) VALUES ('"+ name +"' '"+ öffentlichkeit + "' '"+ notizName +"' '"+ notiz + "';");
						player.sendMessage(name + öffentlichkeit + notizName + notiz);
						name = "";
						öffentlichkeit = "";
						notizName = "";
						notiz = "";
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
					player.sendMessage("§6Bitte gebe den Kommand /notiz <Öffentlichkeit> <Notizname> <Notiz> ein!");
				}
			
			}
		
		}
		return false;
	}
}