package kaya.seymen.projektkurs.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import kaya.seymen.projektkurs.commands.fly.Fly;
import kaya.seymen.projektkurs.commands.gamemode.Gamemode0;
import kaya.seymen.projektkurs.commands.gamemode.Gamemode1;
import kaya.seymen.projektkurs.commands.gamemode.Gamemode2;
import kaya.seymen.projektkurs.commands.gamemode.Gamemode3;
import kaya.seymen.projektkurs.commands.geld.addmoney;
import kaya.seymen.projektkurs.commands.geld.givemoney;
import kaya.seymen.projektkurs.commands.geld.money;
import kaya.seymen.projektkurs.commands.heal.HealCommand;
import kaya.seymen.projektkurs.commands.informationenSpieler.info;
import kaya.seymen.projektkurs.commands.informationenSpieler.informationenEintragen;
import kaya.seymen.projektkurs.commands.notiz.Notiz;
import kaya.seymen.projektkurs.commands.party.PartyCommand;
import kaya.seymen.projektkurs.commands.quiz.stelleDieFrage;
import kaya.seymen.projektkurs.commands.rangUndKit.KitCommand;
import kaya.seymen.projektkurs.commands.rangUndKit.Kits;
import kaya.seymen.projektkurs.commands.rangUndKit.Raenge;
import kaya.seymen.projektkurs.commands.spawn.SpawnCommand;
import kaya.seymen.projektkurs.commands.spawn.setSpawnCommand;
import kaya.seymen.projektkurs.listeners.JoinListener;
import kaya.seymen.projektkurs.util.RecipeLoader;
import kaya.seymen.projektkurs.weapons.WeaponHandler;

public class Main extends JavaPlugin 
{

	private static Main plugin;
	
	public void onEnable() 
	{
		
		plugin = this;
		
		new RecipeLoader().registerRecipes();
		
		getCommand("heal").setExecutor(new HealCommand());
		
		getCommand("gm0").setExecutor(new Gamemode0());
		getCommand("gm1").setExecutor(new Gamemode1());
		getCommand("gm2").setExecutor(new Gamemode2());
		getCommand("gm3").setExecutor(new Gamemode3());
		
		getCommand("fly").setExecutor(new Fly());
		
		getCommand("truhe").setExecutor(new KitCommand());
		
		getCommand("kit").setExecutor(new Kits());
		
		getCommand("rang").setExecutor(new Raenge());
		
		getCommand("givemoney").setExecutor(new givemoney());
		getCommand("addmoney").setExecutor(new addmoney());
		getCommand("money").setExecutor(new money());
		
		getCommand("informationeneintragen").setExecutor(new informationenEintragen());
		getCommand("info").setExecutor(new info());
		
		getCommand("notiz").setExecutor(new Notiz());
		
		getCommand("quizFrage").setExecutor(new stelleDieFrage());
		
		getCommand("setspawn").setExecutor(new setSpawnCommand());
		getCommand("spawn").setExecutor(new SpawnCommand());
		getCommand("party").setExecutor(new PartyCommand());
		
		PluginManager pluginManager = Bukkit.getPluginManager();
		pluginManager.registerEvents(new WeaponHandler(this), this);
		pluginManager.registerEvents(new JoinListener(), this);
	}
	
	public static Main getPlugin()
	{
		return plugin;
	}
	
}
