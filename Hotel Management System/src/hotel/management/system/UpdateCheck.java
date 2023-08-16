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
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateCheck extends JFrame implements ActionListener{
     Choice c1,c11;
     JLabel l8;JFrame frame = new JFrame(); 
    JTextField t1,t2,t3,t4,t5,t6,t7,t22,t33;
    JButton b1,b2,b3,b4,b11,b22;
    int pricep;
     int rd;
     int am,wow=1;
     String roomm = null;
     String deposit = null;
     public static final int BOLD = 1;
   
    UpdateCheck(){
      
     JLabel l1 = new JLabel("Check-in Details");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setForeground(Color.blue);
        l1.setBounds(30,20,250,30);
        add(l1);
JLabel l11 = new JLabel("Change Check-in Status");
        l11.setFont(new Font("Tahoma",Font.PLAIN,20));
        l11.setForeground(Color.blue);
        l11.setBounds(600,20,250,30);
        add(l11);
         JLabel l2 = new JLabel("Customer_ID");
        l2.setBounds(30,80,120,20);
        l2.setFont(new Font ("Tahoma",Font.PLAIN,15));
        add(l2);
         JLabel l22 = new JLabel("Customer_ID");
        l22.setBounds(600,80,120,20);
        l22.setFont(new Font ("Tahoma",Font.PLAIN,15));
        add(l22);

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
        c11 = new Choice();
        try{
            conn c = new conn();
            String str = "Select * from custdetails where checked='No'";
            
            ResultSet rs =c.s.executeQuery(str);
            c11.add("Select");
            while(rs.next())
            {
                
                c11.add(rs.getString("number"));
                
                       
            }
        }
       catch (Exception e){

       }
        c11.setBounds(750,80,150,25);
        add(c11);

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
         JLabel l44 = new JLabel("Name");
        l44.setBounds(600,130,120,20);
        l44.setFont(new Font ("Tahoma",Font.PLAIN,15));
        add(l44);

        t22= new JTextField();
        t22.setBounds(750,130,150,25);
        add(t22);

        JLabel l5 = new JLabel("Check_In");
        l5.setBounds(30,230,120,20);
        l5.setFont(new Font ("Tahoma",Font.PLAIN,15));
        add(l5);
         t3= new JTextField();
        t3.setBounds(200,230,150,25);
        add(t3);
        JLabel l55 = new JLabel("Check_In");
        l55.setBounds(600,180,120,20);
        l55.setFont(new Font ("Tahoma",Font.PLAIN,15));
        add(l55);
         t33= new JTextField();
        t33.setBounds(750,180,150,25);
        add(t33);
        
        JLabel l6 = new JLabel("Room Price");
        l6.setBounds(30,280,120,20);
        l6.setFont(new Font ("Tahoma",Font.PLAIN,15));
        add(l6);
        
         t4= new JTextField();
        t4.setBounds(200,280,150,25);
        add(t4);
        
        JLabel l7 = new JLabel("Amount Paid");
        l7.setBounds(30,330,120,20);
        l7.setFont(new Font ("Tahoma",Font.PLAIN,15));
        add(l7);
         t5= new JTextField();
        t5.setBounds(200,330,150,25);
        add(t5);
         l8 = new JLabel();
        
        l8.setFont(new Font("Tahoma",Font.BOLD,15));
        
        l8.setBounds(0,0,0,0);
        add(l8);
        
         JLabel l88 = new JLabel("↓ Click on button to change Status ↓");
        
        l88.setFont(new Font("Tahoma",Font.BOLD,15));
        
        l88.setBounds(600,280,400,30);
        add(l88);
        JLabel l9 = new JLabel("Pending Amount");
        l9.setBounds(30,380,120,20);
        l9.setFont(new Font ("Tahoma",Font.PLAIN,15));
        add(l9);
        
          t6= new JTextField();
        t6.setBounds(200,380,150,25);
        add(t6);
         
        
           b1= new JButton("Check");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(30,430,100,30);
        add(b1);
        b11= new JButton("Check");
        b11.setBackground(Color.black);
        b11.setForeground(Color.white);
        b11.setBounds(680,230,100,30);
        add(b11);
        b2= new JButton("Status");
        b2.setBackground(Color.green);
        b2.setForeground(Color.white);
        
        b2.setBounds(680,330,100,30);
        add(b2);
b4= new JButton();
        b4.setBackground(Color.WHITE);
        b4.setForeground(Color.white);
        
        add(b4);
       b4.setBorderPainted(false);
b4.setEnabled(false);
         b3= new JButton("Back");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setBounds(200,430,100,30);
        add(b3);
        b11.addActionListener(this);
        b2.addActionListener(this);
        b1.addActionListener(this);
        b4.addActionListener(this);
        b3.addActionListener(this);

        
         getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(500,200,1000,550);
        setVisible(true);setTitle("Update-Check-Status");
    }
   
    public void tp(){
         conn c = new conn();
         try{
        ResultSet rs2 = c.s.executeQuery("select * from custdetails where number = '"+c1.getSelectedItem()+"'");
                   while(rs2.next())
                   {roomm = rs2.getString("room");
                       deposit = rs2.getString("deposit");}
            ResultSet rs1 = c.s.executeQuery("select * from room where room_number = '"+roomm+"'");
                   
                    
                    while(rs1.next())
                   {
                       t4.setText(rs1.getString("price"));
                       String priceee = rs1.getString("price");
                        
                        int gg = Integer.parseInt(priceee) - Integer.parseInt(deposit);
                       
                         
                        wow =gg;
                         
                   }}catch(Exception e){}}
    public void check(){
        tp();
        
        String room = null;
               String id = c1.getSelectedItem();
               if(wow<=0){
                   l8.setText("You have paid your amount");
                   l8.setBounds(380,380,300,30);
                   l8.setForeground(Color.green);
                   b4.setText("");
                 b4.setBackground(Color.WHITE);
        b4.setForeground(Color.white);

                b4.setBounds(0,0,0,0);
                  b4.setEnabled(false);
               }else if(wow >0){
               l8.setText("Want to PAY your rest Money? "+wow+"Rs.");
               l8.setBounds(380,380,320,30);
                l8.setForeground(Color.black);
               b4.setText("Pay");
                b4.setBackground(Color.BLACK);
        b4.setForeground(Color.white);

                b4.setBounds(450,430,100,30);
     b4.setEnabled(true);
   }
               int amountpaid;
               String price=null;
              
               
               conn c = new conn();
               try{
                   ResultSet rs = c.s.executeQuery("select * from custdetails where number = '"+id+"'");
                   while(rs.next())
                   {
                       t1.setText(rs.getString("room"));
                       t2.setText(rs.getString("name"));
                       
                       t3.setText(rs.getString("checked"));
                       t5.setText(rs.getString("deposit"));
                       
                       
                       room = rs.getString("room");
                       deposit = rs.getString("deposit");
                      
                   }
                    ResultSet rs1 = c.s.executeQuery("select * from room where room_number = '"+room+"'");
                   
                    
                    while(rs1.next())
                   {
                       t4.setText(rs1.getString("price"));
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
                      if(rd==0){
                           pricep = 0;
                           
                           t6.setText(Integer.toString(pricep));
                      }else{
                          pricep = rd;
                         
                          t6.setText(Integer.toString(pricep));
                      }
               }catch(Exception e){}
    }
    public void c(){
        try{
            conn c = new conn();
            String str = "Select * from custdetails where checked='Yes'";
            
            ResultSet rs =c.s.executeQuery(str);
             c1.removeAll();c1.add("Select");
            while(rs.next())
            {
               
                c1.add(rs.getString("number"));
                
                       
            }
        }
       catch (Exception e){

       }
    }
     
     public void checkc(){
         
               String id = c11.getSelectedItem();
              
               
               
               conn c = new conn();
               try{
                   ResultSet rs = c.s.executeQuery("select * from custdetails where number = '"+id+"'");
                   while(rs.next())
                   {
                       
                       t22.setText(rs.getString("name"));
                       
                       t33.setText(rs.getString("checked"));
                      
                   }
                   
               }catch(Exception e){}
     }
     public void ch(){
         
        try{
            conn c = new conn();
            String str = "Select * from custdetails where checked='No'";
            
            ResultSet rs =c.s.executeQuery(str);
            c11.removeAll();
                c11.add("Select");
            while(rs.next())
            {
                
                c11.add(rs.getString("number"));
                
                       
            }
        }
       catch (Exception e){

       }
     }
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==b1)
           {
               check();


           }else if(ae.getSource()==b11){
               checkc();
           }else if(ae.getSource()==b2){
               String id = c11.getSelectedItem();
           conn c = new conn();
           try{
               String str ="update custdetails set checked = 'Yes' where number = '"+id+"'";
               String str1 ="update backupc set checked = 'Yes' where number = '"+id+"'";
               c.s.executeUpdate(str);
               c.s.executeUpdate(str1);
               JOptionPane.showMessageDialog(null, "Status Change Successfully");
               ch();c();t22.setText("");t33.setText("");
               
               
           }catch(Exception e){}
           }
         
         else if(ae.getSource()==b4)
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
           new Receptioncmd().setLocationRelativeTo(null);this.dispose();
             
           }
    } 
    
    public static void main(String[] args){
         JFrame frame =new UpdateCheck();
        
        frame.setLocationRelativeTo(null);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
