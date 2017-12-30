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

public class searchbypuritynavi {

	private JFrame frmItemizationSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchbypuritynavi window = new searchbypuritynavi();
					window.frmItemizationSearch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public searchbypuritynavi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemizationSearch = new JFrame();
		frmItemizationSearch.setTitle("ITEMIZATION - Search by Purity Navigator");
		frmItemizationSearch.setIconImage(Toolkit.getDefaultToolkit().getImage(searchbypuritynavi.class.getResource("/images/itemization_logo.png")));
		frmItemizationSearch.getContentPane().setBackground(new Color(176, 224, 230));
		
		JButton btnGold = new JButton("Gold");
		btnGold.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					searchbypurity.main(null);
					frmItemizationSearch.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					search.main(null);
					frmItemizationSearch.dispose();
				}
			}
		});
		btnGold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchbypurity.main(null);
				frmItemizationSearch.dispose();
			}
		});
		
		JButton btnSilver = new JButton("Silver");
		btnSilver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchbysilverpurity.main(null);
				frmItemizationSearch.dispose();
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search.main(null);
				frmItemizationSearch.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmItemizationSearch.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(91)
							.addComponent(btnGold, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(59)
							.addComponent(btnSilver, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(165)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(110, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(66)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnSilver, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnGold, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
					.addGap(56)
					.addComponent(btnBack)
					.addContainerGap(82, Short.MAX_VALUE))
		);
		frmItemizationSearch.getContentPane().setLayout(groupLayout);
		frmItemizationSearch.setBounds(100, 100, 450, 300);
		frmItemizationSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
