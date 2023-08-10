package primaryschoolmanagement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;

public class StudentIn4 extends JFrame {
    private JTextField idField;
    private JTextField nameField;
    private JTextField genderField;
    private JTextField dobField;
    private JTextField classField;
    private JTextField yearField;
    private JTextField statusField;
    private JTextField addressField;
    private JTextField parentNameField;
    private JTextField parentJobField;
    private JTextField parentPhoneField;
    private JTextField parentIDField;
    private JTextField parentEmailField;
    private JButton addButton;
    private JButton updateButton;
    private JButton searchButton;
    private JButton deleteButton;
    private JButton reportButton;
    private JButton clearButton;
    private JLabel backLabel;
    private JLabel title;
    private JTable table;
    private DefaultTableModel tableModel;
    private ArrayList<Student> studentList;

    // Database connection
    private static final String DB_URL = "jdbc:mysql://localhost:3306/primary_school_management";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "999";

    public StudentIn4() {
        setTitle("Student Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        backLabel = new JLabel("BACK");
        backLabel.setForeground(Color.RED);
        backLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        backLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        int top = 25, left = 25, bottom = 25, right = 25;
        backLabel.setBorder(new EmptyBorder(top, left, bottom, right));
        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        backPanel.add(backLabel);
        add(backPanel, BorderLayout.NORTH);

        backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backLabelMouseClicked(evt);
            }

            private void backLabelMouseClicked(MouseEvent evt) {
                dispose();
                new AdminModule().setVisible(true);
            }
        });

        title = new JLabel("STUDENT MANAGEMENT");
        title.setFont(new Font("Times New Roman", Font.BOLD, 24));
        title.setForeground(new Color(0, 200, 0));
        title.setBorder(new EmptyBorder(0, 0, 50, 0));
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);


        JPanel studentPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 25, 5, 5 );

        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.anchor = GridBagConstraints.WEST;
        gbc3.insets = new Insets(5, 5, 5, 5 );

        gbc.gridx = 0;
        gbc.gridy = 0;
        studentPanel.add(new JLabel("Student ID:"), gbc);
        gbc3.gridx = 1;
        gbc3.gridy = 0;
        gbc3.fill = GridBagConstraints.HORIZONTAL;
        idField = new JTextField(25);
        idField.setPreferredSize(new Dimension(25, 25));
        studentPanel.add(idField, gbc3);

        gbc.gridx = 0;
        gbc.gridy = 1;
        studentPanel.add(new JLabel("Name:"), gbc);
        gbc3.gridx = 1;
        gbc3.gridy = 1;
        gbc3.fill = GridBagConstraints.HORIZONTAL;
        nameField= new JTextField(25);
        nameField.setPreferredSize(new Dimension(25, 25));
        studentPanel.add(nameField, gbc3);

        gbc.gridx = 0;
        gbc.gridy = 2;
        studentPanel.add(new JLabel("Gender:"), gbc);
        gbc3.gridx = 1;
        gbc3.gridy = 2;
        gbc3.fill = GridBagConstraints.HORIZONTAL;
        genderField = new JTextField(25);
        genderField.setPreferredSize(new Dimension(25, 25));
        studentPanel.add(genderField, gbc3);

        gbc.gridx = 0;
        gbc.gridy = 3;
        studentPanel.add(new JLabel("DOB:"), gbc);
        gbc3.gridx = 1;
        gbc3.gridy = 3;
        gbc3.fill = GridBagConstraints.HORIZONTAL;
        dobField = new JTextField(25);
        dobField.setPreferredSize(new Dimension(25, 25));
        studentPanel.add(dobField, gbc3);

        gbc.gridx = 0;
        gbc.gridy = 4;
        studentPanel.add(new JLabel("Class:"), gbc);
        gbc3.gridx = 1;
        gbc3.gridy = 4;
        gbc3.fill = GridBagConstraints.HORIZONTAL;
        classField = new JTextField(25);
        classField.setPreferredSize(new Dimension(25, 25));
        studentPanel.add(classField, gbc3);

        gbc.gridx = 0;
        gbc.gridy = 5;
        studentPanel.add(new JLabel("Year:"), gbc);
        gbc3.gridx = 1;
        gbc3.gridy = 5;
        gbc3.fill = GridBagConstraints.HORIZONTAL;
        yearField = new JTextField(25);
        yearField.setPreferredSize(new Dimension(25, 25));
        studentPanel.add(yearField, gbc3);

        gbc.gridx = 0;
        gbc.gridy = 6;
        studentPanel.add(new JLabel("Status:"), gbc);
        gbc3.gridx = 1;
        gbc3.gridy = 6;
        gbc3.fill = GridBagConstraints.HORIZONTAL;
        statusField= new JTextField(25);
        statusField.setPreferredSize(new Dimension(25, 25));
        studentPanel.add(statusField, gbc3);

        gbc.gridx = 0;
        gbc.gridy = 7;
        studentPanel.add(new JLabel("Address:"), gbc);
        gbc3.gridx = 1;
        gbc3.gridy = 7;
        gbc3.fill = GridBagConstraints.HORIZONTAL;
        addressField = new JTextField(25);
        addressField.setPreferredSize(new Dimension(25, 25));
        studentPanel.add(addressField, gbc3);


        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.anchor = GridBagConstraints.WEST;
        gbc1.insets = new Insets(5, 100, 5, 5 );

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.anchor = GridBagConstraints.WEST;
        gbc2.insets = new Insets(5, 5, 5, 25 );

        gbc1.gridx = 2;
        gbc1.gridy = 0;
        studentPanel.add(new JLabel("Parent:"), gbc1);
        gbc2.gridx = 3;
        gbc2.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        parentNameField = new JTextField(25);
        parentNameField.setPreferredSize(new Dimension(25, 25));
        studentPanel.add(parentNameField, gbc2);

        gbc1.gridx = 2;
        gbc1.gridy = 1;
        studentPanel.add(new JLabel("Parent Job:"), gbc1);
        gbc2.gridx = 3;
        gbc2.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        parentJobField = new JTextField(25);
        parentJobField.setPreferredSize(new Dimension(25, 25));
        studentPanel.add(parentJobField, gbc2);

        gbc1.gridx = 2;
        gbc1.gridy = 2;
        studentPanel.add(new JLabel("Parent Phone:"), gbc1);
        gbc2.gridx = 3;
        gbc2.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        parentPhoneField = new JTextField(25);
        parentPhoneField.setPreferredSize(new Dimension(25, 25));
        studentPanel.add(parentPhoneField, gbc2);

        gbc1.gridx = 2;
        gbc1.gridy = 3;
        studentPanel.add(new JLabel("Parent ID:"), gbc1);
        gbc2.gridx = 3;
        gbc2.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        parentIDField = new JTextField(25);
        parentIDField.setPreferredSize(new Dimension(25, 25));
        studentPanel.add(parentIDField, gbc2);

        gbc1.gridx = 2;
        gbc1.gridy = 4;
        studentPanel.add(new JLabel("Parent Email:"), gbc1);
        gbc2.gridx = 3;
        gbc2.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        parentEmailField = new JTextField(25);
        parentEmailField.setPreferredSize(new Dimension(25, 25));
        studentPanel.add(parentEmailField, gbc2);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        addButton = createButton("ADD", e -> addStudent());
        buttonPanel.add(addButton);

        updateButton = createButton("UPDATE", e -> updateStudent());
        buttonPanel.add(updateButton);

        searchButton = createButton("SEARCH", e -> searchStudent());
        buttonPanel.add(searchButton);

        deleteButton = createButton("DELETE", e -> deleteStudent());
        buttonPanel.add(deleteButton);

        reportButton = createButton("REPORT", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reportStudent();
            }
            private void reportStudent() {
                dispose();
                new ReportCard().setVisible(true);
            }
        });
        buttonPanel.add(reportButton);

        clearButton = createButton("CLEAR", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }

            private void clearFields() {
                idField.setText("");
                nameField.setText("");
                genderField.setText("");
                dobField.setText("");
                classField.setText("");
                yearField.setText("");
                statusField.setText("");
                addressField.setText("");
                parentNameField.setText("");
                parentJobField.setText("");
                parentPhoneField.setText("");
                parentIDField.setText("");
                parentEmailField.setText("");
            }
        });
        buttonPanel.add(clearButton);

        int topMargin = 25;
        int leftMargin = 25;
        int bottomMargin = 25;
        int rightMargin = 25;
        buttonPanel.setBorder(new EmptyBorder(topMargin, leftMargin, bottomMargin, rightMargin));

        contentPanel.add(backPanel);
        contentPanel.add(titlePanel);
        contentPanel.add(studentPanel);
        contentPanel.add(buttonPanel);

        // Student table
        table = new JTable();
        tableModel = new DefaultTableModel(new Object[]{"Student ID", "Name", "Gender", "DOB", "Class", "Year", "Status", "Address", "Parent", "Parent Job", "Parent Phone", "Parent ID", "Parent Email"}, 0);
        table.setModel(tableModel);

        // Add components to the frame
        add(contentPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        studentList = new ArrayList<>();

        // Load existing student data from the database
        loadStudentData();

        pack();
        setLocationRelativeTo(null);
    }

    private JButton createButton(String buttonText, ActionListener listener) {
        JButton button = new JButton(buttonText);
        Dimension buttonSize = new Dimension(100, 35);
        button.setPreferredSize(buttonSize);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);
        button.setBackground(UIManager.getColor("control"));
        button.addActionListener(listener);
        return button;
    }

    private void addStudent() {
        String id = idField.getText();
        String name = nameField.getText();
        String gender = genderField.getText();
        String dob = dobField.getText();
        String clas = classField.getText();
        String year = yearField.getText();
        String status = statusField.getText();
        String address = addressField.getText();
        String parent = parentNameField.getText();
        String parentJob = parentJobField.getText();
        String parentPhone = parentPhoneField.getText();
        String parentID = parentIDField.getText();
        String parentEmail = parentEmailField.getText();

        // Validate input
        if (id.isEmpty() || name.isEmpty() || gender.isEmpty() || dob.isEmpty() || clas.isEmpty()
                || year.isEmpty() || status.isEmpty() || address.isEmpty() || parent.isEmpty()
                || parentJob.isEmpty() || parentPhone.isEmpty() || parentID.isEmpty() || parentEmail.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if the student with the same ID already exists
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                JOptionPane.showMessageDialog(this, "Student with ID " + id + " already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Add the student to the database
        if (addStudentToDatabase(id, name, gender, dob, clas, year, status, address,
                parent, parentJob, parentPhone, parentID, parentEmail)) {
            // Add the student to the list
            studentList.add(new Student(id, name, gender, dob, clas, year, status, address,
                    parent, parentJob, parentPhone, parentID, parentEmail));
            updateTable();

            // Clear input fields
            idField.setText("");
            nameField.setText("");
            genderField.setText("");
            dobField.setText("");
            classField.setText("");
            yearField.setText("");
            statusField.setText("");
            addressField.setText("");
            parentNameField.setText("");
            parentJobField.setText("");
            parentPhoneField.setText("");
            parentIDField.setText("");
            parentEmailField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add student.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

//     Update the student table
    private void updateStudent() {
        String id = idField.getText();
        String name = nameField.getText();
        String gender = genderField.getText();
        String dob = dobField.getText();
        String clas = classField.getText();
        String year = yearField.getText();
        String status = statusField.getText();
        String address = addressField.getText();
        String parent = parentNameField.getText();
        String parentJob = parentJobField.getText();
        String parentPhone = parentPhoneField.getText();
        String parentID = parentIDField.getText();
        String parentEmail = parentEmailField.getText();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter student ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                // Update the student in the database
                if (updateStudentInDatabase(id, name, gender, dob, clas, year, status, address, parent, parentJob, parentPhone, parentID, parentEmail)) {
                    updateTable();

                    // Clear input fields
                    idField.setText("");
                    nameField.setText("");
                    genderField.setText("");
                    dobField.setText("");
                    classField.setText("");
                    yearField.setText("");
                    statusField.setText("");
                    addressField.setText("");
                    parentNameField.setText("");
                    parentJobField.setText("");
                    parentPhoneField.setText("");
                    parentIDField.setText("");
                    parentEmailField.setText("");

                    JOptionPane.showMessageDialog(this, "Student with ID " + id + " is updated successfully!");
                    updateTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update student.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                return;
            }
        }

        // If the loop completes without finding a matching student, show an error message
        JOptionPane.showMessageDialog(this, "Student with ID " + id + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Method to update a student in the database
    private boolean updateStudentInDatabase(String id, String name, String gender, String dob, String clas, String year,
                                            String status, String address, String parent, String parentJob,
                                            String parentPhone, String parentID, String parentEmail) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("UPDATE students SET name=?, gender=?, dob=?, clas=?, year=?, status=?, address=?, parent=?, parentJob=?, parentPhone=?, parentID=?, parentEmail=? WHERE id=?")) {

            stmt.setString(1, name);
            stmt.setString(2, gender);
            stmt.setString(3, dob);
            stmt.setString(4, clas);
            stmt.setString(5, year);
            stmt.setString(6, status);
            stmt.setString(7, address);
            stmt.setString(8, parent);
            stmt.setString(9, parentJob);
            stmt.setString(10, parentPhone);
            stmt.setString(11, parentID);
            stmt.setString(12, parentEmail);
            stmt.setString(13, id);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    private void searchStudent() {
        String id = idField.getText();

        // Find the student with the given ID
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                nameField.setText(student.getName());
                genderField.setText(student.getGender());
                dobField.setText(student.getDob());
                classField.setText(student.getClas());
                yearField.setText(student.getYear());
                statusField.setText(student.getStatus());
                addressField.setText(student.getAddress());
                parentNameField.setText(student.getParent());
                parentJobField.setText(student.getParentJob());
                parentPhoneField.setText(student.getParentPhone());
                parentIDField.setText(student.getParentID());
                parentEmailField.setText(student.getParentEmail());
                return;
            }
        }

        // Student not found
        JOptionPane.showMessageDialog(this, "Student with ID " + id + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void deleteStudent() {
        String id = idField.getText();

        // Find the student with the given ID
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                // Delete the student from the database
                if (deleteStudentFromDatabase(id)) {
                    // Delete the student from the list
                    studentList.remove(student);
                    updateTable();

                    // Clear input fields
                    idField.setText("");
                    nameField.setText("");
                    genderField.setText("");
                    dobField.setText("");
                    classField.setText("");
                    yearField.setText("");
                    statusField.setText("");
                    addressField.setText("");
                    parentNameField.setText("");
                    parentJobField.setText("");
                    parentPhoneField.setText("");
                    parentIDField.setText("");
                    parentEmailField.setText("");
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete student.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Student not found
        JOptionPane.showMessageDialog(this, "Student with ID " + id + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    private boolean addStudentToDatabase(String id, String name, String gender, String dob, String clas, String year,
                                         String status, String address, String parent, String parentJob,
                                         String parentPhone, String parentID, String parentEmail) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO students (id, name, gender, dob, clas, year, status, address,\n" +
                                     "parent, parentJob, parentPhone, parentID, parentEmail) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
                stmt.setString(1, id);
                stmt.setString(2, name);
                stmt.setString(3, gender);
                stmt.setString(4, dob);
                stmt.setString(5, clas);
                stmt.setString(6, year);
                stmt.setString(7, status);
                stmt.setString(8, address);
                stmt.setString(9, parent);
                stmt.setString(10, parentJob);
                stmt.setString(11, parentPhone);
                stmt.setString(12, parentID);
                stmt.setString(13, parentEmail);
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean deleteStudentFromDatabase(String id) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM students WHERE id = ?")) {
                stmt.setString(1, id);
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    private void updateTable() {
        // Clear existing table data
        tableModel.setRowCount(0);

        // Populate table with student data
        for (Student student : studentList) {
            Object[] rowData = {student.getId(), student.getName(), student.getGender(), student.getDob(),
                    student.getClas(), student.getYear(), student.getStatus(), student.getAddress(),
                    student.getParent(), student.getParentJob(), student.getParentPhone(),
                    student.getParentID(), student.getParentEmail()};
            tableModel.addRow(rowData);
        }
    }

    private void loadStudentData() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String dob = rs.getString("dob");
                String clas = rs.getString("clas");
                String year = rs.getString("year");
                String status = rs.getString("status");
                String address = rs.getString("address");
                String parent = rs.getString("parent");
                String parentJob = rs.getString("parentJob");
                String parentPhone = rs.getString("parentPhone");
                String parentID = rs.getString("parentID");
                String parentEmail = rs.getString("parentEmail");
                studentList.add(new Student(id, name, gender, dob, clas, year, status, address, parent, parentJob, parentPhone, parentID, parentEmail));
            }

            updateTable();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load student data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        SwingUtilities.invokeLater(() -> {
            StudentIn4 studentIn4 = new StudentIn4();
            studentIn4.setVisible(true);
        });
    }
}

class Student {
    private String id;
    private String name;
    private String gender;
    private String dob;
    private String clas;
    private String year;
    private String status;
    private String address;
    private String parent;
    private String parentJob;
    private String parentPhone;
    private String parentID;
    private String parentEmail;

    public Student(String id, String name, String gender, String dob, String clas, String year,
                   String status, String address, String parent, String parentJob,
                   String parentPhone, String parentID, String parentEmail) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.clas = clas;
        this.year = year;
        this.status = status;
        this.address = address;
        this.parent = parent;
        this.parentJob = parentJob;
        this.parentPhone = parentPhone;
        this.parentID = parentID;
        this.parentEmail = parentEmail;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public String getClas() {
        return clas;
    }

    public String getYear() {
        return year;
    }

    public String getStatus() {
        return status;
    }

    public String getAddress() {
        return address;
    }

    public String getParent() {
        return parent;
    }

    public String getParentJob() {
        return parentJob;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public String getParentID() {
        return parentID;
    }

    public String getParentEmail() {
        return parentEmail;
    }
}
