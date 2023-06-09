package primaryschoolmanagement;

import javax.swing.*;

/**
 * @author steve hoang
 */

public class TeacherModule extends JFrame {
    /**
     * Creates new form TeacherModule
     */
    public TeacherModule() {
        initComponents();
        setSize(500, 400);
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        setTitle("Teacher Module");
        setResizable(false);
    }
    public static void main(String[] args) {
        TeacherModule teacherModule = new TeacherModule();
        teacherModule.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        teacherModule.setVisible(true);
    }
}
