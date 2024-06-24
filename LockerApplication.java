package Exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LockerApplication extends JFrame {
    private JPasswordField passcodeField;
    private JButton enterButton;
    private JLabel statusLabel;
    private String password;

    public LockerApplication() {
        // Set up the frame
        setTitle("Locker Application");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        passcodeField = new JPasswordField(20);
        enterButton = new JButton("Enter");
        statusLabel = new JLabel("Enter your passcode to set as password.");

        // Set up the layout
        setLayout(new GridLayout(5, 3));
        add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);add(b7);add(b8);add(b9);
        add(passcodeField);
        add(enterButton);
        add(statusLabel);

        // Add action listener to the button
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] passcodeChars = passcodeField.getPassword();
                password = new String(passcodeChars);
                statusLabel.setText("Password Set");
                // Clear the password field
                passcodeField.setText("");
            }
        });
    }

    public static void main(String[] args) {
        // Create and display the application window
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LockerApplication().setVisible(true);
            }
        });
    }
}
