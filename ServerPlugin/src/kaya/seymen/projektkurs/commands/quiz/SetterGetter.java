package kaya.seymen.projektkurs.commands.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kaya.seymen.projektkurs.mysql.MySQL;

public class SetterGetter
{
	public static String getLand(int aktuelleFrage) throws Exception
	{
		Connection con = MySQL.getConnection();
		PreparedStatement landStatement = con.prepareStatement("Select land From quizLand Where id = '" + aktuelleFrage + "';");
		ResultSet result = landStatement.executeQuery();		
		result.next();
		String land = (String) result.getObject(1);
		return land;	
	}
	
	public static String getHauptstadt(int aktuelleFrage) throws Exception
	{
		Connection con = MySQL.getConnection();
		PreparedStatement hauptstadtStatement = con.prepareStatement("Select hauptstadt From quizLand Where id = '" + aktuelleFrage + "';");
		ResultSet result = hauptstadtStatement.executeQuery();
		result.next();
		String hauptstadt = (String) result.getObject(1);
		return hauptstadt;
	}
	
	public static void setAktuelleFrage() throws Exception
	{
		Connection con = MySQL.getConnection();
		PreparedStatement statement = con.prepareStatement("UPDATE quizLandStand SET aktuelleFrage = aktuelleFrage + 1;");
		statement.executeUpdate();
	}
	
	public static int getAktuelleFrage() throws Exception
	{
		Connection con = MySQL.getConnection();
		PreparedStatement statement = con.prepareStatement("Select aktuelleFrage From quizLandStand;");
		ResultSet result = statement.executeQuery();
		result.next();
		int aktuelleFrage = (Integer) result.getObject(1);
		return aktuelleFrage;
		
	}
}
