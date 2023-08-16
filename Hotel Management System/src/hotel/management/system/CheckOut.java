/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

/**
 *
 * @author risha
 */import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.*;
public class CheckOut extends JFrame implements ActionListener{
  Choice c1;
    JTextField t1,t2,t3,t6;JLabel l8;
    JButton b1,b2,b3,b4;
    int pricep,wow;
     int rd;
     int am;
     String deposit = null;
     
 CheckOut(){
    
     JLabel l1 = new JLabel("Check-in Details");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setForeground(Color.blue);
        l1.setBounds(30,20,250,30);
        add(l1);

         JLabel l2 = new JLabel("Customer_ID");
        l2.setBounds(30,80,120,20);
        l2.setFont(new Font ("Tahoma",Font.PLAIN,15));
        add(l2);

        c1 = new Choice();
        try{
            conn c = new conn();
            String str = "Select * from custdetails where checked='yes'";
            ResultSet rs =c.s.executeQuery(str);
            c1.add("Select");
            while(rs.next())
            {
                c1.add(rs.getString("number"));
            }
        }
       catch (Exception e){

       }
        c1.setBounds(200,80,150,25);
        add(c1);

        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30,130,120,20);
        l3.setFont(new Font ("Tahoma",Font.PLAIN,15));
        add(l3);
        t1= new JTextField();
        t1.setBounds(200,130,150,25);
        add(t1);
        
        JLabel l4 = new JLabel("Name");
        l4.setBounds(30,180,120,20);
        l4.setFont(new Font ("Tahoma",Font.PLAIN,15));
        add(l4);

        t2= new JTextField();
        t2.setBounds(200,180,150,25);
        add(t2);

       
        
        JLabel l5 = new JLabel("Pending Amount");
        l5.setBounds(30,230,120,20);
        l5.setFont(new Font ("Tahoma",Font.PLAIN,15));
        add(l5);
         t3= new JTextField();
        t3.setBounds(200,230,150,25);
        add(t3);
         l8 = new JLabel();
         l8.setFont(new Font("Tahoma",Font.BOLD,15));
        l8.setBounds(0,0,0,0);
       add(l8);
          t6= new JTextField();
        t6.setBounds(380,230,150,25);
       
        
         b4= new JButton();
        b4.setBackground(Color.WHITE);
        b4.setForeground(Color.white);
        b4.setBounds(0,0,0,0);
        b4.setEnabled(false);
        add(b4);
        
           b1= new JButton("Check");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(30,270,100,30);
        add(b1);

         b2= new JButton("CheckOut");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(150,270,100,30);
        add(b2);

         b3= new JButton("Back");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setBounds(270,270,100,30);
        add(b3);
        b1.addActionListener(this);
        b4.addActionListener(this);
        b3.addActionListener(this);
        b2.addActionListener(this);
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/10th.jpeg"));
       // ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/4th.jpeg"));
    
