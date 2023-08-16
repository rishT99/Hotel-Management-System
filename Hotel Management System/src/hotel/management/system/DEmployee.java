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
import java.time.LocalDateTime;  // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;  // Import the DateTimeFormatter
public class DEmployee extends JFrame implements ActionListener{
    JTable t1;
    JButton b1,b2;
  
      JTextField t2;
    JButton b3,b4,b5;
    Choice c1,c2;
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    DEmployee(){
        
        t1 = new JTable(model);
        t1.setBounds(250, 0, 800, 500);
        add(t1);
        JLabel l1 = new JLabel("Filter To Delete Employee");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setForeground(Color.blue);
        l1.setBounds(250,400,250,30);
        add(l1);
         JLabel l3 = new JLabel("Select Job type");
        l3.setBounds(250,450,100,20);
        l3.setFont(new Font ("Tahoma",Font.PLAIN,15));
        add(l3);
        t2 = new JTextField();
        t2.setBounds(700,530, 150, 30);
        add(t2);
         JLabel l2 = new JLabel("Employee ID");
        l2.setBounds(600,535,90,20);
        l2.setFont(new Font ("Tahoma",Font.PLAIN,15));
        add(l2);
        
  c1 = new Choice();
        c1.add("Select");
        try{
            conn c = new conn();
            String str = "Select DISTINCT job from employee";
            ResultSet rs =c.s.executeQuery(str);
            while(rs.next())
            {
                c1.add(rs.getString("job"));
            }
        }
       catch (Exception e){
           
       }
        c1.setBounds(380,450,150,25);
        c1.setBackground(Color.white);
        add(c1);
       
        b1=new JButton("Load All Data");
        b1.setBounds(250, 560,120,30);
        add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("Back");
        b2.setBounds(470, 560,120,30);
        add(b2);
        b2.addActionListener(this);
        b3=new JButton("Load Data");
        b3.setBounds(250, 500,120,30);
        add(b3);
        b3.addActionListener(this);
        b4=new JButton("Clear");
        b4.setBounds(470, 500,120,30);
        add(b4);
        b4.addActionListener(this);
        b5=new JButton("Delete");
        b5.setBounds(870,530,120,30);
        add(b5);
        b5.addActionListener(this);
        
        model.addColumn("id");
        model.addColumn("Name");
        model.addColumn("age");
        model.addColumn("Gender");
        model.addColumn("Job");
        model.addColumn("Salary");
        model.addColumn("Phone");
        model.addColumn("Aadhar");
        model.addColumn("Email");
         JScrollPane pg = new JScrollPane(t1);
      
       b1.setBackground(Color.black);
       b2.setBackground(Color.black);
       b3.setBackground(Color.black);
       b4.setBackground(Color.black);
       b5.setBackground(Color.black);
        b1.setForeground(Color.white);
        b2.setForeground(Color.white);
        b3.setForeground(Color.white);
        b4.setForeground(Color.white);
        b5.setForeground(Color.white);
   pg.getViewport().setBackground(Color.WHITE);
     getContentPane().setBackground(Color.white);
   Dimension frameSize = new Dimension(800, 400);
   pg.setPreferredSize(frameSize);
        cnt.add(pg);
        
        this.pack();
        this.setBackground(Color.WHITE);
        setLayout(null);
        setBounds(200, 100, 1020,650);
        setVisible(true);        setTitle("Delete Employee");
        
        
    }
    public void choicee(){
        
        c1.removeAll();
        c1.add("Select");
        try{
            conn c = new conn();
            String str = "Select DISTINCT job from employee";
            ResultSet rs =c.s.executeQuery(str);
            while(rs.next())
            {
                c1.add(rs.getString("job"));
            }
        }
       catch (Exception e){
           
       }
        c1.setBounds(380,450,150,25);
        c1.setBackground(Color.white);
        add(c1);
    } 
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1)
        {
            try {
         
          Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms","root","root");
           String sql = "SELECT * FROM employee";
           PreparedStatement pstm=c.prepareStatement(sql);
           
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6),Rs.getString(7),Rs.getString(8),Rs.getString(9)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
        }else if(ae.getSource()==b2){
            
            
            
            this.dispose();
        }else if(ae.getSource()==b3){
             try {
          Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms","root","root");
           String sql = "select * from employee where job = '"+(String)c1.getSelectedItem()+"'";
           PreparedStatement pstm=c.prepareStatement(sql);

            ResultSet Rs = pstm.executeQuery();
            
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6),Rs.getString(7),Rs.getString(8),Rs.getString(9)});
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }else if(ae.getSource()==b4){
            model.setRowCount(0);
        }else if(ae.getSource()==b5){
            
             try {
         String name = null;
          Class.forName("com.mysql.jdbc.Driver");
          int id = Integer.parseInt(t2.getText());
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms","root","root");
           String sql = "delete from employee where id="+id+"";
           String sql1 = "insert into backupe(id,name,age,gender,job,salary,phone,aadhar,email,entrydate) select id,Name,age,gender,job,salary,phone,aadhar,email,entrydate from employee where id IN('"+id+"')";
           conn c11= new conn(); 
           String str = "Select * from employee where id='"+Integer.parseInt(t2.getText())+"'";
            ResultSet rs =c11.s.executeQuery(str);
            while(rs.next())
            {
                name = rs.getString("name");
            }
              String sql5 = "SELECT * FROM employee where id='"+Integer.parseInt(t2.getText())+"'";
           PreparedStatement pstm4=c.prepareStatement(sql5);

            ResultSet Rs4 = pstm4.executeQuery();
           
            if(Rs4.next()==false){
                  int type = JOptionPane.ERROR_MESSAGE;
                 
                JOptionPane.showMessageDialog(null, "Employee not found", "", type);
              
            }else{
           int result = JOptionPane.showConfirmDialog(null,"Sure? You want to Delete Employee ' "+name+" '", "",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
   c11.s.executeUpdate(sql1);
    LocalDateTime myDateObj = LocalDateTime.now();  
        DateTimeFormatter myFormatObjj = DateTimeFormatter.ofPattern(" MMMM dd yyyy HH:mm:ss");
        String formattedDatee = myDateObj.format(myFormatObjj);
        String sql18 ="update backupe set exitdate='"+formattedDatee+"' where id = '"+id+"'";
        c11.s.executeUpdate(sql18);
     int haha = c11.s.executeUpdate(sql);
           String um =(String)c1.getSelectedItem() ;
             int type = 2;
                JOptionPane.showMessageDialog(null, "Employee Deleted Successfully", "", type);
                choicee();
            if(haha!=0){
                if(um=="Selected"){
                    
                    model.setRowCount(0);
                     String sql3 = "SELECT * FROM employee";
           PreparedStatement pstm1=c.prepareStatement(sql3);

            ResultSet Rs1 = pstm1.executeQuery();
            while(Rs1.next()){
                model.addRow(new Object[]{Rs1.getString(1), Rs1.getString(2),Rs1.getString(3),Rs1.getString(4),Rs1.getString(5),Rs1.getString(6),Rs1.getString(7),Rs1.getString(8),Rs1.getString(9)});
            }choicee();
             }else{
                    model.setRowCount(0);
                    String sql4 = "select * from employee where job = '"+(String)c1.getSelectedItem()+"'";
           PreparedStatement pstm2=c.prepareStatement(sql4);

            ResultSet Rs2 = pstm2.executeQuery();
            
            while(Rs2.next()){
                model.addRow(new Object[]{Rs2.getString(1), Rs2.getString(2),Rs2.getString(3),Rs2.getString(4),Rs2.getString(5),Rs2.getString(6),Rs2.getString(7),Rs2.getString(8),Rs2.getString(9)});
                         choicee(); 
            }
            
                }}else{
              choicee();
            }
            
            }else if (result == JOptionPane.NO_OPTION){
               
            }else {
                int type = 2;
                JOptionPane.showMessageDialog(null, "You have to say yes or no", "", type);
               
            }}
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
            
        }
    }
    public static void main(String[] args){
         JFrame frame =new DEmployee();
        
        frame.setLocationRelativeTo(null);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
