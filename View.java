package employee.managment;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author nupur
 */
public class View extends JFrame implements ActionListener{
    Choice emp;
    JTable table;
    JButton s , print , back;
    View()
    {
         getContentPane().setBackground(Color.WHITE);
          setLayout(null);
        
         JLabel search = new JLabel("search by Employee Id");
           search.setBounds(20,30,150,20);
           search.setFont(new Font("serif",Font.PLAIN,20));
           add(search); 
           
           emp = new Choice();
           emp.setBounds(180,20,150,20);
           add(emp);
           try{
               Join c = new Join();
            ResultSet rs= c.s.executeQuery("Select * from employee");
            
            while(rs.next()){ 
                emp.add(rs.getString("empid"));
             
               
           }}
           catch(Exception e){
               
           }
           table = new JTable();
            try{
               Join c = new Join();
            ResultSet rs= c.s.executeQuery("Select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            }
           catch(Exception e){
               
           }
            JScrollPane jsp = new JScrollPane(table);
            jsp.setBounds(0,100,900,600);
            add(jsp);
            
            s=new JButton("search");
           s.setBounds(20, 70, 80, 20);
           s.addActionListener(this);
           add(s);
            
           back=new JButton("back");
           back.setBounds(120, 70, 80, 20);
           back.addActionListener(this);
           add(back);
            
         setSize(900,700);
        setLocation(300,50);
        setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==s){
            String query = "select * from employee where empid='"+emp.getSelectedItem()+"'";
            try{
            Join c = new Join();
            
            ResultSet rs= c.s.executeQuery(query);
            }
            catch(Exception e){
               e.printStackTrace();
           }
        }
        else if (ae.getSource()==back){
            setVisible(false);
            new Home();
        }
        
    }
  public static void main(String args[]){
      new View();
      
  }  
}
