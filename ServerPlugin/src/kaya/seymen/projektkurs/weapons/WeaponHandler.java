package kaya.seymen.projektkurs.weapons;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import  kaya.seymen.projektkurs.main.Main;

public class WeaponHandler implements Listener 
{
	
	private ArrayList<Weapon> weapons;
	
	public WeaponHandler(Main plugin) 
	{
		weapons = new ArrayList<>();
		weapons.add(new Rifle(plugin, Material.IRON_HOE, 0, 0));
		weapons.add(new RocketLauncher(plugin, Material.BLAZE_ROD, 20*5, 10.0));
	}
	
	@EventHandler
	public void handleWeaponShot(PlayerInteractEvent event) 
	{
		if(event.getAction() != Action.RIGHT_CLICK_AIR) return;
		Weapon weapon = checkWeaponMaterial(event.getItem().getType());
		if(weapon != null)
			weapon.shoot(event.getPlayer());
	}
	
	@EventHandler
	public void handleWeaponDamage(EntityDamageByEntityEvent event) 
	{
		if(!(event.getDamager() instanceof Projectile)) return;
		Projectile projectile = (Projectile) event.getDamager();
		if(!(projectile.getShooter() instanceof Player)) return;
		Player player = (Player) projectile.getShooter();
		@SuppressWarnings("deprecation")
		Weapon weapon = checkWeaponMaterial(player.getItemInHand().getType());
		if(weapon != null)
			event.setDamage(weapon.getDamage());
	}
	
	private Weapon checkWeaponMaterial(Material material) 
	{
		for(Weapon current : weapons) {
			if(current.getMaterial() == material)
				return current;
		}
		return null;
	}

}
