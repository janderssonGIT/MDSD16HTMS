package src_test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CheckIn extends Interface {
	
	public CheckIn() {
		
	}
	//Retrieve customer data for check-in using a booking-number.
	protected void getCheckInData(JTextField textFieldCIN, JTextField ConfirmName, JTextField ConfirmSurName, JTextField rid1, JTextField rid2, JTextField rid3,
			JTextField ConfirmStartDate, JTextField ConfirmEndDate, JPanel panelCIN_input, JPanel panelCIN_confirm) {
		
		SQLconnection c = new SQLconnection();
		c.StartConnection();
		
		String bookingNum = textFieldCIN.getText();
		
		try {
		
			if (textFieldCIN.getText() != null) {  //fix condition
				
			String bookingInfoSql = String.format("select * from BookingData where BookingNum = %s", bookingNum);		
			PreparedStatement sql = c.connect.prepareStatement(bookingInfoSql);
			ResultSet rsq = sql.executeQuery();
		
			String startDate = rsq.getString("BookingStartDate");
			ConfirmStartDate.setText(startDate);
			String EndDate = rsq.getString("BookingEndDate");
			ConfirmEndDate.setText(EndDate);
			String RID1 = rsq.getString("RoomId1");
			rid1.setText(RID1);
			String RID2 = rsq.getString("RoomId2");
			rid2.setText(RID2);
			String RID3 = rsq.getString("RoomId3");
			rid3.setText(RID3);
			
			
			String bookingInfoSql2 = String.format("select * from TabData where BookingNum = %s", bookingNum);			
			PreparedStatement sql2 = c.connect.prepareStatement(bookingInfoSql2);
			rsq = sql2.executeQuery();
			
			String name = rsq.getString("Name");
			ConfirmName.setText(name);
			String surname = rsq.getString("SurName");
			ConfirmSurName.setText(surname);
			
			panelCIN_input.setVisible(false);
			panelCIN_confirm.setVisible(true);
			
			} else {
				
				JOptionPane.showMessageDialog(null, "Please enter a booking-number!");
				
			}
		
		}
		catch(Exception exr){
			exr.printStackTrace();
		}

		finally{
			c.endConnection(); 
		}
		
	}
	//Confirm the checkin and set the occupied status of room(s) to 'true' and set the checked in status of the customer to 'true'.
	protected void confirmCheckIn(JTextField textFieldCIN, JCheckBox chckbxConfirmCheckIn) {
		
		SQLconnection c = new SQLconnection();
		c.StartConnection();
		
		String bookingNum = textFieldCIN.getText();
		
		try {
		
			
		if (chckbxConfirmCheckIn.isSelected()) {
			
			String CheckInCustomerSql = String.format("update TabData set IsCheckedIn = \"true\" where BookingNum = \"%s\"", bookingNum);
			PreparedStatement sql = c.connect.prepareStatement(CheckInCustomerSql);
			sql.executeUpdate();
			
			
			String CheckInRoomsSql = String.format("update RoomData set Status = \"true\" where RoomId in (select RoomId from RoomData, (select * from BookingData "
					+ "where BookingNum = \"%s\") as BookingData where RoomData.RoomId = BookingData.RoomId1 or RoomData.RoomId = BookingData.RoomId2 or RoomData.RoomId ="
					+ " BookingData.RoomId3)", bookingNum);
			PreparedStatement sql2 = c.connect.prepareStatement(CheckInRoomsSql);
			sql2.executeUpdate();
			
		} else {
			
			JOptionPane.showMessageDialog(null, "Check-in was not completed.");
			
		}
			
		}
		catch(Exception exr){
			exr.printStackTrace();
		}

		finally{
			c.endConnection(); 
		}	
	}
	

}
