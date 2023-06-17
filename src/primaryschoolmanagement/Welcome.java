package primaryschoolmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * @author steve hoang
 */

public class Welcome extends JFrame {
    /**
     * Creates new form LoginPage
     */
    public Welcome() {
        initComponents();
        setSize(500, 450);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JButton jButton1 = new JButton();
        JButton jButton2 = new JButton();
        JButton jButton3 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome");
        setResizable(false);

        jLabel1.setFont(new Font("Times New Roman", Font.BOLD, 24));
        jLabel1.setForeground(new Color(153, 0, 0));
        jLabel1.setText("PRIMARY SCHOOL MANAGEMENT");

        jLabel2.setFont(new Font("Times New Roman", Font.BOLD, 18));
        jLabel2.setForeground(new Color(200, 153, 0));
        jLabel2.setText("WELCOME");

        jLabel3.setText("Please select your role:");

        jLabel4.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/primaryschoolmanagement/school.png"))));

        jButton1.setText("ADMIN");
        jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton1ActionPerformed(evt);
            }

            private void JButton1ActionPerformed(ActionEvent evt) {
                StaffLogin adminLogin = new StaffLogin();
                adminLogin.setVisible(true);
                dispose();
            }
        });

        jButton2.setText("TEACHER");
        jButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton2ActionPerformed(evt);
            }

            private void JButton2ActionPerformed(ActionEvent evt) {
                StaffLogin teacherLogin = new StaffLogin();
                teacherLogin.setVisible(true);
                dispose();
            }
        });

        jButton3.setText("STAFF");
        jButton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton3ActionPerformed(evt);
            }

            private void JButton3ActionPerformed(ActionEvent evt) {
                AccountantLogin staffLogin = new AccountantLogin();
                staffLogin.setVisible(true);
                dispose();
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        ));
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(jLabel4)
                    .addGap(27, 27, 27)
                    .addComponent(jLabel1)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel2)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel3)
                    .addGap(18, 18, 18)
                    .addComponent(jButton1)
                    .addGap(18, 18, 18)
                    .addComponent(jButton2)
                    .addGap(18, 18, 18)
                    .addComponent(jButton3)
                    .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Welcome().setVisible(true));
    }
}
