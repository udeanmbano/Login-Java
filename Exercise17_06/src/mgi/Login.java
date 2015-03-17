/*
Author-Udean Mbano
MGI2012-3244
Date-08/04/2014
Version 14.2
A program that validates the username and password entered by the user. If both fields are valid it loads the next frame Exercise17_6.java
which are:
  Username:test
 Password: 12345
 */
/*
Udean Mbano `s 24th Birthday
*/
package mgi;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
  import javax.swing.border.*;
import mgi.Exercise17_6;
public class Login  extends JFrame{
    private JButton jbtLogin=new JButton("Login");
    private JButton jbtExit=new JButton("Exit");
    private JButton jbtClear=new JButton("Clear");
    private JLabel UserName = new JLabel("UserName"); 
    private  JLabel Password = new JLabel("Password "); 
    private JTextField jtUserName = new JTextField(15); 
    private JPasswordField jtPassword = new JPasswordField (15);
 
   
    public Login (String title){
        super(title); 
        //Username for program: test
        //Password: 12345
        // creating panel to hold label and text fields
                   Border lineBorder = new LineBorder(Color.BLACK,1);
            Border lineBorder2 = new LineBorder(Color.GRAY,1);
                    JPanel panel = new JPanel();
                    panel.setLayout(new GridLayout(2,1,2,2));
                    panel.add(UserName); 
                    panel.add(Password); 
                    panel.setBorder(lineBorder2);
                    panel.setBackground(Color.WHITE);
              // second panel with two textfields
            JPanel panel2 = new JPanel();
            panel2.setLayout(new GridLayout(2,1,2,2));
            jtUserName.setToolTipText("Your username");
            jtPassword.setToolTipText("Your Password");
            panel2.add(jtUserName); 
            panel2.add(jtPassword);           
            panel2.setBorder(lineBorder2);
            
                   JPanel panel3 = new JPanel();
                   panel3.setLayout(new FlowLayout());
                 panel3.add(jbtLogin);
             panel3.add(jbtExit);
             panel3.add(jbtClear);
             panel3.setBackground(Color.BLUE);
                JPanel panel4 = new JPanel();
             panel4.setLayout(new BorderLayout());
             panel4.setBorder(new EmptyBorder(5, 5, 5, 5));
  
               panel4.add(panel, BorderLayout.WEST);
            panel4.add(panel2, BorderLayout.CENTER);
             panel4.add(panel3, BorderLayout.SOUTH);
             panel4.setBorder(lineBorder);
             panel4.setBackground(Color.BLUE);
                  // Add p to the frame
          add(panel4); 
          
          // regisiter listener
          jbtLogin.addActionListener(new ActionListener(){
          @Override /**Handle the button action*/
                  public void actionPerformed(ActionEvent e)
                  { 
             String puname = jtUserName.getText();
            String ppaswd = jtPassword.getText();
                       if(puname.equals("test") && ppaswd.equals("12345")) {
                          Exercise17_6 publicArea = new Exercise17_6("Inch2Cm Converter");
                         publicArea.setVisible(true);
                         publicArea.setSize(400,100);
                         publicArea.setLocationRelativeTo(null);
                         publicArea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                         dispose();
                                }
                         else {
                        JOptionPane.showMessageDialog(null,"Wrong Password / Username");
                        jtUserName.setText("");
                        jtPassword.setText("");
                        jtPassword.requestFocus();
                            }
            
                        
            
          }
              
                          
          
          });
              jbtExit.addActionListener(new ActionListener(){
          @Override /**Handle the button action*/
                  public void actionPerformed(ActionEvent e)
                  {
                      if(e.getSource()==jbtExit)
                      {
                            System.exit(0);
                      }
                      
                  }
          
          
          });
                  jbtClear.addActionListener(new ActionListener(){
          @Override /**Handle the button action*/
                  public void actionPerformed(ActionEvent e)
                  {
                      if(e.getSource()==jbtClear)
                      {
                        jtUserName.setText("");
                        jtPassword.setText("");
                      }
                      
                  }
          
          
          });
       }

      public static void main(String[] args) { 
           Login  log = new Login ("LOGON"); 
           log.pack();
          log.setSize(400,300);
          log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          log.setVisible(true);
      } 

}