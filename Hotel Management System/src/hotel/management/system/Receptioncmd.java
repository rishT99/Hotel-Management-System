/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 *
 * @author risha
 */
package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

public class Receptioncmd extends JFrame implements ActionListener{
    
    JButton b1, b2, b5, b7, b8, b9, b11;
    
    Receptioncmd()
    {
        JLabel l1 = new JLabel("***** Welcome To Reception *****");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setForeground(Color.blue);
        l1.setBounds(30,0,350,30);
        add(l1);
         b1 = new JButton("New Customer Form");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(10,110,200,30);
        add(b1); 
        b2 = new JButton("Room");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(10,150,200,30);
        add(b2);
        
        
        
       
        
        b5 = new JButton("Customer Info");
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setBounds(10,190,200,30);
        add(b5);
        
       
        
        b7 = new JButton("Check Out");
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.setBounds(10,230,200,30);
        add(b7);
        
        b8 = new JButton("Update Check Status");
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
        b8.setBounds(10,270,200,30);
        add(b8);
        
        b9 = new JButton("Update Room Status");
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.WHITE);
        b9.setBounds(10,310,200,30);
        add(b9);
        
       
        
        b11 = new JButton("Logout");
        b11.setBackground(Color.BLACK);
        b11.setForeground(Color.WHITE);
        b11.setBounds(10,350,200,30);
        add(b11);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
       
       
        b5.addActionListener(this);
       
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
       
        b11.addActionListener(this);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/5th.jpg"));
       // ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/4th.jpeg"));
    
   Image i2 = i1.getImage().getScaledInstance(490,484, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l3 = new JLabel(i3);
     l3.setBounds(300, 38, 400, 400);
    add(l3);        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(800,540);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            
//            new CheckOut()..setLocationRelativeTo(null);
            new AddCustomer().setLocationRelativeTo(null);
            this.dispose();
        }else if(ae.getSource()==b2)
        {
           
//            new CheckOut()..setLocationRelativeTo(null);
            new Room().setLocationRelativeTo(null);
            this.dispose();
        }else if(ae.getSource()==b5)
        {
           
//            new CheckOut()..setLocationRelativeTo(null);
            new CustomerInfo().setLocationRelativeTo(null);
            this.dispose();
        }else if(ae.getSource()==b7)
        {
//            new CheckOut()..setLocationRelativeTo(null);
            new CheckOut().setLocationRelativeTo(null);
            this.dispose();
        }else if(ae.getSource()==b8)
        {
           
//            new CheckOut()..setLocationRelativeTo(null);
            new UpdateCheck().setLocationRelativeTo(null);
            this.dispose();
        }else if(ae.getSource()==b9)
        {
            
//            new CheckOut()..setLocationRelativeTo(null);
            new UpdateRoom().setLocationRelativeTo(null);
            this.dispose();
        }else if(ae.getSource()==b11)
        {
            java.awt.Window win[] = java.awt.Window.getWindows();
            for(int i=0;i<win.length;i++){
        win[i].dispose();
        }
        new LoginAs().setLocationRelativeTo(null);
        }
    }
    public static void main(String[] args){
         JFrame frame =new Receptioncmd();
        
        frame.setLocationRelativeTo(null);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
