package idk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
 
public class Savetext {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Save Text Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        // Create the text field for input
        JTextField textField = new JTextField(20);
        frame.add(textField);

        // Create the save button
        JButton saveButton = new JButton("Save");
        frame.add(saveButton);

        // Add action listener to the button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
                    writer.write(text);
                    JOptionPane.showMessageDialog(frame, "Text saved to output.txt");
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(frame, "Error saving text: " + ioException.getMessage());
                }
            }
        });

        frame.setVisible(true);
    }
}