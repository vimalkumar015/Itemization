import java.awt.EventQueue;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class newitem {

	private JFrame frmItemizationNew;
	static ResultSet rs;
	static ResultSet rs1;
	static JComboBox<String> comboBox;
	static JComboBox<String> comboBox_Location;
	static JComboBox<String> comboBox_1;
	private JTextField txtNull;
	static int oldid;
	static int id;
	static DateFormat dateform;
	static Date date;

	/**
	 * Launch the application.
	 */

	public static void fillCobo() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false", "root", "");
			PreparedStatement stmt = con.prepareStatement("select name from product order by name");
			PreparedStatement stmt1 = con.prepareStatement("select name from location order by name");
			rs = stmt.executeQuery();
			rs1 = stmt1.executeQuery();
			while (rs1.next()) {
				String location_item = rs1.getString("name");
				comboBox_Location.addItem(location_item);
			}
			while (rs.next()) {
				String item = rs.getString("name");
				comboBox.addItem(item);
			}
		} catch (Exception e) {
			System.out.println(e);

		}
	}

	public static void idfill() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false", "root", "");
			PreparedStatement stm = con.prepareStatement("select max(id) as id from stocklist");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				oldid = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		id = oldid + 1;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					idfill();
					newitem window = new newitem();
					fillCobo();
					dateform = new SimpleDateFormat("yyyy/MM/dd");
					window.frmItemizationNew.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public newitem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemizationNew = new JFrame();
		frmItemizationNew.setIconImage(
				Toolkit.getDefaultToolkit().getImage(newitem.class.getResource("/images/itemization_logo.png")));
		frmItemizationNew.setTitle("ITEMIZATION - New Item");
		frmItemizationNew.getContentPane().setBackground(new Color(176, 224, 230));

		JLabel lblProductName = new JLabel("Product name");

		JLabel lblLocation = new JLabel("Location");

		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
				{
					if(comboBox.getSelectedItem().toString().length() == 0 || comboBox_1.getSelectedItem().toString().length() == 0 || comboBox_Location.getSelectedItem().toString().length() == 0 || txtNull.getText().length() == 0 )
					{
						JOptionPane.showMessageDialog(null, "Fields cannot be empty");
					}
					else
					{
						try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = (Connection) DriverManager
								.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false", "root", "");
						PreparedStatement stmt = con.prepareStatement(
								"INSERT INTO stocklist(id,product_name,purity,location,gross_weight,flag) VALUES (?,?,?,?,?,?)");
						stmt.setInt(1, id );
						stmt.setString(2, comboBox.getSelectedItem().toString());
						stmt.setString(3, comboBox_1.getSelectedItem().toString());
						stmt.setString(4, comboBox_Location.getSelectedItem().toString());
						stmt.setDouble(5, Double.parseDouble(txtNull.getText()));
						stmt.setInt(6, 1);
						stmt.execute();
					} catch (Exception e) {

						e.printStackTrace();
					}
					updateconfirmation.main(id);
					frmItemizationNew.dispose();
					}
				}else if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmItemizationNew.dispose();
				}
			}
		});

		comboBox_Location = new JComboBox<String>();
		comboBox_Location.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
				{
					if(comboBox.getSelectedItem().toString().length() == 0 || comboBox_1.getSelectedItem().toString().length() == 0 || comboBox_Location.getSelectedItem().toString().length() == 0 || txtNull.getText().length() == 0 )
					{
						JOptionPane.showMessageDialog(null, "Fields cannot be empty");
					}
					else
					{
						try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = (Connection) DriverManager
								.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false", "root", "");
						PreparedStatement stmt = con.prepareStatement(
								"INSERT INTO stocklist(id,product_name,purity,location,gross_weight,flag) VALUES (?,?,?,?,?,?)");
						stmt.setInt(1, id );
						stmt.setString(2, comboBox.getSelectedItem().toString());
						stmt.setString(3, comboBox_1.getSelectedItem().toString());
						stmt.setString(4, comboBox_Location.getSelectedItem().toString());
						stmt.setDouble(5, Double.parseDouble(txtNull.getText()));
						stmt.setInt(6, 1);
						stmt.execute();
					} catch (Exception e) {

						e.printStackTrace();
					}
					updateconfirmation.main(id);
					frmItemizationNew.dispose();
					}
				}else if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmItemizationNew.dispose();
				}
				
			}
		});
		comboBox_Location.setModel(new DefaultComboBoxModel(new String[] {""}));

		JLabel lblNewLabel = new JLabel("Gross Weight");

		JLabel label = new JLabel("");

		txtNull = new JTextField();
		txtNull.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char vchar = evt.getKeyChar();
				if ((Character.isDigit(vchar)) || (vchar == KeyEvent.VK_PERIOD) || (vchar == KeyEvent.VK_BACK_SPACE)) {
					if (vchar == KeyEvent.VK_PERIOD) {
						String s = txtNull.getText();
						int dot = s.indexOf('.');
						if (dot != -1) {
							evt.consume();
						}
					}
				} else {
					evt.consume();
				}
			}
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
				{
					if(comboBox.getSelectedItem().toString().length() == 0 || comboBox_1.getSelectedItem().toString().length() == 0 || comboBox_Location.getSelectedItem().toString().length() == 0 || txtNull.getText().length() == 0 )
					{
						JOptionPane.showMessageDialog(null, "Fields cannot be empty");
					}
					else
					{
						try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = (Connection) DriverManager
								.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false", "root", "");
						PreparedStatement stmt = con.prepareStatement(
								"INSERT INTO stocklist(id,product_name,purity,location,gross_weight,flag) VALUES (?,?,?,?,?,?)");
						stmt.setInt(1, id );
						stmt.setString(2, comboBox.getSelectedItem().toString());
						stmt.setString(3, comboBox_1.getSelectedItem().toString());
						stmt.setString(4, comboBox_Location.getSelectedItem().toString());
						stmt.setDouble(5, Double.parseDouble(txtNull.getText()));
						stmt.setInt(6, 1);
						stmt.execute();
					} catch (Exception e) {

						e.printStackTrace();
					}
					updateconfirmation.main(id);
					frmItemizationNew.dispose();
					}
				}
			}
		});
		txtNull.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
				{
					if(comboBox.getSelectedItem().toString().length() == 0 || comboBox_1.getSelectedItem().toString().length() == 0 || comboBox_Location.getSelectedItem().toString().length() == 0 || txtNull.getText().length() == 0 )
					{
						JOptionPane.showMessageDialog(null, "Fields cannot be empty");
					}
					else
					{
						try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = (Connection) DriverManager
								.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false", "root", "");
						PreparedStatement stmt = con.prepareStatement(
								"INSERT INTO stocklist(id,product_name,purity,location,gross_weight,flag) VALUES (?,?,?,?,?,?)");
						stmt.setInt(1, id );
						stmt.setString(2, comboBox.getSelectedItem().toString());
						stmt.setString(3, comboBox_1.getSelectedItem().toString());
						stmt.setString(4, comboBox_Location.getSelectedItem().toString());
						stmt.setDouble(5, Double.parseDouble(txtNull.getText()));
						stmt.setInt(6, 1);
						stmt.execute();
					} catch (Exception e) {

						e.printStackTrace();
					}
					updateconfirmation.main(id);
					frmItemizationNew.dispose();
					}
				}else if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmItemizationNew.dispose();
				}
				
			}
		});
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedItem().toString().length() == 0 || comboBox_1.getSelectedItem().toString().length() == 0 || comboBox_Location.getSelectedItem().toString().length() == 0 || txtNull.getText().length() == 0 )
				{
					JOptionPane.showMessageDialog(null, "Fields cannot be empty");
				}
				else
				{
					try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = (Connection) DriverManager
							.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false", "root", "");
					PreparedStatement stmt = con.prepareStatement(
							"INSERT INTO stocklist(id,product_name,purity,location,gross_weight,flag) VALUES (?,?,?,?,?,?)");
					stmt.setInt(1, id );
					stmt.setString(2, comboBox.getSelectedItem().toString());
					stmt.setString(3, comboBox_1.getSelectedItem().toString());
					stmt.setString(4, comboBox_Location.getSelectedItem().toString());
					stmt.setDouble(5, Double.parseDouble(txtNull.getText()));
					stmt.setInt(6, 1);
					stmt.execute();
				} catch (Exception e) {

					e.printStackTrace();
				}
				updateconfirmation.main(id);
				frmItemizationNew.dispose();
				}
			}
		});

		JButton btnCancel = new JButton("Back");
		btnCancel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
			if(evt.getKeyCode() == KeyEvent.VK_ENTER)
			{
				HomePage.main(null);
				frmItemizationNew.dispose();
			}
			else if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
			{
				HomePage.main(null);
				frmItemizationNew.dispose();
			}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePage.main(null);
				frmItemizationNew.dispose();
			}
		});

		JLabel lblPurity = new JLabel("Purity");

		comboBox_1 = new JComboBox<String>();
		comboBox_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
				{
					if(comboBox.getSelectedItem().toString().length() == 0 || comboBox_1.getSelectedItem().toString().length() == 0 || comboBox_Location.getSelectedItem().toString().length() == 0 || txtNull.getText().length() == 0 )
					{
						JOptionPane.showMessageDialog(null, "Fields cannot be empty");
					}
					else
					{
						try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = (Connection) DriverManager
								.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false", "root", "");
						PreparedStatement stmt = con.prepareStatement(
								"INSERT INTO stocklist(id,product_name,purity,location,gross_weight,flag) VALUES (?,?,?,?,?,?)");
						stmt.setInt(1, id );
						stmt.setString(2, comboBox.getSelectedItem().toString());
						stmt.setString(3, comboBox_1.getSelectedItem().toString());
						stmt.setString(4, comboBox_Location.getSelectedItem().toString());
						stmt.setDouble(5, Double.parseDouble(txtNull.getText()));
						stmt.setInt(6, 1);
						stmt.execute();
					} catch (Exception e) {

						e.printStackTrace();
					}
					updateconfirmation.main(id);
					frmItemizationNew.dispose();
					}
				}else if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmItemizationNew.dispose();
				}
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "Regular", "KDM", "Silver", "92M-Silver"}));

		GroupLayout groupLayout = new GroupLayout(frmItemizationNew.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblProductName)
								.addComponent(lblPurity)
								.addComponent(lblLocation)
								.addComponent(lblNewLabel))
							.addGap(45)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNull, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_Location, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(90)
							.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(107, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProductName)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPurity)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocation)
						.addComponent(comboBox_Location, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtNull, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label)
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSubmit)
						.addComponent(btnCancel))
					.addGap(34))
		);
		frmItemizationNew.getContentPane().setLayout(groupLayout);
		frmItemizationNew.setBounds(100, 100, 450, 300);
		frmItemizationNew.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
