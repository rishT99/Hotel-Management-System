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
import java.sql.ResultSet;
import java.time.LocalDateTime;  // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;  // Import the DateTimeFormatter

public class AddEmployee extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5,t6;
    ButtonGroup b1;
    JRadioButton r1,r2,r3;
    JComboBox c1;
    JButton b2,b3;
    AddEmployee()
    {
    JLabel name = new JLabel("Name");
    name.setFont(new Font ("Tahoma",Font.PLAIN,17));
    name.setBounds(60,30,120,30);
    add(name);
    t1 = new JTextField();
    t1.setBounds(200,30,150,30);
    add(t1);
    
    JLabel age = new JLabel("Age");
    age.setFont(new Font ("Tahoma",Font.PLAIN,17));
    age.setBounds(60,80,120,30);
    add(age);
    t2 = new JTextField();
    t2.setBounds(200,80,150,30);
    add(t2);
    
    
    
    JLabel gender = new JLabel("Gender");
    gender.setFont(new Font ("Tahoma",Font.PLAIN,17));
    gender.setBounds(60,130,120,30);
   add(gender);
   b1 = new ButtonGroup();
   r1 = new JRadioButton("Male");
   r1.setFont(new Font("Tahoma", Font.PLAIN, 14));
   r1.setBounds(200,130,54,30);
   r2 = new JRadioButton("Female");
   r2.setFont(new Font("Tahoma", Font.PLAIN, 14));
   r2.setBounds(254,130,70,30);
   r1.setBackground(Color.WHITE);
   r2.setBackground(Color.WHITE);
 r3=new JRadioButton("Other");
        r3.setBounds(327,130,70,30);
        r3.setBackground(Color.white);
           r3.setFont(new Font("Tahoma", Font.PLAIN, 14));

        b1.add(r3);
        add(r3);
   b1.add(r1);
   b1.add(r2);
   add(r1);
   add(r2);
setTitle("Add Employee");
    JLabel jo = new JLabel("Job");
    jo.setFont(new Font ("Tahoma",Font.PLAIN,17));
    jo.setBounds(60,180,120,30);
   add(jo);
   int r=0;int hi;String a = null;String b=null;String cc=null;String m1 = "Manager";String m2 ="Cleaning Manager";String m3 = "Security Manager";
   try{
       
   conn c = new conn();
       String str = "select job from employee where job LIKE '%manager' order by job";
       ResultSet rs =c.s.executeQuery(str);
     while(rs.next()){
           r=rs.getRow();
          
       } 
              rs.absolute(1);
       a=rs.getString(1);      
          rs.absolute(2);
       b=rs.getString(1); rs.absolute(3);
       cc=rs.getString(1);
        
       
           
      
   }catch(Exception e){}
//   System.out.println(a);
//           System.out.println(b);
//           System.out.println(cc);
//           System.out.println(r);
   if(r==0){
   String str[] = {"Manager","Kitchen Staff Manager","Security Manager","Front Desk Clerks","Housekeeping","Kitchen staff","Room Cleaner","Cleaning Manager","Room Service","Waiter","Accountant"};
   c1 = new JComboBox(str);
   c1.setBounds(200,180,150,30);
   c1.setBackground(Color.WHITE);
   add(c1);
   }else if(r==3){
    String str[] = {"Front Desk Clerks","Housekeeping","Kitchen staff","Room Cleaner","Room Service","Waiter","Accountant"};
   c1 = new JComboBox(str);
   c1.setBounds(200,180,150,30);
   c1.setBackground(Color.WHITE);
   add(c1);
   }else if(m1.equals(a)||m1.equals(b)||m1.equals(cc) ){
          String str[] = {"Kitchen Staff Manager","Security Manager","Front Desk Clerks","Housekeeping","Kitchen staff","Room Cleaner","Cleaning Manager","Room Service","Waiter","Accountant"};
c1 = new JComboBox(str);
   c1.setBounds(200,180,150,30);
   c1.setBackground(Color.WHITE);
   add(c1);
   }else if(m2.equals(a)||m2.equals(b)||m2.equals(cc) ){
          String str[] = {"Manager","Security Manager","Front Desk Clerks","Housekeeping","Kitchen staff","Room Cleaner","Cleaning Manager","Room Service","Waiter","Accountant"};
c1 = new JComboBox(str);
   c1.setBounds(200,180,150,30);
   c1.setBackground(Color.WHITE);
   add(c1);
   }else if(m3.equals(a)||m3.equals(b)||m3.equals(cc) ){
          String str[] = {"Manager","Kitchen Staff Manager","Front Desk Clerks","Housekeeping","Kitchen staff","Room Cleaner","Cleaning Manager","Room Service","Waiter","Accountant"};
c1 = new JComboBox(str);
   c1.setBounds(200,180,150,30);
   c1.setBackground(Color.WHITE);
   add(c1);
   }
   JLabel salary = new JLabel("Salary");
   salary.setFont(new Font ("Tahoma",Font.PLAIN,17));
    salary.setBounds(60,230,120,30);
   add(salary);
   t3 = new JTextField();
    t3.setBounds(200,230,150,30);
    add(t3);
    
     JLabel phone = new JLabel("Phone");
   phone.setFont(new Font ("Tahoma",Font.PLAIN,17));
    phone.setBounds(60,280,120,30);
   add(phone);
   t4 = new JTextField();
    t4.setBounds(200,280,150,30);
    add(t4);
    
     JLabel aadhar = new JLabel("Aadhar");
   aadhar.setFont(new Font ("Tahoma",Font.PLAIN,17));
    aadhar.setBounds(60,330,120,30);
   add(aadhar);
   t5 = new JTextField();
    t5.setBounds(200,330,150,30);
    add(t5);
    JLabel l2 = new JLabel("Add Employee Details");
   l2.setFont(new Font ("Tahoma",Font.PLAIN,30));
   l2.setForeground(Color.PINK);
    l2.setBounds(420,30,400,30);
   add(l2);
   
    
     JLabel email = new JLabel("Email");
   email.setFont(new Font ("Tahoma",Font.PLAIN,17));
    email.setBounds(60,380,120,30);
   add(email);
   t6 = new JTextField();
    t6.setBounds(200,380,150,30);
    add(t6);
     b3 = new JButton("Cancel");
        b3.setBounds(200,430,150,30);
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        add(b3);
        b3.addActionListener(this);
       
    b2 = new JButton("Submit");
    b2.setBackground(Color.BLACK);
    b2.setForeground(Color.WHITE);
    b2.setBounds(40,430,150,30);
    add(b2);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/3.jpg"));
    
   Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l3 = new JLabel(i1);
     l3.setBounds(300, 0, 500, 500);
    add(l3);
    b2.addActionListener(this);

    Container c = getContentPane();
    c.setBackground(Color.WHITE);
    setLayout(null);
    setBounds(400,200,800,550);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
        
        if(ae.getSource()==b2){
        String name = t1.getText();
        String age = t2.getText();
        String salary = t3.getText();
        String phone = t4.getText();
        String aadhar = t5.getText();
        String email = t6.getText();
        if(name.equals("")||age.equals("")||salary.equals("")||phone.equals("")||aadhar.equals("")||email.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter all the details", "",2 );
        }else{
            int ark = 0;
    int p = 0;
        try{
            conn c = new conn();
            String str = "Select aadhar from employee where aadhar LIKE '"+aadhar+"'";
            ResultSet rs =c.s.executeQuery(str);
            while(rs.next())
            {
                ark++;
            }
        }
       catch (Exception e){
           
       }
    
        
                try{
            conn c = new conn();
            String str = "Select phone from employee where phone LIKE '"+phone+"'";
            ResultSet rs =c.s.executeQuery(str);
            while(rs.next())
            {
                p++;
            }
        }
       catch (Exception e){
           
       }
        
    int a=Integer.parseInt(age); 
    
    if(ark==0&&p==0&&a>18){
                
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
        
        conn c = new conn();
         LocalDateTime myDateObj = LocalDateTime.now();  
        DateTimeFormatter myFormatObjj = DateTimeFormatter.ofPattern(" MMMM dd yyyy HH:mm:ss");
        String formattedDatee = myDateObj.format(myFormatObjj);
        String n = null;
        String str = "insert into employee values(null,'"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"','"+formattedDatee+"')";
        try{
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"New Employee Added");
           this.dispose();
        }catch(Exception e){
            System.out.println(e);
        }
    }else{
              
             
        if(a<=18 && p!=0&&ark!=0){  
                 JOptionPane.showMessageDialog(null, " 'Aadhar' number And 'Phone' number is already in database \n'Age' must be higher than 18 ", "",2 );
             }
        else if(ark!=0&&a<=18){
            JOptionPane.showMessageDialog(null, " 'Aadhar' number And is already in database \n'Age' must be higher than 18 ", "",2 );
        }
        else if(ark!=0&&p!=0){
            JOptionPane.showMessageDialog(null, " 'Aadhar' number And 'Phone' number is already in database", "",2 );
        }
        else if(p!=0&&a<=18){
                JOptionPane.showMessageDialog(null, "'Phone' number is already in database \n'Age' must be higher than 18 ", "",2 );
                }
        else if(p!=0&&ark!=0){
    
   JOptionPane.showMessageDialog(null, " 'Aadhar' number And 'Phone' number is already in database", "",2 );

                }
        else if(a<=18&&ark!=0){
     JOptionPane.showMessageDialog(null, " 'Aadhar' number is already in database \n'Age' must be higher than 18 ", "",2 );

        }else if(a<=18&&p!=0){
  JOptionPane.showMessageDialog(null, " 'Phone' number is already in database \n'Age' must be higher than 18 ", "",2 );

        }
            else if(a<=18){
            JOptionPane.showMessageDialog(null, " 'Age' must be higher than 18", "",2 );
        }
        else if(p!=0){
                JOptionPane.showMessageDialog(null, " 'Phone' number is already in database", "",2 );
                }
        else if(ark!=0){
    
   JOptionPane.showMessageDialog(null, " 'Aadhar' number is already in database", "",2 );
                }
    }
//        }else{
//   JOptionPane.showMessageDialog(null, " 'Age' must be higher than 18", "",2 );
//                }
//        
//        }else{
//   JOptionPane.showMessageDialog(null, " 'Phone' number is already in database", "",2 );
//                }
//        }else{
//   JOptionPane.showMessageDialog(null, " 'Aadhar' number is already in database", "",2 );
//                }
        }
        }
        
        
        
        
        
        else if(ae.getSource()==b3){
            this.dispose();
        }
    }
    
    public static void main(String args[]){
        
        JFrame frame =new AddEmployee();
        
        frame.setLocationRelativeTo(null);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
// int n=0;
//                try{
//            conn c = new conn();
//            String str = "Select phone from employee where phone LIKE '"+phone+"'";
//            ResultSet rs =c.s.executeQuery(str);
//            while(rs.next())
//            {
//                n++;
//            }
//        }
//       catch (Exception e){
//           
//       }
//                         
//        int a=Integer.parseInt(age);        
//             
//        if(a<=18 || n!=0){  
//                 JOptionPane.showMessageDialog(null, " 'Aadhar' number And 'Phone' number is already in database \n'Age' must be higher than 18 ", "",2 );
//             }
    