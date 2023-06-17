package primaryschoolmanagement;

import javax.swing.*;

/**
 * @author steve hoang
 */

public class StudentModule extends JFrame{
    /**
     * Creates new form StaffModule
     */
    public StudentModule() {
        initComponents();
        setSize(500, 400);
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        setTitle("Student Module");
        setResizable(false);
    }
    public static void main(String[] args) {
        StudentModule studentModule = new StudentModule();
        studentModule.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        studentModule.setVisible(true);
    }
}
