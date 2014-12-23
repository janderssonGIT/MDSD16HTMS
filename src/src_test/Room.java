package src_test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.text.html.parser.Entity;

import net.proteanit.sql.DbUtils;

public class Room extends Interface {
	
	private int RoomID;
	private int Floor;
	private String RoomType;
	private int RoomPrice;
	private String Status;
	private ResultSet rsq;

	
	
	public ResultSet getRsq() {
		return rsq;
	}
	public void setRsq(ResultSet rsq) {
		this.rsq = rsq;
	}
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
		//rsq=null;
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
	
	 public void showValues(){	    
		//START CONNECTION
				SQLconnection c = new SQLconnection();
				c.StartConnection();
			//GET VALUES FROM DATABASE	
		      String sql = "SELECT * FROM ROOM;";
		      try{
		      PreparedStatement pst=c.connect.prepareStatement(sql);
		      //SAVE THEM IN THE RESULTSET
		       rsq=pst.executeQuery();		       
		      }
		      catch(Exception exr){
		    	  exr.printStackTrace();
		      }
		   
	     finally{
	    	 c.endConnection(); 
	     }
	
	 }
	
	
	
}
