import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class updateEmployees extends JFrame {

    static updateEmployees frame;
    private final javax.swing.JButton jButton1;
    private final javax.swing.JButton jButton2;
    private final javax.swing.JButton jButton3;
    private final javax.swing.JLabel jLabel1;
    private final javax.swing.JLabel jLabel2;
    private final javax.swing.JLabel jLabel3;
    private final javax.swing.JLabel jLabel4;
    private final javax.swing.JTextField jTextField1;
    private final javax.swing.JTextField jTextField2;
    private final javax.swing.JTextField jTextField3;

    public static void main (String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new updateEmployees();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public updateEmployees() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel1.setText("Enter the data to update the record");

        jLabel2.setText("Employee Name:");
        jTextField1.setText("");

        jLabel3.setText("Employee Email:");
        jTextField2.setText("");

        jLabel4.setText("Employee Contact:");
        jTextField3.setText("");

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (!jTextField1.getText().equals("") && !jTextField2.getText().equals("") && !jTextField3.getText().equals("")) {
                    String employeeName = jTextField1.getText();
                    String employeeMail = jTextField2.getText();
                    String employeeContact = jTextField3.getText();

                    if (Validation.ValidateEmail(employeeMail) == true && Validation.ValidateNumber(employeeContact) == true) {
                        int i = editEmployeesDao.updateEmployeeRecord(employeeName, employeeMail, employeeContact, editEmployees.employeeID);
                        if (i > 0) {
                            JOptionPane.showMessageDialog(updateEmployees.this, "Record updated successfully.");
                            LibrarianSuccess.main(new String[]{});
                            frame.dispose();
                        }
                        else {
                            JOptionPane.showMessageDialog(updateEmployees.this, "Failed to update record.");
                        }
                    }
                    else if (Validation.ValidateEmail(employeeMail) == false && Validation.ValidateNumber(employeeContact) == true) {
                        JOptionPane.showMessageDialog(updateEmployees.this, "Please enter a valid E-Mail ID.");
                    }
                    else if (Validation.ValidateEmail(employeeMail) == true && Validation.ValidateNumber(employeeContact) == false) {
                        JOptionPane.showMessageDialog(updateEmployees.this, "Please enter a valid contact number.");
                    }
                    else {
                        JOptionPane.showMessageDialog(updateEmployees.this, "Please enter a valid contact number and E-Mail ID.");
                    }
                }
                else if (jTextField1.getText().equals("") && !jTextField2.getText().equals("") && !jTextField3.getText().equals("")) {
                    JOptionPane.showMessageDialog(updateEmployees.this, "Please enter a valid name.");
                }
                else if (!jTextField1.getText().equals("") && jTextField2.getText().equals("") && !jTextField3.getText().equals("")) {
                    JOptionPane.showMessageDialog(updateEmployees.this, "Please enter a valid E-Mail ID.");
                }
                else if (!jTextField1.getText().equals("") && !jTextField2.getText().equals("") && jTextField3.getText().equals("")) {
                    JOptionPane.showMessageDialog(updateEmployees.this, "Please enter a valid contact number.");
                }
                else {
                    JOptionPane.showMessageDialog(updateEmployees.this, "Please provide valid data in the given fields.");
                }
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editEmployees.main(new String[]{});
                frame.dispose();
            }
        });

        jButton3.setText("Return to Main Menu");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LibrarianSuccess.main(new String[]{});
                frame.dispose();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel1)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel4)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(jTextField3))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                        .addComponent(jLabel2)
                                                                                        .addGap(30, 30, 30))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                        .addComponent(jLabel3)
                                                                                        .addGap(32, 32, 32)))
                                                                        .addGap(1, 1, 1)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(138, 138, 138)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton3)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jButton1)
                                                                .addGap(38, 38, 38)
                                                                .addComponent(jButton2)))))
                                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel1)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }
}
