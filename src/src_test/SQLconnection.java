package src_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLconnection {
	public Connection connect = null;
	public Statement stmt = null;
	
	//START DATABASE CONNECTION
	public void StartConnection(){
		try {
		Class.forName("org.sqlite.JDBC");
		
		connect = DriverManager.getConnection("jdbc:sqlite:D:\\eclipse\\Room.sqlite");
		connect.setAutoCommit(false);
	      System.out.println("Opened database successfully");
	      stmt = connect.createStatement();
		
	}
		catch(Exception exp){
			exp.printStackTrace();
		}
	}
	
	//END DATABASE CONNECTION
		public void endConnection(){

		     System.out.println("Operation successful");
		      try{
		    	  stmt.close();
			      connect.commit();
			      connect.close();
			  	  
		      }
		      catch (Exception exc){
		    	  exc.printStackTrace();
		      }
		      
	}
}
