import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibrarianSuccess extends JFrame {

	static LibrarianSuccess frame;
	private final JPanel contentPane;
	private final javax.swing.JButton jButton1;
	private final javax.swing.JButton jButton2;
	private final javax.swing.JButton jButton3;
	private final javax.swing.JButton jButton4;
	private final javax.swing.JButton jButton5;
	private final javax.swing.JButton jButton6;
	private final javax.swing.JButton jButton7;
	private final javax.swing.JButton jButton8;
	private final javax.swing.JButton jButton9;
	private final javax.swing.JButton jButton10;
	private final javax.swing.JButton jButton11;
	private final javax.swing.JLabel jLabel1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LibrarianSuccess();
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
	public LibrarianSuccess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 433);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		jLabel1 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();
		jButton8 = new javax.swing.JButton();
		jButton9 = new javax.swing.JButton();
		jButton10 = new javax.swing.JButton();
		jButton11 = new javax.swing.JButton();

		JLabel jLabel1 = new JLabel("     Librarian Section");
		jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 18));

		jButton1.setText("Add Books");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BooksForm.main(new String[]{});
				frame.dispose();
			}
		});
		jButton1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		jButton2.setText("View Books");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewBooks.main(new String[]{});
				frame.dispose();
			}
		});
		jButton2.setFont(new Font("Tahoma", Font.PLAIN, 13));

		jButton3.setText("Issue Books");
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IssueBookForm.main(new String[]{});
				frame.dispose();
			}
		});
		jButton3.setFont(new Font("Tahoma", Font.PLAIN, 13));

		jButton4.setText("View Issued Books");
		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewIssuedBooks.main(new String[]{});
				frame.dispose();
			}
		});
		jButton4.setFont(new Font("Tahoma", Font.PLAIN, 13));

		jButton5.setText("Return a Book");
		jButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnBook.main(new String[]{});
				frame.dispose();
			}
		});
		jButton5.setFont(new Font("Tahoma", Font.PLAIN, 13));

		jButton6.setText("Add Employees");
		jButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employeeForm.main(new String[]{});
				frame.dispose();
			}
		});
		jButton6.setFont(new Font("Tahoma", Font.PLAIN, 13));

		jButton7.setText("View Employees");
		jButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewEmployee.main(new String[]{});
				frame.dispose();
			}
		});
		jButton7.setFont(new Font("Tahoma", Font.PLAIN, 13));

		jButton8.setText("Edit Employee Records");
		jButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				editEmployees.main(new String[]{});
				frame.dispose();
			}
		});
		jButton8.setFont(new Font("Tahoma", Font.PLAIN, 13));

		jButton9.setText("Delete Employee Records");
		jButton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteEmployee.main(new String[]{});
				frame.dispose();
			}
		});
		jButton9.setFont(new Font("Tahoma", Font.PLAIN, 13));


		jButton10.setText("Logout");
		jButton10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Library.main(new String[]{});
				frame.dispose();
			}
		});
		jButton10.setFont(new Font("Tahoma", Font.PLAIN, 13));

		jButton11.setText("Edit Book Records");
		jButton11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editBook.main(new String[]{});
				frame.dispose();
			}
		});
		jButton11.setFont(new Font("Tahoma", Font.PLAIN, 13));


		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(131, 131, 131)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																.addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
																.addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
														.addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(144, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(20, 20, 20)
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(jButton1)
								.addGap(18, 18, 18)
								.addComponent(jButton11)
								.addGap(18, 18, 18)
								.addComponent(jButton2)
								.addGap(18, 18, 18)
								.addComponent(jButton3)
								.addGap(18, 18, 18)
								.addComponent(jButton4)
								.addGap(18, 18, 18)
								.addComponent(jButton5)
								.addGap(18, 18, 18)
								.addComponent(jButton6)
								.addGap(18, 18, 18)
								.addComponent(jButton7)
								.addGap(18, 18, 18)
								.addComponent(jButton8)
								.addGap(18, 18, 18)
								.addComponent(jButton9)
								.addGap(18, 18, 18)
								.addComponent(jButton10)
								.addContainerGap(51, Short.MAX_VALUE))
		);

		pack();
	}

}
