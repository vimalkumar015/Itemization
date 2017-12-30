import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class search {

	private JFrame frmItemizationSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search window = new search();
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
	public search() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemizationSearch = new JFrame();
		frmItemizationSearch.setIconImage(Toolkit.getDefaultToolkit().getImage(search.class.getResource("/images/itemization_logo.png")));
		frmItemizationSearch.setTitle("ITEMIZATION - Search");
		frmItemizationSearch.getContentPane().setBackground(new Color(176, 224, 230));
		frmItemizationSearch.setBounds(100, 100, 450, 300);
		frmItemizationSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnSearchById = new JButton("Search by ID");
		btnSearchById.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					searchbyid.main(null);
					frmItemizationSearch.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmItemizationSearch.dispose();
				}
			}
		});
		btnSearchById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchbyid.main(null);
				frmItemizationSearch.dispose();
			}
		});
		
		JButton btnInStockList = new JButton("In Stock List");
		btnInStockList.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					instocklist.main(null);
					frmItemizationSearch.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmItemizationSearch.dispose();
				}
			}
		});
		btnInStockList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				instocklist.main(null);
				frmItemizationSearch.dispose();
			}
		});
		
		JButton btnSoldOutList = new JButton("Sold Out List");
		btnSoldOutList.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					soldoutlist.main(null);
					frmItemizationSearch.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmItemizationSearch.dispose();
				}
			}
		});
		btnSoldOutList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				soldoutlist.main(null);
				frmItemizationSearch.dispose();
			}
		});
		
		JButton btnSearchByPurity = new JButton("Search by Purity");
		btnSearchByPurity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					searchbypuritynavi.main(null);
					frmItemizationSearch.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmItemizationSearch.dispose();
				}
			}
		});
		btnSearchByPurity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchbypuritynavi.main(null);
				frmItemizationSearch.dispose();
			}
		});
		
		JButton btnCancel = new JButton("Home");
		btnCancel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					HomePage.main(null);
					frmItemizationSearch.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmItemizationSearch.dispose();
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePage.main(null);
				frmItemizationSearch.dispose();
			}
		});
		
		JButton btnSearchByWeight = new JButton("Search by Weight");
		btnSearchByWeight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					searchbyweight.main(null);
					frmItemizationSearch.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					HomePage.main(null);
					frmItemizationSearch.dispose();
				}
			}
		});
		btnSearchByWeight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 searchbyweight.main(null);
				frmItemizationSearch.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmItemizationSearch.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnSearchByWeight, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSoldOutList, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSearchById, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(82)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnInStockList, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSearchByPurity, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(86, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearchById)
						.addComponent(btnInStockList))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSoldOutList)
						.addComponent(btnSearchByPurity))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearchByWeight)
						.addComponent(btnCancel))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		frmItemizationSearch.getContentPane().setLayout(groupLayout);
	}
}
