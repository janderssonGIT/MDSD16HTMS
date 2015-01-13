/**
 * 
 */
package test_suite;

import static org.junit.Assert.*;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import src_test.CheckIn;
import src_test.SQLconnection;


/**
 * @author Jim
 *
 */
public class CheckInTest {

	/**
	 * Test method for {@link src_test.CheckIn#getCheckInData(javax.swing.JTextField, javax.swing.JTextField, javax.swing.JTextField, javax.swing.JTextField, javax.swing.JTextField, javax.swing.JTextField, javax.swing.JTextField, javax.swing.JTextField, javax.swing.JPanel, javax.swing.JPanel)}.
	 */

	@Test
	public final void testGetCheckInData() {
		
		CheckIn ci = new CheckIn();
		
		JTextField BN = new JTextField("39");			
		JTextField name = new JTextField();
		JTextField surname = new JTextField();
		JTextField rid1 = new JTextField();
		JTextField rid2 = new JTextField();
		JTextField rid3 = new JTextField();
		JTextField CSD = new JTextField();
		JTextField CED = new JTextField();
		JPanel pn1 = new JPanel();
		JPanel pn2 = new JPanel();
			
		ci.getCheckInData(BN, name, surname, rid1, rid2, rid3, CSD, CED, pn1, pn2);
		
		assertNotNull("Textfield 'name' is not null.", name.getText());
		assertNotNull("Textfield 'surname' is not null.", surname.getText());
		assertNotNull("Textfield 'rid1' is not null.", rid1.getText());
		assertNotNull("Textfield 'rid2' is not null.", rid2.getText());
		assertNotNull("Textfield 'rid3' is not null.", rid3.getText());
		assertNotNull("Textfield 'CSD' is not null.", CSD.getText());
		assertNotNull("Textfield 'CED' is not null.", CED.getText());
		assertNotNull("Textfield 'BN' is not null.", BN.getText());
		
		SQLconnection c = new SQLconnection();
		c.StartConnection();
		
		try {
			
			String bookingInfoSql = String.format("select BookingNum from BookingData");		
			PreparedStatement sql = c.connect.prepareStatement(bookingInfoSql);
			ResultSet rsq = sql.executeQuery();
			
			List<String> ids = new ArrayList();
			while (rsq.next()) {
			  ids.add(rsq.getString("BookingNum"));
			}
			
			assertTrue(ids.contains(BN.getText()));
			
		}
		
		catch(Exception exr){
			exr.printStackTrace();
			JOptionPane.showMessageDialog(null, "Please enter a valid booking number!");
		}

		finally{
			c.endConnection(); 
		}
				
	}

	/**
	 * Test method for {@link src_test.CheckIn#confirmCheckIn(javax.swing.JTextField, javax.swing.JCheckBox)}.
	 */
	@Test
	public final void testConfirmCheckIn() {
		
		CheckIn ci = new CheckIn();
		
		

		
	}

}
