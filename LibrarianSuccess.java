import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class LibrarianSuccess extends JFrame {
	static LibrarianSuccess frame;
	private JPanel contentPane;
	private JTextField bookId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LibrarianSuccess();
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
	public LibrarianSuccess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblLibrarianSection = new JLabel("Library");
		lblLibrarianSection.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JButton btnNewButton = new JButton("Add Books");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			BooksForm.main(new String[]{});
			frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnViewBooks = new JButton("View Books");
		btnViewBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewBooks.main(new String[]{});
			}
		});
		btnViewBooks.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblEnterId = new JLabel("Enter the id of the book you want to update: ");
		bookId = new JTextField();
		bookId.setColumns(10);
		JButton btnUpdateBook = new JButton("Update Book");
		btnUpdateBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String book_id = bookId.getText();
				if(!bookId.getText().equals("")) {
				UpdateBook.main(book_id);
				}
				else {
					System.out.println("Enter the id");
				}
			}
		});
		btnUpdateBook.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(81, Short.MAX_VALUE) 
					.addComponent(lblLibrarianSection)
					.addGap(54))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(132)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						
						.addComponent(bookId,GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEnterId,GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnViewBooks, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUpdateBook,GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(101, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLibrarianSection)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnViewBooks, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblEnterId)
					.addGap(18)
					.addComponent(bookId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnUpdateBook,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE )
					.addGap(18))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
