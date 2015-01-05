package src_test;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import src_test.Room;
import com.toedter.calendar.JCalendar;
import javax.swing.JTextPane;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Font;

public class Interface {
	
	JFrame frmAlpha;
	JPanel contentParent;
	JPanel menuParent;
	JPanel childMenu;
	JPanel childBooking;
	JPanel childCheckOut;
	JPanel childCheckIn;
	JPanel childEditRooms;
	JPanel childBegin;
	JButton btnCheckIn;
	JButton btnCheckOut;
	JButton btnBooking;
	JButton btnEditRooms;
	JButton btnExit;
	JButton btnDone2;
	JButton btnDone3;
	JButton btnDone4; 
	JButton btnCreate;
	JButton btnDelete;
	JButton btnUpdate;
	JButton btnBookingCancel1;
	JButton btnSearchButton;
	JButton btnBookCancel_1;
	JButton btnBookConfirm;
	JButton btnBookCancel_2;
	JButton btnValidate;
	JButton btnDoneBooking;
	JButton btnCINCancel;
	JButton btnCOUTCancel;
	JButton btnCINcontinue;
	JTable table;
	JLabel lblRoomID;
	JLabel lblRoomI;
	JLabel lblRoomII;
	JLabel lblRoomIII;
	JLabel lblFloor;
	JTextField textID;
	JTextField textPrice;
	JTextField textFloor;
	JComboBox<String[]> comboRoomType;
	JComboBox<String[]> comboBoxBookNumRooms;
	JComboBox comboBoxRI;
	JComboBox comboBoxRII;
	JComboBox comboBoxRIII;
	JCheckBox chckbxStatus;
	JComboBox comboBoxYY;
	JComboBox comboBoxMM;
	JCalendar calendar1;
	JCalendar calendar2;
	JTextPane textPaneDate1;
	JTextPane textPaneDate2;
	public JScrollPane scrollPane;
	JPanel bookingSelections;
	private JPanel bookingSearchRes;
	private JPanel bookingCinfo;
	private JPanel bookingSummary;
	private JTable table_1;
	String[] roomTypes;
	private JTextField textField;
	private JTable table_2;
	private JTable table_3;
	private JLabel lblSelection;
	private JLabel lblSearchResults;
	private JPanel panelCIN_input;
	private JPanel panelCIN_confirm;
	private JPanel panelCOUT_input;
	private JPanel panelCOUT_summary;
	private JPanel panelCOUT_payment;
	protected JTextField textField_name;
	protected JTextField textField_surname;
	protected JTextField textField_BNV;
	protected JTextField textField_cardNum;
	protected JTextField textField_1;
	protected JTextField textField_2;
	protected JTextField textField_3;
	protected JTextField textField_4;
	protected JTextField textField_5;
	protected JTextField textField_6;
	protected JTextField textField_7;
	protected JTextField textField_8;
	private JTextField textFieldCIN;
	private JLabel lblHotelManagementSystem;
	private JTextField textFieldCOUT;
	private JTextField ConfirmName;
	private JTextField ConfirmSurName;
	private JTextField ConfirmEndDate;
	private JTextField ConfirmStartDate;
	private JTextField rid1;
	private JTextField rid2;
	private JTextField rid3;
	JCheckBox chckbxConfirmCheckin;
	/**
	 * @wbp.parser.entryPoint
	 */
	
