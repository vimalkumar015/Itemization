import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class location {

	private JFrame frmItemizationEdit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					location window = new location();
					window.frmItemizationEdit.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public location() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemizationEdit = new JFrame();
		frmItemizationEdit.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\NirmalGds\\Downloads\\itemization_logo.png"));
		frmItemizationEdit.setTitle("ITEMIZATION - Edit Location ");
		frmItemizationEdit.getContentPane().setBackground(new Color(176, 224, 230));
		frmItemizationEdit.setBounds(100, 100, 450, 300);
		frmItemizationEdit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnAddNewLocation = new JButton("Add New Location");
		btnAddNewLocation.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					addlocation.main(null);
					frmItemizationEdit.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmItemizationEdit.dispose();
				}
			}
		});
		btnAddNewLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addlocation.main(null);
				frmItemizationEdit.dispose();
			}
		});
		
		JButton btnDeleteLocation = new JButton("Delete Location");
		btnDeleteLocation.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					locationdelete.main(null);
					frmItemizationEdit.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmItemizationEdit.dispose();
				}
			}
		});
		btnDeleteLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				locationdelete.main(null);
				frmItemizationEdit.dispose();
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					HomePage.main(null);
					frmItemizationEdit.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmItemizationEdit.dispose();
				}
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage.main(null);
				frmItemizationEdit.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmItemizationEdit.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(65)
					.addComponent(btnAddNewLocation)
					.addGap(66)
					.addComponent(btnDeleteLocation)
					.addContainerGap(95, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(191, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(188))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddNewLocation)
						.addComponent(btnDeleteLocation))
					.addGap(49)
					.addComponent(btnBack)
					.addContainerGap(94, Short.MAX_VALUE))
		);
		frmItemizationEdit.getContentPane().setLayout(groupLayout);
	}

}
