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
public class UpdateRoom extends JFrame implements ActionListener{
    Choice c1,c2;
    JTextField t1,t2,t3;
    JButton b1,b2,b3,b4;
    String roomc;
    int idnum;
   
    UpdateRoom(){
      
        JLabel l1 = new JLabel("Update Room Status");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setForeground(Color.blue);
        l1.setBounds(30,20,250,30);
        add(l1);

         JLabel l2 = new JLabel("Guest_ID");
        l2.setBounds(30,80,120,20);
        l2.setFont(new Font ("Tahoma",Font.PLAIN,15));
        add(l2);

        c1 = new Choice();
        try{
            conn c = new conn();
            String str = "Select * from custdetails";
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
         c2 = new Choice();
        try{
            conn c = new conn();
            String str = "Select * from room where available='Available'";
            ResultSet rs =c.s.executeQuery(str);
            c2.add("Select");
            while(rs.next())
            {
                c2.add(rs.getString("room_number"));
            }
        }
       catch (Exception e){
           
       }
        c2.setBounds(380,130,150,25);
        add(c2);
        JLabel l4 = new JLabel("Availability");
        l4.setBounds(30,180,120,20);
        l4.setFont(new Font ("Tahoma",Font.PLAIN,15));
        add(l4);

        t2= new JTextField();
        t2.setBounds(200,180,150,25);
        add(t2);

        JLabel l5 = new JLabel("Clean Status");
        l5.setBounds(30,230,120,20);
        l5.setFont(new Font ("Tahoma",Font.PLAIN,15));
        add(l5);

        t3= new JTextField();
        t3.setBounds(200,230,150,25);
        add(t3);

        b1= new JButton("Check");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(130,300,120,30);
        add(b1);

         b2= new JButton("Update");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(40,350,120,30);
        add(b2);

         b3= new JButton("Back");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setBounds(220,350,120,30);
        add(b3);
          b4= new JButton("Update Room");
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        b4.setBounds(380,170,150,25);
        add(b4);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(500,200,1000,500);
        setVisible(true);setTitle("Update-Room-Status");

    }
     
     public void check(){
          
        
           

        
      
      String room = null;
               String id = c1.getSelectedItem();
               idnum = Integer.parseInt(id);
               conn c = new conn();
               try{
                   ResultSet rs = c.s.executeQuery("select * from custdetails where number = '"+id+"'");
                   while(rs.next())
                   {
                       t1.setText(rs.getString("room"));
                       room = rs.getString("room");
                       roomc= rs.getString("room");
                   }
                    ResultSet rs1 = c.s.executeQuery("select * from room where room_number = '"+room+"'");
                   while(rs1.next())
                   {
                         t2.setText(rs1.getString("available"));
                         t3.setText(rs1.getString("status"));
                   }
                              String str = "Select * from room where available='Available'";
            ResultSet rs2 =c.s.executeQuery(str);
            c2.removeAll();c2.add("Select");
            while(rs2.next())
            {
                
                c2.add(rs2.getString("room_number"));
            }
               }catch(Exception e){}   
     }
       public void actionPerformed(ActionEvent ae)
       {

           if(ae.getSource()==b1)
           {
               check();


           }else if(ae.getSource()==b2)
           {
               try{
                   conn c = new conn();
                   String room = t1.getText();
                   String available = t2.getText();
                   String status = t3.getText();

                   String str = "update room set available = '"+available+"', status = '"+status+"' where room_number = '"+room+"'";
                   
                   c.s.executeUpdate(str);
                   
                   JOptionPane.showMessageDialog(null, "Room status Updated successfully");
               }catch(Exception e){}
           }else if(ae.getSource()==b3)
           { 
               new Receptioncmd().setLocationRelativeTo(null);this.dispose();
             
           }else if(ae.getSource()==b4)
           {
               String room = c2.getSelectedItem();
               try{
                   conn c = new conn();
                String st1 = "update room set available='Available' where room_number = '"+roomc+"'";
                   String str = "update custdetails set room = '"+room+"' where number = '"+idnum+"'";
                String st2 = "update room set available='Occupied' where room_number = '"+room+"'";
                   c.s.executeUpdate(str);
                   c.s.executeUpdate(st1);
                   c.s.executeUpdate(st2);
                   JOptionPane.showMessageDialog(null, "Room status idk successfully");
                  check();
                  
               }catch(Exception e){}
           }

       }

    public static void main(String args[])
    {
         JFrame frame =new UpdateRoom();

        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
