package primaryschoolmanagement;

import javax.swing.*;

/**
 * @author steve hoang
 */
public class AdminLogin extends JFrame {
    /**
     * Creates new form AdminLogin
     */
    public AdminLogin() {
        initComponents();
        setSize(500, 400);
        setLocationRelativeTo(null);
    }

    private void initComponents() {

    }

    public static void main(String[] args) {
        AdminLogin adminLogin = new AdminLogin();
        adminLogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        adminLogin.setVisible(true);
    }
}
