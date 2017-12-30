import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JButton;
import java.awt.Toolkit;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class updateconfirmation {

	private JFrame frmItemizationConfirmation;
	private JTextField textField_id;
	private JTextField textField_product;
	private JTextField textField_location;
	private JTextField textField_grossweight;
	private JTextField textField_itemstatus;
	private JTextField textField_date;
	private JButton btnOk;
	static int id;
	static String name;
	static String location;
	static double gross_weight;
	static Date date;
	static int state;
	static String purity;
	private JLabel lblPurity;
	private JTextField textField_purity;

	/**
	 * Launch the application.
	 */
	public static void getContent()
	{	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
		PreparedStatement stmt =  (PreparedStatement) con.prepareStatement("select * from stocklist where id = ?");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			name = rs.getString(2);
			purity = rs.getString(3);
			location =rs.getString(4);
			gross_weight = rs.getDouble(5);
			date = rs.getDate(6);
			state = rs.getInt(7);
		}
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}
	public static void main(int getid) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					id=getid;
					getContent();
					updateconfirmation window = new updateconfirmation();
					
					window.frmItemizationConfirmation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public updateconfirmation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemizationConfirmation = new JFrame();
		frmItemizationConfirmation.getContentPane().setBackground(new Color(176, 224, 230));
		frmItemizationConfirmation.setTitle("ITEMIZATION - Confirmation");
		frmItemizationConfirmation.setIconImage(Toolkit.getDefaultToolkit().getImage(updateconfirmation.class.getResource("/images/itemization_logo.png")));
		frmItemizationConfirmation.setBounds(100, 100, 470, 337);
		frmItemizationConfirmation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblId = new JLabel("ID");
		
		textField_id = new JTextField();
		textField_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					newitem.main(null);
					frmItemizationConfirmation.dispose();
				}
			}
		});
		textField_id.setEditable(false);
		textField_id.setColumns(10);
		textField_id.setText(String.valueOf(id));
		
		JLabel lblNewLabel = new JLabel("Product");
		
		textField_product = new JTextField();
		textField_product.setEditable(false);
		textField_product.setText(name);
		textField_product.setColumns(10);
		
		
				
		JLabel lblLocation = new JLabel("Location");
		
		textField_location = new JTextField();
		textField_location.setEditable(false);
		textField_location.setText(location);
		textField_location.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Gross Weight");
		
		textField_grossweight = new JTextField();
		textField_grossweight.setEditable(false);
		textField_grossweight.setText(String.valueOf(gross_weight));
		textField_grossweight.setColumns(10);
		
		JLabel lblItemStatus = new JLabel("Item Status");
		
		textField_itemstatus = new JTextField();
		textField_itemstatus.setEditable(false);
		if(state == 1) {
			textField_itemstatus.setText("In Stock");
		}
		else
		{
			textField_itemstatus.setText("Sold Out");
		}
		textField_itemstatus.setColumns(10);
		
		JLabel lblUpdatedDate = new JLabel("Created On");
		
		textField_date = new JTextField();
		textField_date.setEditable(false);
		textField_date.setText(String.valueOf(date));
		textField_date.setColumns(10);
		
		btnOk = new JButton("Ok");
		btnOk.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					newitem.main(null);
					frmItemizationConfirmation.dispose();
				}
			}
		});
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newitem.main(null);
				frmItemizationConfirmation.dispose();
			}
		});
		
		lblPurity = new JLabel("Purity");
		
		textField_purity = new JTextField();
		textField_purity.setEditable(false);
		textField_purity.setText(purity);
		textField_purity.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frmItemizationConfirmation.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(80)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblId)
								.addComponent(lblNewLabel)
								.addComponent(lblLocation)
								.addComponent(lblPurity)
								.addComponent(lblNewLabel_1)
								.addComponent(lblItemStatus)
								.addComponent(lblUpdatedDate))
							.addGap(43)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_itemstatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_location, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(textField_product, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(textField_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField_purity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_grossweight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_date, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(171)
							.addComponent(btnOk)))
					.addContainerGap(143, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(textField_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_product, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPurity)
						.addComponent(textField_purity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocation)
						.addComponent(textField_location, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_grossweight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_itemstatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblItemStatus))
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUpdatedDate)
						.addComponent(textField_date, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnOk)
					.addGap(19))
		);
		frmItemizationConfirmation.getContentPane().setLayout(groupLayout);
	}

}
