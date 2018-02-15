import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class addlocation {

	private JFrame frmItemizationAdd;
	private JTextField textField;
	static String loc;
	static JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addlocation window = new addlocation();
					window.frmItemizationAdd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public addlocation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemizationAdd = new JFrame();
		frmItemizationAdd.setIconImage(Toolkit.getDefaultToolkit().getImage(addlocation.class.getResource("/images/itemization_logo.png")));
		frmItemizationAdd.setTitle("ITEMIZATION - Add Location");
		frmItemizationAdd.getContentPane().setBackground(new Color(176, 224, 230));
		frmItemizationAdd.setBounds(100, 100, 450, 300);
		frmItemizationAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblEnterTheLocation = new JLabel("Enter the Location Name");
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					loc = textField.getText().toUpperCase();
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
						PreparedStatement stmt = (PreparedStatement) con.prepareStatement("INSERT INTO `location`(`name`,`type`) VALUES (?,?)");
						stmt.setString(1, loc);
						stmt.setString(2, comboBox.getSelectedItem().toString());
						PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("Select name from `location` where name = ? and type = ?");
						stmt1.setString(1, loc);
						stmt1.setString(2, comboBox.getSelectedItem().toString());
						ResultSet rs = stmt1.executeQuery();
						if(rs.next())
						{
							JOptionPane.showMessageDialog(null, loc+" is Already Exist in the Database");
						}else
						{
							stmt.execute();
							JOptionPane.showMessageDialog(null, loc+" is updated to the Database Successfully");
						}
						
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}
				}
			}
		});
		textField.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					location.main(null);
					frmItemizationAdd.dispose();
				}else if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)
				{
					location.main(null);
					frmItemizationAdd.dispose();
				}
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				location.main(null);
				frmItemizationAdd.dispose();
			}
		});
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					loc = textField.getText().toUpperCase();
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
						PreparedStatement stmt = (PreparedStatement) con.prepareStatement("INSERT INTO `location`(`name`,`type`) VALUES (?,?)");
						stmt.setString(1, loc);
						stmt.setString(2, comboBox.getSelectedItem().toString());
						PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("Select name from `location` where name = ? and type = ?");
						stmt1.setString(1, loc);
						stmt1.setString(2, comboBox.getSelectedItem().toString());
						ResultSet rs = stmt1.executeQuery();
						if(rs.next())
						{
							JOptionPane.showMessageDialog(null, loc+" is Already Exist in the Database");
						}else
						{
							stmt.execute();
							JOptionPane.showMessageDialog(null, loc+" is updated to the Database Successfully");
						}
						
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					location.main(null);
					frmItemizationAdd.dispose();
				}
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loc = textField.getText().toUpperCase();
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
					PreparedStatement stmt = (PreparedStatement) con.prepareStatement("INSERT INTO `location`(`name`,`type`) VALUES (?,?)");
					stmt.setString(1, loc);
					stmt.setString(2, comboBox.getSelectedItem().toString());
					PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("Select name from `location` where name = ? and type = ?");
					stmt1.setString(1, loc);
					stmt1.setString(2, comboBox.getSelectedItem().toString());
					ResultSet rs = stmt1.executeQuery();
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null, loc+" is Already Exist in the Database");
					}else
					{
						stmt.execute();
						JOptionPane.showMessageDialog(null, loc+" is updated to the Database Successfully");
					}
					
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblLocationType = new JLabel("Location Type");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "GOLD", "SILVER"}));
		GroupLayout groupLayout = new GroupLayout(frmItemizationAdd.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(116, Short.MAX_VALUE)
					.addComponent(btnUpdate)
					.addGap(67)
					.addComponent(btnBack)
					.addGap(129))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEnterTheLocation)
						.addComponent(lblLocationType))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterTheLocation)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocationType)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(btnUpdate))
					.addContainerGap(105, Short.MAX_VALUE))
		);
		frmItemizationAdd.getContentPane().setLayout(groupLayout);
	}
}
