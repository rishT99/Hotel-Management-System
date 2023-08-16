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
public class Room extends JFrame implements ActionListener{
    JTable t1;
    JButton b1,b2,b3,b4;
;    JTextField t2;
    JComboBox c1;
    JCheckBox c2;
    
     
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    Room(){
       
     
        t1 = new JTable(model);
//        t1.setBounds(5000, 4000, 500, 400);
        
        add(t1);
        
        b1=new JButton("Load All Data");
        b1.setBounds(140, 460,120,30);
        add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("Back");
        b2.setBounds(280, 460,120,30);
        add(b2);
        b2.addActionListener(this);
        
      model.addColumn("Room Number");
        model.addColumn("Available");
        model.addColumn("Status");
        model.addColumn("Price");
        model.addColumn("Room type");
//         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/6th.jpeg"));
//       // ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/4th.jpeg"));
//    
//   Image i2 = i1.getImage().getScaledInstance(590,584, Image.SCALE_DEFAULT);
//    ImageIcon i3 = new ImageIcon(i2);
//    JLabel l3 = new JLabel(i3);
//     l3.setBounds(500, 0, 480, 480);
//    add(l3);        
JLabel l8 = new JLabel("Filter to Search Room");
        l8.setFont(new Font("Tahoma",Font.PLAIN,20));
        l8.setForeground(Color.blue);
        l8.setBounds(560,20,250,30);
        add(l8);
        JLabel l9 = new JLabel("Room Number");
        l9.setFont(new Font("Tahoma",Font.PLAIN,15));
//        l9.setForeground(Color.blue);
        l9.setBounds(580,60,100,30);
        add(l9);
        JLabel l1 = new JLabel("Select Bed");
        l1.setFont(new Font("Tahoma",Font.PLAIN,15));
//        l9.setForeground(Color.blue);
        l1.setBounds(760,60,100,30);
        add(l1);
        
          t2= new JTextField();
        t2.setBounds(560,110,150,30);
        add(t2);
        String str[] = {"Select","Single Bed","Double Bed"};
   c1 = new JComboBox(str);
   c1.setBounds(740,110,150,30);
   c1.setBackground(Color.WHITE);
   add(c1);
   c2 = new JCheckBox("Only display Available");
   c2.setBounds(680, 170, 150, 25);
   c2.setBackground(Color.white);
   
   add(c2);
    b3=new JButton("Load Data");
        b3.setBounds(580, 210,120,30);
        add(b3);
        b3.addActionListener(this);
    b4 =new JButton("Clear");
        b4.setBounds(730, 210,120,30);
        add(b4);
        b4.addActionListener(this);
        b1.setBackground(Color.black);
       b2.setBackground(Color.black);
       b3.setBackground(Color.black);
       b4.setBackground(Color.black);
    
        b1.setForeground(Color.white);
        b2.setForeground(Color.white);
        b3.setForeground(Color.white);
        b4.setForeground(Color.white);
       

         JScrollPane pg = new JScrollPane(t1);
      pg.getViewport().setBackground(Color.WHITE);
     getContentPane().setBackground(Color.white);
   Dimension frameSize = new Dimension(500, 400);
   pg.setPreferredSize(frameSize);
        cnt.add(pg);
        cnt.setBackground(Color.white);
        this.pack();
      
      
        setLayout(null);
        setBounds(200, 100, 1020,550);
        setVisible(true); setTitle("Room-Info");
        
        
    }
   
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b3)
        {
            try {
         
          Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms","root","root");
        String str1 = "select * from room";
        String str2 = "select * from room where available='Available'";
        String str3 = "select * from room where available='Available' AND room_type='"+c1.getSelectedItem()+"'";
        String str4 = "select * from room where room_type='"+c1.getSelectedItem()+"'";
        String str5 = "select * from room where room_number='"+t2.getText()+"'";
        String idk = (String) c1.getSelectedItem();
        if(c2.isSelected()){
              if(idk=="Select"){
           PreparedStatement pstm=c.prepareStatement(str2);

            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5)});
            }}else{
                    
           PreparedStatement pstm=c.prepareStatement(str3);

            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5)});
            }
              }
        }else if(idk!="Select"){
             
           PreparedStatement pstm=c.prepareStatement(str4);

            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5)});
            }
        }else if(t2.getText()!=null){
           
           PreparedStatement pstm=c.prepareStatement(str5);

            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5)});
            }
        }
            
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
        }else if(ae.getSource()==b2){
            new Receptioncmd().setLocationRelativeTo(null);this.dispose();
        }else if(ae.getSource()==b1){
            try {
         
          Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms","root","root");
        String str1 = "select * from room";
         PreparedStatement pstm=c.prepareStatement(str1);

            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5)});
            }
        
           //String sql = "SELECT * FROM room";
         } catch (Exception e) {
            System.out.println(e.getMessage());
        }   
        }else if(ae.getSource()==b4){
        
        model.setRowCount(0);
        }
        
    }
    public static void main(String[] args){
         JFrame frame =new Room();
        
        frame.setLocationRelativeTo(null);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
