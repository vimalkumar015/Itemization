import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginPage {

	private JFrame frmItemizationLogin;
	private JTextField textField_username;
	private JPasswordField passwordField_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frmItemizationLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemizationLogin = new JFrame();
		frmItemizationLogin.getContentPane().setBackground(new Color(176, 224, 230));
		frmItemizationLogin.setBackground(UIManager.getColor("EditorPane.selectionBackground"));
		frmItemizationLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginPage.class.getResource("/images/itemization_logo.png")));
		frmItemizationLogin.setTitle("ITEMIZATION - Login page");
		frmItemizationLogin.setBounds(100, 100, 450, 300);
		frmItemizationLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUserName = new JLabel("User Name");
		
		textField_username = new JTextField();
		textField_username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() ==KeyEvent.VK_ENTER)
				{
				if(textField_username.getText() != null && passwordField_pass.getPassword().toString() != null )
				{
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
						PreparedStatement stmt = con.prepareStatement("select uname,pass from login where uname = ? and pass=?");
						stmt.setString(1, textField_username.getText());
						stmt.setString(2, String.valueOf(passwordField_pass.getPassword()));
						ResultSet rs= stmt.executeQuery();
						if(rs.next())
						{
							HomePage.main(null);
							frmItemizationLogin.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Invalid Username or Password","info",JOptionPane.INFORMATION_MESSAGE);
						}
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
			}
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
					PreparedStatement stmt = con.prepareStatement("select uname,pass,rights from login where uname = ? and pass=?");
					stmt.setString(1, textField_username.getText());
					stmt.setString(2, String.valueOf(passwordField_pass.getPassword()));
					ResultSet rs= stmt.executeQuery();
					if(rs.next())
					{
						if(rs.getString(3) == "admin")
						{
							
						}else
						{
							HomePage.main(null);
							frmItemizationLogin.dispose();
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid Username or Password","info",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
				
			}
		});
		
		JButton btnExit = new JButton("Exit");
		btnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					System.exit(0);
				}
			}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		passwordField_pass = new JPasswordField();
		passwordField_pass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() ==KeyEvent.VK_ENTER)
				{
				if(textField_username.getText() != null && passwordField_pass.getPassword().toString() != null )
				{
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
						PreparedStatement stmt = con.prepareStatement("select uname,pass from login where uname = ? and pass=?");
						stmt.setString(1, textField_username.getText());
						stmt.setString(2, String.valueOf(passwordField_pass.getPassword()));
						ResultSet rs= stmt.executeQuery();
						if(rs.next())
						{
							HomePage.main(null);
							frmItemizationLogin.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Invalid Username or Password","info",JOptionPane.INFORMATION_MESSAGE);
						}
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
			}
			}
		});
		passwordField_pass.setEchoChar('*');
		
		JCheckBox cb_ShowPassword = new JCheckBox("Show Password");
		cb_ShowPassword.setBackground(new Color(176, 224, 230));
		cb_ShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cb_ShowPassword.isSelected()) {
					passwordField_pass.setEchoChar((char)0);
				}
				else {
					passwordField_pass.setEchoChar('*');
				}
			}
		});
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(frmItemizationLogin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUserName)
								.addComponent(lblPassword))
							.addGap(59)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField_pass)
								.addComponent(textField_username, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
								.addComponent(cb_ShowPassword)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(101)
							.addComponent(btnLogin)
							.addGap(33)
							.addComponent(btnExit)))
					.addContainerGap(142, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUserName)
						.addComponent(textField_username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField_pass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cb_ShowPassword)
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin)
						.addComponent(btnExit))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		frmItemizationLogin.getContentPane().setLayout(groupLayout);
	}
}
