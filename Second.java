
package employee.managment;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Second extends JFrame implements ActionListener {
    JTextField username, password;
   Second(){
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       JLabel user = new JLabel("username");
       user.setBounds(40, 20, 100, 30);
       add(user);
       
       username= new JTextField();
       username.setBounds(150, 20, 150, 30);
       add(username);
       
       JLabel p = new JLabel("Password");
       p.setBounds(40, 70, 150, 30);
       add(p);
       
       password= new JTextField();
       password.setBounds(150, 70, 150, 30);
       add(password);
       
       JButton login = new JButton("Login");
       login.setBounds(150,140,150,30);
       login.setBackground(Color.BLACK);
       login.setForeground(Color.WHITE);
       login.addActionListener(this);
       add(login);
       
       ImageIcon Im = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
           Image i1= Im.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
           ImageIcon i3=new ImageIcon(i1);
           JLabel image = new JLabel(i3);
           image.setBounds(350, 0, 200, 200);
           add(image);
           
       
       setSize(600,300);
       setLocation(450,200);
  
       setVisible(true);
   } 
    public void actionPerformed(ActionEvent ae){
        try{
            String name = username.getText();
            String p= password.getText();
            Join c = new Join(); 
            String query = "SELECT * FROM login WHERE username = '" + name + "' AND password = '" + p + "'";
           
            ResultSet rs= c.s.executeQuery(query);
            if(rs.next()){ 
            setVisible(false); 
            new Home(); 
            } 
            else{
                JOptionPane.showMessageDialog(null,"Invalid username or password");
                setVisible(false); 
            }
        }
        catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error while log in");
            
        }
        
        
    }   
       
    
        
    
   public static void main(String args[]){
      new Second();
      
   }

}