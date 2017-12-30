import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class searchbyid {

	private JFrame frmItemizationSearch;
	private JTextField textField_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchbyid window = new searchbyid();
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
	public searchbyid() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemizationSearch = new JFrame();
		frmItemizationSearch.getContentPane().setBackground(new Color(176, 224, 230));
		frmItemizationSearch.setIconImage(Toolkit.getDefaultToolkit().getImage(searchbyid.class.getResource("/images/itemization_logo.png")));
		frmItemizationSearch.setTitle("ITEMIZATION - Search by ID");
		frmItemizationSearch.setBounds(100, 100, 450, 300);
		frmItemizationSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblId = new JLabel("ID");
		
		textField_id = new JTextField();
		textField_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					int id = Integer.parseInt(textField_id.getText());
					
					searchbyidresult.main(id);
					frmItemizationSearch.dispose();
				}
			}
		});
		textField_id.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					int id = Integer.parseInt(textField_id.getText());
					
					searchbyidresult.main(id);
					frmItemizationSearch.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					search.main(null);
					frmItemizationSearch.dispose();
				}
			}
		});
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(textField_id.getText());
			
				searchbyidresult.main(id);
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
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					search.main(null);
					frmItemizationSearch.dispose();
				}
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
							.addGap(57)
							.addComponent(lblId)
							.addGap(62)
							.addComponent(textField_id, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(122)
							.addComponent(btnSearch)
							.addGap(46)
							.addComponent(btnBack)))
					.addContainerGap(112, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(textField_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearch)
						.addComponent(btnBack))
					.addGap(84))
		);
		frmItemizationSearch.getContentPane().setLayout(groupLayout);
	}
}
