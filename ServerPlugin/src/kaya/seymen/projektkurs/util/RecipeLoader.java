package kaya.seymen.projektkurs.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class RecipeLoader
{
	public void registerRecipes()
	{
		ItemStack wurst = new ItemStack(Material.COOKED_BEEF);
		ItemMeta wurstMeta = wurst.getItemMeta();
		wurstMeta.setDisplayName("§6§lWurst");
		wurst.setItemMeta(wurstMeta);
		@SuppressWarnings("deprecation")
		ShapelessRecipe wurstRecipe = new ShapelessRecipe(wurst);
		wurstRecipe.addIngredient(Material.ROTTEN_FLESH);
		wurstRecipe.addIngredient(Material.COOKED_CHICKEN);
		wurstRecipe.addIngredient(Material.COOKED_RABBIT);
		
		ItemStack hilfsbroetchen = new ItemStack(Material.BREAD);
		ItemMeta hilfsbroetchenMeta = hilfsbroetchen.getItemMeta();
		hilfsbroetchenMeta.setDisplayName("§6§lHilfsbrötchen");
		hilfsbroetchen.setItemMeta(hilfsbroetchenMeta);
		@SuppressWarnings("deprecation")
		ShapedRecipe hilfsbroetchenRecipe = new ShapedRecipe(hilfsbroetchen);
		hilfsbroetchenRecipe.shape("ZNZ","WEW","WMW");
		hilfsbroetchenRecipe.setIngredient('Z', Material.SUGAR);
		hilfsbroetchenRecipe.setIngredient('N', Material.NETHER_STAR);
		hilfsbroetchenRecipe.setIngredient('W', Material.WHEAT);
		hilfsbroetchenRecipe.setIngredient('M', Material.MILK_BUCKET);
		hilfsbroetchenRecipe.setIngredient('E', Material.EGG);
	
		ItemStack wurstRoll = new ItemStack(Material.BREAD);
		ItemMeta wurstRollMeta = wurstRoll.getItemMeta();
		wurstRollMeta.setDisplayName("§6§lWurst Roll");
		wurstRoll.setItemMeta(wurstRollMeta);
		@SuppressWarnings("deprecation")
		ShapedRecipe wurstRollRecipe = new ShapedRecipe(wurstRoll);
		wurstRollRecipe.shape("BBB","FFF","BBB");
		wurstRollRecipe.setIngredient('B', Material.BREAD);
		wurstRollRecipe.setIngredient('F', Material.COOKED_BEEF);
		
		Bukkit.addRecipe(wurstRecipe);
		Bukkit.addRecipe(wurstRollRecipe);
		Bukkit.addRecipe(hilfsbroetchenRecipe);
		
	}
	
	
}
