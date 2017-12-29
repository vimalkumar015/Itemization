import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.mysql.jdbc.Connection;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class productnamedelete {

	private JFrame frmItemizationDelete;
	static ResultSet rs;
	static JComboBox<String> comboBox;
	String name;
	DefaultComboBoxModel item;
	int index;

	/**
	 * Launch the application.
	 */
	public static void fillcombo() {
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false", "root","");
		PreparedStatement stmt = con.prepareStatement("select name from product order by name");
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
					productnamedelete window = new productnamedelete();
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
	public productnamedelete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemizationDelete = new JFrame();
		frmItemizationDelete.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\NirmalGds\\Downloads\\itemization_logo.png"));
		frmItemizationDelete.setTitle("ITEMIZATION - Delete Product Name");
		frmItemizationDelete.getContentPane().setBackground(new Color(176, 224, 230));
		frmItemizationDelete.setBounds(100, 100, 450, 300);
		frmItemizationDelete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		comboBox = new JComboBox<String>();
		comboBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					newproductname.main(null);
					frmItemizationDelete.dispose();
				}
			}
		});
		
		
		JLabel lblSelectTheProduct = new JLabel("Select the Product Name to Detele");
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					name = comboBox.getSelectedItem().toString();
					item = (DefaultComboBoxModel) comboBox.getModel();
					index = comboBox.getSelectedIndex();
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
						PreparedStatement pst = conn.prepareStatement("DELETE FROM `product` WHERE name = ?");
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
					newproductname.main(null);
					frmItemizationDelete.dispose();
				}
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = comboBox.getSelectedItem().toString();
				item = (DefaultComboBoxModel) comboBox.getModel();
				index = comboBox.getSelectedIndex();
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
					PreparedStatement pst = conn.prepareStatement("DELETE FROM `product` WHERE name = ?");
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
					newproductname.main(null);
					frmItemizationDelete.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					newproductname.main(null);
					frmItemizationDelete.dispose();
				}
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newproductname.main(null);
				frmItemizationDelete.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmItemizationDelete.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(lblSelectTheProduct))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(95)
							.addComponent(btnDelete)))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBack)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(116, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelectTheProduct)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(75)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDelete)
						.addComponent(btnBack))
					.addContainerGap(100, Short.MAX_VALUE))
		);
		frmItemizationDelete.getContentPane().setLayout(groupLayout);
	}
}
