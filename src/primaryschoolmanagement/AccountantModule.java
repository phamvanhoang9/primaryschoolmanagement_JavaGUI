package primaryschoolmanagement;

import javax.swing.*;

/**
 * @author steve hoang
 */

public class AccountantModule extends JFrame {

        /**
        * Creates new form TeacherModule
        */
        public AccountantModule() {
            initComponents();
            setSize(500, 400);
            setLocationRelativeTo(null);
        }

        private void initComponents() {

            setTitle("Accountant Module");
            setResizable(false);
        }

        public static void main(String[] args) {
            AccountantModule accountantModule = new AccountantModule();
            accountantModule.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            accountantModule.setVisible(true);
        }
}
