import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class viewEmployee extends JFrame {

    static viewEmployee frame;
    private final JButton jButton1;
    private final JButton jButton2;
    private final JLabel jLabel1;
    private final JLabel jLabel2;
    private final JLabel jLabel3;
    private final JLabel jLabel4;
    private JTable jTable1;
    private final JTextField jTextField1;
    private final JTextField jTextField2;
    private final JTextField jTextField3;
    private final JTextField jTextField4;
    private final JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new viewEmployee();
                    frame.setVisible(true);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public viewEmployee() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jLabel4 = new JLabel();
        jTextField3 = new JTextField();
        jLabel3 = new JLabel();
        jTextField4 = new JTextField();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jTable1 = new JTable();

        String[] columns = {
                "id", "employeeid", "employeename", "employeecontact", "employeemail", "booksissued", "booksreturned"
        };

        DefaultTableModel model = new DefaultTableModel(columns, 0);
        jTable1 = new JTable(model);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Employee ID:");

        jLabel2.setText("Employee Name:");

        jLabel4.setText("Employee Contact:");

        jLabel3.setText("Employee Email:");

        jButton1.setText("Search");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                model.setRowCount(0);
                String[][] data = null;
                String[] column = null;

                try {
                    String query = "select * from employees";
                    Connection con = DB.getConnection();
                    PreparedStatement pst = con.prepareStatement(getQuery(query));
                    assignValue(pst);
                    ResultSet rs = pst.executeQuery();

                    while(rs.next()) {
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int cols = rsmd.getColumnCount();

                        Object[] obj = new Object[cols];
                        for(int i = 0; i < cols; i++) {
                            obj[i] = rs.getString(i + 1);
                        }
                        model.addRow(obj);
                    }

                }
                catch (Exception e) {
                    System.out.println(e);
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

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));

        String[][] data = null;
        String[] column = null;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from employees",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ResultSetMetaData rsmd = rs.getMetaData();
                int cols = rsmd.getColumnCount();
                Object[] obj = new Object[cols];
                for(int i = 0; i < cols; i++) {
                    obj[i] = rs.getString(i + 1);
                }
                model.addRow(obj);
            }
            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }

        JScrollPane sp=new JScrollPane(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(25, 25, 25)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                                        .addComponent(jTextField2))
                                                                .addGap(57, 57, 57)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jLabel3)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(282, 282, 282)
                                                                .addComponent(jButton1)))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton2)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jTextField3)
                                                                .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))
                                                .addGap(0, 42, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(sp)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }

    private String getQuery (String query) {
        String filter = "";

        if ((jTextField1.getText()) != null && !jTextField1.getText().isEmpty()) {
            filter += " employeeid = ? and";
        }
        if ((jTextField2.getText()) != null && !jTextField2.getText().isEmpty()) {
            filter += " employeename = ? and";
        }
        if ((jTextField3.getText()) != null && !jTextField3.getText().isEmpty()) {
            filter += " employeemail = ? and";
        }
        if((jTextField4.getText()) != null && !jTextField4.getText().isEmpty()) {
            filter += " employeecontact = ? ";
        }

        if (!filter.isEmpty()) {
            if (filter.endsWith("and")) {
                filter = filter.substring(0, filter.length()-3);
            }
            query += " where " + filter;
        }
        return query;
    }
    private void assignValue (PreparedStatement pst) {
        try {
            int count = 1;
            if ((jTextField1.getText()) != null && !jTextField1.getText().isEmpty()) {
                pst.setString(count, jTextField1.getText());
                count++;
            }
            if ((jTextField2.getText()) != null && !jTextField2.getText().isEmpty()) {
                pst.setString(count, jTextField2.getText());
                count++;
            }
            if ((jTextField3.getText()) != null && !jTextField3.getText().isEmpty()) {
                pst.setString(count, jTextField3.getText());
                count++;
            }
            if ((jTextField4.getText()) != null && !jTextField4.getText().isEmpty()) {
                pst.setString(count, jTextField4.getText());
                count++;
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

}
