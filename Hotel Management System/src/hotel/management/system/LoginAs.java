/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author risha
 */
package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginAs extends JFrame implements ActionListener{

JButton b1,b2,b3;
JLabel l1;

LoginAs()
{
    
    l1=new JLabel("Login As?");
    l1.setBounds(220, 120, 200, 200);
    b1= new JButton("Admin");
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
    b1.setBounds(90,250,150,30);
    add(b1);
    b2= new JButton("Reception");
    b2.setBackground(Color.BLACK);
    b2.setForeground(Color.WHITE);
    b2.setBounds(250,250,150,30);
    add(b2);
    b3= new JButton("Cancel");
    b3.setBackground(Color.BLACK);
    b3.setForeground(Color.WHITE);
    b3.setBounds(350,350,150,30);
    add(b3);
    add(l1);
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/log.png"));
    Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l3 = new JLabel(i3);
    l3.setBounds(150, 10, 200, 200);
   
    add(l3);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    setBounds(400,100,520,420);
    setVisible(true);
    
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==b1)
{
    new Login().setLocationRelativeTo(null);
    this.dispose();
}
else if(ae.getSource()==b2)
{
    new ReceptionL().setLocationRelativeTo(null);
    this.dispose();
}
else if(ae.getSource()==b3){
    System.exit(0);
}
    
}
public static void main(String args[])
{
    JFrame frame =new LoginAs();
        
        frame.setLocationRelativeTo(null);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}



