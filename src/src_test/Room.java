package src_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;

public class Room extends Interface {
	
	private int RoomID;
	private int Floor;
	private String RoomType;
	private int RoomPrice;
	private String Status;
	
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getRoomID() {
		return RoomID;
	}
	public void setRoomID(int roomID) {
		RoomID = roomID;
	}
	public int getFloor() {
		return Floor;
	}
	public void setFloor(int floor) {
		Floor = floor;
	}
	public String getRoomType() {
		return RoomType;
	}
	public void setRoomType(String roomType) {
		RoomType = roomType;
	}
	public int getRoomPrice() {
		return RoomPrice;
	}
	public void setRoomPrice(int roomPrice) {
		RoomPrice = roomPrice;
	}

	public Room(int roomID, int floor, String roomType, int roomPrice,
			String status) {
		super();
		RoomID = roomID;
		Floor = floor;
		RoomType = roomType;
		RoomPrice = roomPrice;
		Status = status;
	}
	public Room() {
		
	}
	public void editRoom(String idRoom ) {
		
		//START CONNECTION
		SQLconnection c = new SQLconnection();
		c.StartConnection();
		
		//GET VALUES FROM THE DATABASE WITH ROOMID=id
		String sqll = "SELECT * FROM ROOM WHERE ID='"+idRoom+"'";
		
		try {
		PreparedStatement pst1 = c.connect.prepareStatement(sqll);
	    
	//SET THE VALUES OBTAINED TO THE VARIABLES
		
		ResultSet rs=pst1.executeQuery();
		while (rs.next()){
	    	
	    	RoomID=Integer.parseInt(rs.getString("ID"));				    	
	    	RoomType=rs.getString("TYPE");				    					    	
	    	Floor=Integer.parseInt(rs.getString("Floor"));				    					    	
	    	RoomPrice=Integer.parseInt(rs.getString("Price"));	
	    	Status=rs.getString("Status");
	    	}
	    c.endConnection();
		}
	    catch(Exception x){
			x.printStackTrace();
		} 
	    
	}
	
	
	
	public void addRoom() {
		
	}
	
	/*
	public ResultSet showValuesInTable(){
		
		ResultSet rs="";

		//START CONNECTION
				SQLconnection c = new SQLconnection();
				c.StartConnection();
		      String sql = "SELECT * FROM ROOM;";
		      try{
		      PreparedStatement pst=c.connect.prepareStatement(sql);
		      
		      rs=pst.executeQuery();
		      pst.execute();
		      c.endConnection();
		      }
		      catch(Exception exp){
		    	  exp.printStackTrace();
		    	  
		      }
		//
		    
		
		
		return rs;
	}
	*/
	
	
}
