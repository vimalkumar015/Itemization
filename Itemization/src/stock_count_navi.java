import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class stock_count_navi {

	private JFrame frmItemizationStock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stock_count_navi window = new stock_count_navi();
					window.frmItemizationStock.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public stock_count_navi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemizationStock = new JFrame();
		frmItemizationStock.setTitle("ITEMIZATION - Stock Count");
		frmItemizationStock.setIconImage(Toolkit.getDefaultToolkit().getImage(stock_count_navi.class.getResource("/images/itemization_logo.png")));
		frmItemizationStock.getContentPane().setBackground(new Color(176, 224, 230));
		
		JButton btnDisplayStock = new JButton("Display Stock");
		
		JButton btnBoxStock = new JButton("Box Stock");
		
		JButton btnBack = new JButton("Back");
		GroupLayout groupLayout = new GroupLayout(frmItemizationStock.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(151)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(56, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addComponent(btnDisplayStock, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
					.addComponent(btnBoxStock, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addGap(56))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(87, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDisplayStock)
						.addComponent(btnBoxStock))
					.addGap(60)
					.addComponent(btnBack)
					.addGap(68))
		);
		frmItemizationStock.getContentPane().setLayout(groupLayout);
		frmItemizationStock.setBounds(100, 100, 413, 300);
		frmItemizationStock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
