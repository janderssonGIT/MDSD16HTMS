package src_test;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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

	protected Room(int roomID, int floor, String roomType, int roomPrice,
			String status) {
		super();
		RoomID = roomID;
		Floor = floor;
		RoomType = roomType;
		RoomPrice = roomPrice;
		Status = status;		
		
	}
	protected Room() {
		
	}
	protected void editRoom(JTable table, JTextField textID, JTextField textFloor, JTextField textPrice, JComboBox<String[]> comboRoomType, String[] roomTypes, JCheckBox chckbxStatus) {
		
		//Read the info from the JTable
	    int row = table.getSelectedRow();
	    String roomId = (table.getModel().getValueAt(row,0).toString());
	    String roomType = (table.getModel().getValueAt(row,4).toString());
	    String floor = (table.getModel().getValueAt(row,1).toString());
	    String price = (table.getModel().getValueAt(row,3).toString());
	    String status = (table.getModel().getValueAt(row, 2).toString());
	    
	    //SET THE VALUES TO THE TEXTFIELDS
	    textID.setText(roomId);
	    textFloor.setText(floor);
	    textPrice.setText(price);		    

	    if (roomType.equals("Single")) {
	    		comboRoomType.getModel().setSelectedItem(roomTypes[0]);
	    	} else if (roomType.equals("Double")) {
	    		comboRoomType.getModel().setSelectedItem(roomTypes[1]);
	    	} else if (roomType.equals("Suite")) {
	    		comboRoomType.getModel().setSelectedItem(roomTypes[2]);
	    	} else if (roomType.equals("Dual Single")) {
	    		comboRoomType.getModel().setSelectedItem(roomTypes[3]);
	    	} else if (roomType.equals("Triple Single")) {
	    		comboRoomType.getModel().setSelectedItem(roomTypes[4]);
	    	} else if (roomType.equals("Family")) {
	    		comboRoomType.getModel().setSelectedItem(roomTypes[5]);
	    	} 
	    
	    if (status.equals("false")) {
	    		chckbxStatus.setSelected(false);
	    }	else if (status.equals("true")) {
	    		chckbxStatus.setSelected(true);
	    }
		
	}
			
	protected void addRoom(JTable table, JTextField textID, JTextField textFloor, JTextField textPrice, JComboBox<String[]> comboRoomType, JCheckBox chckbxStatus) {
		
		String roomID = textID.getText();
	    String floor = textFloor.getText();
	    String price = textPrice.getText();
	    String roomTypes = (String) comboRoomType.getSelectedItem();
		
	    SQLconnection c = new SQLconnection();
		c.StartConnection();
		
		String sql = String.format("INSERT INTO RoomData(RoomID, Floor, Status, RoomPrice, RoomType) VALUES(%s, %s, \"false\", %s, \"%s\")", roomID, floor, price, roomTypes);
			
		try{
		      PreparedStatement pst=c.connect.prepareStatement(sql);
		       pst.executeUpdate();	
		           
		      }
		      catch(Exception exr){
		    	  exr.printStackTrace();
		    	  JOptionPane.showMessageDialog(frmAlpha, "The ID already exists, please select another ID.");
		      }
		   
	     finally{
	    	 c.endConnection(); 
	     }
		
	}
	
	protected void updateRoom(JTable table, JTextField textID, JTextField textFloor, JTextField textPrice, JComboBox<String[]> comboRoomType, JCheckBox chckbxStatus) {
		
		String roomID = textID.getText();
	    String floor = textFloor.getText();
	    String price = textPrice.getText();
	    String roomTypes = (String) comboRoomType.getSelectedItem();
		
	    SQLconnection c = new SQLconnection();
		c.StartConnection();
		
		String sql = String.format("update RoomData set Floor = %s, RoomPrice = %s, RoomType = \"%s\" where RoomId = %s", floor, price, roomTypes, roomID);
		
		try{
		      PreparedStatement pst=c.connect.prepareStatement(sql);
		       pst.executeUpdate();	
		           
		      }
		      catch(Exception exr){
		    	  exr.printStackTrace();
		      }
		   
	     finally{
	    	 c.endConnection(); 
	     }
	}
	
	protected void deleteRoom(JTable table) {
		
		 int row = table.getSelectedRow();
		    String roomID = (table.getModel().getValueAt(row,0).toString());
		    
		    SQLconnection c = new SQLconnection();
			c.StartConnection();
			
			String sql = String.format("DELETE FROM RoomData WHERE RoomID = %s;", roomID);
			
	      try{
	      PreparedStatement pst=c.connect.prepareStatement(sql);
	       pst.executeUpdate();	
	           
	      }
	      catch(Exception exr){
	    	  exr.printStackTrace();
	      }
	   
     finally{
    	 c.endConnection(); 
     }
		
	}
	
	protected void showValues(JTable table){	    
		 	
				SQLconnection c = new SQLconnection();
				c.StartConnection();
				
		      String sql = "SELECT * FROM ROOMDATA;";
		      try{
		      PreparedStatement pst=c.connect.prepareStatement(sql);
		    
		       rsq=pst.executeQuery();	
		       table.setModel(DbUtils.resultSetToTableModel(rsq));
		      }
		      catch(Exception exr){
		    	  exr.printStackTrace();
		      }
		   
	     finally{
	    	 c.endConnection(); 
	     }
	
	 }
			
}