   Image i2 = i1.getImage().getScaledInstance(240,284, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l9 = new JLabel(i3);
     l9.setBounds(380, 40, 580, 180);
    add(l9);        
         getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(500,200,800,400);
        setVisible(true);        setTitle("Check-Out");

    }
 
 
    public void check(){
       String room = null;
               String id = c1.getSelectedItem();
               
               int amountpaid;
               String price=null;
              
               
               conn c = new conn();
               try{
                   ResultSet rs = c.s.executeQuery("select * from custdetails where number = '"+id+"'");
                   while(rs.next())
                   {
                       t1.setText(rs.getString("room"));
                       t2.setText(rs.getString("name"));
                      
                       
                       
                       room = rs.getString("room");
                       deposit = rs.getString("deposit");
                      
                   }
                    ResultSet rs1 = c.s.executeQuery("select * from room where room_number = '"+room+"'");
                   
                    
                    while(rs1.next())
                   {
                        price = rs1.getString("price");
                        amountpaid = Integer.parseInt(price) - Integer.parseInt(deposit);
                       wow=amountpaid;
                         
                         rd=amountpaid;
                         
                   }
                   
//                    ResultSet rs2 = c.s.executeQuery("select * from custdetails where number = '"+id+"'");
//                      while(rs2.next())
//                   {
//                      am = rs2.getInt("amount");
//                         
//                   }
System.out.println(wow);
            if(wow<=0){
                   l8.setText("You have paid amount");
                   l8.setForeground(Color.green);
                   l8.setBounds(380,230,250,30);
                   b4.setBackground(Color.WHITE);
        b4.setForeground(Color.white);
        b4.setBounds(0,0,0,0);
        b4.setEnabled(false);
               }else if(wow >0){
               l8.setText("Pay your rest "+wow+"Rs.");
                l8.setForeground(Color.black);
                l8.setBounds(380,230,250,30);
                b4.setText("Pay");
               b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        b4.setBounds(390,270,100,30);
        b4.setEnabled(true);
               }
                      if(rd==0){
                           pricep = 0;
                           t3.setText(Integer.toString(pricep));
                           t6.setText(Integer.toString(pricep));
                      }else{
                          pricep = rd;
                          t3.setText(Integer.toString(pricep));
                          t6.setText(Integer.toString(pricep));
                      }
               }catch(Exception e){}
    }
    public void ch(){
        try{
            conn c = new conn();
            String str = "Select * from custdetails where checked='yes'";
            ResultSet rs =c.s.executeQuery(str);
            c1.removeAll();
            c1.add("Select");
            while(rs.next())
            {
                
                c1.add(rs.getString("number"));
            }
        }
       catch (Exception e){

       }   t1.setText("");t2.setText("");t3.setText("");t6.setText("");
    }
    
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==b1)
           {
               check();


           }else if(ae.getSource()==b4)
           {
               
               
              
               int tt = Integer.parseInt(t6.getText());
               if(pricep==tt){
                   try{
                   conn c = new conn();
                    String id = c1.getSelectedItem();

                   String str = "update custdetails set deposit = deposit + '"+tt+"' where number = '"+id+"'";
                   c.s.executeUpdate(str);
                   JOptionPane.showMessageDialog(null, "Payment received");
                  check();
//        String text = "Payment received";
//    String title = "Success";
//    int optionType = JOptionPane.OK_CANCEL_OPTION;
//    int result = JOptionPane.showConfirmDialog(null, text, title, optionType);
//    if (result == JOptionPane.OK_OPTION) {
//        check();
//    }

               }catch(Exception e){}
               }else{
                   JOptionPane.showMessageDialog(null, "Customer has not paid the full amount", "warning", HEIGHT);
               }


           }else if(ae.getSource()==b3)
           { 
              new Receptioncmd().setLocationRelativeTo(null);  this.dispose();       
           }else if(ae.getSource()==b2){
               String room = null;
               String id = c1.getSelectedItem();
               String deposit = null;
               int amountpaid;
               String price=null;
              
               
               conn c = new conn();
               try{
                   ResultSet rs = c.s.executeQuery("select * from custdetails where number = '"+id+"'");
                   while(rs.next())
                   {
                       room = rs.getString("room");
                       deposit = rs.getString("deposit");
                      
                   }
                    ResultSet rs1 = c.s.executeQuery("select * from room where room_number = '"+room+"'");
                   
                    
                    while(rs1.next())
                   {
                        price = rs1.getString("price");
                        amountpaid = Integer.parseInt(price) - Integer.parseInt(deposit);
                       
                         
                         rd=amountpaid;
                         
                   }
//                    ResultSet rs2 = c.s.executeQuery("select * from custdetails where number = '"+id+"'");
//                      while(rs2.next())
//                   {
//                      am = rs2.getInt("amount");
//                         
//                   }
                      if(rd<=0){
                          c.s.executeUpdate("update backupc set paid = '"+deposit+"' where number = '"+id+"'");
                         c.s.executeUpdate("delete from custdetails where number = '"+id+"'");
                          c.s.executeUpdate("update room set available = 'Available' where room_number = '"+room+"'");
                           JOptionPane.showMessageDialog(null, "Customer check Out process Successfully");
                       ch();
               
                           
                      }else{
                         
                          JOptionPane.showMessageDialog(null, "Please pay your remaining balance", "warning", HEIGHT);
                      }
               }catch(Exception e){}
           }
    } 
    
    
    public static void main(String[] args){
        
         JFrame frame =new CheckOut();
        
        frame.setLocationRelativeTo(null);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
