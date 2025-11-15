
package employee.managment;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author nupur
 */
public class AddEmployee extends JFrame implements ActionListener {
    Random ran=new Random();
    int num= ran.nextInt(999999);
  JTextField name , address,phone,email,salary,fname;
  JComboBox edu;
  JLabel emp;
  JButton add,back;
    AddEmployee(){
       
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
         JLabel heading = new JLabel("Add Detaills");
           heading.setBounds(320,30,500,50);
           heading.setFont(new Font("serif",Font.PLAIN,60));
           add(heading);
        
           JLabel labelname = new JLabel("Name");
           labelname.setBounds(50,150,200,30);
           labelname.setFont((new Font("Raleway",Font.PLAIN,20)));
           add(labelname);
           
           name = new JTextField();
           name.setBounds(250,150,200,30);
           //name.addActionListener(this);
           add(name);
           
           JLabel labelname1 = new JLabel("Fathers Name");
           labelname1.setBounds(450,150,200,30);
           labelname1.setFont(new Font("Raleway",Font.PLAIN,20));
           add(labelname1);
           
           fname = new JTextField();
           fname.setBounds(650,150,200,30);
           //name.addActionListener(this);
           add(fname);
           
           JLabel labelname2 = new JLabel("Address");
           labelname2.setBounds(50,200,200,30);
           labelname2.setFont(new Font("Raleway",Font.PLAIN,20));
           add(labelname2);
           
           address = new JTextField();
           address.setBounds(250,200,200,30);
           //name.addActionListener(this);
           add(address);
           
           JLabel labelname3 = new JLabel("email");
           labelname3.setBounds(450,200,200,30);
           labelname3.setFont(new Font("Raleway",Font.PLAIN,20));
           add(labelname3);
           
           email = new JTextField();
           email.setBounds(650,200,200,30);
           add(email);
           
         JLabel labelname4 = new JLabel("salary");
           labelname4.setBounds(50,250,100,30);
           labelname4.setFont(new Font("Raleway",Font.PLAIN,20));
           add(labelname4);
           
           salary = new JTextField();
           salary.setBounds(250,250,200,30);
           //name.addActionListener(this);
           add(salary);
           
           JLabel labelname5 = new JLabel("Employee Number");
           labelname5.setBounds(250,250,200,30);
           labelname5.setFont(new Font("Raleway",Font.PLAIN,20));
           add(labelname5);
           
           phone = new JTextField();
           phone.setBounds(450,250,200,30);
           
           add(phone);
           
         JLabel labele = new JLabel("Highest Education");
           labele.setBounds(50,300,200,30);
           labele.setFont(new Font("Raleway",Font.PLAIN,20));
           add(labele);
           String courses[]={"BBA","BCA","BA", "B.COM","B.TECH","MBA","M.TECH"};
          
           
           edu = new JComboBox(courses);
           edu.setBounds(250,300,200,30);
           //name.addActionListener(this);
           edu.setBackground(Color.WHITE);
           add(edu);
        
           JLabel labelemp = new JLabel("Employee id");
           labelemp.setBounds(450,400,200,30);
           labelemp.setFont(new Font("Raleway",Font.BOLD,25));
           add(labelemp);
           
           emp = new JLabel(""+num);
           emp.setBounds(650,400,200,30);
           emp.setFont(new Font("Raleway",Font.BOLD,25));
           add(emp);
           
           add=new JButton("Add");
           add.setBounds(250, 550, 150, 40);
           add.setBackground(Color.BLACK);
           add.setForeground(Color.GREEN);
           add.addActionListener(this);
           add(add);
           
           back=new JButton("back");
           back.setBounds(450, 550, 150, 40);
           back.setBackground(Color.BLACK);
           back.setForeground(Color.GREEN);
           back.addActionListener(this);
           add(back);
           
           
           
           
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
        String n=name.getText();
        String f=fname.getText();
        String s=salary.getText();
        String p=phone.getText();
        String ad=address.getText();
        String em=email.getText();
        String id=emp.getText();
        String ed =(String)edu.getSelectedItem();
        
        try{
            
            Join c = new Join(); 
            String query = "INSERT INTO employee VALUES ('" + n + "', '" + f + "','" + s + "','" + p + "','" + ad + "','" + em + "','" + id + "','" + ed + "')";
            c.s.executeUpdate(query);
           JOptionPane.showMessageDialog(null,"Details added successfully");
            setVisible(false);
            new Home();
            
            
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
    }
        else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String args[]){
        new AddEmployee();
        
    }

}
