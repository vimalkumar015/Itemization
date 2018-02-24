import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePage.main(null);
				frmItemizationStock.dispose();
			}
		});
		
		JButton btnLocationWiseCount = new JButton("Location Wise Count");
		btnLocationWiseCount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
				{
					location_wise_count.main(null);
					frmItemizationStock.dispose();
				}
				else if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmItemizationStock.dispose();
				}
			}
		});
		btnLocationWiseCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				location_wise_count.main(null);
				frmItemizationStock.dispose();
			}
		});
		
		JButton btnFullReport = new JButton("Full Report");
		btnFullReport.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
				{	
					stock_count_full_report.main(null);
					frmItemizationStock.dispose();
				}
				else if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmItemizationStock.dispose();
				}
			}
		});
		btnFullReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				stock_count_full_report.main(null);
				frmItemizationStock.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmItemizationStock.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addComponent(btnLocationWiseCount)
							.addGap(50)
							.addComponent(btnFullReport, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(150)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(67)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLocationWiseCount)
						.addComponent(btnFullReport))
					.addGap(71)
					.addComponent(btnBack)
					.addContainerGap(77, Short.MAX_VALUE))
		);
		frmItemizationStock.getContentPane().setLayout(groupLayout);
		frmItemizationStock.setBounds(100, 100, 413, 300);
		frmItemizationStock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
