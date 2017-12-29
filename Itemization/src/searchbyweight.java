 import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class searchbyweight {

	private JFrame frmItemizationSearch;
	private JTextField textField;
	static Double weight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchbyweight window = new searchbyweight();
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
	public searchbyweight() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemizationSearch = new JFrame();
		frmItemizationSearch.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\NirmalGds\\Downloads\\itemization_logo.png"));
		frmItemizationSearch.setTitle("ITEMIZATION - Search by Weight");
		frmItemizationSearch.getContentPane().setBackground(new Color(176, 224, 230));
		
		JLabel lblEnterTheWeight = new JLabel("Enter the Weight to filter");
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char vchar = evt.getKeyChar();
				if(vchar == KeyEvent.VK_ENTER)
		        {
		        	weight = Double.parseDouble(textField.getText());
					searchbyweightresult.main(weight);
					frmItemizationSearch.dispose();
		        }else if((Character.isDigit(vchar))||(vchar==KeyEvent.VK_PERIOD)||(vchar==KeyEvent.VK_BACK_SPACE)){
		            if(vchar==KeyEvent.VK_PERIOD){ 
		                        String s=textField.getText();
		                        int dot=s.indexOf('.');
		                        if(dot!=-1){
		                            evt.consume();
		                        }
		                    }
		        }
		        else{    
		            evt.consume();
		        }
			}
		});
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					weight = Double.parseDouble(textField.getText());
					searchbyweightresult.main(weight);
					frmItemizationSearch.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					 search.main(null);
					 frmItemizationSearch.dispose();
				}
					
			}
		});
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				weight = Double.parseDouble(textField.getText());
				searchbyweightresult.main(weight);
				frmItemizationSearch.dispose();
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					search.main(null);
					 frmItemizationSearch.dispose();
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					 search.main(null);
					 frmItemizationSearch.dispose();
				}
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
							.addGap(36)
							.addComponent(lblEnterTheWeight)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(136)
							.addComponent(btnSearch)
							.addGap(39)
							.addComponent(btnBack)))
					.addContainerGap(105, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterTheWeight)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(82)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearch)
						.addComponent(btnBack))
					.addContainerGap(107, Short.MAX_VALUE))
		);
		frmItemizationSearch.getContentPane().setLayout(groupLayout);
		frmItemizationSearch.setBounds(100, 100, 450, 300);
		frmItemizationSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
