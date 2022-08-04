import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class changeLibrarianPassword extends JFrame {

    static changeLibrarianPassword frame;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPasswordField jPasswordField;

    public static void main (String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new changeLibrarianPassword();
                    frame.setVisible(true);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public changeLibrarianPassword() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Librarian ID:");
        jTextField1.setText("");

        jLabel2.setText("New Password:");
        jPasswordField.setText("");

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                int librarianID = Integer.parseInt(jTextField1.getText());
                String newPassword = jPasswordField.getText();

                if (!jTextField1.getText().equals("") && !jPasswordField.getText().equals("")) {
                    try {

                        String query = "update librarian set password = ? where id = ?";
                        Connection con = DB.getConnection();
                        PreparedStatement pst = con.prepareStatement(query);
                        pst.setString(1, newPassword);
                        pst.setInt(2, librarianID);
                        int i = pst.executeUpdate();

                        if (i > 0) {
                            JOptionPane.showMessageDialog(changeLibrarianPassword.this, "Password changed.");
                            frame.dispose();
                            AdminSuccess.main(new String[]{});
                        }
                        else {
                            JOptionPane.showMessageDialog(changeLibrarianPassword.this, "Failed to change password.");
                        }

                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                }
                else if (jTextField1.getText().equals("") && !jPasswordField.getText().equals("")) {
                    JOptionPane.showMessageDialog(changeLibrarianPassword.this, "Please enter a valid Librarian ID.");
                }
                else if (!jTextField1.getText().equals("") && jPasswordField.getText().equals("")) {
                    JOptionPane.showMessageDialog(changeLibrarianPassword.this, "Please enter a valid password.");
                }
                else {
                    JOptionPane.showMessageDialog(changeLibrarianPassword.this, "Please enter valid data in the fields.");
                }
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminSuccess.main(new String[]{});
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
                                                .addGap(156, 156, 156)
                                                .addComponent(jButton1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButton2)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel1)
                                                                        .addComponent(jLabel2))
                                                                .addGap(62, 62, 62)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                                                        .addComponent(jPasswordField))))))
                                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(70, 70, 70))
        );

        pack();

    }
}
