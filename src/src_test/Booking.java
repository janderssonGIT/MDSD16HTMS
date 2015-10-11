package src_test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.xml.soap.SOAPException;
import net.proteanit.sql.DbUtils;
import com.toedter.calendar.JCalendar;

public class Booking extends Interface{

	public Booking() {
	}
	//Method for enabling Roomtype comboboxes based on the input of a combobox representing the number of rooms.
	protected void setNumOfRooms(JComboBox comboBoxBookNumRooms, JComboBox comboBoxRI, JComboBox comboBoxRII, JComboBox comboBoxRIII, JLabel lblRoomI, JLabel lblRoomII, JLabel lblRoomIII) {
		
		String cbv = (String) comboBoxBookNumRooms.getSelectedItem();
		String a = Integer.toString(1);
		String b = Integer.toString(2);
		String c = Integer.toString(3);
		
		if (cbv.equals(a)) {
			comboBoxRI.setEnabled(true);
			comboBoxRII.setEnabled(false);
			comboBoxRIII.setEnabled(false);
			lblRoomI.setEnabled(true);
			lblRoomII.setEnabled(false);
			lblRoomIII.setEnabled(false);
		} else if (cbv.equals(b)) {
			comboBoxRI.setEnabled(true);
			comboBoxRII.setEnabled(true);
			comboBoxRIII.setEnabled(false);
			lblRoomI.setEnabled(true);
			lblRoomII.setEnabled(true);
			lblRoomIII.setEnabled(false);
		} else if (cbv.equals(c)) {
			comboBoxRI.setEnabled(true);
			comboBoxRII.setEnabled(true);
			comboBoxRIII.setEnabled(true);
			lblRoomI.setEnabled(true);
			lblRoomII.setEnabled(true);
			lblRoomIII.setEnabled(true);
		}
	}
	//Displays the JCalendar Date() values from both calendars in string format in the lower textfields.
	protected void showDates(JCalendar calendar1, JCalendar calendar2, JTextPane textPaneDate1, JTextPane textPaneDate2) {
		
		Date c1 = calendar1.getDate();
		Date c2 = calendar2.getDate();
		Format formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s1 = formatter1.format(c1);
		Format formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s2 = formatter2.format(c2);
		textPaneDate1.setText(s1);
		textPaneDate2.setText(s2);		
	}
	//Method for querying the database for unique room(s) of a set roomtype between the set start -and end date.
	protected boolean searchRooms(JCalendar calendar1, JCalendar calendar2, JComboBox comboBoxBookNumRooms, JComboBox comboBoxRI, JComboBox comboBoxRII, JComboBox comboBoxRIII) {
		
		Date c1 = calendar1.getDate();
		Date c2 = calendar2.getDate();
		
		Format formatter1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		String s1 = formatter1.format(c1);
		Format formatter2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		String s2 = formatter2.format(c2);
				
		Instant t1 = Instant.parse(s1);
		Instant t2 = Instant.parse(s2);

		if (t1.isAfter(t2.minusSeconds(86400))) {
			return false;
		} 
		return true;
	}
	//Method for displaying the search results in JTables.
	protected void showResult(JTable table_1, JTable table_2, JTable table_3, JCalendar calendar1, JCalendar calendar2, JComboBox comboBoxRI, JComboBox comboBoxRII, JComboBox comboBoxRIII, 
			JPanel bookingSelections, JPanel bookingSearchRes, JPanel bookingCinfo, JPanel bookingSummary){	    
		
			SQLconnection c = new SQLconnection();
			c.StartConnection();
			
			Date c1 = calendar1.getDate();
			Date c2 = calendar2.getDate();
			
			Format formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			String StartDate = formatter1.format(c1);
			Format formatter2 = new SimpleDateFormat("yyyy-MM-dd");
			String EndDate = formatter2.format(c2);
			
			String querystring = "select RoomData.RoomId as 'Room Id',RoomData.RoomType as 'Room type',RoomData.RoomPrice as 'Price per night',RoomData.Capacity as "
					+ "Capacity from RoomData where RoomData.RoomType = \"%s\" and RoomData.RoomId not in ( select RoomId from RoomData, (select * from BookingData where "
					+ "strftime(\"%%s\", BookingStartDate) < strftime(\"%%s\", \"%s\") and strftime(\"%%s\", BookingEndDate) > strftime(\"%%s\", \"%s\")) as BookingData where "
					+ "RoomData.RoomId = BookingData.RoomId1 or RoomData.RoomId = BookingData.RoomId2 or RoomData.RoomId = BookingData.RoomId3) limit 1;";
			try{
			String s1 = (String) comboBoxRI.getSelectedItem();
			String sql1 = String.format(querystring, s1, EndDate, StartDate);	
			System.out.println(sql1);
			PreparedStatement pst1=c.connect.prepareStatement(sql1);
			ResultSet rsq=pst1.executeQuery();	
			table_1.setModel(DbUtils.resultSetToTableModel(rsq));
			table_1.getColumnModel().getColumn(0).setMinWidth(0);
			table_1.getColumnModel().getColumn(0).setMaxWidth(0);
			
			if (comboBoxRII.isEnabled()) {
				String s2 = (String) comboBoxRII.getSelectedItem();
				String sql2 = String.format(querystring, s2, EndDate, StartDate);
				PreparedStatement pst2=c.connect.prepareStatement(sql2);
				rsq = pst2.executeQuery();	
				table_2.setModel(DbUtils.resultSetToTableModel(rsq));
				table_2.getColumnModel().getColumn(0).setMinWidth(0);
				table_2.getColumnModel().getColumn(0).setMaxWidth(0);
				} 
			if (comboBoxRIII.isEnabled()) {
				String s3 = (String) comboBoxRIII.getSelectedItem();
				String sql3 = String.format(querystring, s3, EndDate, StartDate);
				PreparedStatement pst3=c.connect.prepareStatement(sql3);
				rsq = pst3.executeQuery();	
				table_3.setModel(DbUtils.resultSetToTableModel(rsq));
				table_3.getColumnModel().getColumn(0).setMinWidth(0);
				table_3.getColumnModel().getColumn(0).setMaxWidth(0);
			}
			catch(Exception exr){
				exr.printStackTrace();
			}
			finally{
				c.endConnection(); 
			}
			if (table_1.getModel().getRowCount() < 1) {
				JOptionPane.showMessageDialog(null, "No available rooms were found!");
				bookingSelections.setVisible(true);
				bookingSearchRes.setVisible(false);
				bookingCinfo.setVisible(false);
				bookingSummary.setVisible(false);
			} else {
				bookingSelections.setVisible(false);
				bookingSearchRes.setVisible(true);
				bookingCinfo.setVisible(false);
				bookingSummary.setVisible(false);
			}
	}
	//Simple method for switching panels through a confirmation dialog.
	protected void confirmRooms(JPanel bookingSelections, JPanel bookingSearchRes, JPanel bookingCinfo, JPanel bookingSummary) {
		
		int result = JOptionPane.showOptionDialog(null, "Do you wish to confirm the selected rooms?", "Confirm Booking.", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
		
		if (result == JOptionPane.YES_OPTION) {
			bookingSelections.setVisible(false);
			bookingSearchRes.setVisible(false);
			bookingCinfo.setVisible(true);
			bookingSummary.setVisible(false);
		} else {
			bookingSelections.setVisible(true);
			bookingSearchRes.setVisible(false);
			bookingCinfo.setVisible(false);
			bookingSummary.setVisible(false);						
		}
	}
	//Method for validating the customer's card information, and if validated, record the completed booking in the database and display a summary with a generated booking number.
	//This method implements the .icCreditCardValid method.
	protected void bookingValidate(JTable table_1, JTable table_2, JTable table_3, JCalendar calendar1, 
			JCalendar calendar2, JTextField textField_name, JTextField textField_surname, JTextField textField_cardNum, 
			JTextField textField_BNV, JComboBox comboBoxMM, JComboBox comboBoxYY, JTextField textField_1, JTextField textField_2, JTextField textField_3, JTextField textField_4, 
			JTextField textField_5, JTextField textField_6, JTextField textField_7, JTextField textField_8, JPanel bookingSelections, JPanel bookingSearchRes,
			JPanel bookingCinfo, JPanel bookingSummary) {	
		
		String cardNum = textField_cardNum.getText();
		String bnv = textField_BNV.getText();
		int mm = Integer.parseInt((String) comboBoxMM.getSelectedItem());
		int yy = Integer.parseInt((String) comboBoxYY.getSelectedItem());
		String name = textField_name.getText();
		String surname = textField_surname.getText();
		
		try {
		se.chalmers.cse.mdsd1415.banking.customerRequires.CustomerRequires banking = se.chalmers.cse.mdsd1415.banking.customerRequires.CustomerRequires
				.instance();
		if (banking.isCreditCardValid(cardNum, bnv, mm, yy, name,
				surname)) {
			System.out.println("Valid credit card");
			JOptionPane.showMessageDialog(null, "Credit card was successfully validated.");
	
			String bookingNum = this.bookingPutBookingData(table_1, table_2, table_3, calendar1, calendar2);
			this.bookingPutCustomerData(textField_name, textField_surname, textField_cardNum, textField_BNV, comboBoxMM, comboBoxYY, bookingNum);
			this.bookingPutCustomerDataSummary(textField_1, textField_2, textField_3, textField_4, textField_5, textField_6, textField_7, textField_8, 
					table_1, table_2, table_3, bookingNum, textField_name, textField_surname, calendar1, calendar2);
					
			bookingSelections.setVisible(false);
			bookingSearchRes.setVisible(false);
			bookingCinfo.setVisible(false);
			bookingSummary.setVisible(true);
			
			JOptionPane.showMessageDialog(null, "Booking successful! Please save your booking-number.");
			
		} else {
			System.out.println("Invalid credit card");
			JOptionPane.showMessageDialog(null, "Credit card could not be validated. Please re-enter your card details.");
		}
				
		} catch (SOAPException e) {
			System.err.println("Error occurred while communicating with the bank");
			e.printStackTrace();
		}
	}
	//Record the booking data in database.
	protected String bookingPutBookingData(JTable table_1, JTable table_2, JTable table_3, JCalendar calendar1, JCalendar calendar2) {
		
		SQLconnection c = new SQLconnection();
		c.StartConnection();
		
		Date c1 = calendar1.getDate();
		Date c2 = calendar2.getDate();
		String bookingNum = null;
		String RID1 = "";
		String RID2 = "";
		String RID3 = "";
		
		Format formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		String StartDate = formatter1.format(c1);
		Format formatter2 = new SimpleDateFormat("yyyy-MM-dd");
		String EndDate = formatter2.format(c2);
		
		try{
			if (table_3.getModel().getRowCount() > 0) {
				
				RID1 = (table_1.getModel().getValueAt(0,0).toString());
				RID2 = (table_2.getModel().getValueAt(0,0).toString());
				RID3 = (table_3.getModel().getValueAt(0,0).toString());
				
				String sql = String.format("insert into BookingData (RoomId1,RoomId2,RoomId3,BookingStartDate,BookingEndDate) values "
						+ "(\"%s\",\"%s\",\"%s\",\"%s\",\"%s\")", RID1, RID2, RID3, StartDate, EndDate);
				
				PreparedStatement pst = c.connect.prepareStatement(sql);
				pst.executeUpdate();
			
			} else if (table_2.getModel().getRowCount() > 0) {
				RID1 = (table_1.getModel().getValueAt(0,0).toString());
				RID2 = (table_2.getModel().getValueAt(0,0).toString());

				String sql = String.format("insert into BookingData (RoomId1,RoomId2,RoomId3,BookingStartDate,BookingEndDate) values "
						+ "(\"%s\",\"%s\",\"%s\",\"%s\",\"%s\")", RID1, RID2, RID3, StartDate, EndDate);
				
				PreparedStatement pst = c.connect.prepareStatement(sql);
				pst.executeUpdate();
				
			} else if (table_1.getModel().getRowCount() > 0) {
				
				RID1 = (table_1.getModel().getValueAt(0,0).toString());
				
				String sql = String.format("insert into BookingData (RoomId1,RoomId2,RoomId3,BookingStartDate,BookingEndDate) values "
						+ "(\"%s\",\"%s\",\"%s\",\"%s\",\"%s\")", RID1, RID2, RID3, StartDate, EndDate);
				
				PreparedStatement pst = c.connect.prepareStatement(sql);
				pst.executeUpdate();
			}
			
			String sql = String.format("select BookingNum from BookingData where RoomId1 = \"%s\" and RoomId2 = \"%s\" and RoomId3 = \"%s\" and BookingStartDate = \"%s\" and "
					+ "BookingEndDate = \"%s\"",  RID1, RID2, RID3, StartDate, EndDate);	
					
			PreparedStatement pst = c.connect.prepareStatement(sql);
			JTable tempTab = new JTable();
			tempTab.setModel(DbUtils.resultSetToTableModel(pst.executeQuery()));
			bookingNum = Integer.toString((Integer) tempTab.getModel().getValueAt(0,0));
			System.out.println("This is the num: " + bookingNum);	
		}
		catch(Exception exr){
			exr.printStackTrace();
		}
		finally{
			c.endConnection(); 
		}
		return bookingNum;
	}
	//Record the customer tab data in the database.
	protected void bookingPutCustomerData(JTextField textField_name, JTextField textField_surname, 
			JTextField textField_cardNum, JTextField textField_BNV, JComboBox comboBoxMM, JComboBox comboBoxYY, String bookingNum) {
		
		SQLconnection c = new SQLconnection();
		c.StartConnection();
		
		String name = textField_name.getText();
		String surname = textField_surname.getText();
		String cardNum = textField_cardNum.getText();
		String bnv = textField_BNV.getText();
		int mm = Integer.valueOf((String)comboBoxMM.getSelectedItem());
		int yy = Integer.valueOf((String)comboBoxYY.getSelectedItem());	
		
		try{		
		String putCustomerDataSql = String.format("insert into TabData (BookingNum, Name, SurName, CVCNum, CardNumber, ExpMonth, ExpYear, TotalBill, IsCheckedIn) values "
				+ "(\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\")", bookingNum, name, surname, bnv, cardNum, mm, yy, null, "false");
		
		PreparedStatement sql = c.connect.prepareStatement(putCustomerDataSql);
		sql.executeUpdate();
		
		}
		catch(Exception exr){
			exr.printStackTrace();
		}

		finally{
			c.endConnection(); 
		}
	}
	//Display a summary and the generated booking number.
	protected void bookingPutCustomerDataSummary(JTextField textField_1, JTextField textField_2, JTextField textField_3, JTextField textField_4, 
			JTextField textField_5, JTextField textField_6, JTextField textField_7, JTextField textField_8, JTable table_1, JTable table_2, JTable table_3,
			String bookingNum, JTextField textField_name, JTextField textField_surname, JCalendar calendar1, JCalendar calendar2) {
		
		String name = textField_name.getText();
		String surname = textField_surname.getText();
		
		String RID1 = "";
		String RID2 = "";
		String RID3 = "";
		
		Date c1 = calendar1.getDate();
		Date c2 = calendar2.getDate();
		
		Format formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		String StartDate = formatter1.format(c1);
		Format formatter2 = new SimpleDateFormat("yyyy-MM-dd");
		String EndDate = formatter2.format(c2);
		
		if (table_3.getModel().getRowCount() > 0) {
			RID1 = (table_1.getModel().getValueAt(0,1).toString());
			RID2 = (table_2.getModel().getValueAt(0,1).toString());
			RID3 = (table_3.getModel().getValueAt(0,1).toString());
			textField_3.setText(RID1);
			textField_4.setText(RID2);
			textField_5.setText(RID3);
			
		} else if (table_2.getModel().getRowCount() > 0) {
			RID1 = (table_1.getModel().getValueAt(0,1).toString());
			RID2 = (table_2.getModel().getValueAt(0,1).toString());
			textField_3.setText(RID1);
			textField_4.setText(RID2);
			
		} else if (table_1.getModel().getRowCount() > 0) {
			
			RID1 = (table_1.getModel().getValueAt(0,1).toString());
			textField_3.setText(RID1);
		}
		textField_1.setText(name);
		textField_2.setText(surname);
		textField_6.setText(StartDate);
		textField_7.setText(EndDate);
		textField_8.setText(bookingNum);		
	}
	
protected int nightsBetween(JCalendar calendar1, JCalendar calendar2) {
		
	Calendar start = Calendar.getInstance();
	Calendar end = Calendar.getInstance();
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    
    Date c1 = calendar1.getDate();
	Date c2 = calendar2.getDate();
	
	Format formatter1 = new SimpleDateFormat("yyyy-MM-dd");
	String startDate = formatter1.format(c1);
	Format formatter2 = new SimpleDateFormat("yyyy-MM-dd");
	String endDate = formatter2.format(c2);
    
    try {
    start.setTime(formatter.parse(startDate));
    end.setTime(formatter.parse(endDate));
    }
	catch(Exception exr){
		exr.printStackTrace();
	}
    Calendar date = (Calendar) start.clone();
    int daysBetween = 0;
    while (date.before(end)) {
        date.add(Calendar.DAY_OF_MONTH, 1);
        daysBetween++;
    }
    return daysBetween;
    }
	
protected double calculatePriceBooking(int value, JTable table_1, JTable table_2, JTable table_3) {
	SQLconnection c = new SQLconnection();
	c.StartConnection();
	
	double res = 0;
	double rid1 = 0;
	double rid2 = 0;
	double rid3 = 0;
	String RID1 = "";
	String RID2 = "";
	String RID3 = "";
	
	if (table_3.getModel().getRowCount() > 0) {
		RID1 = (table_1.getModel().getValueAt(0,0).toString());
		RID2 = (table_2.getModel().getValueAt(0,0).toString());
		RID3 = (table_3.getModel().getValueAt(0,0).toString());
		
	} else if (table_2.getModel().getRowCount() > 0) {	
		RID1 = (table_1.getModel().getValueAt(0,0).toString());
		RID2 = (table_2.getModel().getValueAt(0,0).toString());
		
	} else if (table_1.getModel().getRowCount() > 0) {	
		RID1 = (table_1.getModel().getValueAt(0,0).toString());
	}
	
	try {
		String RoomPriceSQL1 = String.format("select RoomPrice from RoomData where RoomId = %s", RID1);
		PreparedStatement sql1 = c.connect.prepareStatement(RoomPriceSQL1);
		ResultSet rsq = sql1.executeQuery();
		rid1 = rsq.getDouble("RoomPrice");
		
		if (!RID2.equals("")) {
			String RoomPriceSQL2 = String.format("select RoomPrice from RoomData where RoomId = %s", RID2);
			PreparedStatement sql2 = c.connect.prepareStatement(RoomPriceSQL2);
			rsq = sql2.executeQuery();
			rid2 = rsq.getDouble("RoomPrice");
		} 
		
		if (!RID3.equals("")) {
			String RoomPriceSQL3 = String.format("select RoomPrice from RoomData where RoomId = %s", RID3);
			PreparedStatement sql3 = c.connect.prepareStatement(RoomPriceSQL3);
			rsq = sql3.executeQuery();
			rid3 = rsq.getDouble("RoomPrice");
		} 
		res = value * (rid1 + rid2 + rid3);	
	}
	catch(Exception exr){
		exr.printStackTrace();
	}
	finally{
		c.endConnection(); 
	}
	return res;
}
}
