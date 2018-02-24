 import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class location_wise_count_report {

	static private JFrame frmItemizationLocation;
	static String loc;
	static private JTextField textField;
	static private JTextField textField_2;
	static private JTextField textField_3;
	static private JTextField textField_1;
	static JLabel lblOverAllAbsent; 
	static int check = 0;
	static String list[] = new String[] {"TRAY 01","TRAY 02","TRAY 03","TRAY 06","TRAY 07","TRAY 08","TRAY 09","TRAY 10","TRAY 11","TRAY 12","TRAY 13","TRAY 14","TRAY 15","TRAY 16","TRAY 17","TRAY 20","TRAY 23","TRAY 24","TRAY 25","TRAY 25","TRAY 26","TRAY 27","TRAY 28","TRAY 29","TRAY 30","TRAY 31","TRAY 32","TRAY 33","TRAY 34","TRAY 35","TRAY 34","TRAY 35","TRAY 36","TRAY 37","TRAY 38"};

	/**
	 * Launch the application.
	 */
	
	public static void filldata()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
			PreparedStatement pst = (PreparedStatement) con.prepareStatement("select location,COUNT(*),SUM(gross_weight) FROM stocklist WHERE flag = 1 AND location = ? GROUP BY location");
			PreparedStatement pst1 = (PreparedStatement) con.prepareStatement("SELECT SUM(absent) FROM (SELECT location.name,count(stock.location),location.count,location.count - count(stock.location) as absent  FROM location LEFT OUTER JOIN (SELECT * FROM stocklist WHERE flag = 1) AS stock ON location.name = stock.location WHERE location.name = ? GROUP BY location.name) AS processed");
			pst.setString(1, loc);
			pst1.setString(1, loc);
			ResultSet rs = pst.executeQuery();
			ResultSet rs1 = pst1.executeQuery(); 
			if(rs.next())
			{
				textField.setText(rs.getString(1));
				textField_2.setText(String.valueOf(rs.getInt(2))+" Nos.");
				textField_1.setText(String.valueOf(rs.getDouble(3))+" Gram");
			}
			else
			{	check = 1;
				JOptionPane.showMessageDialog(null, "No Item Present in "+loc);
				location_wise_count.main(null);
				frmItemizationLocation.dispose();
			}
			if( loc.equals("TRAY 01") || loc.equals("TRAY 02") || loc.equals("TRAY 03") || loc.equals("TRAY 06") || loc.equals("TRAY 07") || loc.equals("TRAY 08") || loc.equals("TRAY 09") || loc.equals("TRAY 10") || loc.equals("TRAY 11") || loc.equals("TRAY 12") || loc.equals("TRAY 13") || loc.equals("TRAY 14") || loc.equals("TRAY 15") || loc.equals("TRAY 16") || loc.equals("TRAY 17") || loc.equals("TRAY 20") || loc.equals("TRAY 23") || loc.equals("TRAY 24") || loc.equals("TRAY 25") || loc.equals("TRAY 25") || loc.equals("TRAY 26") || loc.equals("TRAY 27") || loc.equals("TRAY 28") || loc.equals("TRAY 29") || loc.equals("TRAY 30") || loc.equals("TRAY 31") || loc.equals("TRAY 32") || loc.equals("TRAY 33") || loc.equals("TRAY 34") || loc.equals("TRAY 35") || loc.equals("TRAY 34") || loc.equals("TRAY 35") || loc.equals("TRAY 36") || loc.equals("TRAY 37") || loc.equals("TRAY 38"))
			{
			if(rs1.next())
			{
				textField_3.setText(String.valueOf(rs1.getInt(1))+" Nos.");
			}
			else
			{
				frmItemizationLocation.dispose();
			}
			}
			else {
				textField_3.setEnabled(false);
				textField_3.hide();
				lblOverAllAbsent.hide();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String name) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loc = name;
					
					location_wise_count_report window = new location_wise_count_report();
					filldata();
					if(check == 0)
					{
						window.frmItemizationLocation.setVisible(true);
					}
					else
					{
						check = 0;
						window.frmItemizationLocation.setVisible(false);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public location_wise_count_report() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemizationLocation = new JFrame();
		frmItemizationLocation.setTitle("ITEMIZATION - Location Wise Count Report");
		frmItemizationLocation.setIconImage(Toolkit.getDefaultToolkit().getImage(location_wise_count_report.class.getResource("/images/itemization_logo.png")));
		frmItemizationLocation.getContentPane().setBackground(new Color(176, 224, 230));
		frmItemizationLocation.setBounds(100, 100, 450, 300);
		frmItemizationLocation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblLocationName = new JLabel("Location Name");
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
				{
					location_wise_count.main(null);
					frmItemizationLocation.dispose();
				}
			}
		});
		textField.setEditable(false);
		textField.setColumns(10);
		
		JLabel lblCount = new JLabel("Total Count");
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
				{
					location_wise_count.main(null);
					frmItemizationLocation.dispose();
				}
			}
		});
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		
		JLabel lblTotalWeight = new JLabel("Total Weight");
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
				{
					location_wise_count.main(null);
					frmItemizationLocation.dispose();
				}
			}
		});
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
				{
					location_wise_count.main(null);
					frmItemizationLocation.dispose();
				}
			}
		});
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				location_wise_count.main(null);
				frmItemizationLocation.dispose();
			}
		});
		
		lblOverAllAbsent = new JLabel("Absent Count");
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
				{
					location_wise_count.main(null);
					frmItemizationLocation.dispose();
				}
			}
		});
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frmItemizationLocation.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLocationName)
								.addComponent(lblCount)
								.addComponent(lblTotalWeight)
								.addComponent(lblOverAllAbsent))
							.addGap(57)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_2, 155, 155, Short.MAX_VALUE)
								.addComponent(textField_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(161)
							.addComponent(btnOk)))
					.addGap(103))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocationName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCount)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTotalWeight))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOverAllAbsent))
					.addGap(35)
					.addComponent(btnOk)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		frmItemizationLocation.getContentPane().setLayout(groupLayout);
	}
}
