import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class newproductname {

	private JFrame frmProductNameEdit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newproductname window = new newproductname();
					window.frmProductNameEdit.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public newproductname() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProductNameEdit = new JFrame();
		frmProductNameEdit.setIconImage(Toolkit.getDefaultToolkit().getImage(newproductname.class.getResource("/images/itemization_logo.png")));
		frmProductNameEdit.setTitle("ITEMIZATION - Product Name Edit");
		frmProductNameEdit.getContentPane().setBackground(new Color(176, 224, 230));
		frmProductNameEdit.setBounds(100, 100, 450, 300);
		frmProductNameEdit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnAddProductName = new JButton("Add Product Name");
		btnAddProductName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					addproductname.main(null);
					frmProductNameEdit.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmProductNameEdit.dispose();
				}
			}
		});
		btnAddProductName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addproductname.main(null);
				frmProductNameEdit.dispose();
			}
		});
		
		JButton btnDeleteProductName = new JButton("Delete Product Name");
		btnDeleteProductName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					productnamedelete.main(null);
					frmProductNameEdit.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmProductNameEdit.dispose();
				}
			}
		});
		btnDeleteProductName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productnamedelete.main(null);
				frmProductNameEdit.dispose();
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					HomePage.main(null);
					frmProductNameEdit.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmProductNameEdit.dispose();
				}
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage.main(null);
				frmProductNameEdit.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmProductNameEdit.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(192, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(187))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addComponent(btnAddProductName)
					.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
					.addComponent(btnDeleteProductName)
					.addGap(49))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(80)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddProductName)
						.addComponent(btnDeleteProductName))
					.addGap(43)
					.addComponent(btnBack)
					.addContainerGap(92, Short.MAX_VALUE))
		);
		frmProductNameEdit.getContentPane().setLayout(groupLayout);
	}
}
