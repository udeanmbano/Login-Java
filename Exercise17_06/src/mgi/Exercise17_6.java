/*
Author-Udean Mbano
MGI2012-3244
Date-08/04/2014
Version 14.2
A Program that converts inches to centimetres.If you enter a value in the inch text field
and press the Enterkey, the corresponding kilometer measurement is displayed
in the centimeter text field and vice versa.
 */

/*
Udean Mbano `s 24th Birthday
*/

package mgi;

import java.awt.BorderLayout;
import java.awt.FlowLayout; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
 
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
  import javax.swing.border.*;
public class Exercise17_6  extends JFrame { 
  
      private final float CENTIMETERS_IN_INCH = 2.54f; 
      private Converter conv = new Converter();
      JLabel inchLabel = new JLabel("Inches:"); 
      JLabel cmLabel = new JLabel("Centimeters: "); 
      JTextField inchTextField = new JTextField(10); 
      JTextField cmTextField = new JTextField(10); 
      JButton convertUnits = new JButton("Convert");
  
      public Exercise17_6 (String title) { 
            super(title); 
           setBounds(200, 200, 250, 130);           
           Border lineBorder = new LineBorder(Color.BLACK,1);
            Border lineBorder2 = new LineBorder(Color.GRAY,1);
                    JPanel panel = new JPanel();
                    panel.setLayout(new GridLayout(2,1,2,2));
                    panel.add(inchLabel); 
                    panel.add(cmLabel); 
                    panel.setBorder(lineBorder2);
              // second panel with two textfields
            JPanel panel2 = new JPanel();
            panel2.setLayout(new GridLayout(2,1,2,2));
            inchTextField.setToolTipText("your inches");
            cmTextField.setToolTipText("your centimetres");
            panel2.add(inchTextField); 
            panel2.add(cmTextField);           
            panel2.setBorder(lineBorder2);
            // Panel p to hold the label panel and text field panel
            JPanel panel3 = new JPanel();
             panel3.setLayout(new BorderLayout());
             panel3.setBorder(new EmptyBorder(5, 5, 5, 5));
            panel3.add(panel, BorderLayout.WEST);
            panel3.add(panel2, BorderLayout.CENTER);
             panel3.setBorder(lineBorder);
                  // Add p to the frame
          add(panel3);   
    // Register listener
             inchTextField.addActionListener(new Listener()); 
            cmTextField.addActionListener(new Listener());
    

    // frame loaded
   setVisible(true);
      
      } 

      class Listener implements ActionListener {
    @Override // Handle ActionEvent
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == inchTextField) {
               conv.inchtocm();
      }
      else if((e.getSource() == cmTextField)) {
        conv.cmtoinch();
      }
    }
  }
      public static void main(String[] args) { 
           Exercise17_6  Frame = new Exercise17_6 ("Inch2Cm Converter"); 
           Frame.pack();
           Frame.setSize(600,100);
           Frame.setLocationRelativeTo(null);
          Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      } 
      class Converter extends JPanel
      {
       
          public void inchtocm()
          {float inch, cm;
                try { 
                        inch = Float.parseFloat(inchTextField.getText()); 
                        if (inch <= 0) 
                             throw new NumberFormatException(); 
                        cm = inch * CENTIMETERS_IN_INCH; 
                        cmTextField.setText(Float.toString(cm)); 
                  } catch (NumberFormatException ex) { 
                        JOptionPane.showMessageDialog(null, 
                                               "Inches value is invalid. It must be positive float number!"); 
                        inchTextField.setText(""); 
                        inchTextField.grabFocus(); 
                  } 
          }
          
          public void cmtoinch()
          {float inch, cm;
                 try { 
                        cm = Float.parseFloat(cmTextField.getText()); 
                        if (cm <= 0) 
                             throw new NumberFormatException(); 
                        inch = cm / CENTIMETERS_IN_INCH; 
                        inchTextField.setText(Float.toString(inch)); 
                  } catch (NumberFormatException ex) { 
                        JOptionPane.showMessageDialog(null, 
                                               "Centimeters value is invalid. It must be positive float number!"); 
                        cmTextField.setText(""); 
                        cmTextField.grabFocus(); 
                  } 
          }
      }
}