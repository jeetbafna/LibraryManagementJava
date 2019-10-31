import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BooksForm extends JFrame {
	//Initializing all the import textFields and panels
	static BooksForm frame;
	private JPanel contentPane;
	private JTextField textField;
	//private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JComboBox c1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BooksForm();
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
	public BooksForm() {
		//Setting the frame size and border
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//Label for the window
		JLabel lblAddBooks = new JLabel("Add Book");
		lblAddBooks.setForeground(Color.GRAY);
		lblAddBooks.setFont(new Font("Tahoma", Font.PLAIN, 18));
		//Publisher options
		String s1[] = { "Pearson", "Techmax", "Cengage", "AAN", "BBT" }; 
  
        // create a dropdown with the required String s1 
        c1 = new JComboBox(s1); 
		// Creating labels for fields that we require in a book
		JLabel lblCallNo = new JLabel("Book_id:");
		//JLabel lblPublisher = new JLabel("Publisher:");
		JLabel lblName = new JLabel("Title:");
		JLabel lblPages = new JLabel("Pages:");
		JLabel lblQuantity = new JLabel("Quantity:");
		JLabel lblLanguage = new JLabel("Language:");
		JLabel lblEdition = new JLabel("Edition:");
		JLabel lblDescription = new JLabel("Description:");
		JLabel lblSubject = new JLabel("Subject:");
		JLabel lblLocation = new JLabel("Location:");
		JLabel lblIsbn = new JLabel("ISBN:");
		JLabel lblGenre = new JLabel("Genre:");
		JLabel lblFormat = new JLabel("Format:");
		JLabel lblDewey = new JLabel("Dewey Decimal Number:");
		JLabel lblLccn = new JLabel("LCCN:");
		JLabel lblAuthor = new JLabel("Author:");
		JLabel lblCity = new JLabel("Publisher:");
//		Initializing all the text fields 
		textField = new JTextField();
		textField.setColumns(10);
		
//		textField_1 = new JTextField();
//		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setColumns(10);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		// Setting the isbn textfield length to 10 so that it does not it does not acceot more characters
		textField_10.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        if(textField_10.getText().length()>10&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});

		textField_11 = new JTextField();
		textField_11.setColumns(10);

		textField_12 = new JTextField();
		textField_12.setColumns(10);

		textField_13 = new JTextField();
		textField_13.setColumns(10);

		textField_14 = new JTextField();
		textField_14.setColumns(10);

		textField_15 = new JTextField();
		textField_15.setColumns(10);
		// Adding an onlick listener to the button Addbook
		JButton btnAddBooks = new JButton("Add Books");
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			String book_id=textField.getText();
			// Array is a comma separated String so converting it into a list
			String author=textField_15.getText();
			List<String> list = new ArrayList<String>(Arrays.asList(author.split(",")));
		
			// Getting all the details for the book
			String publisher = (String)c1.getSelectedItem();
			//String publisher=textField_1.getText();
			String title=textField_2.getText();
			String spages=textField_3.getText();
			String squantity=textField_4.getText();
			String language=textField_5.getText();
			String edition=textField_6.getText();
			String description=textField_7.getText();
			String subject=textField_8.getText();
			String location=textField_9.getText();
			String isbn=textField_10.getText();
			String genre=textField_11.getText();
			String format=textField_12.getText();
			String deweyd=textField_13.getText();
			String lccn=textField_14.getText();
			// Converting the String into integers for quantity and pages
			int quantity=Integer.parseInt(squantity);
			int pages=Integer.parseInt(spages);
			// Passing all the values to a different class to save the book, if the book is saved an integer greater than 0 is returned
			int i=BookDao.save(book_id,publisher, title,pages, quantity, language, edition, description, subject, location, isbn, genre, format, deweyd, lccn);
			if(i>0){
				JOptionPane.showMessageDialog(BooksForm.this,"Books added successfully!");
				// Redirecting after a successful add
				LibrarianSuccess.main(new String[]{});
				frame.dispose();
				
			}else{
				if(i==-1) {
					// Returns -1 if the user tries to save the book with the same isbn
					JOptionPane.showMessageDialog(BooksForm.this,"Cannot save the book with same ISBN");
				}
				else {
				// If the book is not saved due to any error
				JOptionPane.showMessageDialog(BooksForm.this,"Sorry, unable to save!");
				}
			}
			// Iterating through the authors and saving it in the author table
			for(int j=0;j<list.size();j++) {
				System.out.println(list.get(j));
				try {
					Connection con=DB.getConnection();
				    PreparedStatement ps = null;
				    //Checking is the author name already exists in the table
				    String sql = "SELECT r_id FROM Author ";
				           sql += "WHERE author_name = ?;";
				    ps = con.prepareStatement(sql);
				    ps.setString(1, list.get(j));
				    ResultSet rs = ps.executeQuery();
				    if (rs.next()) {
				    	// Checking if the author name exists with the same book id in the table, if not we save the author name with the current book id
				       if(book_id != rs.getString("r_id")){
				    	   PreparedStatement ps1=con.prepareStatement("insert into author(r_id, author_name) values(?,?)");
				    	   ps1.setString(1,book_id);
				    	   ps1.setString(2, list.get(j));
				    	   ps1.executeUpdate();
				    	   continue;
				       }
				    }
				    else {
				    	// If the author name is not present in the table save it
				    	   PreparedStatement ps1=con.prepareStatement("insert into author(r_id, author_name) values(?,?)");
				    	   ps1.setString(1,book_id);
				    	   ps1.setString(2, list.get(j));
				    	   int l = ps1.executeUpdate();
				    	   System.out.println(l);
				    	   continue;
				    }
				    con.close();
				} catch (SQLException s) {
					//Handle Exception
					System.out.println(s);
				}
			}
			}
		});
		
