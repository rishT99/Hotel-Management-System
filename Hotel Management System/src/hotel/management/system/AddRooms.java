/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//**
 *
 * @author risha
 */
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AddRooms extends JFrame implements ActionListener{
   JTextField t1,t2;
   JComboBox c1,c2,c3;
   JButton b1,b2;
   
    AddRooms(){
        
        
        JLabel l1 = new JLabel("Add Rooms");
        l1.setBounds(200,20,100,20);
        l1.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(l1);
        
       JLabel room = new JLabel("Room Number");
       
        room.setFont(new Font("Tahoma", Font.PLAIN, 16));

        room.setBounds(60,80,120,30);
        add(room);
        
        
       JLabel available = new JLabel("Available");
       
        available.setFont(new Font("Tahoma", Font.PLAIN, 16));

        available.setBounds(60,130,120,30);
        add(available);
       
        c1 = new JComboBox (new String[]{"Available","Occupied"});
        c1.setBounds(200, 130, 150, 30);
        c1.setBackground(Color.white);
        add(c1);
        
        
       JLabel status = new JLabel("Cleaning Status");
        status.setFont(new Font("Tahoma", Font.PLAIN, 16));
        status.setBounds(60,180,120,30);
        add(status);
            
        c2 = new JComboBox (new String[]{"Cleaned","Dirty"});
        c2.setBounds(200, 180, 150, 30);
        c2.setBackground(Color.white);
        add(c2);
        
       JLabel price = new JLabel("Price");
        price.setFont(new Font("Tahoma", Font.PLAIN, 16));
        price.setBounds(60,230,120,30);
        add(price);
        
        t1 = new JTextField();
        t1.setBounds(200,80,150,30);
        add(t1);
        
        t2 = new JTextField();
        t2.setBounds(200,230,150,30);
        add(t2);
        
        JLabel type = new JLabel("Bed Type");
        type.setFont(new Font("Tahoma", Font.PLAIN, 16));
        type.setBounds(60,280,120,30);
        add(type);
        
        c3 = new JComboBox (new String[]{"Single Bed","Double Bed"});
        c3.setBounds(200, 280, 150, 30);
        c3.setBackground(Color.white);
        add(c3);
      
        b1 = new JButton("Add Room");
        b1.setBounds(60,350,130,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBounds(220,350,130,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/4th.jpeg"));
    
   Image i2 = i1.getImage().getScaledInstance(1000,850, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l3 = new JLabel(i1);
     l3.setBounds(400, 0, 500, 400);
    add(l3);
    Container c = getContentPane();
    c.setBackground(Color.WHITE);
    setBounds(350,200,1000,500);
    setLayout(null);
    setVisible(true);
            setTitle("Add Room");

    
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b1){
            String room = t1.getText();
            String available = (String)c1.getSelectedItem();
            String status = (String)c2.getSelectedItem();
            String price = t2.getText();
            String type = (String)c3.getSelectedItem();
            
            conn c = new conn();
            try{
                String str = "insert into room values('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";
            
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Room Added Successfully");
                this.dispose();
            }catch(Exception e){
                System.out.println();
            }
    }else if(ae.getSource() == b2){
        this.dispose();
    }
        
        
        
    }
    
     public static void main(String args[]){
        
        JFrame frame =new AddRooms();
        
        frame.setLocationRelativeTo(null);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
