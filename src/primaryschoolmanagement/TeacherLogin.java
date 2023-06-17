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

public class TeacherLogin extends JFrame implements UserLogin {
    /**
     * Creates new form TeacherLogin
     */

    private JTextField userID;
    private JPasswordField pass;

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
        userID = new JTextField();
        pass = new JPasswordField();

        setTitle("Teacher Login");
        setResizable(false);

        jLabel1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        jLabel1.setForeground(new Color(0, 200, 0));
        jLabel1.setText("WELCOME TEACHER");

        jLabel2.setText("UserID:");

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
                StaffIdentity teacherIdentity = new StaffIdentity();
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
                String user = userID.getText();
                String password = String.valueOf(pass.getPassword());

                boolean loginSuccessful = checkLogin(user, password);

                if (loginSuccessful) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    loginSuccessful();
                } else {
                    showErrorMessage("Invalid username or password. Please try again.");
                    userID.setText("");
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
                        .addComponent(userID)
                        .addComponent(pass, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(forgotPass))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(275, 275, 275)
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
                        .addComponent(userID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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

    public boolean checkLogin(String user, String password) {
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

    @Override
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    @Override
    public void loginSuccessful() {
        TeacherModule teacherModule = new TeacherModule();
        teacherModule.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        StaffLogin teacherLogin = new StaffLogin();
        teacherLogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        teacherLogin.setVisible(true);
    }
}
