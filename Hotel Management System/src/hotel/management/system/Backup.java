/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author risha
 */
public class Backup extends JFrame implements ActionListener {
      JTable t1;
      JTextField t2;
    JButton b1,b2,b3,b4;
    Choice c1,c2;
    String umm;
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    Backup(){
        
        t1 = new JTable(model);
        t1.setBounds(40, 0, 800, 500);
        add(t1);
        
        t2 = new JTextField();
        t2.setBounds(350, 450, 150, 30);
        
        add(t2);
        c2 = new Choice();
        try{
            c2.add("Select");
            conn c = new conn();
            String str = "Select DISTINCT month from backupc";
            ResultSet rs =c.s.executeQuery(str);
            while(rs.next())
            {
                c2.add(rs.getString("month"));
            }
        }
       catch (Exception e){
           
       }
        c2.setBounds(540,450,150,25);
        c2.setBackground(Color.white);
        add(c2);
        c1 = new Choice();
        try{
            conn c = new conn();
            String str1 = "Select DISTINCT year from backupc";
            ResultSet rs1 =c.s.executeQuery(str1);
            c1.add("Select");
            while(rs1.next())
            {
                c1.add(rs1.getString("year"));
            }
        }
       catch (Exception e){
           
       }
        c1.setBounds(720,450,150,25);
        c1.setBackground(Color.white);
        add(c1);
        JLabel l1 = new JLabel("Date");
        l1.setBounds(380, 400, 150, 30);
        l1.setFont(new Font ("Tahoma",Font.PLAIN,17));

        add(l1);
        JLabel l2 = new JLabel("Month");
        l2.setBounds(570,400,150,25);
        l2.setFont(new Font ("Tahoma",Font.PLAIN,17));

        add(l2);
        JLabel l3 = new JLabel("Year");
        l3.setBounds(750,400,150,25);
        l3.setFont(new Font ("Tahoma",Font.PLAIN,17));

        add(l3);
        b1=new JButton("Load All Data");
        b1.setBounds(350, 560,120,30);
         b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("Back");
        b2.setBounds(570, 560,120,30);
         b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        add(b2);
        b2.addActionListener(this);
        b3=new JButton("Load Data");
        b3.setBounds(350, 500,120,30);
         b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        add(b3);
        b3.addActionListener(this);
        b4=new JButton("Clear");
         b4.setForeground(Color.WHITE);
        b4.setBackground(Color.BLACK);
        b4.setBounds(570, 500,120,30);
        add(b4);
        b4.addActionListener(this);
        
        model.addColumn("ID");
        model.addColumn("ID_Number");
        model.addColumn("Name");
        model.addColumn("Gender");
        model.addColumn("Country");
        model.addColumn("Room");
        model.addColumn("Checked");
        model.addColumn("Deposit");
         model.addColumn("Amount Paid");
          model.addColumn("Date & Time");
         
         JScrollPane pg = new JScrollPane(t1);
      pg.setBackground(Color.WHITE);
       
t1.getColumnModel().getColumn(0).setPreferredWidth(30);
 
t1.getColumnModel().getColumn(3).setPreferredWidth(27);
t1.getColumnModel().getColumn(4).setPreferredWidth(27);
t1.getColumnModel().getColumn(5).setPreferredWidth(27);
t1.getColumnModel().getColumn(6).setPreferredWidth(27);
t1.getColumnModel().getColumn(7).setPreferredWidth(27);
t1.getColumnModel().getColumn(8).setPreferredWidth(27);
t1.getColumnModel().getColumn(9).setPreferredWidth(100);
//t1.getColumnModel().getColumn(3).setPreferredWidth(27);
   Dimension frameSize = new Dimension(1100, 400);
   pg.getViewport().setBackground(Color.white);
   pg.setPreferredSize(frameSize);
        cnt.add(pg);
        cnt.setBackground(Color.white);
        this.pack();
        this.setBackground(Color.WHITE);
        setLayout(null);
        setBounds(200, 100, 1150,650);
        setVisible(true);
        
                setTitle("Customer Backup Details");

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1)
        {
            try {
         
          Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms","root","root");
           String sql = "SELECT * FROM backupc";
           
           
           PreparedStatement pstm=c.prepareStatement(sql);

            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6),Rs.getString(7),Rs.getString(8),Rs.getString(9),Rs.getString(13)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
        }else if(ae.getSource()==b2){
            
           
            
            this.dispose();
        }else if(ae.getSource() == b3)
        {
            try {
         
          Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms","root","root");
       
        String str3 = "select * from backupc where day='"+t2.getText()+"' AND month='"+(String)c2.getSelectedItem()+"' AND year='"+c1.getSelectedItem()+"'";
       String he = (String)c2.getSelectedItem();
       
           String chal = c1.getSelectedItem();
//           int cha = Integer.parseInt(chal);
           String st1 = "select * from backupc where month='"+(String)c2.getSelectedItem()+"' AND year='"+c1.getSelectedItem()+"'"; 
                String lala = "select * from backupc where year='"+c1.getSelectedItem()+"'"; 

         
           umm =t2.getText();
          
     
            
 umm =t2.getText();

        if(umm.equals("") &&!(he.equals("Select"))&&!(chal.equals("Select"))){
                PreparedStatement pstm=c.prepareStatement(st1);
            ResultSet Rs = pstm.executeQuery(); 
            while(Rs.next()){
 model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6),Rs.getString(7),Rs.getString(8),Rs.getString(9),Rs.getString(13)});
            }
         }else if(!umm.equals("") &&!(he.equals("Select"))&&!(chal.equals("Select"))){
           
           PreparedStatement pstm=c.prepareStatement(str3);

            ResultSet Rs1 = pstm.executeQuery();
            while(Rs1.next()){
                model.addRow(new Object[]{Rs1.getString(1), Rs1.getString(2),Rs1.getString(3),Rs1.getString(4),Rs1.getString(5),Rs1.getString(6),Rs1.getString(7),Rs1.getString(8),Rs1.getString(9),Rs1.getString(13)});
            }
        }else if(umm.equals("") &&(he.equals("Select"))&&!(chal.equals("Select"))){
                PreparedStatement pstm=c.prepareStatement(lala);
            ResultSet Rs = pstm.executeQuery(); 
            while(Rs.next()){
 model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6),Rs.getString(7),Rs.getString(8),Rs.getString(9),Rs.getString(13)});
            }
         }
            
           
        } catch (Exception e) {
            
        }
       
        }else if(ae.getSource()==b4){
        
        model.setRowCount(0);
        }
    }
    public static void main(String[] args){
         JFrame frame =new Backup();
        
        frame.setLocationRelativeTo(null);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
