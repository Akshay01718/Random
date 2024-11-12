package idk;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DivideUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Integer Division");
        JTextField num1Field = new JTextField();
        JTextField num2Field = new JTextField();
        JTextField resultField = new JTextField();
        resultField.setEditable(false);
        
        JButton divideButton = new JButton("Divide");
        
        num1Field.setBounds(50, 50, 150, 20);
        num2Field.setBounds(50, 100, 150, 20);
        resultField.setBounds(50, 150, 150, 20);
        divideButton.setBounds(50, 200, 150, 20);
        
        frame.add(num1Field);
        frame.add(num2Field);
        frame.add(resultField);
        frame.add(divideButton);
        
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        
        divideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(num1Field.getText());
                    int num2 = Integer.parseInt(num2Field.getText());
                    int result = num1 / num2;
                    resultField.setText(String.valueOf(result));
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: Division by zero!", "Arithmetic Exception", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: Please enter valid integers!", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
