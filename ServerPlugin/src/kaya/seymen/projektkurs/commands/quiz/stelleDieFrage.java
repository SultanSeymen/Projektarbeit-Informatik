package kaya.seymen.projektkurs.commands.quiz;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class stelleDieFrage implements CommandExecutor 
{	
	int fragenRichtig = 0, fragenInsgesamt = 0, caseNummer = 0;
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if(sender instanceof Player) 
		{
			Player player = (Player) sender;
			
			if(player.hasPermission("tutorial.quizFrage"))
			{
				switch(caseNummer)
				{
				case 0: 
					try 
					{
						int aktuelleFrage = SetterGetter.getAktuelleFrage();
						String land = SetterGetter.getLand(aktuelleFrage);
						player.sendMessage("§3Was ist die Hauptstadt von §2'" + land + "'§3?");
						player.sendMessage("Die aktuelle Frage ist " + aktuelleFrage + ".");
					} 
					catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					caseNummer = 1;
					break;
						
				case 1:
					
					try {
						int aktuelleFrage = SetterGetter.getAktuelleFrage();
						String antwort = SetterGetter.getHauptstadt(aktuelleFrage);
						if(antwort.equalsIgnoreCase(args[0]))
						{
							fragenRichtig++;
							fragenInsgesamt++;
							player.sendMessage("§2Richtig! Du hast §3'" + fragenRichtig + "'§2 Fragen von§3 '" + fragenInsgesamt + "'§2 richtig beantwortet.");
						}
						else
						{
							fragenInsgesamt++;
							player.sendMessage("§2Leider Falsch! Du hast §3'" + fragenRichtig + "'§2 Fragen von§3 '" + fragenInsgesamt + "'§2 richtig beantwortet.");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					try {
						SetterGetter.setAktuelleFrage();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					caseNummer = 0;
					
					if(fragenInsgesamt == 48)
					{
						caseNummer = 2;
						break;
					}
					break;
					
				case 2:
					player.sendMessage("§1Danke fürs mitspielen. Das Quiz ist beendet.");
					break;
				}
			}
		}
		return false;
	}
}
