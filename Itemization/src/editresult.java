import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class editresult {

	private JFrame frmItemizationEdit;
	private JTextField textField;
	private JTextField textField_1;
	static int newid;
	static ResultSet rs1;
	static ResultSet rs2;
	static JComboBox<String> comboBox;
	JComboBox<?> comboBox_1;
	static JComboBox<String> comboBox_2;
	static String name;
	static String purity;
	static String location;
	static Double grossweight;
	

	/**
	 * Launch the application.
	 */
	public static void fillDetails()
	{
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
		PreparedStatement pst1 = (PreparedStatement) con.prepareStatement("Select * from product order by name");
		PreparedStatement pst2 = (PreparedStatement) con.prepareStatement("Select * from location order by name");
		rs1 =pst1.executeQuery();
		rs2 =pst2.executeQuery();
		while(rs1.next())
		{
			String product = rs1.getString(1);
			comboBox.addItem(product);
		}
		while(rs2.next())
		{
			String loc = rs2.getString(1);
			comboBox_2.addItem(loc);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newid = id;
					editresult window = new editresult();
					fillDetails();
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
	public editresult() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemizationEdit = new JFrame();
		frmItemizationEdit.getContentPane().setBackground(new Color(176, 224, 230));
		frmItemizationEdit.setTitle("ITEMIZATION - Edit");
		frmItemizationEdit.setIconImage(Toolkit.getDefaultToolkit().getImage(editresult.class.getResource("/images/itemization_logo.png")));
		frmItemizationEdit.setBounds(100, 100, 520, 362);
		frmItemizationEdit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblId = new JLabel("ID");
		
		JLabel lblProdct = new JLabel("Product");
		
		JLabel lblLocation = new JLabel("Location");
		
		JLabel lblPurity = new JLabel("Purity");
		
		JLabel lblGrossWeight = new JLabel("Gross Weight");
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText(String.valueOf(newid));
		textField.setColumns(10);
		
		comboBox = new JComboBox<String>();
		
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Regular", "KDM", "Silver", "92M-Silver"}));
		
		comboBox_2 = new JComboBox<String>();
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					if(comboBox.getSelectedItem() != null && comboBox_1.getSelectedItem() != null &&  comboBox_2.getSelectedItem() != null && textField_1.getText()!= null)
					{
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
						PreparedStatement pst = (PreparedStatement) con.prepareStatement("UPDATE `stocklist` SET `id`=?,`product_name`=?,`Purity`=?,`location`=?,`gross_weight`=? WHERE id =?");
						pst.setInt(1, newid);
						pst.setString(2, String.valueOf(comboBox.getSelectedItem()));
						pst.setString(3, String.valueOf(comboBox_1.getSelectedItem()));
						pst.setString(4, String.valueOf(comboBox_2.getSelectedItem()));
						pst.setDouble(5, Double.valueOf(textField_1.getText()));
						pst.setInt(6, newid);
						pst.execute();
						JOptionPane.showMessageDialog(null, "Changes Updated to DataBase");
						edit.main(null);
						frmItemizationEdit.dispose();
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}
					}else
					{
						JOptionPane.showMessageDialog(null, "Please Fill All");
					}
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					edit.main(null);
					frmItemizationEdit.dispose();
				}
			}
		});
		textField_1.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					if(comboBox.getSelectedItem() != null && comboBox_1.getSelectedItem() != null &&  comboBox_2.getSelectedItem() != null && textField_1.getText()!= null)
					{
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
						PreparedStatement pst = (PreparedStatement) con.prepareStatement("UPDATE `stocklist` SET `id`=?,`product_name`=?,`Purity`=?,`location`=?,`gross_weight`=? WHERE id =?");
						pst.setInt(1, newid);
						pst.setString(2, String.valueOf(comboBox.getSelectedItem()));
						pst.setString(3, String.valueOf(comboBox_1.getSelectedItem()));
						pst.setString(4, String.valueOf(comboBox_2.getSelectedItem()));
						pst.setDouble(5, Double.valueOf(textField_1.getText()));
						pst.setInt(6, newid);
						pst.execute();
						JOptionPane.showMessageDialog(null, "Changes Updated to DataBase");
						edit.main(null);
						frmItemizationEdit.dispose();
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}
					}else
					{
						JOptionPane.showMessageDialog(null, "Please Fill All");
					}
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					edit.main(null);
					frmItemizationEdit.dispose();
				}
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem() != null && comboBox_1.getSelectedItem() != null &&  comboBox_2.getSelectedItem() != null && textField_1.getText()!= null)
				{
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
					PreparedStatement pst = (PreparedStatement) con.prepareStatement("UPDATE `stocklist` SET `id`=?,`product_name`=?,`Purity`=?,`location`=?,`gross_weight`=? WHERE id =?");
					pst.setInt(1, newid);
					pst.setString(2, String.valueOf(comboBox.getSelectedItem()));
					pst.setString(3, String.valueOf(comboBox_1.getSelectedItem()));
					pst.setString(4, String.valueOf(comboBox_2.getSelectedItem()));
					pst.setDouble(5, Double.valueOf(textField_1.getText()));
					pst.setInt(6, newid);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Changes Updated to DataBase");
					edit.main(null);
					frmItemizationEdit.dispose();
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
				}else
				{
					JOptionPane.showMessageDialog(null, "Please Fill All");
				}
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					edit.main(null);
					frmItemizationEdit.dispose();
				}
			else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					edit.main(null);
					frmItemizationEdit.dispose();
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit.main(null);
				frmItemizationEdit.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmItemizationEdit.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblId)
								.addComponent(lblProdct)
								.addComponent(lblPurity)
								.addComponent(lblLocation)
								.addComponent(lblGrossWeight))
							.addGap(39)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(121)
							.addComponent(btnUpdate)
							.addGap(66)
							.addComponent(btnCancel)))
					.addContainerGap(185, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProdct)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPurity)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocation)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGrossWeight)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(61)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdate)
						.addComponent(btnCancel))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		frmItemizationEdit.getContentPane().setLayout(groupLayout);
	}
}
