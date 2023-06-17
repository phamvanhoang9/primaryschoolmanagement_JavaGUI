package primaryschoolmanagement;

import javax.swing.*;
import java.awt.*;

/**
 * @author steve hoang
 */

public class AdminModule extends JFrame {
    /**
     * Creates new form AdminModule
     */

    public AdminModule() {
        setTitle("Admin Module");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 400);
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
                StaffLogin adminLogin = new StaffLogin();
                adminLogin.setVisible(true);
                dispose();
            }
        });

        JLabel title = new JLabel("ADMIN MENU");
        title.setFont(new Font("Times New Roman", Font.BOLD, 18));
        title.setForeground(new Color(0, 200, 0));

        JButton teacherManagement = new JButton("Teacher Management");
        teacherManagement.setCursor(new Cursor(Cursor.HAND_CURSOR));
        teacherManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherManagementActionPerformed(evt);
            }

            private void teacherManagementActionPerformed(java.awt.event.ActionEvent evt) {
                TeacherModule teacherModule = new TeacherModule();
                teacherModule.setVisible(true);
                dispose();
            }
        });

        JButton staffManagement = new JButton("Staff Management");
        staffManagement.setCursor(new Cursor(Cursor.HAND_CURSOR));
        staffManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffManagementActionPerformed(evt);
            }

            private void staffManagementActionPerformed(java.awt.event.ActionEvent evt) {
                FinanceModule staffModule = new FinanceModule();
                staffModule.setVisible(true);
                dispose();
            }
        });

        JButton studentManagement = new JButton("Student Management");
        studentManagement.setCursor(new Cursor(Cursor.HAND_CURSOR));
        studentManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentManagementActionPerformed(evt);
            }

            private void studentManagementActionPerformed(java.awt.event.ActionEvent evt) {
                StudentModule studentModule = new StudentModule();
                studentModule.setVisible(true);
                dispose();
            }
        });

        JButton financeManagement = new JButton("Finance Management");
        financeManagement.setCursor(new Cursor(Cursor.HAND_CURSOR));
        financeManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                financeManagementActionPerformed(evt);
            }

            private void financeManagementActionPerformed(java.awt.event.ActionEvent evt) {
                FinanceModule financeModule = new FinanceModule();
                financeModule.setVisible(true);
                dispose();
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(back)
                    .addGap(100, 100, 100)
                    .addComponent(title)
                    .addContainerGap(100, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGap(100, 100, 100)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(teacherManagement, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(staffManagement, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(studentManagement, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(financeManagement, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        ));

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(back)
                        .addComponent(title))
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(teacherManagement)
                        .addComponent(studentManagement))
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(staffManagement)
                        .addComponent(financeManagement))
                    .addGap(50, 50, 50))
        );

        panel.add(back);
        panel.add(title);
        panel.add(teacherManagement);
        panel.add(staffManagement);
        panel.add(studentManagement);
        panel.add(financeManagement);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AdminModule().setVisible(true);
    }
}
