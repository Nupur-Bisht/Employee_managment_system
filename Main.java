
package employee.managment;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author nupur
 */

public class Main extends JFrame implements ActionListener {
   
       Main(){
           getContentPane().setBackground(Color.WHITE);
           
           setLayout(null);
           JLabel heading = new JLabel("Employee Managment System");
           heading.setBounds(80,30,1200,60);
           heading.setFont(new Font("serif",Font.PLAIN,60));
           heading.setForeground(Color.red);
           add(heading);
           
           ImageIcon Im = new ImageIcon(ClassLoader.getSystemResource("icons/main.jpg"));
           Image i1= Im.getImage().getScaledInstance(1110,700,Image.SCALE_DEFAULT);
           ImageIcon i3=new ImageIcon(i1);
           JLabel image = new JLabel(i3);
           image.setBounds(0, 0, 1170, 650);
           add(image);
           
           
           JButton click_here=new JButton("click here to continue");
           click_here.setBounds(400, 400, 300, 50);
           click_here.setBackground(Color.BLACK);
           click_here.setForeground(Color.GREEN);
           click_here.addActionListener(this);
           image.add(click_here);
           
           
           
           setSize(1170,650);
           setLocation(100,50);
           
           setVisible(true);
       }
       public void actionPerformed( ActionEvent ae){
           setVisible(false);
           new Second();
           
       }

  public static void main(String args[])
    {
       new Main(); 
    }
}