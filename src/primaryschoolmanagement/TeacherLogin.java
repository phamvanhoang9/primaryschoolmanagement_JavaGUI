package primaryschoolmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

/**
 * @author steve hoang
 */

public class TeacherLogin extends JFrame {
    /**
     * Creates new form TeacherLogin
     */
    public TeacherLogin() {
        initComponents();
        setSize(400, 450);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel forgotPass = new JLabel();
        JLabel back = new JLabel();
        JButton submit = new JButton();
        JTextField userName = new JTextField();
        JPasswordField pass = new JPasswordField();

        setTitle("Teacher Login");
        setResizable(false);

        jLabel1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        jLabel1.setForeground(new Color(0, 200, 0));
        jLabel1.setText("WELCOME TEACHER");

        jLabel2.setText("Username:");

        jLabel3.setText("Password:");

        forgotPass.setForeground(new Color(255, 99, 55));
        forgotPass.setText("Forgot Password?");
        forgotPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
        forgotPass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                forgotPassMouseClicked(e);
            }
            private void forgotPassMouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "You need to reset password!");
                TeacherIdentity teacherIdentity = new TeacherIdentity();
                teacherIdentity.setVisible(true);
                dispose();
            }
        });
        back.setForeground(new Color(255, 99, 55));
        back.setText("Back");
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backMouseClicked(e);
            }
            private void backMouseClicked(MouseEvent e) {
                Welcome welcome = new Welcome();
                welcome.setVisible(true);
                dispose();
            }
        });

        submit.setText("Submit");
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitActionPerformed(e);
            }

            private void submitActionPerformed(ActionEvent e) {
                String user = userName.getText();
                String password = String.valueOf(pass.getPassword());

                boolean loginSuccessful = checkLogin(user, password);

                if (loginSuccessful) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
                    userName.setText("");
                    pass.setText("");
                }
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(325, 325, 325)
                    .addComponent(back))
                .addGroup(layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addComponent(jLabel1))
                .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addGap(25, 25, 25)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(userName)
                        .addComponent(pass, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))

                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(forgotPass))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(300, 300, 300)
                            .addComponent(submit)))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(back)
                    .addGap(25, 25, 25)
                    .addComponent(jLabel1)
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(25, 25, 25)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(pass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(submit)
                        .addComponent(forgotPass))
                    .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();
    }

    private boolean checkLogin(String user, String password) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/primary_school_management", "root", "999");
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM teacher_login WHERE userID = '" + user + "' AND password = '" + password + "'";
            ResultSet rs = stmt.executeQuery(query);

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        TeacherLogin teacherLogin = new TeacherLogin();
        teacherLogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        teacherLogin.setVisible(true);
    }
}


