import javax.swing.*;
import java.awt.*;

public class updateLibrarian extends JFrame {

    static updateLibrarian frame;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;

    public static void main (String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new updateLibrarian();
                    frame.setVisible(true);
                }
                catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }

    public updateLibrarian () {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Enter the data to update the record");

        jLabel2.setText("Librarian Name:");
        jTextField1.setText("");

        jLabel3.setText("Librarian Email:");
        jTextField2.setText("");

        jLabel4.setText("Librarian Contact:");
        jTextField3.setText("");

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (!jTextField1.getText().equals("") && !jTextField2.getText().equals("") && !jTextField3.getText().equals("")) {
                    String librarianName = jTextField1.getText();
                    String librarianMail = jTextField2.getText();
                    String librarianContact = jTextField3.getText();

                    if (Validation.ValidateEmail(librarianMail) == true && Validation.ValidateNumber(librarianContact) == true) {
                        int i = editLibrarianDao.updateLibrarianRecord(librarianName, librarianMail, librarianContact, editLibrarian.librarianID);
                        if (i > 0) {
                            JOptionPane.showMessageDialog(updateLibrarian.this, "Record updated successfully.");
                            AdminSuccess.main(new String[]{});
                            frame.dispose();
                        }
                        else {
                            JOptionPane.showMessageDialog(updateLibrarian.this, "Failed to update record.");
                        }
                    }
                    else if (Validation.ValidateEmail(librarianMail) == false && Validation.ValidateNumber(librarianContact) == true) {
                        JOptionPane.showMessageDialog(updateLibrarian.this, "Please enter a valid E-Mail ID.");
                    }
                    else if (Validation.ValidateEmail(librarianMail) == true && Validation.ValidateNumber(librarianContact) == false) {
                        JOptionPane.showMessageDialog(updateLibrarian.this, "Please enter a valid contact number.");
                    }
                    else {
                        JOptionPane.showMessageDialog(updateLibrarian.this, "Please enter a valid contact number and E-Mail ID.");
                    }
                }
                else if (jTextField1.getText().equals("") && !jTextField2.getText().equals("") && !jTextField3.getText().equals("")) {
                    JOptionPane.showMessageDialog(updateLibrarian.this, "Please enter a valid name.");
                }
                else if (!jTextField1.getText().equals("") && jTextField2.getText().equals("") && !jTextField3.getText().equals("")) {
                    JOptionPane.showMessageDialog(updateLibrarian.this, "Please enter a valid E-Mail ID.");
                }
                else if (!jTextField1.getText().equals("") && !jTextField2.getText().equals("") && jTextField3.getText().equals("")) {
                    JOptionPane.showMessageDialog(updateLibrarian.this, "Please enter a valid contact number.");
                }
                else {
                    JOptionPane.showMessageDialog(updateLibrarian.this, "Please provide valid data in the given fields.");
                }
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editLibrarian.main(new String[]{});
                frame.dispose();
            }
        });

        jButton3.setText("Return to Main Menu");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminSuccess.main(new String[]{});
                frame.dispose();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel3))
                                                .addGap(36, 36, 36)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                                        .addComponent(jTextField2)
                                                        .addComponent(jTextField3)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jButton1)
                                                                        .addGap(52, 52, 52)
                                                                        .addComponent(jButton2)))
                                                        .addComponent(jLabel1))))
                                .addGap(123, 123, 123))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(26, 26, 26))
        );

        pack();

    }
}
