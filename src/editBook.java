import javax.swing.*;
import java.awt.*;

public class editBook extends JFrame {

    static editBook frame;
    private final javax.swing.JButton jButton1;
    private final javax.swing.JButton jButton2;
    private final javax.swing.JLabel jLabel1;
    private final javax.swing.JLabel jLabel2;
    private final javax.swing.JTextField jTextField1;
    private final javax.swing.JTextField jTextField2;
    static String callno;

    public static void main (String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new editBook();
                    frame.setVisible(true);
                }
                catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }

    public editBook () {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name:");
        jTextField1.setText("");

        jLabel2.setText("Call no:");
        jTextField2.setText("");

        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (!jTextField1.getText().equals("") && !jTextField2.getText().equals("")) {

                    String name = jTextField1.getText();
                    callno = jTextField2.getText();

                    boolean exists = editBookDao.bookExists(callno, name);
                    if (exists == true) {
                        updateBooks.main(new String[]{});
                        frame.dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(editBook.this, "Please enter the ID and name of a valid book.");
                    }
                }
                else if (jTextField1.getText().equals("") && !jTextField2.getText().equals("")) {
                    JOptionPane.showMessageDialog(editBook.this, "Please enter a book name.");
                }
                else if (!jTextField1.getText().equals("") && jTextField2.getText().equals("")) {
                    JOptionPane.showMessageDialog(editBook.this, "Please enter a valid book call number.");
                }
                else {
                    JOptionPane.showMessageDialog(editBook.this, "Please enter the required data in the fields.");
                }
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
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
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton2))
                                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                        .addComponent(jTextField2))
                                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }
}
