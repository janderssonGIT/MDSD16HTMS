package src_test;

import java.awt.EventQueue;

public class Main extends Interface{

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface main = new Interface();
					main.initializeUI();
					main.eventHandlerEditRoom();
					main.eventHandlerBooking();
					main.eventHandlerCheckIn();
					main.eventHandlerCheckOut();
					main.frmAlpha.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
//jim was here
//yeah man saw that
