
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.proteanit.sql.DbUtils;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vimiv
 */
public class instocklist extends javax.swing.JFrame {
	String temp;
	JComboBox comboBox;
	JButton jButton1;
	

    /**
     * Creates new form instocklist
     * @throws SQLException 
     */
	private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {
		if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
    	{
    		search.main(null);
    		this.dispose();
    	}else if(evt.getKeyCode() == KeyEvent.VK_ENTER)
    	{
    		search.main(null);
    		this.dispose();
    	}
	}
	private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {                                    
    	if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
    	{
    		search.main(null);
    		this.dispose();
    	}else if(evt.getKeyCode() == KeyEvent.VK_ENTER)
    	{
    		MessageFormat header = new MessageFormat("In Stock List Report of "+temp);
            MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try {
            jTable1.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(instocklist.class.getName()).log(Level.SEVERE, null, ex);
        }
    	}
    }
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	search.main(null);
		this.dispose();
    }
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { 
		        MessageFormat header = new MessageFormat("In Stock List Report of "+temp);
            MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try {
            jTable1.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(instocklist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        temp = comboBox.getSelectedItem().toString();
        if(temp == "All")
        {
        	jButton1.setEnabled(true);
        	try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
                PreparedStatement pst = conn.prepareStatement("SELECT `id` as ID, `product_name` as PRODUCT, `Purity` as PURITY, `location` as LOCATION, `gross_weight` as `GROSS WEIGHT`, date(`date&time`) as `CREATED ON` FROM `stocklist` WHERE flag = 1");
                PreparedStatement pst1 = conn.prepareStatement("SELECT sum(`gross_weight`) FROM `stocklist` WHERE flag = 1"); 
                ResultSet rs = pst.executeQuery();
                ResultSet rs1 = pst1.executeQuery();
                if(rs != null)
                {
                    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                }
                if(rs1.next())
                {
                	textField.setText(String.valueOf(rs1.getDouble(1))+" Grams" );
                }
                }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }else if(temp == "Gold")
        {
        	jButton1.setEnabled(true);
        	try {
        		Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
                PreparedStatement pst = conn.prepareStatement("SELECT `id` as ID, `product_name` as PRODUCT, `Purity` as PURITY, `location` as LOCATION, `gross_weight` as `GROSS WEIGHT`, date(`date&time`) as `CREATED ON` FROM `stocklist` where (`Purity` = \"Regular\" OR `Purity` = \"KDM\") and `flag` = 1");
                PreparedStatement pst1 = conn.prepareStatement("SELECT sum(`gross_weight`) FROM `stocklist` where (`Purity` = \"Regular\" OR `Purity` = \"KDM\") and `flag` = 1");
                ResultSet rs = pst.executeQuery();
                ResultSet rs1 = pst1.executeQuery();
                if(rs != null)
                {
                    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                }
                if(rs1.next())
                {
                	textField.setText(String.valueOf(rs1.getDouble(1))+" Grams" );
                }
                
        	} catch(Exception e)
            {
                //e.printStackTrace();
            }
        }else if(temp == "Silver")
        {
        	jButton1.setEnabled(true);
        	try {
        		Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
                PreparedStatement pst = conn.prepareStatement("SELECT `id` as ID, `product_name` as PRODUCT, `Purity` as PURITY, `location` as LOCATION, `gross_weight` as `GROSS WEIGHT`, date(`date&time`) as `CREATED ON` FROM `stocklist` where (`Purity` = \"Silver\" OR `Purity` = \"92M-Silver\") and `flag` = 1");
                PreparedStatement pst1 = conn.prepareStatement("SELECT sum(`gross_weight`) FROM `stocklist` where (`Purity` = \"Silver\" OR `Purity` = \"92M-Silver\") and `flag` = 1");
                ResultSet rs = pst.executeQuery();
                ResultSet rs1 = pst1.executeQuery();
                if(rs != null)
                {
                    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                }
                if(rs1.next())
                {
                	textField.setText(String.valueOf(rs1.getDouble(1))+" Grams" );
                }
        	} catch(Exception e)
            {
                e.printStackTrace();
            }
        }else if(temp == "Covering")
        {
        	jButton1.setEnabled(true);
        	try {
        		Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gdlashmi?useSSL=false","root","");
                PreparedStatement pst = conn.prepareStatement("SELECT `id` as ID, `product_name` as PRODUCT, `Purity` as PURITY, `location` as LOCATION, `gross_weight` as `GROSS WEIGHT`, date(`date&time`) as `CREATED ON` FROM `stocklist` where `Purity` = \"Covering\" and `flag` = 1");
                PreparedStatement pst1 = conn.prepareStatement("SELECT sum(`gross_weight`) FROM `stocklist` where `Purity` = \"Covering\" and `flag` = 1");
                ResultSet rs = pst.executeQuery();
                ResultSet rs1 = pst1.executeQuery();
                if(rs != null)
                {
                    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                }
                if(rs1.next())
                {
                	textField.setText(String.valueOf(rs1.getDouble(1))+" Grams" );
                }
        	} catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(temp == "None")
        {
        	DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
        	textField.setText("");
        	jButton1.setEnabled(false);
        }
    }
    
    public instocklist() throws SQLException {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(instocklist.class.getResource("/images/itemization_logo.png")));
    	setTitle("ITEMIZATION - In Stock List");
    	getContentPane().setBackground(new Color(176, 224, 230));
        initComponents();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @throws SQLException 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() throws SQLException {

        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setEnabled(false);
        jTable1 = new javax.swing.JTable();
        jTable1.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        
        JLabel lblType = new JLabel("Type");
        lblType.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        comboBox = new javax.swing.JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"None", "All", "Gold", "Silver", "Covering"}));
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        JLabel lblTotalWeight = new JLabel("Total Weight :");
        
        textField = new JTextField();
        textField.setEditable(false);
        
        textField.setColumns(10);
        
        jButton1 = new JButton("Print");
        jButton1.setEnabled(false);
        
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        JButton jButton2 = new JButton("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(lblType)
        							.addGap(39)
        							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(213)
        					.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(88)
        							.addComponent(lblTotalWeight)
        							.addGap(18)
        							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addGap(143)
        							.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)))))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(22)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblType)
        				.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblTotalWeight))
        			.addGap(30)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButton1)
        				.addComponent(jButton2))
        			.addContainerGap(26, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(instocklist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(instocklist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(instocklist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(instocklist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
					new instocklist().setVisible(true);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private JTextField textField;
}
