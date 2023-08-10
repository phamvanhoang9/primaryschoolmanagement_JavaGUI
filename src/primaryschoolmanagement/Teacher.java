package primaryschoolmanagement;

import javax.swing.*;

/**
 * @author steve hoang
 */

public class Teacher extends JFrame {
    /**
     * Creates new form TeacherModule
     */
    public Teacher() {
        initComponents();
        setSize(500, 400);
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        setTitle("Teacher Module");
        setResizable(false);
    }
    public static void main(String[] args) {
        Teacher teacherModule = new Teacher();
        teacherModule.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        teacherModule.setVisible(true);
    }
}
