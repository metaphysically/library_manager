

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IssueBookForm extends JFrame implements FocusListener {

    static IssueBookForm frame;
    private final JPanel contentPane;
    private javax.swing.JButton jButton1;
    private final javax.swing.JButton jButton2;
    private final javax.swing.JLabel jLabel1;
    private final javax.swing.JLabel jLabel2;
    private final javax.swing.JLabel jLabel3;
    private final javax.swing.JLabel jLabel4;
    private final javax.swing.JLabel jLabel5;
    private final javax.swing.JLabel jLabel6;
    private final javax.swing.JLabel jLabel7;
    private final javax.swing.JLabel jLabel8;
    private final javax.swing.JTextField jTextField1;
    private final javax.swing.JTextField jTextField2;
    private final javax.swing.JTextField jTextField3;
    private final javax.swing.JTextField jTextField4;
    private final javax.swing.JTextField jTextField5;
    private final javax.swing.JTextField jTextField6;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new IssueBookForm();
                    frame.setVisible(true);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public IssueBookForm() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();


        jLabel1.setText("Issue Book");
        jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        jLabel1.setForeground(Color.GRAY);

        jLabel2.setText("Call no:");
        jTextField1.setText("");
        jTextField1.addFocusListener(this);

        jLabel3.setText("Name: ");
        jTextField2.setText("");
        jTextField2.setEditable(false);

        jLabel4.setText("Books available: ");
        jTextField3.setText("");
        jTextField3.setEditable(false);

        jLabel5.setText("Employee ID: ");
        jTextField4.setText("");
        jTextField4.addFocusListener(new FocusListener() {
            public void focusLost(FocusEvent event) {
                try {
                    String getName = "select employeename, employeecontact from employees where employeeid = ?";
                    String pass = jTextField4.getText();
                    Connection con = DB.getConnection();
                    PreparedStatement pst = con.prepareStatement(getName);
                    pst.setString(1, pass);
                    ResultSet rs = pst.executeQuery();
                    String name = "";
                    if (rs.next()) {
                        jTextField5.setText(rs.getString(1));
                        jTextField6.setText(rs.getString(2));

                    }
                }
                catch (Exception e) {
                    System.out.println(e);
                }
            }

            public void focusGained(FocusEvent event) {
                //takes text from the textfield, therefore focusGained does not require any code.
            }
        });

        jLabel6.setText("Employee Name: ");
        jLabel7.setText("Contact Details: ");

        jLabel8.setText("          Note: Please check the Employee ID Carefully before issuing a book!");
        jLabel8.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jLabel8.setForeground(Color.RED);



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 438, 414);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);



        jButton1 = new JButton("Issue Book");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String bookcallno = jTextField1.getText();
                int employeeid = Integer.parseInt(jTextField4.getText());
                String employeename = jTextField5.getText();
                String employeecontact = jTextField6.getText();

                if (IssueBookDao.checkBook(bookcallno)) {
                    if (!IssueBookDao.checkQuantity(bookcallno)) {
                        JOptionPane.showMessageDialog(IssueBookForm.this, "Sorry, book unavailable!");
                    }
                    else {
                        if (Validation.ValidateNumber(employeecontact) == true) {
                            int i = IssueBookDao.save(bookcallno, employeeid, employeename, employeecontact);
                            if (i > 0) {
                                JOptionPane.showMessageDialog(IssueBookForm.this, "Book issued successfully!");
                                IssueBookDao.increaseIssuedCount(employeeid, employeename);
                                LibrarianSuccess.main(new String[]{});
                                frame.dispose();

                            }
                            else {
                                JOptionPane.showMessageDialog(IssueBookForm.this, "Sorry, unable to issue this book!");
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(IssueBookForm.this, "Please re-enter a valid contact number.");
                        }
                    }


                }
                else {
                    JOptionPane.showMessageDialog(IssueBookForm.this, "Sorry, Callno doesn't exist!");
                }// end of checkbook if-else

            }
        });

        jButton2 = new JButton("Back");
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
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(242, 242, 242)
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel7))
                                                .addGap(34, 34, 34)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                                                .addComponent(jLabel4)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jTextField4)
                                                                        .addComponent(jTextField1)
                                                                        .addComponent(jTextField5)
                                                                        .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addGap(66, 66, 66))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(255, 255, 255)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(48, 48, 48)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel1)
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(63, 63, 63))
        );

        pack();
    }

    @Override
    public void focusGained(FocusEvent e) {
        //takes text from the textfield, therefore focusGained does not require any code.
    }

    @Override
    public void focusLost(FocusEvent e) {
        try {
            //get name.
            String getName = "select name from books where callno = ?";
            String pass = jTextField1.getText();
            Connection con = DB.getConnection();
            PreparedStatement pst = con.prepareStatement(getName);
            pst.setString(1, pass);
            ResultSet rs = pst.executeQuery();
            String name = "";
            if (rs.next()) {
                name = rs.getString(1);
            }
            jTextField2.setText(name);

            //get quantity and issued values and subtract them to return a value for the availability field's data.
            String getQuantity = "select quantity from books where callno = ?";
            String getIssued = "select issued from books where callno = ?";
            pst = con.prepareStatement(getQuantity);
            pst.setString(1, pass);
            rs = pst.executeQuery();
            pst = con.prepareStatement(getIssued);
            pst.setString(1, pass);
            ResultSet rs2 = pst.executeQuery();
            int quantity, issued;
            if (rs.next() && rs2.next()) {
                quantity = rs.getInt(1);
                issued = rs2.getInt(1);
                jTextField3.setText(String.valueOf(quantity - issued));
            }
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
