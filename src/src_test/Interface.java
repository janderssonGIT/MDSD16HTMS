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
import java.sql.Statement;
import java.time.format.TextStyle;

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
	JButton btnDone1;
	JButton btnDone2;
	JButton btnDone3;
	JButton btnDone4; 
	JButton btnCreate;
	JTable table;
	JLabel lblRoomID;
	JTextField textID;
	JLabel lblFloor;
	JTextField textPrice;
	JTextField textFloor;
	JTextField textRoomtype;
	JScrollPane scrollPane;
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
		childBooking.setLayout(null);
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
		
		JLabel lblNumberOfBeds = new JLabel("Number of beds:");
		lblNumberOfBeds.setBounds(16, 87, 95, 14);
		
		JComboBox comboNumBed = new JComboBox();
		comboNumBed.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboNumBed.setBounds(153, 83, 54, 22);
		
		JPanel panelBeds = new JPanel();
		panelBeds.setBounds(16, 116, 191, 135);
		panelBeds.setBackground(Color.LIGHT_GRAY);
		panelBeds.setBorder(new LineBorder(Color.GRAY, 1, true));
		
		JLabel lblNewLabel = new JLabel("Status:");
		lblNewLabel.setBounds(255, 32, 69, 14);
		
		JLabel lblPrice = new JLabel("Price per night:");
		lblPrice.setBounds(255, 59, 99, 14);
		
		textPrice = new JTextField();
		textPrice.setBounds(385, 56, 86, 20);
		textPrice.setColumns(10);
		
		JCheckBox chckbxStatus = new JCheckBox("Occupied");
		chckbxStatus.setEnabled(false);
		chckbxStatus.setBackground(Color.LIGHT_GRAY);
		chckbxStatus.setBounds(385, 28, 86, 23);
		
		JLabel lblBed = new JLabel("Bedtype 1");
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Single", "Double ", "Suite"}));
		
		JLabel lblBed_1 = new JLabel("Bedtype 2");
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Single", "Double ", "Suite"}));
		
		JLabel lblBed_2 = new JLabel("Bedtype 3");
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Single", "Double ", "Suite"}));
		
		JLabel lblBed_3 = new JLabel("Bedtype 4");
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Single", "Double ", "Suite"}));
		GroupLayout gl_panelBeds = new GroupLayout(panelBeds);
		gl_panelBeds.setHorizontalGroup(
			gl_panelBeds.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBeds.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelBeds.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblBed, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
						.addComponent(lblBed_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblBed_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblBed_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelBeds.createParallelGroup(Alignment.TRAILING)
						.addComponent(comboBox_2, 0, 112, Short.MAX_VALUE)
						.addComponent(comboBox_3, Alignment.LEADING, 0, 112, Short.MAX_VALUE)
						.addComponent(comboBox_4, Alignment.LEADING, 0, 112, Short.MAX_VALUE)
						.addComponent(comboBox_5, Alignment.LEADING, 0, 112, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelBeds.setVerticalGroup(
			gl_panelBeds.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBeds.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelBeds.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBed))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelBeds.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBed_1))
					.addGap(6)
					.addGroup(gl_panelBeds.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBed_2))
					.addGap(6)
					.addGroup(gl_panelBeds.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBed_3))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		panelBeds.setLayout(gl_panelBeds);
		panelAddRooms.setLayout(null);
		panelAddRooms.add(textPrice);
		panelAddRooms.add(chckbxStatus);
		panelAddRooms.add(panelBeds);
		panelAddRooms.add(lblNumberOfBeds);
		panelAddRooms.add(comboNumBed);
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
		lblRoomType.setBounds(255, 87, 86, 14);
		panelAddRooms.add(lblRoomType);
		
		textRoomtype = new JTextField();
		textRoomtype.setBounds(385, 84, 86, 20);
		panelAddRooms.add(textRoomtype);
		textRoomtype.setColumns(10);
		//*****************************
		btnCreate=new JButton("Create");
		
		btnCreate.setBounds(382, 297, 89, 23);
		panelAddRooms.add(btnCreate);
		
		JButton btnUpdate = new JButton("Update");
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
		
		btnDone1 = new JButton("Done");
		btnDone1.setBounds(680, 539, 73, 23);
		childBooking.add(btnDone1);		
		
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
		
		JButton btnDelete = new JButton("Delete Room");
		btnDelete.setBounds(639, 227, 114, 23);
		childEditRooms.add(btnDelete);
		
		JButton btnCancel = new JButton("Save & Return");
		btnCancel.setBounds(548, 539, 119, 23);
		childEditRooms.add(btnCancel);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(0, 550, 127, 23);
		childMenu.add(btnExit);			
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
				
				Room methodSelectTable = new Room();
				
				
				//READ THE ROOMID FROM THE JTABLE
				int row = table.getSelectedRow();
				String tableClick=(table.getModel().getValueAt(row,0).toString());
				
				//FIND FROM THE DATABASE VALUES WITH ID=ROOMID
				methodSelectTable.editRoom(tableClick);
				
				//SET THE VALUES TO THE TEXTFIELDS
				textID.setText(String.valueOf((methodSelectTable.getRoomID())));
				textRoomtype.setText(methodSelectTable.getRoomType());
				textFloor.setText(String.valueOf((methodSelectTable.getFloor())));
				textPrice.setText(String.valueOf((methodSelectTable.getRoomPrice())));
				
				
				
				
				
			}});		
		
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
				
				/*
				Room rm=new Room();
				table.setModel(DbUtils.resultSetToTableModel(rm.showValuesInTable()));
				*/
				
				
				   Statement stmt = null;
				   
				  Connection p = null;
				    try {
				      Class.forName("org.sqlite.JDBC");
				      //p = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Jim\\Desktop\\eclipse\\db\\RoomDB.sqlite");
				      
				      //mayo database
				      p = DriverManager.getConnection("jdbc:sqlite:D:\\eclipse\\Room.sqlite");
				    
				      p.setAutoCommit(false);
				      System.out.println("Opened database successfully");
				      
				      stmt = p.createStatement();
				      String sql = "SELECT * FROM ROOM;";
				      PreparedStatement pst=p.prepareStatement(sql);
				      ResultSet rs=pst.executeQuery();
				      
				      table.setModel(DbUtils.resultSetToTableModel(rs));
				      
				      pst.execute();
				      			      
				      //stmt.executeUpdate(sql);
				      p.commit();			      
				 
				      stmt.close();
				      p.close();
				    } catch ( Exception exc ) {
				      System.err.println( exc.getClass().getName() + ": " + exc.getMessage() );
				      JOptionPane.showMessageDialog(null, "error", "error",JOptionPane.ERROR_MESSAGE);
				      System.exit(0);
				    }
				    System.out.println("Operation done successfully");
				 
				//
				  
				
			}
			
		});
		//Done - Booking (Returns to Main menu)
		btnDone1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditRooms.setEnabled(true);
				btnCheckIn.setEnabled(true);
				btnCheckOut.setEnabled(true);
				btnBooking.setEnabled(true);
				childBegin.setVisible(true);
				btnExit.setEnabled(true);
				childBooking.setVisible(false);
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
