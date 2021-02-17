package kaya.seymen.projektkurs.weapons;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;

import  kaya.seymen.projektkurs.main.Main;

public class Rifle extends Weapon
{

	public Rifle(Main plugin, Material material, long reloadTime, double damage)
	{
		super(plugin, material, reloadTime, damage);
	}

	@Override
	public void shootEffects(Player player)
	{
		player.launchProjectile(Snowball.class);
	}

}
