package primaryschoolmanagement;

import javax.swing.*;

/**
 * @author steve hoang
 */

public class StaffModule extends JFrame{
        /**
        * Creates new form StaffModule
        */
        public StaffModule() {
            initComponents();
            setSize(500, 400);
            setLocationRelativeTo(null);
        }

        private void initComponents() {

            setTitle("Staff Module");
            setResizable(false);
        }
        public static void main(String[] args) {
            FinanceModule staffModule = new FinanceModule();
            staffModule.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            staffModule.setVisible(true);
        }
}