	protected void initializeUI() {
		frmAlpha = new JFrame();
		frmAlpha.setTitle("HMS Alpha v0.1");
		frmAlpha.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmAlpha.setBounds(100, 100, 928, 622);
		frmAlpha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlpha.getContentPane().setLayout(null);
		
		menuParent = new JPanel();
		menuParent.setBackground(Color.LIGHT_GRAY);
		menuParent.setBounds(10, 11, 127, 573);
		frmAlpha.getContentPane().add(menuParent);
		menuParent.setLayout(new CardLayout(0, 0));
		
		contentParent = new JPanel();
		contentParent.setBackground(SystemColor.desktop);
		contentParent.setBounds(147, 11, 763, 573);
		frmAlpha.getContentPane().add(contentParent);
		contentParent.setLayout(new CardLayout(0, 0));
		
		childMenu = new JPanel();
		childMenu.setBackground(new Color(95, 158, 160));
		menuParent.add(childMenu, "name_5598457223351");
		childMenu.setLayout(null);
		
		childBooking = new JPanel();
		childBooking.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Booking ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		childBooking.setBackground(Color.LIGHT_GRAY);
		contentParent.add(childBooking, "name_5484551631872");
		childBooking.setVisible(false);
		
		childCheckIn = new JPanel();
		childCheckIn.setBorder(new TitledBorder(null, "Check in", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		childCheckIn.setBackground(Color.LIGHT_GRAY);
		contentParent.add(childCheckIn, "name_5562293233879");
		childCheckIn.setLayout(new CardLayout(0, 0));
		
		panelCIN_input = new JPanel();
		panelCIN_input.setBackground(Color.LIGHT_GRAY);
		panelCIN_input.setForeground(Color.LIGHT_GRAY);
		childCheckIn.add(panelCIN_input, "name_56098983988884");
		panelCIN_input.setLayout(null);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the booking number:");
		lblPleaseEnterThe.setBounds(45, 52, 195, 14);
		panelCIN_input.add(lblPleaseEnterThe);
		
		textFieldCIN = new JTextField();
		textFieldCIN.setBounds(239, 49, 86, 20);
		panelCIN_input.add(textFieldCIN);
		textFieldCIN.setColumns(10);
		
		btnCINcontinue = new JButton("Continue");
		btnCINcontinue.setBounds(652, 516, 89, 23);
		panelCIN_input.add(btnCINcontinue);
		
		btnCINCancel = new JButton("Cancel");
		btnCINCancel.setBounds(553, 516, 89, 23);
		panelCIN_input.add(btnCINCancel);
		
		panelCIN_confirm = new JPanel();
		panelCIN_confirm.setBackground(Color.LIGHT_GRAY);
		childCheckIn.add(panelCIN_confirm, "name_56292173208666");
		panelCIN_confirm.setLayout(null);
		
		btnDone2 = new JButton("Done");
		btnDone2.setBounds(665, 516, 76, 23);
		panelCIN_confirm.add(btnDone2);
		
		JLabel label_2 = new JLabel("Name:");
		label_2.setBounds(34, 40, 106, 14);
		panelCIN_confirm.add(label_2);
		
		JLabel label_3 = new JLabel("Surname:");
		label_3.setBounds(34, 65, 106, 14);
		panelCIN_confirm.add(label_3);
		
		ConfirmName = new JTextField();
		ConfirmName.setEditable(false);
		ConfirmName.setColumns(10);
		ConfirmName.setBackground(Color.LIGHT_GRAY);
		ConfirmName.setBounds(162, 40, 111, 20);
		panelCIN_confirm.add(ConfirmName);
		
		ConfirmSurName = new JTextField();
		ConfirmSurName.setEditable(false);
		ConfirmSurName.setColumns(10);
		ConfirmSurName.setBackground(Color.LIGHT_GRAY);
		ConfirmSurName.setBounds(162, 65, 111, 20);
		panelCIN_confirm.add(ConfirmSurName);
		
		JLabel lblRoomid = new JLabel("RoomID");
		lblRoomid.setBounds(34, 154, 106, 14);
		panelCIN_confirm.add(lblRoomid);
		
		JLabel label_5 = new JLabel("Start date:");
		label_5.setBounds(34, 179, 151, 14);
		panelCIN_confirm.add(label_5);
		
		JLabel label_6 = new JLabel("End date:");
		label_6.setBounds(34, 204, 106, 14);
		panelCIN_confirm.add(label_6);
		
		ConfirmEndDate = new JTextField();
		ConfirmEndDate.setEditable(false);
		ConfirmEndDate.setColumns(10);
		ConfirmEndDate.setBackground(Color.LIGHT_GRAY);
		ConfirmEndDate.setBounds(162, 204, 145, 20);
		panelCIN_confirm.add(ConfirmEndDate);
		
		ConfirmStartDate = new JTextField();
		ConfirmStartDate.setEditable(false);
		ConfirmStartDate.setColumns(10);
		ConfirmStartDate.setBackground(Color.LIGHT_GRAY);
		ConfirmStartDate.setBounds(162, 179, 145, 20);
		panelCIN_confirm.add(ConfirmStartDate);
		
		rid1 = new JTextField();
		rid1.setEditable(false);
		rid1.setColumns(10);
		rid1.setBackground(Color.LIGHT_GRAY);
		rid1.setBounds(161, 148, 86, 20);
		panelCIN_confirm.add(rid1);
		
		rid2 = new JTextField();
		rid2.setEditable(false);
		rid2.setColumns(10);
		rid2.setBackground(Color.LIGHT_GRAY);
		rid2.setBounds(280, 148, 86, 20);
		panelCIN_confirm.add(rid2);
		
		rid3 = new JTextField();
		rid3.setEditable(false);
		rid3.setColumns(10);
		rid3.setBackground(Color.LIGHT_GRAY);
		rid3.setBounds(388, 148, 86, 20);
		panelCIN_confirm.add(rid3);
		
		chckbxConfirmCheckin = new JCheckBox("Confirm check-in.");
		chckbxConfirmCheckin.setBackground(Color.LIGHT_GRAY);
		chckbxConfirmCheckin.setBounds(482, 516, 151, 23);
		panelCIN_confirm.add(chckbxConfirmCheckin);
		childCheckIn.setVisible(false);
		
		childCheckOut = new JPanel();
		childCheckOut.setBorder(new TitledBorder(null, "Check out", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		childCheckOut.setBackground(Color.LIGHT_GRAY);
		contentParent.add(childCheckOut, "name_5566590524065");
		childCheckOut.setLayout(new CardLayout(0, 0));
		
		panelCOUT_input = new JPanel();
		panelCOUT_input.setBackground(Color.LIGHT_GRAY);
		childCheckOut.add(panelCOUT_input, "name_56451217707001");
		panelCOUT_input.setLayout(null);
		
		JLabel label_1 = new JLabel("Please enter the booking number:");
		label_1.setBounds(52, 49, 195, 14);
		panelCOUT_input.add(label_1);
		
		textFieldCOUT = new JTextField();
		textFieldCOUT.setColumns(10);
		textFieldCOUT.setBounds(246, 46, 86, 20);
		panelCOUT_input.add(textFieldCOUT);
		
		JButton btnCOUTcontinue = new JButton("Continue");
		btnCOUTcontinue.setBounds(652, 516, 89, 23);
		panelCOUT_input.add(btnCOUTcontinue);
		
		btnCOUTCancel = new JButton("Cancel");
		btnCOUTCancel.setBounds(553, 516, 89, 23);
		panelCOUT_input.add(btnCOUTCancel);
		
		panelCOUT_summary = new JPanel();
		panelCOUT_summary.setBackground(Color.LIGHT_GRAY);
		childCheckOut.add(panelCOUT_summary, "name_56455242071996");
		panelCOUT_summary.setLayout(null);
		
		panelCOUT_payment = new JPanel();
		panelCOUT_payment.setBackground(Color.LIGHT_GRAY);
		childCheckOut.add(panelCOUT_payment, "name_56514071763250");
		panelCOUT_payment.setLayout(null);
		
		btnDone3 = new JButton("Done");
		btnDone3.setBounds(668, 516, 73, 23);
		panelCOUT_payment.add(btnDone3);
		childCheckOut.setVisible(false);
		
		childEditRooms = new JPanel();
		childEditRooms.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Edit Rooms", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		childEditRooms.setBackground(Color.LIGHT_GRAY);
		contentParent.add(childEditRooms, "name_5577380246129");
		childEditRooms.setLayout(null);
		childEditRooms.setVisible(false);
		
		childBegin = new JPanel();
		childBegin.setBackground(Color.LIGHT_GRAY);
		contentParent.add(childBegin, "name_8144873569318");
		childBegin.setLayout(null);
		
		lblHotelManagementSystem = new JLabel("HOTEL MANAGEMENT SYSTEM v1.0");
		lblHotelManagementSystem.setForeground(Color.DARK_GRAY);
		lblHotelManagementSystem.setFont(new Font("Tahoma", Font.ITALIC, 37));
		lblHotelManagementSystem.setBounds(88, 51, 665, 64);
		childBegin.add(lblHotelManagementSystem);
		childBegin.setVisible(true);
		
		JPanel panelAddRooms = new JPanel();
		panelAddRooms.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Add Room/Update Room", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(64, 64, 64)));
		panelAddRooms.setBackground(Color.LIGHT_GRAY);
		panelAddRooms.setBounds(10, 231, 487, 331);
		childEditRooms.add(panelAddRooms);
		
		lblRoomID = new JLabel("Room ID:");
		lblRoomID.setBounds(16, 32, 95, 14);
		
		textID = new JTextField();
		textID.setBounds(131, 29, 86, 20);
		textID.setColumns(10);
		
		lblFloor = new JLabel("Floor:");
		lblFloor.setBounds(16, 59, 95, 14);
		
		comboRoomType = new JComboBox();
		roomTypes = new String[] {"Single", "Double", "Suite", "Dual Single", "Triple Single", "Family"};
		comboRoomType.setModel(new DefaultComboBoxModel(roomTypes));
		comboRoomType.setBounds(131, 83, 86, 22);
		
		JLabel lblNewLabel = new JLabel("Status:");
		lblNewLabel.setBounds(16, 112, 69, 14);
		
		JLabel lblPrice = new JLabel("Price per night:");
		lblPrice.setBounds(16, 137, 99, 14);
		
		textPrice = new JTextField();
		textPrice.setBounds(131, 134, 86, 20);
		textPrice.setColumns(10);
		
		chckbxStatus = new JCheckBox("Occupied");
		chckbxStatus.setEnabled(false);
		chckbxStatus.setBackground(Color.LIGHT_GRAY);
		chckbxStatus.setBounds(131, 108, 86, 23);
		panelAddRooms.setLayout(null);
		panelAddRooms.add(textPrice);
		panelAddRooms.add(chckbxStatus);
		panelAddRooms.add(comboRoomType);
		panelAddRooms.add(lblFloor);
		panelAddRooms.add(lblRoomID);
		panelAddRooms.add(textID);
		panelAddRooms.add(lblPrice);
		panelAddRooms.add(lblNewLabel);
		
		textFloor = new JTextField();
		textFloor.setBounds(163, 56, 54, 20);
		panelAddRooms.add(textFloor);
		textFloor.setColumns(10);
		
		JLabel lblRoomType = new JLabel("Room type:");
		lblRoomType.setBounds(16, 87, 86, 14);
		panelAddRooms.add(lblRoomType);
		btnCreate=new JButton("Create");
		
		btnCreate.setBounds(382, 297, 89, 23);
		panelAddRooms.add(btnCreate);
		
		btnUpdate = new JButton("Update");		
		btnUpdate.setBounds(382, 266, 89, 23);
		panelAddRooms.add(btnUpdate);
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setBounds(16, 165, 95, 14);
		panelAddRooms.add(lblCapacity);
		
		textField = new JTextField();
		textField.setBounds(182, 162, 35, 20);
		panelAddRooms.add(textField);
		textField.setColumns(10);
		
		JLabel lblinteger = new JLabel("(ex: 3)");
		lblinteger.setForeground(Color.GRAY);
		lblinteger.setBounds(227, 32, 69, 14);
		panelAddRooms.add(lblinteger);
		
		JLabel lbldouble = new JLabel("(ex: 200.00)");
		lbldouble.setForeground(Color.GRAY);
		lbldouble.setBounds(227, 137, 69, 14);
		panelAddRooms.add(lbldouble);
		
		JLabel lblex = new JLabel("(ex: 8)");
		lblex.setForeground(Color.GRAY);
		lblex.setBounds(227, 59, 69, 14);
		panelAddRooms.add(lblex);
		
		JLabel lblex_1 = new JLabel("(ex: 2)");
		lblex_1.setForeground(Color.GRAY);
		lblex_1.setBounds(227, 165, 69, 14);
		panelAddRooms.add(lblex_1);
				
		btnBooking = new JButton("New Booking");
		btnBooking.setBounds(0, 0, 127, 23);
		childMenu.add(btnBooking);
		
		btnCheckIn = new JButton("Check in");
		btnCheckIn.setBounds(0, 23, 127, 23);
		childMenu.add(btnCheckIn);
		
		btnCheckOut = new JButton("Check out");
		btnCheckOut.setBounds(0, 46, 127, 23);
		childMenu.add(btnCheckOut);		
		
		btnEditRooms = new JButton("Edit Rooms");
		btnEditRooms.setBounds(0, 69, 127, 23);
		childMenu.add(btnEditRooms);		
		childBooking.setLayout(new CardLayout(0, 0));
		
		bookingSelections = new JPanel();
		bookingSelections.setBackground(Color.LIGHT_GRAY);
		childBooking.add(bookingSelections, "name_362396983654753");
		bookingSelections.setLayout(null);
		
		JLabel lblStartDate = new JLabel("Start date:");
		lblStartDate.setForeground(Color.DARK_GRAY);
		lblStartDate.setBounds(10, 192, 79, 14);
		bookingSelections.add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End date:");
		lblEndDate.setForeground(Color.DARK_GRAY);
		lblEndDate.setBounds(240, 192, 79, 14);
		bookingSelections.add(lblEndDate);
		
		JLabel lblNumberOfRooms = new JLabel("Number of Rooms:");
		lblNumberOfRooms.setBounds(20, 266, 127, 14);
		bookingSelections.add(lblNumberOfRooms);
		
		comboBoxBookNumRooms = new JComboBox();
		comboBoxBookNumRooms.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		comboBoxBookNumRooms.setBounds(172, 263, 36, 20);
		bookingSelections.add(comboBoxBookNumRooms);
		
		btnSearchButton = new JButton("Search");
		btnSearchButton.setBounds(652, 517, 89, 23);
		bookingSelections.add(btnSearchButton);
		
		btnBookingCancel1 = new JButton("Cancel");
		btnBookingCancel1.setBounds(556, 517, 89, 23);
		bookingSelections.add(btnBookingCancel1);
		
		calendar1 = new JCalendar();
		calendar1.setBounds(10, 27, 198, 153);
		bookingSelections.add(calendar1);
		
		calendar2 = new JCalendar();
		calendar2.setBounds(240, 27, 198, 153);
		calendar2.setDate(Date.from(LocalDateTime.now().plusDays(1).atZone(ZoneId.systemDefault()).toInstant()));
		bookingSelections.add(calendar2);
		
		JLabel lblmax = new JLabel("(max 3)");
		lblmax.setForeground(Color.DARK_GRAY);
		lblmax.setBounds(218, 266, 46, 14);
		bookingSelections.add(lblmax);
		
		lblRoomI = new JLabel("Room I");
		lblRoomI.setForeground(Color.DARK_GRAY);
		lblRoomI.setBounds(20, 295, 79, 14);
		bookingSelections.add(lblRoomI);
		
		lblRoomII = new JLabel("Room II");
		lblRoomII.setForeground(Color.DARK_GRAY);
		lblRoomII.setBounds(20, 320, 79, 14);
		bookingSelections.add(lblRoomII);
		
		lblRoomIII = new JLabel("Room III");
		lblRoomIII.setForeground(Color.DARK_GRAY);
		lblRoomIII.setBounds(20, 345, 79, 14);
		bookingSelections.add(lblRoomIII);
		
		comboBoxRI = new JComboBox();
		comboBoxRI.setModel(new DefaultComboBoxModel(new String[] {"Single", "Double", "Suite", "Dual Single", "Triple Single", "Family"}));
		comboBoxRI.setBounds(137, 292, 127, 20);
		bookingSelections.add(comboBoxRI);
		
		comboBoxRII = new JComboBox();
		comboBoxRII.setModel(new DefaultComboBoxModel(new String[] {"Single", "Double", "Suite", "Dual Single", "Triple Single", "Family"}));
		comboBoxRII.setEnabled(false);
		comboBoxRII.setBounds(137, 317, 127, 20);
		bookingSelections.add(comboBoxRII);
		
		comboBoxRIII = new JComboBox();
		comboBoxRIII.setModel(new DefaultComboBoxModel(new String[] {"Single", "Double", "Suite", "Dual Single", "Triple Single", "Family"}));
		comboBoxRIII.setEnabled(false);
		comboBoxRIII.setBounds(137, 342, 127, 20);
		bookingSelections.add(comboBoxRIII);
		
		textPaneDate1 = new JTextPane();
		textPaneDate1.setEditable(false);
		textPaneDate1.setBounds(92, 186, 116, 20);
		bookingSelections.add(textPaneDate1);
		
		textPaneDate2 = new JTextPane();
		textPaneDate2.setEditable(false);
		textPaneDate2.setBounds(322, 186, 116, 20);
		bookingSelections.add(textPaneDate2);
		
		lblSelection = new JLabel("Selections - 1/4");
		lblSelection.setBounds(10, 526, 89, 14);
		bookingSelections.add(lblSelection);
		
		bookingSearchRes = new JPanel();
		bookingSearchRes.setBackground(Color.LIGHT_GRAY);
		childBooking.add(bookingSearchRes, "name_362401980778775");
		bookingSearchRes.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 34, 731, 39);
		bookingSearchRes.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		btnBookConfirm = new JButton("Confirm");
		btnBookConfirm.setBounds(652, 517, 89, 23);
		bookingSearchRes.add(btnBookConfirm);
		
		btnBookCancel_1 = new JButton("Back");
		btnBookCancel_1.setBounds(553, 517, 89, 23);
		bookingSearchRes.add(btnBookCancel_1);
		
		JLabel lblRoomSearch1 = new JLabel("Room I");
		lblRoomSearch1.setBounds(10, 11, 46, 14);
		bookingSearchRes.add(lblRoomSearch1);
		
		JLabel lblRoomIi = new JLabel("Room II");
		lblRoomIi.setBounds(10, 88, 46, 14);
		bookingSearchRes.add(lblRoomIi);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 113, 731, 39);
		bookingSearchRes.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		JLabel lblRoomIii = new JLabel("Room III");
		lblRoomIii.setBounds(10, 167, 46, 14);
		bookingSearchRes.add(lblRoomIii);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 192, 731, 39);
		bookingSearchRes.add(scrollPane_3);
		
		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);
		
		lblSearchResults = new JLabel("Search Results - 2/4");
		lblSearchResults.setBounds(10, 526, 151, 14);
		bookingSearchRes.add(lblSearchResults);
		
		bookingCinfo = new JPanel();
		bookingCinfo.setBackground(Color.LIGHT_GRAY);
		childBooking.add(bookingCinfo, "name_362405422276297");
		bookingCinfo.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 11, 93, 14);
		bookingCinfo.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(10, 36, 93, 14);
		bookingCinfo.add(lblSurname);
		
