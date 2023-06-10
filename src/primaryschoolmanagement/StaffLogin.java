package primaryschoolmanagement;

import javax.swing.*;

/**
 * @author steve hoang
 */

public class StaffLogin extends JFrame {
    /**
     * Creates new form StaffLogin
     */
    public StaffLogin() {
        initComponents();
        setSize(500, 400);
        setLocationRelativeTo(null);
    }

    private void initComponents() {

    }

    public static void main(String[] args) {
        StaffLogin staffLogin = new StaffLogin();
        staffLogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        staffLogin.setVisible(true);
    }
}
