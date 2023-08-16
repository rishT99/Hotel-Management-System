/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//**
 *
 * @author risha
 */
package hotel.management.system;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class EmployeeInfo extends JFrame implements ActionListener {

   JTable t1;
    JButton b1,b2;
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    EmployeeInfo(){
        
        t1 = new JTable(model);
        t1.setBounds(40, 0, 800, 500);
        add(t1);
        
        b1=new JButton("Load Data");
        b1.setBounds(250, 420,120,30);
        add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("Back");
        b2.setBounds(470, 420,120,30);
        add(b2);
        b2.addActionListener(this);
        b1.setBackground(Color.black);
       b2.setBackground(Color.black);
      
 
        b1.setForeground(Color.white);
        b2.setForeground(Color.white);
        model.addColumn("Name");
        model.addColumn("age");
        model.addColumn("Gender");
        model.addColumn("Job");
        model.addColumn("Salary");
        model.addColumn("Phone");
        model.addColumn("Aadhar");
        model.addColumn("Email");
        t1.getColumnModel().getColumn(1).setPreferredWidth(30);
 


t1.getColumnModel().getColumn(7).setPreferredWidth(100);
         JScrollPane pg = new JScrollPane(t1);
       pg.getViewport().setBackground(Color.WHITE);
     getContentPane().setBackground(Color.white);
   Dimension frameSize = new Dimension(800, 400);
   pg.setPreferredSize(frameSize);
        cnt.add(pg);
        
        this.pack();
        this.setBackground(Color.WHITE);
        setLayout(null);
        setBounds(200, 100, 920,500);
        setVisible(true);        setTitle("Employee-Info");
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1)
        {
            try {
         
          Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms","root","root");
           String sql = "SELECT * FROM employee";
           PreparedStatement pstm=c.prepareStatement(sql);

            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString(2), Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6),Rs.getString(7),Rs.getString(8),Rs.getString(9)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
        }else if(ae.getSource()==b2){
            
            
            this.dispose();
        }
    }
    public static void main(String[] args){
         JFrame frame =new EmployeeInfo();
        
        frame.setLocationRelativeTo(null);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