		textField_name = new JTextField();
		textField_name.setBounds(167, 8, 116, 19);
		bookingCinfo.add(textField_name);
		textField_name.setColumns(10);
		
		textField_surname = new JTextField();
		textField_surname.setColumns(10);
		textField_surname.setBounds(167, 33, 116, 19);
		bookingCinfo.add(textField_surname);
		
		JLabel lblCardNumber = new JLabel("Card number:");
		lblCardNumber.setBounds(10, 149, 93, 14);
		bookingCinfo.add(lblCardNumber);
		
		JLabel lblNewLabel_1 = new JLabel("Expiration date (MM / YY):");
		lblNewLabel_1.setBounds(10, 199, 146, 14);
		bookingCinfo.add(lblNewLabel_1);
		
		JLabel lblBnvNumber = new JLabel("BNV number:");
		lblBnvNumber.setBounds(10, 224, 93, 14);
		bookingCinfo.add(lblBnvNumber);
		
		textField_BNV = new JTextField();
		textField_BNV.setBounds(231, 221, 61, 20);
		bookingCinfo.add(textField_BNV);
		textField_BNV.setColumns(10);
		
		textField_cardNum = new JTextField();
		textField_cardNum.setColumns(10);
		textField_cardNum.setBounds(131, 146, 161, 20);
		bookingCinfo.add(textField_cardNum);
		
