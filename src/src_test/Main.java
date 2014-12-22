package src_test;

import java.awt.EventQueue;

public class Main extends Interface{

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface main = new Interface();
					main.initializeUI();
					main.eventHandler();
					main.frmAlpha.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

