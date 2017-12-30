import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class addproductname {

	private JFrame frmItemizationAdd;
	private JTextField textField;
	String productname;
	String newresult=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addproductname window = new addproductname();
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
	public addproductname() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemizationAdd = new JFrame();
		frmItemizationAdd.setIconImage(Toolkit.getDefaultToolkit().getImage(addproductname.class.getResource("/images/itemization_logo.png")));
		frmItemizationAdd.setTitle("ITEMIZATION - Add New Product Name");
		frmItemizationAdd.getContentPane().setBackground(new Color(176, 224, 230));
		frmItemizationAdd.setBounds(100, 100, 450, 300);
		frmItemizationAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					productname = textField.getText().toUpperCase();
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
						PreparedStatement stmt = (PreparedStatement) con.prepareStatement("INSERT INTO `product`(`name`) VALUES (?)");
						stmt.setString(1, productname);
						PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("Select name from `product` where name = ?");
						stmt1.setString(1, productname);
						ResultSet rs = stmt1.executeQuery();
						if(rs.next())
						{
							JOptionPane.showMessageDialog(null, productname+" is Already exist in the Database");
						}else
						{
							stmt.execute();
							JOptionPane.showMessageDialog(null, productname+" is Updated to the Database Successfully");
						}
						
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}
				}
			}
		});
		textField.setColumns(10);
		
		JLabel lblEnterTheProduct = new JLabel("Enter the Product Name");
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					productname = textField.getText().toUpperCase();
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
						PreparedStatement stmt = (PreparedStatement) con.prepareStatement("INSERT INTO `product`(`name`) VALUES (?)");
						stmt.setString(1, productname);
						PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("Select name from `product` where name = ?");
						stmt1.setString(1, productname);
						ResultSet rs = stmt1.executeQuery();
						if(rs.next())
						{
							JOptionPane.showMessageDialog(null, productname+" is Already exist in the Database");
						}else
						{
							stmt.execute();
							JOptionPane.showMessageDialog(null, productname+" is Updated to the Database Successfully");
						}
						
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					newproductname.main(null);
					frmItemizationAdd.dispose();
				}
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productname = textField.getText().toUpperCase();
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
					PreparedStatement stmt = (PreparedStatement) con.prepareStatement("INSERT INTO `product`(`name`) VALUES (?)");
					stmt.setString(1, productname);
					PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("Select name from `product` where name = ?");
					stmt1.setString(1, productname);
					ResultSet rs = stmt1.executeQuery();
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null, productname+" is Already exist in the Database");
					}else
					{
						stmt.execute();
						JOptionPane.showMessageDialog(null, productname+" is Updated to the Database Successfully");
					}
					
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
					newproductname.main(null);
					frmItemizationAdd.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					newproductname.main(null);
					frmItemizationAdd.dispose();
				}
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newproductname.main(null);
				frmItemizationAdd.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmItemizationAdd.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addComponent(lblEnterTheProduct)
							.addGap(61)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(101)
							.addComponent(btnUpdate)
							.addGap(75)
							.addComponent(btnBack)))
					.addContainerGap(72, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEnterTheProduct))
					.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdate)
						.addComponent(btnBack))
					.addGap(85))
		);
		frmItemizationAdd.getContentPane().setLayout(groupLayout);
	}
}
