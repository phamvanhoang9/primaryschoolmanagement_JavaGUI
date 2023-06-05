package primaryschoolmanagement;

import javax.swing.*;

/**
 * @author steve hoang
 */

public class TeacherLogin extends JFrame {
    /**
     * Creates new form TeacherLogin
     */
    public TeacherLogin() {
        initComponents();
        setSize(500, 400);
    }

    private void initComponents() {

    }

    public static void main(String[] args) {
        TeacherLogin teacherLogin = new TeacherLogin();
        teacherLogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        teacherLogin.setVisible(true);
    }
}
