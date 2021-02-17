package kaya.seymen.projektkurs.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MySQL  
{

	public static void main(String[] args) throws Exception
	{
		post();
	}

	
    public static ArrayList<String> get() throws Exception{
        try{
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM benutzer ");
            ResultSet result = statement.executeQuery();
           
            ArrayList<String> array = new ArrayList<String>();
            while(result.next()){
            	System.out.print(result.getString("id"));
                System.out.print(" ");
                System.out.print(result.getString("benutzername"));
                System.out.print(" ");
                System.out.println(result.getString("name"));
               
                array.add(result.getString("name"));
            }
            System.out.println("All records have been selected!");
            return array;
           
        }catch(Exception e){System.out.println(e);}
        return null;
       
    }
	
	public static void post() throws Exception
	{
		try
		{
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO benutzer (rang, benutzername) VALUES ('DIAMOND','SultanSeymen')");
			
			posted.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("Insert Completed.");
		}
	}
	
	public static void createTable() throws Exception
	{
		try
		{
		
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS benutzer(id int NOT NULL auto_increment, Benutzername varchar(255), Name varchar(255), Email varchar(255), Email2 varchar(255)"
					+ ", Passwort varchar(255), Passwort2 varchar (255), PRIMARY KEY (id))");
			create.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		finally
		{
			System.out.println("Function complete.");
		}
	}
	
	public static Connection getConnection() throws Exception
	{
		
		try
		{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://ms2636.gamedata.io:3306/ni4747892_1_DB";
			String username = "ni4747892_1_DB";
			String password = "P7m52COM";
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Conected");
			return con;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		return null;
	}
	
}
