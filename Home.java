
package employee.managment;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author nupur
 */
public class Home extends JFrame implements ActionListener{
    JButton view, add, update,remove;
    Home(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
         ImageIcon Im = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
           Image i1= Im.getImage().getScaledInstance(1110,700,Image.SCALE_DEFAULT);
           ImageIcon i3=new ImageIcon(i1);
           JLabel image = new JLabel(i3);
           image.setBounds(0, 0, 1120, 630);
           add(image);
           
           JLabel heading = new JLabel("Employee Management System");
           heading.setBounds(0,10,400,40);
           heading.setFont(new Font("Raleway",Font.BOLD,25));
           image.add(heading);
           
           add = new JButton("Add Employee");
           add.setBounds(820,80,150,40);
           add.addActionListener(this);
           image.add(add);
           
           view = new JButton("View Employee");
           view.setBounds(640,80,150,40);
           view.addActionListener(this);
           image.add(view);
           
           remove = new JButton("Remove Employee");
           remove.setBounds(720,30,150,40);
           remove.addActionListener(this);
           image.add(remove);
           
        setSize(1120,630);
        setLocation(100,100);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            setVisible(false);
          new AddEmployee();
        }
        else if(ae.getSource() == view){
            setVisible(false);
            new View();
        }
        else if(ae.getSource() == remove){
            setVisible(false);
            new Remove();
        }
    } 
    
    public static void main(String args[]){
        new Home();
        
    }
    
}
