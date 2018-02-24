import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class location_wise_count {

	private JFrame frmItemizationLocation;
	static JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	
	public static void fillcombo()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement("select name from location ORDER BY name");
			ResultSet rs = pst.executeQuery(); 
			while(rs.next())
			{
				String item = rs.getString("name");
				comboBox.addItem(item);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					location_wise_count window = new location_wise_count();
					fillcombo();
					window.frmItemizationLocation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public location_wise_count() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemizationLocation = new JFrame();
		frmItemizationLocation.setTitle("ITEMIZATION - Location Wise Count");
		frmItemizationLocation.getContentPane().setBackground(new Color(176, 224, 230));
		
		JLabel lblLocationName = new JLabel("Location Name");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {""}));
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
				{
					location_wise_count_report.main(comboBox.getSelectedItem().toString());
					frmItemizationLocation.dispose();
				}
				else if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					stock_count_navi.main(null);
					frmItemizationLocation.dispose();
				}
			}
		});
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				location_wise_count_report.main(comboBox.getSelectedItem().toString());
				frmItemizationLocation.dispose();
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
				{
					stock_count_navi.main(null);
					frmItemizationLocation.dispose();
				}
				else if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					stock_count_navi.main(null);
					frmItemizationLocation.dispose();
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				stock_count_navi.main(null);
				frmItemizationLocation.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmItemizationLocation.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(94)
							.addComponent(btnSubmit)
							.addGap(100)
							.addComponent(btnCancel))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblLocationName)
							.addGap(48)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(105, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(71, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLocationName))
					.addGap(68)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSubmit)
						.addComponent(btnCancel))
					.addGap(85))
		);
		frmItemizationLocation.getContentPane().setLayout(groupLayout);
		frmItemizationLocation.setIconImage(Toolkit.getDefaultToolkit().getImage(location_wise_count.class.getResource("/images/itemization_logo.png")));
		frmItemizationLocation.setBounds(100, 100, 450, 300);
		frmItemizationLocation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
