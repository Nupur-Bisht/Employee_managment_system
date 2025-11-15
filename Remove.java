
package employee.managment;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class Remove extends JFrame implements ActionListener {
    Choice emp;
    JButton delete ,back;
    
    Remove(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel labelname = new JLabel("EmployeeID");
           labelname.setBounds(50,50,100,30);
         
           add(labelname);
           
           emp = new Choice();
           emp.setBounds(250,50,150,30);
           add(emp);
        
        try{
               Join c = new Join();
            ResultSet rs= c.s.executeQuery("Select * from employee");
            
            while(rs.next()){ 
                emp.add(rs.getString("empid"));
             
               
           }}
           catch(Exception e){
               e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error while log in");
            
           }
        
     
           JLabel name1 = new JLabel("Name");
           name1.setBounds(50,200,150,30);
        
           add(name1);
           
           JLabel name = new JLabel();
           name.setBounds(200,200,150,30);
         
           add(name);
           
          JLabel labelname1 = new JLabel("Phone Number");
           labelname1.setBounds(50,250,150,30);
           
           add(labelname1);
           
           JLabel ph = new JLabel();
           ph.setBounds(200,250,100,30);
           
           add(ph);
           
           
           JLabel labelname3 = new JLabel("Employee email");
           labelname3.setBounds(50,300,100,30);
          
           add(labelname3);
           
           JLabel em = new JLabel();
           em.setBounds(150,300,100,30);
           
           add(em);
           
           
          
           try{
               Join c = new Join();
            ResultSet rs= c.s.executeQuery("Select * from employee where emp='"+emp.getSelectedItem()+"'");
            
            while(rs.next()){ 
                name.setText(rs.getString("name"));
                ph.setText(rs.getString("phone"));
                em.setText(rs.getString("email"));
            
           }}
           catch(Exception e){
               e.printStackTrace();
           }
           
       emp.addItemListener(new ItemListener() {
    public void itemStateChanged(ItemEvent ie) {
      //  if (ie.getStateChange() == ItemEvent.SELECTED) {
            try {
                Join c = new Join();
                String query = "SELECT * FROM employee WHERE emp = '" + emp.getSelectedItem() + "'";
                ResultSet rs = c.s.executeQuery(query);

                while (rs.next()) {
                    name.setText(rs.getString("name"));
                    ph.setText(rs.getString("phone"));
                    em.setText(rs.getString("email"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    //}
});
           delete=new JButton("Delete");
           delete.setBounds(120, 500, 100, 40);
           delete.setBackground(Color.BLACK);
           delete.setForeground(Color.GREEN);
           delete.addActionListener(this);
           add(delete);
           
           back=new JButton("back");
           back.setBounds(220, 500, 100, 40);
           back.setBackground(Color.BLACK);
           back.setForeground(Color.GREEN);
           back.addActionListener(this);
           add(back);
        
        
        
        setSize(900,600);
        setLocation(300,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete){
           String query = "delete from employee where empid='"+emp.getSelectedItem()+"'";
            try{
            Join c = new Join();
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Details deleted successfully");
            setVisible(false);
            new Home();
            
            
            }
            catch(Exception e){
               e.printStackTrace();
           }
        }
        else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String args[]){
        new Remove();
        
    }
    
}
