import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ViewLibrarian extends JFrame {

	static ViewLibrarian frame;
	private final JPanel contentPane;
	private final JTable table;
	private final JLabel jLabel1 = new JLabel();
	private final JLabel jLabel2 = new javax.swing.JLabel();
	private final JTextField jTextField1 = new JTextField();
	private final JTextField jTextField2 = new javax.swing.JTextField();
	private final JToggleButton jToggleButton1 = new JToggleButton();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ViewLibrarian();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewLibrarian() {

		String[] columns = {
				"id", "name", "password", "email", "address", "city", "contact"
		};
		DefaultTableModel model = new DefaultTableModel(columns, 0);
		table = new JTable(model);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Name: ");

		jLabel2.setText("Contact: ");

		jToggleButton1.setText("Search");
		jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					model.setRowCount(0);
					String[][] data = null;
					String[] column = null;
					StringBuilder sb = new StringBuilder();
					String query = "select * from librarian";
					Connection con = DB.getConnection();
					PreparedStatement pst = con.prepareStatement(getQuery(query));
					assignValue(pst);

					ResultSet rs = pst.executeQuery();
					while(rs.next()){
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


		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		String[][] data =null;
		String[] column =null;
		try {
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from librarian",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ResultSetMetaData rsmd=rs.getMetaData();
				int cols=rsmd.getColumnCount();
				Object[] obj = new Object[cols];
				for(int i=0;i<cols;i++) {
					obj[i]=rs.getString(i + 1);
				}
				model.addRow(obj);
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}

		JButton jButton2 = new JButton("Back");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AdminSuccess.main(new String[]{});
				frame.dispose();
			}
		});

		JScrollPane sp=new JScrollPane(table);

		contentPane.add(sp, BorderLayout.CENTER);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addGap(36, 36, 36)
																.addComponent(jLabel1)
																.addGap(36, 36, 36)
																.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(77, 77, 77)
																.addComponent(jLabel2))
														.addGroup(layout.createSequentialGroup()
																.addGap(251, 251, 251)
																.addComponent(jToggleButton1)))
												.addGap(62, 62, 62)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
																.addComponent(jButton2)
																.addGap(30, 30, 30)))
												.addGap(0, 45, Short.MAX_VALUE))
										.addGroup(layout.createSequentialGroup()
												.addContainerGap()
												.addComponent(sp)))
								.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(32, 32, 32)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel1)
										.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel2)
										.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jToggleButton1)
										.addComponent(jButton2))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
								.addContainerGap())
		);

		pack();


	}

	private String getQuery (String query) {
		String filter = "";

		if ((jTextField1.getText()) != null && !jTextField1.getText().isEmpty()) {
			filter += " name = ? and";
		}
		if ((jTextField2.getText()) != null && !jTextField2.getText().isEmpty()) {
			filter += " contact = ? and";
		}
		if (!filter.isEmpty()) {
			if (filter.endsWith("and")) {
				filter = filter.substring(0, filter.length() - 3);
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
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
