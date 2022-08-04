import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class updateBooks extends JFrame {

    static updateBooks frame;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;


    public static void main (String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new updateBooks();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public updateBooks() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel1.setText("Enter the data to update the record");

        jLabel2.setText("Book Name:");
        jTextField1.setText("");

        jLabel3.setText("Book Author: ");
        jTextField2.setText("");

        jLabel4.setText("Book Publisher:");
        jTextField3.setText("");

        jLabel5.setText("Book Quantity:");
        jTextField4.setText("");

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (!jTextField1.getText().equals("") && !jTextField2.getText().equals("") && !jTextField3.getText().equals("") && !jTextField4.getText().equals("")) {

                    String bookName = jTextField1.getText();
                    String bookAuthor = jTextField2.getText();
                    String bookPublisher = jTextField3.getText();
                    int quantity = Integer.parseInt(jTextField4.getText());
                    if (checkQuantity(quantity, editBook.callno) == true) {
                        int i = editBookDao.updateBookRecord(bookName, bookAuthor, bookPublisher, quantity, editBook.callno);

                        if (i > 0) {
                            JOptionPane.showMessageDialog(updateBooks.this, "Record updated successfully.");
                            LibrarianSuccess.main(new String[]{});
                            frame.dispose();
                        } else {
                            JOptionPane.showMessageDialog(updateBooks.this, "Failed to update record.");
                        }
                        if (jTextField1.getText().equals("") && !jTextField2.getText().equals("") && !jTextField3.getText().equals("") && !jTextField4.getText().equals("")) {
                            JOptionPane.showMessageDialog(updateBooks.this, "Please enter a valid book name.");
                        } else if (!jTextField1.getText().equals("") && jTextField2.getText().equals("") && !jTextField3.getText().equals("") && !jTextField4.getText().equals("")) {
                            JOptionPane.showMessageDialog(updateBooks.this, "Please enter a valid author's name.");
                        } else if (!jTextField1.getText().equals("") && !jTextField2.getText().equals("") && jTextField3.getText().equals("") && !jTextField4.getText().equals("")) {
                            JOptionPane.showMessageDialog(updateBooks.this, "Please enter a valid publisher's name.");
                        } else if (!jTextField1.getText().equals("") && !jTextField2.getText().equals("") && !jTextField3.getText().equals("") && !jTextField4.getText().equals("")) {
                            JOptionPane.showMessageDialog(updateBooks.this, "Please enter a valid quantity value.");
                        } else {
                            JOptionPane.showMessageDialog(updateBooks.this, "Please enter valid data in the given fields.");
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(updateBooks.this,"Invalid quantity.\nEnter a quantity that is higher than the number of books that are currently issued.");
                    }
                }
                }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBook.main(new String[]{});
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
                                                .addGap(26, 26, 26)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel4)
                                                                        .addGap(18, 18, 18))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(jLabel2)
                                                                                        .addGap(11, 11, 11)))
                                                                        .addGap(29, 29, 29)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addGap(22, 22, 22)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextField1)
                                                        .addComponent(jTextField2)
                                                        .addComponent(jTextField3)
                                                        .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(126, 126, 126)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton3)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jButton1)
                                                                .addGap(27, 27, 27)
                                                                .addComponent(jButton2)))))
                                .addGap(49, 64, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }

    public static boolean checkQuantity (int quantity, String callno) {

        boolean isEnough = false;

        try {
            String query = "select issued from books where callno = ?";
            Connection con = DB.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            int issued;
            if (rs.next() == true) {
                issued = rs.getInt(1);
                if (quantity > issued) {
                    isEnough = true;
                }
            }

            else {
                isEnough = false;
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return isEnough;
    }
}
