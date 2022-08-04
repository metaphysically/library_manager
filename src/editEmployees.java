import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class editEmployees extends JFrame {

    static editEmployees frame;
    private final javax.swing.JButton jButton1;
    private final javax.swing.JButton jButton2;
    private final javax.swing.JLabel jLabel1;
    private final javax.swing.JLabel jLabel2;
    private final javax.swing.JTextField jTextField1;
    private final javax.swing.JTextField jTextField2;
    static int employeeID;

    public static void main (String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new editEmployees();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public editEmployees () {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Employee ID:");
        jTextField1.setText("");

        jLabel2.setText("Employee Name:");
        jTextField2.setText("");

        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (!jTextField1.getText().equals("") && !jTextField2.getText().equals("")) {

                    employeeID = Integer.parseInt(jTextField1.getText());
                    String employeeName = jTextField2.getText();
                    boolean exists = editEmployeesDao.employeeExists(employeeID, employeeName);

                    if (exists == true) {
                        updateEmployees.main(new String[]{});
                        frame.dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(editEmployees.this, "Please enter the ID and name of a valid employee.");
                    }
                }
                else if (jTextField1.getText().equals("") && !jTextField2.getText().equals("")) {
                    JOptionPane.showMessageDialog(editEmployees.this, "Please enter a valid employee ID.");
                }
                else if (!jTextField1.getText().equals("") && jTextField2.getText().equals("")) {
                    JOptionPane.showMessageDialog(editEmployees.this, "Please enter a valid employee name.");
                }
                else {
                    JOptionPane.showMessageDialog(editEmployees.this, "Please enter the required data in the fields.");
                }
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibrarianSuccess.main(new String[]{});
                frame.dispose();
            }
        });


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addGap(33, 33, 33)
                                                .addComponent(jButton2))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                                .addComponent(jTextField2)))
                                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();

    }

}
