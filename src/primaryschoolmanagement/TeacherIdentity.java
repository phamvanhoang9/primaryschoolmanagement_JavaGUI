package primaryschoolmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

/**
 * @author steve hoang
 */

public class TeacherIdentity extends JFrame {
    /**
     * Creates new form TeacherIdentity
     */
    private JTextField idField;

    public TeacherIdentity() {
        setTitle("Verify your identity");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JLabel back = new JLabel();
        back.setForeground(new Color(255, 99, 55));
        back.setText("Back");
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }

            private void backMouseClicked(java.awt.event.MouseEvent evt) {
                TeacherLogin teacherLogin = new TeacherLogin();
                teacherLogin.setVisible(true);
                dispose();
            }
        });

        JLabel title = new JLabel("Please enter your ID:");
//        title.setHorizontalAlignment(JLabel.CENTER);

        idField = new JTextField();
//        idField.setHorizontalAlignment(JTextField.CENTER);

        JButton submit = new JButton("Submit");
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userID = idField.getText();
                String newPassword = generateNewPassword();
                showNewPassword(userID, newPassword);
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/primary_school_management", "root", "999");
                    updatePassword(userID, newPassword, connection);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(225, 225, 225)
                    .addComponent(back))
                .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(title))
                .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(idField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(175, 175, 175)
                    .addComponent(submit))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(back)
                    .addGap(25, 25, 25)
                    .addComponent(title)
                    .addGap(10, 10, 10)
                    .addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(25, 25, 25)
                    .addComponent(submit))
        );

        panel.add(back);
        panel.add(title);
        panel.add(idField);
        panel.add(submit);

        add(panel);
        setVisible(true);
    }

    private String generateNewPassword() {
        // Generate a new password for the user
        int length = 8;
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*_=+-/.?<>)";

        String availableCharacters = uppercaseLetters + lowercaseLetters + numbers + specialCharacters;

        StringBuilder newPassword = new StringBuilder();
        Random random = new Random();

        // Ensure at least one character from each category is included in the password
        newPassword.append(uppercaseLetters.charAt(random.nextInt(uppercaseLetters.length())));
        newPassword.append(lowercaseLetters.charAt(random.nextInt(lowercaseLetters.length())));
        newPassword.append(numbers.charAt(random.nextInt(numbers.length())));
        newPassword.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));

        // Generate the rest of the password
        for (int i = 0; i < length - 4; i++) {
            newPassword.append(availableCharacters.charAt(random.nextInt(availableCharacters.length())));
        }

        return newPassword.toString();
    }

    private void updatePassword(String userID, String newPassword, Connection conn) throws SQLException {
        // Update the user's password in the database
        String query = "UPDATE teacher_login SET password = ? WHERE userID = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, newPassword);
        pstmt.setString(2, userID);
        pstmt.executeUpdate();
    }

    private void showNewPassword(String userID, String newPassword) {
        String message = "User ID: " + userID + "\nNew Password: " + newPassword;
        JOptionPane.showMessageDialog(null, message, "Password Reset", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        TeacherIdentity teacherIdentity = new TeacherIdentity();
        teacherIdentity.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        teacherIdentity.setVisible(true);
    }
}
