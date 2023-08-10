package primaryschoolmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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
        setSize(500, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JLabel back = new JLabel();
        back.setForeground(Color.RED);
        back.setText("BACK");
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }

            private void backMouseClicked(java.awt.event.MouseEvent evt) {
                AdminLogin adminLogin = new AdminLogin();
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
            public void actionPerformed(ActionEvent evt) {
                teacherManagementActionPerformed(evt);
            }

            private void teacherManagementActionPerformed(ActionEvent evt) {
                Teacher teacherModule = new Teacher();
                teacherModule.setVisible(true);
                dispose();
            }
        });

        JButton staffManagement = new JButton("Staff Management");
        staffManagement.setCursor(new Cursor(Cursor.HAND_CURSOR));
        staffManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                staffManagementActionPerformed(evt);
            }

            private void staffManagementActionPerformed(ActionEvent evt) {
                FinanceModule staffModule = new FinanceModule();
                staffModule.setVisible(true);
                dispose();
            }
        });

        JButton studentManagement = new JButton("Student Management");
        studentManagement.setCursor(new Cursor(Cursor.HAND_CURSOR));
        studentManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                studentManagementActionPerformed(evt);
            }

            private void studentManagementActionPerformed(ActionEvent evt) {
                StudentIn4 studentManagement = new StudentIn4();
                studentManagement.setVisible(true);
                dispose();
            }
        });

        JButton financeManagement = new JButton("Finance Management");
        financeManagement.setCursor(new Cursor(Cursor.HAND_CURSOR));
        financeManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                financeManagementActionPerformed(evt);
            }

            private void financeManagementActionPerformed(ActionEvent evt) {
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
                    .addGap(425)
                    .addComponent(back))
                .addGroup(layout.createSequentialGroup()
                    .addGap(200, 200, 200)
                    .addComponent(title))
                .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(teacherManagement, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(studentManagement, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(staffManagement, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(financeManagement, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(50, 50, 50))
        );

        layout.setVerticalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(back)
                .addGap(20, 20, 20)
                .addComponent(title)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(teacherManagement)
                    .addComponent(staffManagement))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(studentManagement)
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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | UnsupportedLookAndFeelException |
                 InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        new AdminModule().setVisible(true);
    }
}
