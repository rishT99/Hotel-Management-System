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
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class HotelManagementSystem extends JFrame implements ActionListener{
       JButton b1;
    HotelManagementSystem()
    {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/1st.jpg"));
       JLabel l1 = new JLabel(i1);
       
       setLayout(null);
       
       l1.setBounds(100,30,1200,675);
       add(l1);
       
    b1= new JButton("Next to GO...");
       
       b1.setBackground(Color.WHITE);
      b1.setFont(new Font("Italic", Font.PLAIN, 30));
       b1.setBorder(null);
       b1.setForeground(Color.BLACK);
       b1.setBounds(620,680,200,50);
       add(b1);
        getContentPane().setBackground(Color.white);
       b1.addActionListener(this);
               
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        new LoginAs().setLocationRelativeTo(null);
        this.dispose();
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame =new HotelManagementSystem();
        
         frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
    

