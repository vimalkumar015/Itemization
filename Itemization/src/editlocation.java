import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class editlocation {

	private JFrame frmItemizationEdit;
	static ResultSet rs;
	static JComboBox<String> comboBox;

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
					editlocation window = new editlocation();
					fillcombo();
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
	public editlocation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemizationEdit = new JFrame();
		frmItemizationEdit.setTitle("ITEMIZATION - Edit Location");
		frmItemizationEdit.setIconImage(Toolkit.getDefaultToolkit().getImage(editlocation.class.getResource("/images/itemization_logo.png")));
		frmItemizationEdit.getContentPane().setBackground(new Color(176, 224, 230));
		
		JLabel lblLocationName = new JLabel("Location Name");
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {""}));
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					editlocationfinal.main(comboBox.getSelectedItem().toString());
					frmItemizationEdit.dispose(); 
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					location.main(null);
					frmItemizationEdit.dispose(); 
				}
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editlocationfinal.main(comboBox.getSelectedItem().toString());
				frmItemizationEdit.dispose(); 
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				location.main(null);
				frmItemizationEdit.dispose(); 
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmItemizationEdit.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addComponent(lblLocationName)
							.addGap(55)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(87)
							.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(82)
							.addComponent(btnCancel)))
					.addContainerGap(100, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocationName)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(73)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEdit)
						.addComponent(btnCancel))
					.addContainerGap(101, Short.MAX_VALUE))
		);
		frmItemizationEdit.getContentPane().setLayout(groupLayout);
		frmItemizationEdit.setBounds(100, 100, 450, 300);
		frmItemizationEdit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
