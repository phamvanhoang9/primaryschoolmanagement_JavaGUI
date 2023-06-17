package primaryschoolmanagement;

import javax.swing.*;

/**
 * @author steve hoang
 */

public class FinanceModule extends JFrame{
    /**
     * Creates new form FinanceModule
     */
    public FinanceModule() {
        initComponents();
        setSize(500, 400);
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        setTitle("Finance Module");
        setResizable(false);
    }
    public static void main(String[] args) {
        FinanceModule financeModule = new FinanceModule();
        financeModule.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        financeModule.setVisible(true);
    }
}