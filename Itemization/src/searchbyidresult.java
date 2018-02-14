import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class searchbyidresult {

	private JFrame frmItemizationSearch;
	static int id;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	static String name;
	static String location;
	static double gross_weight;
	static Date date;
	static String purity;
	static int flag;
	

	/**
	 * Launch the application.
	 */
	public static void getcontent() {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
			PreparedStatement pst = (PreparedStatement) con.prepareStatement("select * from stocklist where id = ?");			
			pst.setInt(1,id);
			ResultSet rs =pst.executeQuery();
			if(rs.next())
			{
				name = rs.getString(2);
				purity = rs.getString(3);
				location = rs.getString(4);
				gross_weight = rs.getDouble(5);
				date = rs.getDate(6);
				flag = rs.getInt(7);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(flag == 0)
		{
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement("select * from soldoutdate where id = ?");
			pst.setInt(1, id);
			ResultSet rs =pst.executeQuery();
			if(rs.next())
			{
				date = rs.getDate(2);
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	public static void main(int getid) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					id=getid;
					getcontent();
					searchbyidresult window = new searchbyidresult();
					window.frmItemizationSearch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public searchbyidresult() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemizationSearch = new JFrame();
		frmItemizationSearch.getContentPane().setBackground(new Color(176, 224, 230));
		frmItemizationSearch.setIconImage(Toolkit.getDefaultToolkit().getImage(searchbyidresult.class.getResource("/images/itemization_logo.png")));
		frmItemizationSearch.setTitle("ITEMIZATION - Search Result");
		frmItemizationSearch.setBounds(100, 100, 455, 356);
		frmItemizationSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblId = new JLabel("ID");
		
		JLabel lblProduct = new JLabel("Product");
		
		JLabel lblPurity = new JLabel("Purity");
		
		JLabel lblLocation = new JLabel("Location");
		
		JLabel lblItemStatus = new JLabel("Item Status");
		
		JLabel lblGrossWeight = new JLabel("Gross Weight");
		
		JLabel lblCreatedDate = new JLabel("Created On");
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					search.main(null);
					frmItemizationSearch.dispose();
				}
			}
		});
		textField.setEditable(false);
		textField.setText(String.valueOf(id));
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText(name);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText(purity);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setText(location);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setText(String.valueOf(gross_weight));
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		if(flag == 1) {
			textField_5.setText("In Stock");
			}
			else
			{
			textField_5.setText("Sold Out");
			lblCreatedDate.setText("Sold On");
			}
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setText(String.valueOf(date));
		textField_6.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					search.main(null);
					frmItemizationSearch.dispose();
				}
			}
		});
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search.main(null);
				frmItemizationSearch.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmItemizationSearch.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblId)
								.addComponent(lblProduct)
								.addComponent(lblPurity)
								.addComponent(lblLocation)
								.addComponent(lblGrossWeight)
								.addComponent(lblItemStatus)
								.addComponent(lblCreatedDate, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(126)
							.addComponent(btnOk)))
					.addContainerGap(199, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProduct)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPurity)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocation)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGrossWeight)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblItemStatus)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCreatedDate)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(btnOk)
					.addGap(23))
		);
		frmItemizationSearch.getContentPane().setLayout(groupLayout);
	}
}
