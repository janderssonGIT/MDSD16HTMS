package src_test;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.TextStyle;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
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
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import src_test.Room;

import com.toedter.calendar.JCalendar;

import javax.swing.UIManager;

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
	JTable table;
	JLabel lblRoomID;
	JTextField textID;
	JLabel lblFloor;
	JTextField textPrice;
	JTextField textFloor;
	JComboBox<String[]> comboRoomType;
	JCheckBox chckbxStatus;
	public JScrollPane scrollPane;
	private JPanel bookingSelections;
	private JPanel bookingSearchRes;
	private JPanel bookingCinfo;
	private JPanel bookingSummary;
	private JTextField textFieldBookSD;
	private JTextField textFieldBookED;
	private JTextField textFieldBookGuestNum;
	private JTable table_1;
	String[] roomTypes;
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
		childBooking.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Booking", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		childBooking.setBackground(Color.LIGHT_GRAY);
		contentParent.add(childBooking, "name_5484551631872");
		childBooking.setVisible(false);
		
		childCheckIn = new JPanel();
		childCheckIn.setBorder(new TitledBorder(null, "Check in", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		childCheckIn.setBackground(Color.LIGHT_GRAY);
		contentParent.add(childCheckIn, "name_5562293233879");
		childCheckIn.setLayout(null);
		childCheckIn.setVisible(false);
		
		childCheckOut = new JPanel();
		childCheckOut.setBorder(new TitledBorder(null, "Check out", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		childCheckOut.setBackground(Color.LIGHT_GRAY);
		contentParent.add(childCheckOut, "name_5566590524065");
		childCheckOut.setLayout(null);
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
		childBegin.setVisible(true);
		
		JPanel panelAddRooms = new JPanel();
		panelAddRooms.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Add Room", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, Color.DARK_GRAY));
		panelAddRooms.setBackground(Color.LIGHT_GRAY);
		panelAddRooms.setBounds(10, 231, 487, 331);
		childEditRooms.add(panelAddRooms);
		
		lblRoomID = new JLabel("Room ID:");
		lblRoomID.setBounds(16, 32, 95, 14);
		
		textID = new JTextField();
		textID.setBounds(121, 29, 86, 20);
		textID.setColumns(10);
		
		lblFloor = new JLabel("Floor:");
		lblFloor.setBounds(16, 59, 95, 14);
		
		comboRoomType = new JComboBox();
		roomTypes = new String[] {"Single", "Double", "Suite", "Dual Single", "Triple Single", "Family"};
		comboRoomType.setModel(new DefaultComboBoxModel(roomTypes));
		comboRoomType.setBounds(121, 83, 86, 22);
		
		JLabel lblNewLabel = new JLabel("Status:");
		lblNewLabel.setBounds(255, 32, 69, 14);
		
		JLabel lblPrice = new JLabel("Price per night:");
		lblPrice.setBounds(255, 59, 99, 14);
		
		textPrice = new JTextField();
		textPrice.setBounds(385, 56, 86, 20);
		textPrice.setColumns(10);
		
		chckbxStatus = new JCheckBox("Occupied");
		chckbxStatus.setEnabled(false);
		chckbxStatus.setBackground(Color.LIGHT_GRAY);
		chckbxStatus.setBounds(385, 28, 86, 23);
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
		textFloor.setBounds(153, 56, 54, 20);
		panelAddRooms.add(textFloor);
		textFloor.setColumns(10);
		
		JLabel lblRoomType = new JLabel("Room type:");
		lblRoomType.setBounds(16, 87, 86, 14);
		panelAddRooms.add(lblRoomType);
		//*****************************
		btnCreate=new JButton("Create");
		
		btnCreate.setBounds(382, 297, 89, 23);
		panelAddRooms.add(btnCreate);
		
		btnUpdate = new JButton("Update");		
		btnUpdate.setBounds(382, 266, 89, 23);
		panelAddRooms.add(btnUpdate);
				
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
		btnEditRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnEditRooms.setBounds(0, 69, 127, 23);
		childMenu.add(btnEditRooms);		
		childBooking.setLayout(new CardLayout(0, 0));
		
		bookingSelections = new JPanel();
		bookingSelections.setBackground(Color.LIGHT_GRAY);
		childBooking.add(bookingSelections, "name_362396983654753");
		bookingSelections.setLayout(null);
		
		JLabel lblStartDate = new JLabel("Start date:");
		lblStartDate.setBounds(20, 11, 79, 14);
		bookingSelections.add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End date:");
		lblEndDate.setBounds(20, 36, 79, 14);
		bookingSelections.add(lblEndDate);
		
		JLabel lblNumberOfRooms = new JLabel("Number of Rooms:");
		lblNumberOfRooms.setBounds(20, 61, 102, 14);
		bookingSelections.add(lblNumberOfRooms);
		
		textFieldBookSD = new JTextField();
		textFieldBookSD.setToolTipText("YYYY-MM-DD");
		textFieldBookSD.setBounds(139, 8, 86, 20);
		bookingSelections.add(textFieldBookSD);
		textFieldBookSD.setColumns(10);
		
		textFieldBookED = new JTextField();
		textFieldBookED.setToolTipText("YYYY-MM-DD");
		textFieldBookED.setBounds(139, 33, 86, 20);
		bookingSelections.add(textFieldBookED);
		textFieldBookED.setColumns(10);
		
		JComboBox comboBoxBookNumRooms = new JComboBox();
		comboBoxBookNumRooms.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBoxBookNumRooms.setBounds(189, 58, 36, 20);
		bookingSelections.add(comboBoxBookNumRooms);
		
		JButton btnSearchButton = new JButton("Search");
		btnSearchButton.setBounds(652, 517, 89, 23);
		bookingSelections.add(btnSearchButton);
		
		JButton btnBookingCancel1 = new JButton("Cancel");
		btnBookingCancel1.setBounds(556, 517, 89, 23);
		bookingSelections.add(btnBookingCancel1);
		
		JLabel lblNumberOfGuests = new JLabel("Number of guests");
		lblNumberOfGuests.setBounds(20, 86, 102, 14);
		bookingSelections.add(lblNumberOfGuests);
		
		textFieldBookGuestNum = new JTextField();
		textFieldBookGuestNum.setBounds(189, 83, 36, 20);
		bookingSelections.add(textFieldBookGuestNum);
		textFieldBookGuestNum.setColumns(10);
		
		JLabel lblyyyymmdd = new JLabel("(YYYY-MM-DD)");
		lblyyyymmdd.setBounds(235, 11, 86, 14);
		bookingSelections.add(lblyyyymmdd);
		
		JLabel label = new JLabel("(YYYY-MM-DD)");
		label.setBounds(235, 36, 86, 14);
		bookingSelections.add(label);
		
		bookingSearchRes = new JPanel();
		bookingSearchRes.setBackground(Color.LIGHT_GRAY);
		childBooking.add(bookingSearchRes, "name_362401980778775");
		bookingSearchRes.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(56, 59, 645, 237);
		bookingSearchRes.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(652, 517, 89, 23);
		bookingSearchRes.add(btnConfirm);
		
		JButton btnCancel_1 = new JButton("Cancel");
		btnCancel_1.setBounds(553, 517, 89, 23);
		bookingSearchRes.add(btnCancel_1);
		
		bookingCinfo = new JPanel();
		bookingCinfo.setBackground(Color.LIGHT_GRAY);
		childBooking.add(bookingCinfo, "name_362405422276297");
		bookingCinfo.setLayout(null);
		
		bookingSummary = new JPanel();
		bookingSummary.setBackground(Color.LIGHT_GRAY);
		childBooking.add(bookingSummary, "name_362408729838843");
		bookingSummary.setLayout(null);
		
		btnDone2 = new JButton("Done");
		btnDone2.setBounds(680, 539, 73, 23);
		childCheckIn.add(btnDone2);
		childCheckIn.setVisible(false);		
		
		btnDone3 = new JButton("Done");
		btnDone3.setBounds(680, 540, 73, 23);
		childCheckOut.add(btnDone3);
		childCheckOut.setVisible(false);
		
		btnDone4 = new JButton("Cancel");
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
		
		JButton btnCancel = new JButton("Save & Return");
		btnCancel.setBounds(548, 539, 119, 23);
		childEditRooms.add(btnCancel);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(0, 550, 127, 23);
		childMenu.add(btnExit);			
		
		JButton btnEditTab = new JButton("Edit Tab");
		btnEditTab.setBounds(0, 92, 127, 23);
		childMenu.add(btnEditTab);
	}
	
	public void eventHandler() {

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
			}
		});
		//Go to Check In
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
		//Done - Check In (Returns to Main menu)
		btnDone2.addActionListener(new ActionListener() {
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
}
