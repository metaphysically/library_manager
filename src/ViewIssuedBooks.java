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

public class ViewIssuedBooks extends JFrame {

	static ViewIssuedBooks frame;
	private final JPanel contentPane;
	private final JTable table;
	private final JLabel jLabel1 = new javax.swing.JLabel();
	private final JLabel jLabel2 = new javax.swing.JLabel();
	private final JLabel jLabel3 = new javax.swing.JLabel();
	private final JLabel jLabel4 = new javax.swing.JLabel();
	private final JTextField jTextField1 = new JTextField();
	private final JTextField jTextField2 = new JTextField();
	private final JTextField jTextField3 = new JTextField();
	private final JTextField jTextField4 = new JTextField();
	private final JButton jButton1 = new JButton();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ViewIssuedBooks();
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
	public ViewIssuedBooks() {
		String[] columns = {
				"id", "bookcallno", "employeeid", "employeename", "employeecontact", "issueddate"
		};
		DefaultTableModel model = new DefaultTableModel(columns, 0);
		table = new JTable(model);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Call no: ");
		jTextField1.setText("");
		jLabel2.setText("Employee Name: ");
		jTextField2.setText("");
		jLabel3.setText("Employee ID:");
		jTextField3.setText("");
		jLabel4.setText("Employee Contact:");
		jTextField4.setText("");

		jButton1.setText("Search");
		jButton1.setActionCommand("Search");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					model.setRowCount(0);
					String[][] data = null;
					String[] column = null;
					StringBuilder sb = new StringBuilder();
					String query = "select * from issuebooks";
					Connection con = DB.getConnection();
					PreparedStatement pst = con.prepareStatement(getQuery(query));
					assignValue(pst);
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						ResultSetMetaData rsmd = rs.getMetaData();
						int cols = rsmd.getColumnCount();
						Object[] obj = new Object[cols];
						for (int i = 0; i < cols; i++) {
							obj[i] = rs.getString(i + 1);
							System.out.println(rs.getString(i + 1));
						}
						model.addRow(obj);
					}
				}
				catch (Exception e) {
					System.out.println(e);
				}
			}
		});
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		String[][] data = null;
		String[] column = null;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from issuebooks", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ResultSetMetaData rsmd = rs.getMetaData();
				int cols = rsmd.getColumnCount();
				Object[] obj = new Object[cols];
				for(int i = 0; i < cols; i++) {
					obj[i]=rs.getString(i + 1);
				}
				model.addRow(obj);
			}
			con.close();

		}
		catch (Exception e) {
			System.out.println(e);
		}

		JButton jButton2 = new JButton("Back");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianSuccess.main(new String[]{});
				frame.dispose();
			}
		});

		JScrollPane sp=new JScrollPane(table);


		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addGap(326, 326, 326)
								.addComponent(jButton1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
								.addComponent(jButton2)
								.addGap(117, 117, 117))
						.addGroup(layout.createSequentialGroup()
								.addGap(46, 46, 46)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel2)
										.addComponent(jLabel1))
								.addGap(43, 43, 43)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
										.addComponent(jTextField2))
								.addGap(118, 118, 118)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel3)
										.addComponent(jLabel4))
								.addGap(36, 36, 36)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jTextField3)
										.addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(sp)
								.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(30, 30, 30)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel1)
										.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel3)
										.addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(52, 52, 52)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel2)
										.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel4)
										.addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(55, 55, 55)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jButton1)
										.addComponent(jButton2))
								.addGap(18, 18, 18)
								.addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		pack();
	}

	private String getQuery (String query) {
		String filter = "";

		if ((jTextField1.getText()) != null && !jTextField1.getText().isEmpty()) {
			filter += " bookcallno = ? and";
		}
		if ((jTextField2.getText()) != null && !jTextField2.getText().isEmpty()) {
			filter += " employeename = ? and";
		}
		if ((jTextField3.getText()) != null && !jTextField3.getText().isEmpty()) {
			filter += " employeeid = ? and";
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
