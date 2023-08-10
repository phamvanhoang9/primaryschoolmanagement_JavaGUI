package primaryschoolmanagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;

import static java.awt.Font.BOLD;

public class ReportCard extends JFrame {

    // Database connection
    private static final String DB_URL = "jdbc:mysql://localhost:3306/primary_school_management";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "999";

    public ReportCard() {
        initComponents();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        cl = new javax.swing.JTextField();
        math = new javax.swing.JTextField();
        viet = new javax.swing.JTextField();
        eng = new javax.swing.JTextField();
        sci = new javax.swing.JTextField();
        art = new javax.swing.JTextField();
        music = new javax.swing.JTextField();
        phy = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(text);

        jLabel1.setFont(new java.awt.Font("Times New Roman", BOLD, 14)); // NOI18N
        jLabel1.setText("REPORT ");

        jLabel2.setText("ID");

        jLabel4.setText("Name:");

        jLabel5.setText("Class:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", BOLD, 14)); // NOI18N
        jLabel6.setText("GRADES:");

        jLabel7.setText("Math:");

        jLabel8.setText("Vietnamese:");

        jLabel9.setText("English:");

        jLabel12.setText("Science:");

        jLabel13.setText("Art:");

        jLabel14.setText("Music:");

        jLabel15.setText("Physical:");

        jLabel10.setText("-----------------------------------------------------------------------");

        jButton1.setText("SUBMIT");
        jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setText("BACK");
        jLabel11.setForeground(Color.RED);
        jLabel11.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel10)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(15)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jLabel5))
                                                                .addGap(64)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(id, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(cl, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(name, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jButton1)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel7)
                                                                                .addComponent(jLabel8)
                                                                                .addComponent(jLabel9)
                                                                                .addComponent(jLabel12)
                                                                                .addComponent(jLabel13)
                                                                                .addComponent(jLabel14)
                                                                                .addComponent(jLabel15))
                                                                        .addGap(32)
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(math, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(viet, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(eng, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(sci, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(art, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(music, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(phy, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel11)
                                                .addGap(30)))
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel11))
                                .addGap(25)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(cl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addGap(24)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGap(25)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(math, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(viet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(eng, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(sci, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(art, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel14)
                                        .addComponent(music, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel15)
                                        .addComponent(phy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(32)
                                .addComponent(jButton1)
                                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:

        try{
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String sql="insert into report_student values (?,?,?,?,?,?,?,?,?,?,?)";
            String i = id.getText();
            String n= name.getText();
            String cla= cl.getText();
            String m = math.getText();
            double s1= Double.parseDouble(m);
            String vi = viet.getText();
            double s2 = Double.parseDouble(vi);
            String en = eng.getText();
            double s3= Double.parseDouble(en);
            String sc = sci.getText();
            double s4= Double.parseDouble(sc);
            String ar = art.getText();
            double s5= Double.parseDouble(ar);
            String mu = music.getText();
            double s6= Double.parseDouble(mu);
            String ph = phy.getText();
            double s7= Double.parseDouble(ph);

            double total=((s1+s2+s3+s4+s5+s6+s7))/7;

            String grade;

            if(total>= 9.5){
                grade= "A+";
            }
            else if(total>=8.5){
                grade="A";
            }

            else if(total>=8){
                grade="B+";
            }

            else if(total>=7){
                grade="B";
            }

            else if(total>=6.5){
                grade="C+";
            }
            else if(total>=5.5){
                grade="C";
            }
            else if(total>=4.5){
                grade="D+";
            }
            else if(total>=4){
                grade="D";
            }
            else
            {
                grade="F";
            }

            PreparedStatement ptst= conn.prepareStatement(sql);
            ptst.setString(1, i);
            ptst.setString(2, n);
            ptst.setString(3, cla);
            ptst.setString(4, m);
            ptst.setString(5, vi);
            ptst.setString(6, en);
            ptst.setString(7, sc);
            ptst.setString(8, ar);
            ptst.setString(9, mu);
            ptst.setString(10, ph);
            ptst.setString(11, grade);

            ptst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data has been saved");

            text.setText("REPORT CARD\n\n ID: "+i+"\nStudent Name: "+n+"\nClass: "+cla+"\n\n-----------------------\nMarks\n\nMath: "+m+"\nVietnamese: "+vi+
                    "\nEnglish: "+en+"\nScience: "+sc+"\nArt: "+ar+"\nMusic: "+mu+"\nPhysical Education: "+ph+"\nGrade: "+grade);
            conn.close();


        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        StudentIn4 obj =new StudentIn4();
        obj.setVisible(true);
        dispose();
    }

    /**
     * @param args the command line arguments
     */
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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportCard().setVisible(true);
            }
        });
    }

    private javax.swing.JTextField name;
    private javax.swing.JTextField cl;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField math;
    private javax.swing.JTextField viet;
    private javax.swing.JTextField eng;
    private javax.swing.JTextField sci;
    private javax.swing.JTextField art;
    private javax.swing.JTextField music;
    private javax.swing.JTextField phy;
    private javax.swing.JTextPane text;
}
