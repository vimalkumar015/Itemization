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
		btnSilver.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					searchbysilverpurity.main(null);
					frmItemizationSearch.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					search.main(null);
					frmItemizationSearch.dispose();
				}
			}
		});
		btnSilver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchbysilverpurity.main(null);
				frmItemizationSearch.dispose();
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					search.main(null);
					frmItemizationSearch.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					search.main(null);
					frmItemizationSearch.dispose();
				}
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search.main(null);
				frmItemizationSearch.dispose();
			}
		});
		
		JButton btnCovering = new JButton("Covering");
		btnCovering.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
				{
					searchbycoveringpurity.main(null);
					frmItemizationSearch.dispose();
				}else if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					search.main(null);
					frmItemizationSearch.dispose();
				}
			}
		});
		btnCovering.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchbycoveringpurity.main(null);
				frmItemizationSearch.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmItemizationSearch.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(btnGold, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnBack, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(btnSilver, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(btnCovering, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(66)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGold, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
						.addComponent(btnSilver, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCovering, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addComponent(btnBack)
					.addContainerGap(82, Short.MAX_VALUE))
		);
		frmItemizationSearch.getContentPane().setLayout(groupLayout);
		frmItemizationSearch.setBounds(100, 100, 450, 300);
		frmItemizationSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
