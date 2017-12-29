import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Toolkit;

public class locationdelete {

	private JFrame frmItemizationDelete;
	static ResultSet rs;
	static JComboBox<String> comboBox;
	String name;
	DefaultComboBoxModel<String> item;
	int index;

	/**
	 * Launch the application.
	 */
	
	public static void fillcombo() {
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false", "root","");
		PreparedStatement stmt = con.prepareStatement("select name from location order by name");
		rs = stmt.executeQuery();
		while (rs.next()) {
			String item = rs.getString("name");
			comboBox.addItem(item);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					locationdelete window = new locationdelete();
					fillcombo();
					window.frmItemizationDelete.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public locationdelete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemizationDelete = new JFrame();
		frmItemizationDelete.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\NirmalGds\\Downloads\\itemization_logo.png"));
		frmItemizationDelete.setTitle("ITEMIZATION - Delete Location");
		frmItemizationDelete.getContentPane().setBackground(new Color(176, 224, 230));
		frmItemizationDelete.setBounds(100, 100, 450, 300);
		frmItemizationDelete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblSelectTheLocation = new JLabel("Select the Location to Delete");
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
		comboBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					name = comboBox.getSelectedItem().toString();
					item = (DefaultComboBoxModel<String>) comboBox.getModel();
					index = comboBox.getSelectedIndex();
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
						PreparedStatement pst = conn.prepareStatement("DELETE FROM `location` WHERE name = ?");
						pst.setString(1, name);
						pst.execute();
						item.removeElementAt(index);
						comboBox.setSelectedIndex(0);
						JOptionPane.showMessageDialog(null, name+" is Removed from the Database");
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					location.main(null);
					frmItemizationDelete.dispose();
				}
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					name = comboBox.getSelectedItem().toString();
					item = (DefaultComboBoxModel<String>) comboBox.getModel();
					index = comboBox.getSelectedIndex();
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
						PreparedStatement pst = conn.prepareStatement("DELETE FROM `location` WHERE name = ?");
						pst.setString(1, name);
						pst.execute();
						item.removeElementAt(index);
						comboBox.setSelectedIndex(0);
						JOptionPane.showMessageDialog(null, name+" is Removed from the Database");
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					location.main(null);
					frmItemizationDelete.dispose();
				}
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = comboBox.getSelectedItem().toString();
				item = (DefaultComboBoxModel<String>) comboBox.getModel();
				index = comboBox.getSelectedIndex();
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
					PreparedStatement pst = conn.prepareStatement("DELETE FROM `location` WHERE name = ?");
					pst.setString(1, name);
					pst.execute();
					item.removeElementAt(index);
					comboBox.setSelectedIndex(0);
					JOptionPane.showMessageDialog(null, name+" is Removed from the Database");
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					location.main(null);
					frmItemizationDelete.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					location.main(null);
					frmItemizationDelete.dispose();
				}
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				location.main(null);
				frmItemizationDelete.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmItemizationDelete.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnDelete)
						.addComponent(lblSelectTheLocation))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(77)
							.addComponent(btnBack)))
					.addContainerGap(100, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelectTheLocation)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDelete)
						.addComponent(btnBack))
					.addContainerGap(111, Short.MAX_VALUE))
		);
		frmItemizationDelete.getContentPane().setLayout(groupLayout);
	}

}
