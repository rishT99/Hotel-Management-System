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
import java.time.LocalDateTime;  // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;  // Import the DateTimeFormatter
import java.util.ArrayList;
public class AddCustomer extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    JComboBox c1,c3,c4;
    JLabel l11,l12,l13,l14;
    JRadioButton r1,r2,r3;
    ButtonGroup bg;
   
    String id;
    AddCustomer(){
        
        JLabel l1 = new JLabel("NEW CUSTOMER FORM");
        l1.setBounds(100,20,300,30);

        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l1);
        
        JLabel l2 = new JLabel("ID");
        l2.setBounds(35,80,100,20);
        l2.setFont(new Font ("Tahoma",Font.PLAIN,17));

        add(l2);
        
        c1= new JComboBox(new String[]{"Passport","Voter-ID Card","Driving License","Aadhar Card"});
        c1.setBounds(220,80,150,25);
        c1.setBackground(Color.white);
        add(c1);
        
        
        
        JLabel l3 = new JLabel("Number");
        l3.setBounds(35,120,100,20);
                l3.setFont(new Font ("Tahoma",Font.PLAIN,17));
        add(l3);
        
        t1= new JTextField();
        t1.setBounds(220,120,150,25);
        add(t1);
        JLabel l4 = new JLabel("Name");
                l4.setFont(new Font ("Tahoma",Font.PLAIN,17));

        l4.setBounds(35,160,100,20);
        add(l4);
        
         t2= new JTextField();
        t2.setBounds(220,160,150,25);
        add(t2);
        
        JLabel l5 = new JLabel("Gender");
                l5.setFont(new Font ("Tahoma",Font.PLAIN,17));
        l5.setBounds(35,200,100,20);
        add(l5);
        bg = new ButtonGroup();
        r1=new JRadioButton("Male");
        r1.setBounds(210,200,60,25);
        r1.setBackground(Color.white);
        r1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bg.add(r1);
      
        r2=new JRadioButton("Female");
        r2.setBounds(270,200,75,25);
        r2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        r2.setBackground(Color.white);
        bg.add(r2);
        
        r3=new JRadioButton("Other");
        r3.setBounds(342,200,60,25);
        r3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        r3.setBackground(Color.white);
        bg.add(r3);
        add(r1);
   add(r2);
   add(r3);
   l11 = new JLabel();
        l11.setBounds(0,0,0,0);

        add(l11);
         l12 = new JLabel();
        l12.setBounds(0,0,0,0);

      
        add(l12);
       l13 = new JLabel();
        l13.setBounds(0,0,0,0);

        
          
        add(l13);
         l14 = new JLabel();
        l14.setBounds(0,0,0,0);

        
          
        add(l14);
        JLabel l6 = new JLabel("Country");
                l6.setFont(new Font ("Tahoma",Font.PLAIN,17));
        l6.setBounds(35,240,100,20);
        add(l6);
         t3= new JTextField();
        t3.setBounds(220,240,150,25);
        add(t3);
        
        JLabel l7 = new JLabel("Allocated Room Number");
                l7.setFont(new Font ("Tahoma",Font.PLAIN,17));
        l7.setBounds(35,280,180,20);
        add(l7);
        int hi=0;
        
        
        ArrayList<String> hmm = new ArrayList<String>();
        
        try{
            conn c = new conn();
            String str = "Select * from room where available='Available'";
            ResultSet rs =c.s.executeQuery(str);
            
            while(rs.next())
            {hi++;
               hmm.add(rs.getString("room_number"));
            }
        }
       catch (Exception e){
           
       }
       
        
        String sence ="Select ";
        for(String s:hmm)
        {
            sence += s+" ";
        }
     
        String hello[];
        hello = sence.split(" ");
         c4 = new JComboBox(hello);
         
        c4.setBounds(220,280,150,25);
        add(c4);

                if(hi==0){
            c4.removeAllItems();
            
          c4.addItem("Not Available");
        }
              
       
        JLabel l8 = new JLabel("Checked In");
        l8.setBounds(35,320,100,20);
              l8.setFont(new Font ("Tahoma",Font.PLAIN,17));
        add(l8);
        String strc[]={"Yes","No"};
         c3= new JComboBox(strc);
        c3.setBounds(220,320,150,25);
        add(c3);
        JLabel l9 = new JLabel("Deposit");
        l9.setBounds(35,360,100,20);
                l9.setFont(new Font ("Tahoma",Font.PLAIN,17));
        add(l9);
         t5= new JTextField();
        t5.setBounds(220,360,150,25);
        add(t5);
          b1 = new JButton("Add Customer");
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
    b1.setBounds(50,410,120,25);
    add(b1);  b2 = new JButton("Back");
    b2.setBackground(Color.BLACK);
    b2.setForeground(Color.WHITE);
    b2.setBounds(200,410,120,25);
    add(b2);
    c1.setBackground(Color.WHITE);
        c4.setBackground(Color.WHITE);
            c3.setBackground(Color.WHITE);
    c4.addActionListener(this);
    b1.addActionListener(this);
    b2.addActionListener(this);
    
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/7th.jpeg"));
       // ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/4th.jpeg"));
    
   Image i2 = i1.getImage().getScaledInstance(390,384, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l10 = new JLabel(i3);
     l10.setBounds(400, 0, 800, 470);
    add(l10);        
       
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(500,200,1000,500);
        setTitle("Add Customer");
        setVisible(true);
}

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==c4)
        {
            String item=(String) c4.getSelectedItem();
            if(item.equals("Select") || item.equals("Not Available"))
            {
                l11.setText("");
        l11.setBounds(0,0,0,0);

        
         l12.setText("");
        l12.setBounds(0,0,0,0);

      
        
       l13.setText("");
        l13.setBounds(0,0,0,0);

        
          
        
         l14.setText("");
        l14.setBounds(0,0,0,0);

            }
            else{
                String clean=null;
                String bed=null;
                String paise=null;
                  try{
            conn c = new conn();
            String str = "Select * from room where room_number='"+item+"'";
            ResultSet rs =c.s.executeQuery(str);
            while(rs.next())
            {
                clean=rs.getString("status");
                bed=rs.getString("room_type");
                paise=rs.getString("price");
            }
        }
       catch (Exception e){
           
       }
                 l11.setText("↓ Room Details ↓");
        l11.setBounds(440,160,300,30);

        l11.setForeground(Color.BLUE);
        l11.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(l11);
       l12.setText("Cleaning Status: "+clean+"");
        l12.setBounds(410,200,300,30);

      
        l12.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l12);
        l13.setText("Bed Type: "+bed);
        l13.setBounds(410,240,300,30);

        
           l13.setFont(new Font("Tahoma", Font.BOLD, 15));
      l14.setText("Price: "+paise);
        l14.setBounds(410,280,300,30);

        
           l14.setFont(new Font("Tahoma", Font.BOLD, 15));
     
            
            } 
           
        }
        if(ae.getSource()==b1){
            
        String id = (String) c1.getSelectedItem();
         String number = t1.getText();
        String  name = t2.getText();
        String country = t3.getText();
        String room = (String) c4.getSelectedItem();

        String checked = (String)c3.getSelectedItem();
        String deposit = t5.getText();
       
        
      
     if(number.equals("") || name.equals("") || country.equals("") || deposit.equals("") || room.equals("Not Available"))
     {
        JOptionPane.showMessageDialog(null, "Please enter all the details", "",2 );
     }else{
 //        System.out.println("Im in");
        int ark = 0;
    
        try{
            conn c = new conn();
            String str = "Select id,number from custdetails where number LIKE '"+number+"' AND id LIKE '"+id+"'";
            ResultSet rs =c.s.executeQuery(str);
            while(rs.next())
            {
                ark++;
            }
        }
       catch (Exception e){
           
       }
    
        if(ark==0){
        String gender = null;
        if(r1.isSelected())
        {
            gender = "Male";
            
        }else if(r2.isSelected()){
            gender = "Female";
        }else if(r3.isSelected()){
            gender = "Other";
        }
        String job = (String)c1.getSelectedItem();
        int amount=0;
        conn c = new conn();
         LocalDateTime myDateObj = LocalDateTime.now();  
          DateTimeFormatter myFormatObjj = DateTimeFormatter.ofPattern(" MMMM dd yyyy HH:mm:ss");
//          DateTimeFormatter myFormatObjjj = DateTimeFormatter.ofPattern("HH:mm:ss");
             DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd");  
             DateTimeFormatter myFormatOb = DateTimeFormatter.ofPattern("MMMM");
             DateTimeFormatter myFormatO = DateTimeFormatter.ofPattern("yyyy");

String formattedDatee = myDateObj.format(myFormatObjj);
String formattedDate = myDateObj.format(myFormatObj);
String formattedDat = myDateObj.format(myFormatOb);
String formattedDa = myDateObj.format(myFormatO);
        String str = "insert into custdetails values('"+id+"',"+number+",'"+name+"','"+gender+"','"+country+"','"+room+"','"+checked+"','"+deposit+"')";
        String str2 = "insert into backupc values('"+id+"',"+number+",'"+name+"','"+gender+"','"+country+"','"+room+"','"+checked+"','"+deposit+"','"+amount+"','"+formattedDate+"','"+formattedDa+"','"+formattedDat+"','"+formattedDatee+"')";
        String str1 = "update room set available = 'Occupied' where room_number = '"+room+"'";
        
        try{
            c.s.executeUpdate(str);
            c.s.executeUpdate(str1);
            c.s.executeUpdate(str2);
            JOptionPane.showMessageDialog(null,"New Customer Added");
          new Receptioncmd().setLocationRelativeTo(null);
            this.dispose();
        }catch(Exception e){
            System.out.println(e);
        }} else{
                    JOptionPane.showMessageDialog(null, ""+id+" number is already in database", "",2 );
        }
        }    
        }
        if(ae.getSource()==b2)
        {
          new Receptioncmd().setLocationRelativeTo(null);
          this.dispose();
        }
        
       
    }

     public static void main(String[] args){
         JFrame frame =new AddCustomer();
        
        frame.setLocationRelativeTo(null);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}