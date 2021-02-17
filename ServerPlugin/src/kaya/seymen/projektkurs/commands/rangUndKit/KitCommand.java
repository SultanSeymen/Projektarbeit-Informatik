package kaya.seymen.projektkurs.commands.rangUndKit;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitCommand implements CommandExecutor 
{
	
	ItemStack heiligerBogen = new ItemStack(Material.BOW);

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			if(player.hasPermission("tutorial.truhe"))
			{
				if(args.length == 0)
				{
					Inventory inventory = Bukkit.createInventory(null, 9*3, "§6§lKit-Inventar");
					
					
					ItemMeta itemMeta = heiligerBogen.getItemMeta();
					itemMeta.setDisplayName("§6Heiliger Bogen der Janitscharen");
					itemMeta.addEnchant(Enchantment.DAMAGE_ALL,5,false);
					heiligerBogen.setItemMeta(itemMeta);
					heiligerBogen.setAmount(10);
					inventory.setItem(13, heiligerBogen);
					
					player.openInventory(inventory);
					player.sendMessage("§aDir wurde das Kit-Menü geöffnet!");
				}
				else
				{
					player.sendMessage("§cBitte benutze §c/kit§c!");
				}
			}
			else
			{
				player.sendMessage("§cDazu hast du keine Rechte!");
			}
		}
		return false;
	}

	
	
	
}
