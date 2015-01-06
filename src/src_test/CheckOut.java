package src_test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.soap.SOAPException;

public class CheckOut {
	
	private ResultSet rsq;

	public ResultSet getRsq() {
		return rsq;
	}
	public void setRsq(ResultSet rsq) {
		this.rsq = rsq;
	}
	
	public CheckOut() {
		
	}
	//Retrieve customer information.
	public void getCheckOutData(JTextField textFieldCOUT, JTextField textField_COUTname, JTextField textField_COUTsurname, JTextField textField_COUTrid1, JTextField 
			textField_COUTrid2, JTextField textField_COUTrid3,JTextField textField_COUTstartdate, JTextField textField_COUTenddate, JPanel panelCOUT_input, 
			JPanel panelCOUT_payment, JTextField textField_COUTcardnum,JTextField textField_COUTexpmonth, JTextField textField_COUTexpyear, JTextField textField_COUTbnv) {
		
		SQLconnection c = new SQLconnection();
		c.StartConnection();
		
		String bookingNum = textFieldCOUT.getText();
		
		try {
		
			if (!textFieldCOUT.getText().equals("")) {
				
				
				String checkCheckedIn = String.format("select IsCheckedIn from TabData where BookingNum = \"%s\"", bookingNum);
				PreparedStatement sql = c.connect.prepareStatement(checkCheckedIn);
				rsq = sql.executeQuery();
				
			if (!rsq.isClosed()) {
									
			
				if (rsq.getString("IsCheckedIn").equals("true")) { 
					
					String bookingInfoSql = String.format("select * from BookingData where BookingNum = %s and BookingNum in (select BookingNum from TabData where IsCheckedIn = 'true')", bookingNum);		
					PreparedStatement sql2 = c.connect.prepareStatement(bookingInfoSql);
					rsq = sql2.executeQuery();
					
					String StartDate = rsq.getString("BookingStartDate");
					textField_COUTstartdate.setText(StartDate);
			
					String EndDate = rsq.getString("BookingEndDate");
					textField_COUTenddate.setText(EndDate);
			
					String RID1 = rsq.getString("RoomId1");
					textField_COUTrid1.setText(RID1);
					String RID2 = rsq.getString("RoomId2");
					textField_COUTrid2.setText(RID2);
					String RID3 = rsq.getString("RoomId3");
					textField_COUTrid3.setText(RID3);
			
			
					String bookingInfoSql2 = String.format("select * from TabData where BookingNum = %s", bookingNum);			
					PreparedStatement sql3 = c.connect.prepareStatement(bookingInfoSql2);
					rsq = sql3.executeQuery();
			
					String name = rsq.getString("Name");
					textField_COUTname.setText(name);
			
					String surname = rsq.getString("SurName");
					textField_COUTsurname.setText(surname);
			
					String bnv = rsq.getString("CVCNum");
					textField_COUTbnv.setText(bnv);
			
					String cardn = rsq.getString("CardNumber");
					textField_COUTcardnum.setText(cardn);
			
					String expm = rsq.getString("ExpMonth");
					textField_COUTexpmonth.setText(expm);
			
					String expy = rsq.getString("ExpYear");
					textField_COUTexpyear.setText(expy);
			
					panelCOUT_input.setVisible(false);
					panelCOUT_payment.setVisible(true);
			
			} else {
				
				JOptionPane.showMessageDialog(null, "This bookingnumber is not checked in, you may not check out.");
			
			}
			
			}	
				
			} else {
				
				JOptionPane.showMessageDialog(null, "Please enter a valid booking-number!");
				
			}
			
			
		
		}
		catch(Exception exr){
			exr.printStackTrace();
		}

		finally{
			c.endConnection(); 
		}
		
	}
	//Retrieve number of nights stayed.
	public int daysBetween(String startDate, String endDate) {
		
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
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
	//Calculate price based on the number of nights stayed, and the prices of the booked rooms.
	public double calculatePrice(int value, JTextField textField_COUTrid1, JTextField textField_COUTrid2, JTextField textField_COUTrid3) {
		
		SQLconnection c = new SQLconnection();
		c.StartConnection();
		
		double res = 0;
		double rid1 = 0;
		double rid2 = 0;
		double rid3 = 0;

		String stringrid1 = textField_COUTrid1.getText();
		String stringrid2 = textField_COUTrid2.getText();
		String stringrid3 = textField_COUTrid3.getText();
		
		try {
			
			String RoomPriceSQL1 = String.format("select RoomPrice from RoomData where RoomId = %s", stringrid1);
			PreparedStatement sql1 = c.connect.prepareStatement(RoomPriceSQL1);
			rsq = sql1.executeQuery();
			rid1 = rsq.getDouble("RoomPrice");
			
			if (!stringrid2.equals("")) {
				
				String RoomPriceSQL2 = String.format("select RoomPrice from RoomData where RoomId = %s", stringrid2);
				PreparedStatement sql2 = c.connect.prepareStatement(RoomPriceSQL2);
				rsq = sql2.executeQuery();
				rid2 = rsq.getDouble("RoomPrice");
			} 
			
			if (!stringrid3.equals("")) {
				
				String RoomPriceSQL3 = String.format("select RoomPrice from RoomData where RoomId = %s", stringrid3);
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
	//Process payment
	public void makePayment(JTextField textFieldCOUT, String price) {
		
		SQLconnection c = new SQLconnection();
		c.StartConnection();
		
		String bookingNum = textFieldCOUT.getText();
		
		String name = null;
		String surname = null;
		String bnv = null;
		String cardn = null;
		int expm = 0;
		int expy = 0;
		double bill = Double.parseDouble(price);
	
		try {
			
			try {
			
			String bookingInfoSql2 = String.format("select * from TabData where BookingNum = %s", bookingNum);			
			PreparedStatement sql2 = c.connect.prepareStatement(bookingInfoSql2);
			rsq = sql2.executeQuery();
			
			name = rsq.getString("Name");			
			surname = rsq.getString("SurName");			
			bnv = rsq.getString("CVCNum");		
			cardn = rsq.getString("CardNumber");		
			expm = rsq.getInt("ExpMonth");			
			expy = rsq.getInt("ExpYear");
			
			}
			catch(Exception exr){
				exr.printStackTrace();
			}

			finally{
				c.endConnection(); 
			}
	
		
		se.chalmers.cse.mdsd1415.banking.customerRequires.CustomerRequires banking = se.chalmers.cse.mdsd1415.banking.customerRequires.CustomerRequires
				.instance();
		
		if (banking.makePayment(cardn, bnv, expm, expy, name, surname,
				bill)) {
			System.out.println("Payment of" + bill + " successfully processed");
			JOptionPane.showMessageDialog(null, "Payment of " + bill + " successfully processed");
			
			c = new SQLconnection();
			c.StartConnection();
			
			try {
				
				String CheckInCustomerSql = String.format("update TabData set IsCheckedIn = \"false\" where BookingNum = \"%s\"", bookingNum);
				PreparedStatement sql = c.connect.prepareStatement(CheckInCustomerSql);
				sql.executeUpdate();
				
				
				String CheckInRoomsSql = String.format("update RoomData set Status = \"false\" where RoomId in (select RoomId from RoomData, (select * from BookingData "
						+ "where BookingNum = \"%s\") as BookingData where RoomData.RoomId = BookingData.RoomId1 or RoomData.RoomId = BookingData.RoomId2 or RoomData.RoomId ="
						+ " BookingData.RoomId3)", bookingNum);
				PreparedStatement sql2 = c.connect.prepareStatement(CheckInRoomsSql);
				sql2.executeUpdate();
				
			}
			catch(Exception exr){
				exr.printStackTrace();
			}

			finally{
				c.endConnection(); 
			}
						
		} else {
			System.out
					.println("Payment failed - invalid credit card or insufficient credit");
				JOptionPane.showMessageDialog(null, "Payment failed - invalid credit card or insufficient credit");
		}
		
		} catch (SOAPException e) {
			System.err
					.println("Error occurred while communicating with the bank");
			e.printStackTrace();
		}
		
	}

}
