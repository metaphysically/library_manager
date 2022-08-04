import javax.swing.*;
import java.awt.*;

public class editLibrarian extends JFrame {

    static editLibrarian frame;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    static int librarianID;

    public static void main (String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new editLibrarian();
                    frame.setVisible(true);
                }
                catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }

    public editLibrarian() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setText("Librarian ID:");
        jTextField1.setText("");

        jLabel2.setText("Librarian Name:");
        jTextField2.setText("");

        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

               if (!jTextField1.getText().equals("") && !jTextField2.getText().equals("")) {

                   librarianID = Integer.parseInt(jTextField1.getText());
                   String librarianName = jTextField2.getText();

                   if (editLibrarianDao.librarianExists(librarianID, librarianName) == true) {
                        updateLibrarian.main(new String[]{});
                        frame.dispose();
                   }
                   else {
                       JOptionPane.showMessageDialog(editLibrarian.this, "Please provide the valid credentails of a librarian.");
                   }
               }
               else if (jTextField1.getText().equals("") && !jTextField2.getText().equals("")) {
                   JOptionPane.showMessageDialog(editLibrarian.this, "Please enter a valid ID.");
               }
               else if (!jTextField1.getText().equals("") && jTextField2.getText().equals("")) {
                   JOptionPane.showMessageDialog(editLibrarian.this, "Please enter a valid name.");
               }
               else {
                   JOptionPane.showMessageDialog(editLibrarian.this, "Please provide the valid credentials of a librarian.");
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
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addGap(32, 32, 32)
                                                .addComponent(jButton2))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField1)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
    }

}
