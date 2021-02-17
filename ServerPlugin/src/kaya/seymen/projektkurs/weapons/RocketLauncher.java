package kaya.seymen.projektkurs.weapons;

import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;

import  kaya.seymen.projektkurs.main.Main;

public class RocketLauncher extends Weapon 
{

	public RocketLauncher(Main plugin, Material material, long reloadTime, double damage)
	{
		super(plugin, material, reloadTime, damage);
	}

	@Override
	public void shootEffects(Player player) 
	{
		Fireball projectile = player.launchProjectile(Fireball.class);
		projectile.setIsIncendiary(false);
		projectile.setYield(0f);
	}

}
