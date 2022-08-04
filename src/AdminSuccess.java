import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.sql.*;
public class AdminSuccess extends JFrame {

	static AdminSuccess frame;
	private final JPanel contentPane;
	private final javax.swing.JButton jButton1;
	private final javax.swing.JButton jButton2;
	private final javax.swing.JButton jButton3;
	private final javax.swing.JButton jButton4;
	private final javax.swing.JButton jButton5;
	private final javax.swing.JButton jButton6;
	private final javax.swing.JButton jButton7;
	private final javax.swing.JLabel jLabel1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AdminSuccess();
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
	public AdminSuccess() {

		jLabel1 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


		setBounds(100, 100, 450, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		

		jLabel1.setText("   Admin Section");
		jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jLabel1.setForeground(Color.GRAY);

		jButton1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jButton1.setText("Add Librarian");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				LibrarianForm.main(new String[]{});
				frame.dispose();
			}
		});


		jButton2.setText("View Librarian");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ViewLibrarian.main(new String[]{});
				frame.dispose();
			}
		});
		jButton2.setFont(new Font("Tahoma", Font.PLAIN, 15));

		jButton3.setText("Edit Librarian Records");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				frame.dispose();
			}
		});
		jButton3.setFont(new Font("Tahoma", Font.PLAIN, 15));


		jButton4.setText("Change Admin Password");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				changeAdminPassword.main(new String[]{});
				frame.dispose();
			}
		});
		jButton4.setFont(new Font("Tahoma", Font.PLAIN, 15));


		jButton5.setText("Logout");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Library.main(new String[]{});
				frame.dispose();
			}
		});
		jButton5.setFont(new Font("Tahoma", Font.PLAIN, 15));

		jButton6.setText("Delete Librarian");
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				DeleteLibrarian.main(new String[]{});
				frame.dispose();
			}
		});
		jButton6.setFont(new Font("Tahoma", Font.PLAIN, 15));

		jButton7.setText("Change Librarian Password");
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				changeLibrarianPassword.main(new String[]{});
				frame.dispose();
			}
		});
		jButton7.setFont(new Font("Tahoma", Font.PLAIN, 15));


		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(147, 147, 147)
								.addComponent(jLabel1)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addContainerGap(114, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
										.addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(108, 108, 108))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabel1)
								.addGap(45, 45, 45)
								.addComponent(jButton1)
								.addGap(18, 18, 18)
								.addComponent(jButton2)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jButton3)
								.addGap(18, 18, 18)
								.addComponent(jButton6)
								.addGap(18, 18, 18)
								.addComponent(jButton4)
								.addGap(18, 18, 18)
								.addComponent(jButton7)
								.addGap(19, 19, 19)
								.addComponent(jButton5)
								.addContainerGap(51, Short.MAX_VALUE))
		);

		pack();
	}
}