		comboBoxYY = new JComboBox();
		comboBoxYY.setModel(new DefaultComboBoxModel(new String[] {"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"}));
		comboBoxYY.setBounds(246, 196, 46, 20);
		bookingCinfo.add(comboBoxYY);
		
		JLabel label = new JLabel("/");
		label.setBounds(231, 199, 18, 14);
		bookingCinfo.add(label);
		
		comboBoxMM = new JComboBox();
		comboBoxMM.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBoxMM.setBounds(177, 196, 44, 20);
		bookingCinfo.add(comboBoxMM);
		
		JLabel lblCustomerDetails = new JLabel("Customer details - 3/4");
		lblCustomerDetails.setBounds(5, 526, 151, 14);
		bookingCinfo.add(lblCustomerDetails);
		
		btnValidate = new JButton("Confirm");
		btnValidate.setBounds(652, 522, 89, 23);
		bookingCinfo.add(btnValidate);
		
		btnBookCancel_2 = new JButton("Back");
		btnBookCancel_2.setBounds(553, 522, 89, 23);
		bookingCinfo.add(btnBookCancel_2);
		
		bookingSummary = new JPanel();
		bookingSummary.setBackground(Color.LIGHT_GRAY);
		childBooking.add(bookingSummary, "name_362408729838843");
		bookingSummary.setLayout(null);
		
