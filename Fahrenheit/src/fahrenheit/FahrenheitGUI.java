/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrenheit;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Ivan Day
 */
public class FahrenheitGUI {
    private int WIDTH = 300;
    private int HEIGHT = 75;
    
    private JFrame frame;
    private JPanel panel;
    private JLabel inputLabel, outputLabel, resultLabel;
    private JTextField fahrenheit;
    
    public FahrenheitGUI(){
        frame = new JFrame ("Temperature Conversion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        inputLabel = new JLabel ("Enter Fahrenheit temperature");
        outputLabel = new JLabel ("Temperature in Celsius: ");
        resultLabel = new JLabel ("--");
        
        fahrenheit = new JTextField(5);
        fahrenheit.addActionListener (new TempListener());
        
        panel = new JPanel();
        panel.setPreferredSize (new Dimension(WIDTH, HEIGHT));
        panel.setBackground(Color.yellow);
        panel.add (inputLabel);
        panel.add (fahrenheit);
        panel.add (outputLabel);
        panel.add (resultLabel);
        
        frame.getContentPane().add (panel);
    }
    
    public void display(){
        frame.pack();
        frame.setVisible(true);
    }
    
    private class TempListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            int fahrenheitTemp, celsiusTemp;
            
            String text = fahrenheit.getText();
            
            fahrenheitTemp = Integer.parseInt(text);
            celsiusTemp = (fahrenheitTemp - 32) * 5/9;
            
            resultLabel.setText(Integer.toString(celsiusTemp));
        }
    }
}
