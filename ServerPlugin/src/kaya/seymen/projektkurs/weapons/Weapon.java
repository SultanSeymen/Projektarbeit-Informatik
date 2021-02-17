package kaya.seymen.projektkurs.weapons;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import  kaya.seymen.projektkurs.main.Main;

public abstract class Weapon 
{
	
	private Main plugin;
	private Material material;
	private long reloadTime;
	private double damage;
	private ArrayList<String> shotWeapon;
	
	public Weapon(Main plugin, Material material, long reloadTime, double damage) 
	{
		this.plugin = plugin;
		this.material = material;
		this.reloadTime = reloadTime;
		this.damage = damage;
		
		shotWeapon = new ArrayList<>();
	}
	
	public void shoot(Player player)
	{
		if(!shotWeapon.contains(player.getName()))
		{
			shotWeapon.add(player.getName());
			shootEffects(player);
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
			{
				@Override
				public void run() {
					shotWeapon.remove(player.getName());
				}
			}, reloadTime);
		} else
			player.sendMessage("§cDie Waffe lädt gerade nach.");
	}
	
	public abstract void shootEffects(Player player);
	
	public Material getMaterial() 
	{
		return material;
	}
	
	public double getDamage()
	{
		return damage;
	}
	
}
