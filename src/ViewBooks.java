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

public class ViewBooks extends JFrame {

	static ViewBooks frame;
	private final JPanel contentPane;
	private final JTable table;
	private final javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
	private final javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
	private final javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
	private final javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
	private final javax.swing.JTextField jTextField1 = new javax.swing.JTextField();
	private final javax.swing.JTextField jTextField2 = new javax.swing.JTextField();
	private final javax.swing.JTextField jTextField3 = new javax.swing.JTextField();
	private final javax.swing.JTextField jTextField4 = new javax.swing.JTextField();
	private final javax.swing.JButton jButton1 = new javax.swing.JButton();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ViewBooks();
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
	public ViewBooks() {
            
                //Set Properties
                jLabel1.setText("Call no:");
                jLabel2.setText("Author:");
                jLabel3.setText("Name:");
                jLabel4.setText("Publisher:");
				jTextField1.setText("");
				jTextField2.setText("");
				jTextField3.setText("");
				jTextField4.setText("");
				String[] columns = {
						"id", "callno", "name", "author", "publisher", "quantity", "issued", "added_date"
				};
				DefaultTableModel model = new DefaultTableModel(columns, 0);
				table = new JTable(model);
                jButton1.setText("Search");
                jButton1.setActionCommand("Search");
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
						model.setRowCount(0);
						String[][] data = null;
						String[] column = null;

                        try {
							String query = "select * from books";
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
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		String[][] data = null;
		String[] column = null;
			try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from books",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
		JButton jButton2 = new JButton("Back");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianSuccess.main(new String[]{});
				frame.dispose();
			}
		});

		JScrollPane sp=new JScrollPane(table);
		
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
																.addGap(32, 32, 32)
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(jLabel1)
																		.addComponent(jLabel2))
																.addGap(45, 45, 45)
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																		.addComponent(jTextField1)
																		.addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
																.addGap(144, 144, 144)
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(jLabel3)
																		.addComponent(jLabel4)))
														.addGroup(layout.createSequentialGroup()
																.addGap(293, 293, 293)
																.addComponent(jButton1)))
												.addGap(25, 25, 25)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jButton2)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																.addComponent(jTextField3)
																.addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)))
												.addGap(0, 211, Short.MAX_VALUE))
										.addGroup(layout.createSequentialGroup()
												.addContainerGap()
												.addComponent(sp)))
								.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(28, 28, 28)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel1)
										.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel3)
										.addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(35, 35, 35)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel2)
										.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel4)
										.addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jButton1)
										.addComponent(jButton2))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		pack();
	}

	private String getQuery (String query) {
		String filter = "";

		if ((jTextField1.getText()) != null && !jTextField1.getText().isEmpty()) {
					filter += " callno = ? and";
		}
		if ((jTextField3.getText()) != null && !jTextField3.getText().isEmpty()) {
			filter += " name = ? and";
		}
		if ((jTextField2.getText()) != null && !jTextField2.getText().isEmpty()) {
			filter += " author = ? and";
		}
		if((jTextField4.getText()) != null && !jTextField4.getText().isEmpty()) {
			filter += " publisher = ? ";
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
			if ((jTextField3.getText()) != null && !jTextField3.getText().isEmpty()) {
				pst.setString(count, jTextField3.getText());
				count++;
			}
			if ((jTextField2.getText()) != null && !jTextField2.getText().isEmpty()) {
				pst.setString(count, jTextField2.getText());
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