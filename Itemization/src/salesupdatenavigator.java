import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class salesupdatenavigator {

	private JFrame frmItemizationSales;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					salesupdatenavigator window = new salesupdatenavigator();
					window.frmItemizationSales.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public salesupdatenavigator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemizationSales = new JFrame();
		frmItemizationSales.setTitle("ITEMIZATION - Sales Update Navigator");
		frmItemizationSales.setIconImage(Toolkit.getDefaultToolkit().getImage(salesupdatenavigator.class.getResource("/images/itemization_logo.png")));
		frmItemizationSales.getContentPane().setBackground(new Color(176, 224, 230));
		
		JButton btnUpdate = new JButton("Standard Update");
		btnUpdate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
				{
					salesupdate.main(null);
					frmItemizationSales.dispose();
				}
				else if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmItemizationSales.dispose();
				}
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salesupdate.main(null);
				frmItemizationSales.dispose();
			}
		});
		
		JButton btnCustomUpdate = new JButton("Custom Update");
		btnCustomUpdate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					customsalesupdateid.main(null);
					frmItemizationSales.dispose();
				}
				else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					customsalesupdateid.main(null);
					frmItemizationSales.dispose();
				}
			}
		});
		btnCustomUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customsalesupdateid.main(null);
				frmItemizationSales.dispose();
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_ENTER)
				{
					HomePage.main(null);
					frmItemizationSales.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmItemizationSales.dispose();
				}
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage.main(null);
				frmItemizationSales.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmItemizationSales.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addComponent(btnUpdate)
							.addGap(59)
							.addComponent(btnCustomUpdate))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(157)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(99, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(67)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdate)
						.addComponent(btnCustomUpdate))
					.addGap(62)
					.addComponent(btnBack)
					.addContainerGap(86, Short.MAX_VALUE))
		);
		frmItemizationSales.getContentPane().setLayout(groupLayout);
		frmItemizationSales.setBounds(100, 100, 450, 300);
		frmItemizationSales.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
