import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class salesupdateconfirmation {

	private JFrame frmIteizationSales;
	private JTextField textField_id;
	private JTextField textField_product;
	private JTextField textField_location;
	private JTextField textField_grossweight;
	private JTextField textField_itemstatus;
	static int id;
	static String name;
	static String location;
	static double gross_weight;
	static int state;
	static String purity;
	private JTextField textField_purity;
	static String msge;

	/**
	 * Launch the application.
	 */
	public static void getcontent() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
			PreparedStatement stmt =  (PreparedStatement) con.prepareStatement("select * from stocklist where id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				name = rs.getString(2);
				location =rs.getString(4);
				purity = rs.getString(3);
				gross_weight = rs.getDouble(5);
				state = rs.getInt(7);
						
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(int getid) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					id =getid;
					getcontent();
					salesupdateconfirmation window = new salesupdateconfirmation();
					window.frmIteizationSales.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public salesupdateconfirmation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIteizationSales = new JFrame();
		frmIteizationSales.setIconImage(Toolkit.getDefaultToolkit().getImage(salesupdateconfirmation.class.getResource("/images/itemization_logo.png")));
		
		frmIteizationSales.setTitle("ITEIZATION - Sales Update Confirmation");
		
		frmIteizationSales.getContentPane().setBackground(new Color(176, 224, 230));
		
		JLabel lblId = new JLabel("ID");
		
		JLabel lblProduct = new JLabel("Product");
		
		JLabel lblLocaion = new JLabel("Location");
		
		JLabel lblGrossWeight = new JLabel("Gross Weight");
		
		JLabel lblItemStatus = new JLabel("Item Status");
		
		textField_id = new JTextField();
		textField_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
						PreparedStatement stmt0 = (PreparedStatement) con.prepareStatement("Select * from stocklist where id= ?");
						stmt0.setInt(1, id);
						ResultSet rs= stmt0.executeQuery();
						PreparedStatement stmt =  (PreparedStatement) con.prepareStatement("UPDATE stocklist SET flag = 0 WHERE id = ?");
						stmt.setInt(1, id);
						PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("INSERT INTO `soldoutdate`(`id`) VALUES (?)");
						stmt1.setInt(1, id);
						if(rs.next())
						{
						if(rs.getInt(7) == 1)
						{
							stmt.execute();
							stmt1.execute();
							JOptionPane.showMessageDialog(null, "Sucessfully updated the item status");
						}
					else {
							JOptionPane.showMessageDialog(null, "Item already updated as Sold Out");
					}
					}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
					
					HomePage.main(null);
					frmIteizationSales.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					salesupdate.main(null);
					frmIteizationSales.dispose();
				}
			}
		});
		textField_id.setEditable(false);
		textField_id.setText(String.valueOf(id));
		textField_id.setColumns(10);
		
		textField_product = new JTextField();
		textField_product.setEditable(false);
		textField_product.setText(name);
		textField_product.setColumns(10);
		
		textField_location = new JTextField();
		textField_location.setEditable(false);
		textField_location.setText(location);
		textField_location.setColumns(10);
		
		textField_grossweight = new JTextField();
		textField_grossweight.setEditable(false);
		textField_grossweight.setText(String.valueOf(gross_weight));
		textField_grossweight.setColumns(10);
		
		textField_itemstatus = new JTextField();
		textField_itemstatus.setEditable(false);
		if(state == 1)
		{
			textField_itemstatus.setText("In stock");
		}else
		{
			textField_itemstatus.setText("Sold Out");
		}
		textField_itemstatus.setColumns(10);
		
		
		JButton btnUpdateAsSold = new JButton("Update As Sold Out");
		btnUpdateAsSold.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
						PreparedStatement stmt0 = (PreparedStatement) con.prepareStatement("Select * from stocklist where id= ?");
						stmt0.setInt(1, id);
						ResultSet rs= stmt0.executeQuery();
						PreparedStatement stmt =  (PreparedStatement) con.prepareStatement("UPDATE stocklist SET flag = 0 WHERE id = ?");
						stmt.setInt(1, id);
						PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("INSERT INTO `soldoutdate`(`id`) VALUES (?)");
						stmt1.setInt(1, id);
						if(rs.next())
						{
						if(rs.getInt(7) == 1)
						{
							stmt.execute();
							stmt1.execute();
							JOptionPane.showMessageDialog(null, "Sucessfully updated the item status");
						}
					else {
							JOptionPane.showMessageDialog(null, "Item already updated as Sold Out");
					}
					}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
					
					HomePage.main(null);
					frmIteizationSales.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					salesupdate.main(null);
					frmIteizationSales.dispose();
				}
			}
		});
		btnUpdateAsSold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
					PreparedStatement stmt0 = (PreparedStatement) con.prepareStatement("Select * from stocklist where id= ?");
					stmt0.setInt(1, id);
					ResultSet rs= stmt0.executeQuery();
					PreparedStatement stmt =  (PreparedStatement) con.prepareStatement("UPDATE stocklist SET flag = 0 WHERE id = ?");
					stmt.setInt(1, id);
					PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("INSERT INTO `soldoutdate`(`id`) VALUES (?)");
					stmt1.setInt(1, id);
					if(rs.next())
					{
					if(rs.getInt(7) == 1)
					{
						stmt.execute();
						stmt1.execute();
						JOptionPane.showMessageDialog(null, "Sucessfully updated the item status");
					}
				else {
						JOptionPane.showMessageDialog(null, "Item already updated as Sold Out");
				}
				}
					
					
					
					
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
				HomePage.main(null);
				frmIteizationSales.dispose();
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salesupdate.main(null);
				frmIteizationSales.dispose();
			}
		});
		
		JLabel lblpurity = new JLabel("Purity");
		
		textField_purity = new JTextField();
		textField_purity.setEditable(false);
		textField_purity.setColumns(10);
		textField_purity.setText(purity);
		GroupLayout groupLayout = new GroupLayout(frmIteizationSales.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblId)
								.addComponent(lblProduct)
								.addComponent(lblItemStatus)
								.addComponent(lblGrossWeight)
								.addComponent(lblLocaion)
								.addComponent(lblpurity))
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_purity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_location, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_grossweight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_itemstatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_product, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(57)
							.addComponent(btnUpdateAsSold)
							.addGap(53)
							.addComponent(btnCancel)))
					.addContainerGap(132, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(textField_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProduct)
						.addComponent(textField_product, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblpurity)
						.addComponent(textField_purity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocaion)
						.addComponent(textField_location, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGrossWeight)
						.addComponent(textField_grossweight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblItemStatus)
						.addComponent(textField_itemstatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancel)
						.addComponent(btnUpdateAsSold))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		frmIteizationSales.getContentPane().setLayout(groupLayout);
		frmIteizationSales.setBounds(100, 100, 477, 311);
		frmIteizationSales.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
