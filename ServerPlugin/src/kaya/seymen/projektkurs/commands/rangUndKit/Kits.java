package kaya.seymen.projektkurs.commands.rangUndKit;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Kits implements CommandExecutor{

	ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
	ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
	ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
	ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
	
	ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
	ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
	ItemStack shovel = new ItemStack(Material.DIAMOND_SHOVEL);
	ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
	
	ItemStack[] diamondKitListe = {sword,pickaxe,shovel,axe,new ItemStack(Material.COOKED_BEEF, 64)};
	
	
	ItemStack[] vipPlusKitListe = {new ItemStack(Material.DIAMOND_SWORD, 1), new ItemStack(Material.DIAMOND_PICKAXE, 1), new ItemStack(Material.DIAMOND_AXE, 1), 
			new ItemStack(Material.DIAMOND_SHOVEL, 1), new ItemStack(Material.COOKED_BEEF, 64)};
	
	ItemStack[] vipKitListe = {new ItemStack(Material.DIAMOND_SWORD, 1), new ItemStack(Material.DIAMOND_PICKAXE, 1), new ItemStack(Material.IRON_AXE, 1), 
			new ItemStack(Material.IRON_SHOVEL, 1), new ItemStack(Material.COOKED_BEEF, 32)};
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			
			if(player.hasPermission("tutorial.kit"))
			{
				if(args.length == 1)
				{
					if(args[0].equalsIgnoreCase("diamond"))
					{
						if(player.getPlayerListName().contains("[DIAMOND]") || player.getPlayerListName().contains("[OWNER]"))
						{
							helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
							chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
							leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
							boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
							
							helmet.addEnchantment(Enchantment.DURABILITY, 3);
							chestplate.addEnchantment(Enchantment.DURABILITY, 3);
							leggings.addEnchantment(Enchantment.DURABILITY, 3);
							boots.addEnchantment(Enchantment.DURABILITY, 3);
							
							sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
							sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
							sword.addEnchantment(Enchantment.LOOT_BONUS_MOBS, 3);
							sword.addEnchantment(Enchantment.DURABILITY, 3);
							
							pickaxe.addEnchantment(Enchantment.DIG_SPEED, 5);
							shovel.addEnchantment(Enchantment.DIG_SPEED, 5);
							axe.addEnchantment(Enchantment.DIG_SPEED, 5);
							
							pickaxe.addEnchantment(Enchantment.DURABILITY, 3);
							shovel.addEnchantment(Enchantment.DURABILITY, 3);
							axe.addEnchantment(Enchantment.DURABILITY, 3);
							
							pickaxe.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);
							
							player.getInventory().addItem(diamondKitListe);
							player.getInventory().setHelmet(helmet);
							player.getInventory().setChestplate(chestplate);
							player.getInventory().setLeggings(leggings);
							player.getInventory().setBoots(boots);
							
							player.sendMessage("Dir wurde das Diamond Kit zugewiesen!");
						}
						
					}
					else if(args[0].equalsIgnoreCase("vip+"))
					{
						if(player.getPlayerListName().contains("[VIP+]") || player.getPlayerListName().contains("[OWNER]"))
						{
							player.getInventory().addItem(vipPlusKitListe);
							player.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
							player.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
							player.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
							player.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
							player.sendMessage("Dir wurde das VIP+ Kit zugewiesen!");
						}
						
					}
					else if(args[0].equalsIgnoreCase("vip"))
					{
						if(player.getPlayerListName().contains("[VIP]") || player.getPlayerListName().contains("[OWNER]"))
						{
							player.getInventory().addItem(vipKitListe);
							player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
							player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
							player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
							player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
							player.sendMessage("Dir wurde das VIP Kit zugewiesen!");
						}
						
					}
					else
					{
						player.sendMessage("Dieses Kit gibt es nicht!");
					}
				}
				
				else
				{
					player.sendMessage(ChatColor.YELLOW + "Bitte benutze /kit <RANG>");
				}
			}
			else
			{
				player.sendMessage(ChatColor.RED + "Dazu hast du keine Rechte!");
			}
		}
		else
		{
			sender.sendMessage("Dieses Kommando darfst du nicht benutzen!");
		}
		
		return false;
		
	}
	

	

}
