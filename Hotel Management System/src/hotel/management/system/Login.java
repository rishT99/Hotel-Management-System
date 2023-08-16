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
import java.sql.*;
public class Login extends JFrame implements ActionListener{
JTextField t1;
JPasswordField p1;
JButton b1,b2;
JLabel l1,l2;

Login()
{
    
    l1=new JLabel("Username");
    l1.setBounds(40,20, 100,30);
    l2=new JLabel("Password");
    l2.setBounds(40,70, 100,30);
    t1=new JTextField();
    t1.setBounds(150,20,150,30);
    p1=new JPasswordField();
    p1.setBounds(150,70,150,30);
    b1= new JButton("Login");
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
    b1.setBounds(40,150,150,30);
    add(b1);
    b2= new JButton("Cancel");
    b2.setBackground(Color.BLACK);
    b2.setForeground(Color.WHITE);
    b2.setBounds(200,150,150,30);
    add(b2);
    add(l1);
    add(l2);
    add(t1);
    add(p1);
    b1.addActionListener(this);
    b2.addActionListener(this);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/log.png"));
    Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l3 = new JLabel(i3);
    l3.setBounds(350, 10, 200, 200);
   
    add(l3);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    setBounds(600,300,600,300);
    setVisible(true);
    
}
 

public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==b1)
    {
        
    String username = t1.getText();
    String password = p1.getText();
    
    conn c = new conn(); 
    
    String str ="select * from login where username ='"+username+"' and password = '"+password+"'";
    try{
        ResultSet rs = c.s.executeQuery(str);
        if(rs.next()){
            new AdminDash().setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null,"Invalid Username or Password");
        }
        
    }
    catch(Exception e){
        
    }
    }else if(ae.getSource()==b2)
    {
      new LoginAs().setLocationRelativeTo(null);
      this.dispose();
    }
    
}

public static void main(String args[])
{
    JFrame frame =new Login();
        
        frame.setLocationRelativeTo(null);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

}
