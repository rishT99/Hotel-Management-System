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

        
        
public class AdminDash extends JFrame implements ActionListener{
    
    
    JMenuBar mb;
    JMenu m1,m2,m3;
    JMenuItem i1,i2,i3,i4,i5,i6,i7,i9;
    
    AdminDash(){
        
        mb = new JMenuBar();
        add(mb);
        m1 = new JMenu("Management Controls");
        mb.add(m1);
        
        m2 = new JMenu("Admin Controls");
        mb.add(m2);
        m3 = new JMenu("Logout");
        mb.add(m3);
        i9 = new JMenuItem("LOGOUT BYE");
        i9.addActionListener(this);
        m3.add(i9);
        i1 = new JMenuItem("RECEPTION CONTROLS");
        i1.addActionListener(this);
        m1.add(i1);
        i2 = new JMenuItem("ADD EMPLOYEE");
         i2.addActionListener(this);
        m2.add(i2);
        i5 = new JMenuItem("ALL EMPLOYEE INFO");
         i5.addActionListener(this);
        m2.add(i5);
        i6 = new JMenuItem("MANAGER INFO");
         i6.addActionListener(this);
        m2.add(i6);
        i4 = new JMenuItem("DELETE EMPLOYEE");
         i4.addActionListener(this);
        m2.add(i4);
        i3 = new JMenuItem("ADD ROOMS");
         i3.addActionListener(this);
        m2.add(i3);
        
       
        i7 = new JMenuItem("CUSTOMER BACKUP INFO");
         i7.addActionListener(this);
        m2.add(i7);
       
        mb.setBounds(0,0,1950,30);
        
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
         JLabel l3 = new JLabel("Admin Control");
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
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("ADD EMPLOYEE"))
            new AddEmployee().setLocationRelativeTo(null);
        else if(ae.getActionCommand().equals("ADD ROOMS"))
            new AddRooms().setLocationRelativeTo(null);
         else if(ae.getActionCommand().equals("DELETE EMPLOYEE"))
            new DEmployee().setLocationRelativeTo(null);
         else if(ae.getActionCommand().equals("RECEPTION CONTROLS"))
             new Receptioncmd().setLocationRelativeTo(null);
         
         else if(ae.getActionCommand().equals("ALL EMPLOYEE INFO"))
             new EmployeeInfo().setLocationRelativeTo(null);
         else if(ae.getActionCommand().equals("MANAGER INFO"))
             new ManagerInfo().setLocationRelativeTo(null);
         else if(ae.getActionCommand().equals("CUSTOMER BACKUP INFO"))
             new Backup().setLocationRelativeTo(null);
        else if(ae.getActionCommand().equals("LOGOUT BYE"))
        {
            java.awt.Window win[] = java.awt.Window.getWindows();
            for(int i=0;i<win.length;i++){
        win[i].dispose();
        }
        new LoginAs().setLocationRelativeTo(null);
        }
    }
    public static void main(String args[])
{
    JFrame frame =new AdminDash();
        
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
    
    
}
