import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class transaction {

	private JFrame frmItemizationTransaction;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					transaction window = new transaction();
					window.frmItemizationTransaction.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public transaction() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemizationTransaction = new JFrame();
		frmItemizationTransaction.setTitle("ITEMIZATION - Transaction Report");
		frmItemizationTransaction.setIconImage(Toolkit.getDefaultToolkit().getImage(transaction.class.getResource("/images/itemization_logo.png")));
		frmItemizationTransaction.getContentPane().setBackground(new Color(176, 224, 230));
		
		JButton btnTodaysReport = new JButton("Todays Report");
		btnTodaysReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				todaysreport.main(null);
				frmItemizationTransaction.dispose();
				}
		});
		btnTodaysReport.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
				{
					todaysreport.main(null);
					frmItemizationTransaction.dispose();
				}else if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmItemizationTransaction.dispose();
				}
			}
		});
		
		JButton btnCustomReport = new JButton("Custom Report");
		btnCustomReport.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
				{
					customreport.main(null);
					frmItemizationTransaction.dispose();
				}else if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmItemizationTransaction.dispose();
				}
			}
		});
		btnCustomReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				customreport.main(null);
				frmItemizationTransaction.dispose();
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
				{
					HomePage.main(null);
					frmItemizationTransaction.dispose();
				}else if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmItemizationTransaction.dispose();
				}
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				HomePage.main(null);
				frmItemizationTransaction.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmItemizationTransaction.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(57)
							.addComponent(btnTodaysReport)
							.addGap(85)
							.addComponent(btnCustomReport))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(177)
							.addComponent(btnBack)))
					.addContainerGap(84, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(98)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTodaysReport)
						.addComponent(btnCustomReport))
					.addGap(42)
					.addComponent(btnBack)
					.addContainerGap(75, Short.MAX_VALUE))
		);
		frmItemizationTransaction.getContentPane().setLayout(groupLayout);
		frmItemizationTransaction.setBounds(100, 100, 450, 300);
		frmItemizationTransaction.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
