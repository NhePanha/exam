package Exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LockerApplications extends JFrame {
    private JPasswordField passcodeField;
    private JButton enterButton;
    private JLabel statusLabel;
    private String storedPassword;

    public LockerApplications() {
        // Set up the frame
        setTitle("Locker Application");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize storedPassword (for demonstration, you would load this from storage)
        storedPassword = null; // Initially no password set

        // Create components
        passcodeField = new JPasswordField(20);
        enterButton = new JButton("Enter");
        statusLabel = new JLabel("Enter your passcode to set as password or to open the locker.");

        // Set up the layout
        setLayout(new GridLayout(3, 1));
        add(passcodeField);
        add(enterButton);
        add(statusLabel);

        // Add action listener to the button
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] enteredPasscodeChars = passcodeField.getPassword();
                String enteredPasscode = new String(enteredPasscodeChars);

                if (storedPassword == null) {
                    // Set the password for the first time
                    storedPassword = enteredPasscode;
                    statusLabel.setText("Password Set");
                } else {
                    // Verify the entered password
                    if (enteredPasscode.equals(storedPassword)) {
                        statusLabel.setText("Correct Password");
                    } else {
                        statusLabel.setText("Incorrect Password");
                    }
                }

                // Clear the passcode field
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
