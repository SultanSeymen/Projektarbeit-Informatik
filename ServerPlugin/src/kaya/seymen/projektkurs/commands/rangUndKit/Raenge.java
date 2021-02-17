package kaya.seymen.projektkurs.commands.rangUndKit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import kaya.seymen.projektkurs.mysql.MySQL;

public class Raenge implements CommandExecutor{

	String rang;
	String name;
	
	Date dt = new Date();
	SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.S" );
	String datum = ""+ df.format(dt) +"";
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			
			Player target = Bukkit.getPlayer(args[1]);
			
			if(player.hasPermission("tutorial.rang"))
			{
				String rang = args[0];
				
				if(args.length == 2)
				{
					if(rang.equalsIgnoreCase("owner"))
					{
						String name = target.getName();

						target.setPlayerListName("§c§l[OWNER] §2" + name);
						target.setDisplayName("§c§l[OWNER] §2" + name + "§f");
						
						try
						{
							Connection con = MySQL.getConnection();
							PreparedStatement posted = con.prepareStatement("INSERT INTO benutzer (rang, benutzername,datum) VALUES ('" + rang + "','"+ name + "','"+ datum + "')");
							posted.executeUpdate();
							player.sendMessage("§3Der Spieler '" + args[1] + "' hat den Rang '" + rang + "' bekommen.");
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
						finally
						{
							System.out.println("Insert Completed.");
						}
					}
					else if(rang.equalsIgnoreCase("diamond"))
					{
						String name = target.getName();

						target.setPlayerListName("§b§l[DIAMOND] §2" + name);
						target.setDisplayName("§b§l[DIAMOND] §2" + name + "§f");
						
						try
						{
							Connection con = MySQL.getConnection();
							PreparedStatement posted = con.prepareStatement("INSERT INTO benutzer (rang, benutzername,datum) VALUES ('" + rang + "','"+ name + "','"+ datum + "')");
							posted.executeUpdate();
							player.sendMessage("§3Der Spieler '" + args[1] + "' hat den Rang '" + rang + "' bekommen.");
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
						finally
						{
							System.out.println("Insert Completed.");
						}
					}
					else if(rang.equalsIgnoreCase("vip+"))
					{
						String name = target.getName();

						target.setPlayerListName("§6§l[VIP+] §2" + name);
						target.setDisplayName("§6§l[VIP+] §2" + name + "§f");
						
						try
						{
							Connection con = MySQL.getConnection();
							PreparedStatement posted = con.prepareStatement("INSERT INTO benutzer (rang, benutzername,datum) VALUES ('" + rang + "','"+ name + "','"+ datum + "')");
							posted.executeUpdate();
							player.sendMessage("§3Der Spieler '" + args[1] + "' hat den Rang '" + rang + "' bekommen.");
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
						finally
						{
							System.out.println("Insert Completed.");
						}
					}
					else if(rang.equalsIgnoreCase("vip"))
					{
						String name = target.getName();

						target.setPlayerListName("§5§l[VIP] §2" + name);
						target.setDisplayName("§5§l[VIP] §2" + name + "§f");
						
						try
						{
							Connection con = MySQL.getConnection();
							PreparedStatement posted = con.prepareStatement("INSERT INTO benutzer (rang, benutzername,datum) VALUES ('" + rang + "','"+ name + "','"+ datum + "')");
							posted.executeUpdate();
							player.sendMessage("§3Der Spieler '" + args[1] + "' hat den Rang '" + rang + "' bekommen.");
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
						finally
						{
							System.out.println("Insert Completed.");
						}
					}
					else
					{
						target.sendMessage(ChatColor.YELLOW + "Diesen Rang gibt es nicht.");
						
					}
				}
				else
				{
					target.sendMessage(ChatColor.YELLOW + "Bitte benutze /rang <RANG> <SPIELER>");
				}
			}
			
			else
			{
				target.sendMessage(ChatColor.RED + "Dazu hast du keine Rechte!");
			}
		}
		
		else
		{
			sender.sendMessage("Dieses Kommando darfst du nicht benutzen!");
		}
		
		return false;
	}

}
