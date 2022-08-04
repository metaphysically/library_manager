import javax.swing.*;
import java.awt.*;

public class changeAdminPassword extends JFrame {

    static changeAdminPassword frame;
    private final javax.swing.JButton jButton1;
    private final javax.swing.JButton jButton2;
    private final javax.swing.JLabel jLabel1;
    private final javax.swing.JLabel jLabel2;
    private final javax.swing.JLabel jLabel3;
    private final javax.swing.JPasswordField jPasswordField1;
    private final javax.swing.JPasswordField jPasswordField2;
    private final javax.swing.JTextField jTextField1;

    public static void main (String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new changeAdminPassword();
                    frame.setVisible(true);
                }
                catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }

    public changeAdminPassword() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username:");
        jTextField1.setText("");

        jLabel2.setText("Old Password;");
        jPasswordField1.setText("");

        jLabel3.setText("New Password:");
        jPasswordField2.setText("");

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (!jTextField1.getText().equals("") && !jPasswordField1.getText().equals("") && !jPasswordField2.getText().equals("")) {
                    String username = jTextField1.getText();
                    String oldPassword = jPasswordField1.getText();
                    String newPassword = jPasswordField2.getText();

                    if (username.equals(AdminLogin.adminUsername) && oldPassword.equals(AdminLogin.adminPassword)) {
                        AdminLogin.adminPassword = newPassword;
                    }
                    else {
                        JOptionPane.showMessageDialog(changeAdminPassword.this, "Username or old password incorrect.");
                    }
                }
                else if (jTextField1.getText().equals("") && !jPasswordField1.getText().equals("") && !jPasswordField2.getText().equals("")) {
                    JOptionPane.showMessageDialog(changeAdminPassword.this, "Please enter a valid username");
                }
                else if (!jTextField1.getText().equals("") && jPasswordField1.getText().equals("") && !jPasswordField2.getText().equals("")) {
                    JOptionPane.showMessageDialog(changeAdminPassword.this, "Please enter a valid password.");
                }
                else if (!jTextField1.getText().equals("") && !jPasswordField1.getText().equals("") && jPasswordField2.getText().equals("")) {
                    JOptionPane.showMessageDialog(changeAdminPassword.this, "Please enter a valid password.");
                }
                else {
                    JOptionPane.showMessageDialog(changeAdminPassword.this, "Please enter valid data in the given fields.");
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
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jButton2)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextField1)
                                                        .addComponent(jPasswordField1)
                                                        .addComponent(jPasswordField2, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))))
                                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();

    }
}
