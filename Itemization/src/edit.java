import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class edit {

	private JFrame frmIteizationEdit;
	private JTextField textField;
	int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					edit window = new edit();
					window.frmIteizationEdit.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public edit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIteizationEdit = new JFrame();
		frmIteizationEdit.setTitle("ITEIZATION - Edit Search");
		frmIteizationEdit.setIconImage(Toolkit.getDefaultToolkit().getImage(edit.class.getResource("/images/itemization_logo.png")));
		frmIteizationEdit.getContentPane().setBackground(new Color(176, 224, 230));
		
		JLabel lblNewLabel = new JLabel("Enter the ID");
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
				{
					id = Integer.parseInt(textField.getText());
					try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
					PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT * FROM `stocklist` WHERE id = ? and flag = 1");
					pst.setInt(1, id);
					ResultSet rs = pst.executeQuery();
					if(rs.next())
					{
						editconfiration.main(id);
						frmIteizationEdit.dispose();
					}else
					{
						JOptionPane.showMessageDialog(null, "Item Does not Exist or Item Sold Out");
					}
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
				{
					id = Integer.parseInt(textField.getText());
					try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
					PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT * FROM `stocklist` WHERE id = ? and flag = 1");
					pst.setInt(1, id);
					ResultSet rs = pst.executeQuery();
					if(rs.next())
					{
						editconfiration.main(id);
						frmIteizationEdit.dispose();
					}else
					{
						JOptionPane.showMessageDialog(null, "Item Does not Exist or Item Sold Out");
					}
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}else if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmIteizationEdit.dispose();
				}
			}
		});
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				id = Integer.parseInt(textField.getText());
				try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
				PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT * FROM `stocklist` WHERE id = ? and flag = 1");
				pst.setInt(1, id);
				ResultSet rs = pst.executeQuery();
				if(rs.next())
				{
					editconfiration.main(id);
					frmIteizationEdit.dispose();
				}else
				{
					JOptionPane.showMessageDialog(null, "Item Does not Exist or Item Sold Out");
				}
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					HomePage.main(null);
					frmIteizationEdit.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmIteizationEdit.dispose();
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage.main(null);
				frmIteizationEdit.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmIteizationEdit.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addComponent(lblNewLabel)
							.addGap(45)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(94)
							.addComponent(btnSearch)
							.addGap(45)
							.addComponent(btnCancel)))
					.addContainerGap(141, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(74)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearch)
						.addComponent(btnCancel))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		frmIteizationEdit.getContentPane().setLayout(groupLayout);
		frmIteizationEdit.setBounds(100, 100, 450, 300);
		frmIteizationEdit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
