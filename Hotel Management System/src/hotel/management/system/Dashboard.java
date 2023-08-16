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

public class Dashboard extends JFrame{
    
    
    
    
    Dashboard(){
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/2nd.jpg"));
     
       Image i2 = i1.getImage().getScaledInstance(1380,740, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l1 = new JLabel(i3);
    l1.setBounds(0,0,1380,780);
        add(l1);
        JLabel l2 = new JLabel("WELCOME!!....");
        l2.setBounds(580,50,600,50);
        
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Tahoma",Font.TYPE1_FONT,50));
        l1.add(l2);
         JLabel l3 = new JLabel("Reception");
        l3.setBounds(540,680,600,50);
        
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Tahoma",Font.TYPE1_FONT,50));
        l1.add(l3);
        
        Container c = getContentPane();
        c.setBackground(Color.WHITE);
        setLayout(null);
        setBounds(0,0,1950,1000);
        
        setVisible(true);
        
        
    }
    
   
    public static void main(String args[])
{
    JFrame frame =new Dashboard();
        
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
    
    
}