//		JButton btnSearch = new JButton("Search");
//		btnSearch.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String book_id = textField.getText();
//				//String publisher = (String)c1.getSelectedItem();
//				//String publisher=textField_1.getText();
//				String title=textField_2.getText();
//				String language=textField_5.getText();
//				String edition=textField_6.getText();
//				String description=textField_7.getText();
//				String subject=textField_8.getText();
//				String location=textField_9.getText();
//				String isbn=textField_10.getText();
//				String genre=textField_11.getText();
//				String format=textField_12.getText();
//				String deweyd=textField_13.getText();
//				String lccn=textField_14.getText();
//				SearchBook.main(book_id,1);
//			}
//		});
		// Button to clear all the text fields.
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
				textField_10.setText("");
				textField_11.setText("");
				textField_12.setText("");
				textField_13.setText("");
				textField_14.setText("");
				textField_15.setText("");
			}
		});
		// Searching based on each field
		JButton btnSearch1 = new JButton("Search");
		btnSearch1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().equals("")){
					// We send the text in the text field and number which indicates the field which is being sent
					SearchBook.main(textField.getText(),1);
				}
			}
		});
		JButton btnSearch2 = new JButton("Search");
		btnSearch2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_2.getText().equals("")){
					SearchBook.main(textField_2.getText(),2);
				}
			}
		});
		JButton btnSearch3 = new JButton("Search");
		btnSearch3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_5.getText().equals("")){
					SearchBook.main(textField_5.getText(),3);
				}
			}
		});
		JButton btnSearch4 = new JButton("Search");
		btnSearch4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_6.getText().equals("")){
					SearchBook.main(textField_6.getText(),4);
				}
			}
		});
		JButton btnSearch5 = new JButton("Search");
		btnSearch5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_7.getText().equals("")){
					SearchBook.main(textField_7.getText(),5);
				}
			}
		});
		JButton btnSearch6 = new JButton("Search");
		btnSearch6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_8.getText().equals("")){
					SearchBook.main(textField_8.getText(),6);
				}
			}
		});
		JButton btnSearch7 = new JButton("Search");
		btnSearch7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_9.getText().equals("")){
					SearchBook.main(textField_9.getText(),7);
				}
			}
		});
		JButton btnSearch8 = new JButton("Search");
		btnSearch8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_10.getText().equals("")){
					SearchBook.main(textField_10.getText(),8);
				}
			}
		});
		JButton btnSearch9 = new JButton("Search");
		btnSearch9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_11.getText().equals("")){
					SearchBook.main(textField_11.getText(),9);
				}
			}
		});
		JButton btnSearch10 = new JButton("Search");
		btnSearch10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_12.getText().equals("")){
					SearchBook.main(textField_12.getText(),10);
				}
			}
		});
		JButton btnSearch11 = new JButton("Search");
		btnSearch11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_13.getText().equals("")){
					SearchBook.main(textField_13.getText(),11);
				}
			}
		});
		JButton btnSearch12 = new JButton("Search");
		btnSearch12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_14.getText().equals("")){
					SearchBook.main(textField_14.getText(),12);
				}
			}
		});
		JButton btnSearch13 = new JButton("Search");
		btnSearch13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_15.getText().equals("")){
					SearchBook.main(textField_15.getText(),13);
				}
			}
		});
		
		// Layout of the screeen
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(150)
							.addComponent(lblAddBooks))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblCallNo, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								//.addComponent(lblPublisher, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPages, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
								.addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLanguage, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEdition, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSubject, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLocation, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIsbn, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGenre, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFormat, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDewey, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLccn, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAuthor, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCity, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(c1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								//.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(btnSearch1, GroupLayout.PREFERRED_SIZE,77, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnSearch2, GroupLayout.PREFERRED_SIZE,77, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnSearch3, GroupLayout.PREFERRED_SIZE,77, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnSearch4, GroupLayout.PREFERRED_SIZE,77, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnSearch5, GroupLayout.PREFERRED_SIZE,77, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnSearch6, GroupLayout.PREFERRED_SIZE,77, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnSearch7, GroupLayout.PREFERRED_SIZE,77, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnSearch8, GroupLayout.PREFERRED_SIZE,77, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnSearch9, GroupLayout.PREFERRED_SIZE,77, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnSearch10, GroupLayout.PREFERRED_SIZE,77, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnSearch11, GroupLayout.PREFERRED_SIZE,77, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnSearch12, GroupLayout.PREFERRED_SIZE,77, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnSearch13, GroupLayout.PREFERRED_SIZE,77, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(125, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(161)
					.addComponent(btnAddBooks, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(162, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(359, Short.MAX_VALUE)
					.addComponent(btnClear)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAddBooks)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCallNo)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch1))
					.addGap(18)
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
//						.addComponent(lblPublisher)
//						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch2))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPages)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuantity)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLanguage)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch3))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEdition)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch4))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescription)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch5))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSubject)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch6))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocation)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch7))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIsbn)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch8))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGenre)
						.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch9))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFormat)
						.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch10))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDewey)
						.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch11))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLccn)
						.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch12))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAuthor)
						.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch13))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCity)
						.addComponent(c1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(btnAddBooks, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnClear))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