		btnDoneBooking = new JButton("Done");
		btnDoneBooking.setBounds(652, 517, 89, 23);
		bookingSummary.add(btnDoneBooking);
		
		JLabel lblSummary = new JLabel("Summary - 4/4");
		lblSummary.setBounds(10, 526, 151, 14);
		bookingSummary.add(lblSummary);
		
		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setBounds(10, 60, 106, 14);
		bookingSummary.add(lblName_1);
		
		JLabel lblSurname_1 = new JLabel("Surname:");
		lblSurname_1.setBounds(10, 85, 106, 14);
		bookingSummary.add(lblSurname_1);
		
		JLabel lblNewLabel_2 = new JLabel("Roomtype(s):");
		lblNewLabel_2.setBounds(10, 174, 106, 14);
		bookingSummary.add(lblNewLabel_2);
		
		JLabel lblStartDate_1 = new JLabel("Start date:");
		lblStartDate_1.setBounds(10, 199, 151, 14);
		bookingSummary.add(lblStartDate_1);
		
		JLabel lblEndDate_1 = new JLabel("End date:");
		lblEndDate_1.setBounds(10, 224, 106, 14);
		bookingSummary.add(lblEndDate_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setBounds(138, 60, 111, 20);
		bookingSummary.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBackground(Color.LIGHT_GRAY);
		textField_2.setColumns(10);
		textField_2.setBounds(138, 85, 111, 20);
		bookingSummary.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBackground(Color.LIGHT_GRAY);
		textField_3.setColumns(10);
		textField_3.setBounds(137, 168, 86, 20);
		bookingSummary.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBackground(Color.LIGHT_GRAY);
		textField_4.setColumns(10);
		textField_4.setBounds(233, 168, 86, 20);
		bookingSummary.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBackground(Color.LIGHT_GRAY);
		textField_5.setColumns(10);
		textField_5.setBounds(329, 168, 86, 20);
		bookingSummary.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBackground(Color.LIGHT_GRAY);
		textField_6.setColumns(10);
		textField_6.setBounds(138, 199, 145, 20);
		bookingSummary.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBackground(Color.LIGHT_GRAY);
		textField_7.setColumns(10);
		textField_7.setBounds(138, 224, 145, 20);
		bookingSummary.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBackground(Color.LIGHT_GRAY);
		textField_8.setBounds(329, 397, 46, 20);
		bookingSummary.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblThisIsYour = new JLabel("This is your booking number, please save it:");
		lblThisIsYour.setBounds(70, 400, 249, 14);
		bookingSummary.add(lblThisIsYour);
		childCheckIn.setVisible(false);		
		childCheckOut.setVisible(false);
		
		btnDone4 = new JButton("Done");
		btnDone4.setBounds(677, 539, 76, 23);
		childEditRooms.add(btnDone4);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 743, 198);
		childEditRooms.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnDelete = new JButton("Delete Room");
		btnDelete.setBounds(639, 227, 114, 23);
		childEditRooms.add(btnDelete);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(0, 550, 127, 23);
		childMenu.add(btnExit);
	}
	//EDIT ROOMS EVENTHANDLERS
	public void eventHandlerEditRoom() {
		//Exitbutton
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		}); 
		//selectJTableRow
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Room r = new Room();
				r.editRoom(table, textID, textFloor, textPrice, comboRoomType, roomTypes, chckbxStatus);
			    
			}});	
		//Delete Room
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Room r = new Room();
				r.deleteRoom(table);
				r.showValues(table);		
			}
		});
		//Add Room
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				
				Room r = new Room();
				r.addRoom(table, textID, textFloor, textPrice, comboRoomType, chckbxStatus);
				r.showValues(table);
			}
		});
		//Update Room
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Room r = new Room();
				r.updateRoom(table, textID, textFloor, textPrice, comboRoomType, chckbxStatus);
				r.showValues(table);
			}
		});
		//Go to Check Out	
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				childBooking.setVisible(false);
				childCheckIn.setVisible(false);
				childCheckOut.setVisible(true);
				childBegin.setVisible(false);
				childEditRooms.setVisible(false);
				btnCheckIn.setEnabled(false);
				btnCheckOut.setEnabled(true);
				btnBooking.setEnabled(false);
				btnEditRooms.setEnabled(false);
				btnExit.setEnabled(false);
			}
		});
		//Go to Edit Rooms
		btnEditRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				childBooking.setVisible(false);
				childCheckIn.setVisible(false);
				childCheckOut.setVisible(false);
				childBegin.setVisible(false);
				childEditRooms.setVisible(true);
				btnCheckIn.setEnabled(false);
				btnCheckOut.setEnabled(false);
				btnBooking.setEnabled(false);
				btnEditRooms.setEnabled(true);
				btnExit.setEnabled(false);
				
				Room r = new Room();
				r.showValues(table);
		
				}	
			
		});
		//Done - Check Out (Returns to Main menu)
		btnDone3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditRooms.setEnabled(true);
				btnCheckIn.setEnabled(true);
				btnCheckOut.setEnabled(true);
				btnBooking.setEnabled(true);
				childBegin.setVisible(true);
				btnExit.setEnabled(true);
				childCheckOut.setVisible(false);
			}
		});
		//Done - Edit Rooms (Returns to Main menu)
		btnDone4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditRooms.setEnabled(true);
				btnCheckIn.setEnabled(true);
				btnCheckOut.setEnabled(true);
				btnBooking.setEnabled(true);
				childBegin.setVisible(true);
				btnExit.setEnabled(true);
				childEditRooms.setVisible(false);
			}
		});
					
	}
	//BOOOKING EVENTHANDLERS
	public void eventHandlerBooking() {
		//Go to Booking
		btnBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				childBooking.setVisible(true);
				childCheckIn.setVisible(false);
				childCheckOut.setVisible(false);
				childBegin.setVisible(false);
				childEditRooms.setVisible(false);
				btnCheckIn.setEnabled(false);
				btnCheckOut.setEnabled(false);
				btnBooking.setEnabled(true);
				btnEditRooms.setEnabled(false);
				btnExit.setEnabled(false);
						
				Booking b = new Booking();
				b.showDates(calendar1, calendar2, textPaneDate1, textPaneDate2);
						
			}			
		});
		//Searchrooms
		btnSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Booking b = new Booking();
				
				if (b.searchRooms(calendar1, calendar2, comboBoxBookNumRooms, comboBoxRI, comboBoxRII, comboBoxRIII)) {
									
					b.showResult(table_1, table_2, table_3, calendar1, calendar2, comboBoxRI, comboBoxRII, comboBoxRIII, bookingSelections, bookingSearchRes, bookingCinfo, bookingSummary);
									
				} else {
					JOptionPane.showMessageDialog(null, "Selected checkout date may not end within 24 hours of the start date!");
				}
														
			}
		});	
		//Return to Main from Booking
		btnBookingCancel1.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				btnEditRooms.setEnabled(true);
				btnCheckIn.setEnabled(true);
				btnCheckOut.setEnabled(true);
				btnBooking.setEnabled(true);
				childBegin.setVisible(true);
				btnExit.setEnabled(true);
				childBooking.setVisible(false);
			}
		});
		//Select number of Rooms
		comboBoxBookNumRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Booking b = new Booking();
				b.setNumOfRooms(comboBoxBookNumRooms, comboBoxRI, comboBoxRII, comboBoxRIII, lblFloor, lblFloor, lblFloor);
				
			}
		});		
		//Update selected date of JCalendar#1
		calendar1.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
				Booking b = new Booking();
				b.showDates(calendar1, calendar2, textPaneDate1, textPaneDate2);
			}
		});
		//Update selected date of JCalendar#2
		calendar2.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
				Booking b = new Booking();
				b.showDates(calendar1, calendar2, textPaneDate1, textPaneDate2);
			}
		});
		//2nd page "Back" -button.
		btnBookCancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				bookingSelections.setVisible(true);
				bookingSearchRes.setVisible(false);
				bookingCinfo.setVisible(false);
				bookingSummary.setVisible(false);
			}
		});
		//Confirm.button, 2nd page
		btnBookConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Booking b = new Booking();
				b.confirmRooms(bookingSelections, bookingSearchRes, bookingCinfo, bookingSummary);
			}
		});
		//3rd booking page "Back" -button
		btnBookCancel_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookingSelections.setVisible(false);
				bookingSearchRes.setVisible(true);
				bookingCinfo.setVisible(false);
				bookingSummary.setVisible(false);
			}
		});
		//Perform validation with the bank -if successful, save the booking with an associated bookingNumber, 
		//and create a customer tab with the associated bookingNumber. Print bookingNumber.
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Booking b = new Booking();
				b.bookingValidate(table_1, table_2, table_3, calendar1, calendar2, textField_name, textField_surname, textField_cardNum, 
						textField_BNV, comboBoxMM, comboBoxYY, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6, textField_7, textField_8);
				
				bookingSelections.setVisible(false);
				bookingSearchRes.setVisible(false);
				bookingCinfo.setVisible(false);
				bookingSummary.setVisible(true);
				
				JOptionPane.showMessageDialog(null, "Booking successful! Please save your booking-number.");
				
			}
		});		
		btnDoneBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnEditRooms.setEnabled(true);
				btnCheckIn.setEnabled(true);
				btnCheckOut.setEnabled(true);
				btnBooking.setEnabled(true);
				childBegin.setVisible(true);
				btnExit.setEnabled(true);
				childBooking.setVisible(false);
			}
		});
		
	}	
	//CHECKIN EVENTHANDLERS
	public void eventHandlerCheckIn() {
		
		btnCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				childBooking.setVisible(false);
				childCheckIn.setVisible(true);
				childCheckOut.setVisible(false);
				childBegin.setVisible(false);
				childEditRooms.setVisible(false);
				btnCheckIn.setEnabled(true);
				btnCheckOut.setEnabled(false);
				btnBooking.setEnabled(false);
				btnEditRooms.setEnabled(false);
				btnExit.setEnabled(false);
				panelCIN_input.setVisible(true);
			}
		});
		btnCINCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditRooms.setEnabled(true);
				btnCheckIn.setEnabled(true);
				btnCheckOut.setEnabled(true);
				btnBooking.setEnabled(true);
				childBegin.setVisible(true);
				btnExit.setEnabled(true);
				childCheckIn.setVisible(false);
			}
		});
		btnCINcontinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CheckIn ci = new CheckIn();
				ci.getCheckInData(textFieldCIN, ConfirmName, ConfirmSurName, rid1, rid2, rid3, ConfirmStartDate, ConfirmEndDate, panelCIN_input, panelCIN_confirm);
			}
		});
		btnDone2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditRooms.setEnabled(true);
				btnCheckIn.setEnabled(true);
				btnCheckOut.setEnabled(true);
				btnBooking.setEnabled(true);
				childBegin.setVisible(true);
				btnExit.setEnabled(true);
				childCheckIn.setVisible(false);
				panelCIN_input.setVisible(false);
				panelCIN_confirm.setVisible(false);
				
				CheckIn ci = new CheckIn();
				ci.confirmCheckIn(textFieldCIN, chckbxConfirmCheckin);
				
			}
		});

	}	
	//CHECKOUT EVENTHANDLERS
	public void eventHandlerCheckOut() {	
		btnCOUTCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditRooms.setEnabled(true);
				btnCheckIn.setEnabled(true);
				btnCheckOut.setEnabled(true);
				btnBooking.setEnabled(true);
				childBegin.setVisible(true);
				btnExit.setEnabled(true);
				childCheckOut.setVisible(false);
			}
		});		

	}
}
