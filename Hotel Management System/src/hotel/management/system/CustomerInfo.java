/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

/**
 *
 * @author risha
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class CustomerInfo extends JFrame implements ActionListener {
    
   JTable t1;
    JButton b1,b2;
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
  
     
    CustomerInfo(){
      
        t1 = new JTable(model);
        t1.setBounds(40, 0, 800, 500);
        add(t1);
        
        b1=new JButton("Load Data");
        b1.setBounds(320, 420,120,30);
         b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("Back");
        b2.setBounds(540, 420,120,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        add(b2);
        b2.addActionListener(this);
        
        model.addColumn("ID");
        model.addColumn("ID_Number");
        model.addColumn("Name");
        model.addColumn("Gender");
        model.addColumn("Country");
        model.addColumn("Room");
        model.addColumn("Checked");
        model.addColumn("Deposit");
         JScrollPane pg = new JScrollPane(t1);
      
   Dimension frameSize = new Dimension(800, 400);
   pg.setPreferredSize(frameSize);
   b1.setForeground(Color.white);
        b1.setBackground(Color.black);
   pg.getViewport().setBackground(Color.WHITE);
     getContentPane().setBackground(Color.white);
        cnt.add(pg);
        
        this.pack();
        this.setBackground(Color.WHITE);
        setLayout(null);
        setBounds(200, 100, 860,500);
        setVisible(true);        setTitle("Customer-Info");
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1)
        {
            try {
         
          Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms","root","root");
           String sql = "SELECT * FROM custdetails";
           PreparedStatement pstm=c.prepareStatement(sql);

            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6),Rs.getString(7),Rs.getString(8)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
        }else if(ae.getSource()==b2){
            
           new Receptioncmd().setLocationRelativeTo(null);this.dispose();
        }
    }
    public static void main(String[] args){
         JFrame frame =new CustomerInfo();
        
        frame.setLocationRelativeTo(null);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
