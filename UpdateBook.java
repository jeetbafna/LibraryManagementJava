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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UpdateBook extends JFrame {
	static UpdateBook frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
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
	
	public static void main(String book_id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UpdateBook(book_id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public UpdateBook(String book_id){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddBooks = new JLabel("Update Book");
		lblAddBooks.setForeground(Color.GRAY);
		lblAddBooks.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
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
		JLabel lblPublisher = new JLabel("Publisher:");
		

		textField = new JTextField();
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
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
		
		JButton btnUpdateBook = new JButton("Update Book");
		try {
			Connection con=DB.getConnection();
		    PreparedStatement ps = null;
		    String sql = "SELECT * FROM books ";
		           sql += "WHERE r_id = ?;";
		    ps = con.prepareStatement(sql);
		    ps.setString(1, book_id);
		    ResultSet rs = ps.executeQuery();
		    if(rs.next()) {
		    	PreparedStatement ps1 = null;
		    	String sql1 = "SELECT author_name from author ";
		    		   sql1+= "WHERE r_id = ?;";
		    	ps1=con.prepareStatement(sql1);
		    	ps1.setString(1, book_id);
		    	ResultSet rs1 = ps1.executeQuery();
		    	while(rs1.next()) {
		    		textField_14.setText(rs1.getString("author_name") + ",");
		    	}
		    	String pages1 = Integer.toString(rs.getInt("pages"));
		    	String quantity1 = Integer.toString(rs.getInt("quantity"));
		    	textField.setText(rs.getString("r_id"));
		    	textField_1.setText(rs.getString("title"));
		    	textField_2.setText(pages1);
		    	textField_3.setText(quantity1);
		    	textField_4.setText(rs.getString("language"));
		    	textField_5.setText(rs.getString("edition"));
		    	textField_6.setText(rs.getString("description"));
		    	textField_7.setText(rs.getString("subject"));
		    	textField_8.setText(rs.getString("location"));
		    	textField_9.setText(rs.getString("isbn"));
		    	textField_10.setText(rs.getString("genre"));
		    	textField_11.setText(rs.getString("format"));
		    	textField_12.setText(rs.getString("deweydecimalnumber"));
		    	textField_13.setText(rs.getString("lccn"));
		    	//textField_14.setText(rs.getString("publisher"));
		    	textField_15.setText(rs.getString("publisher"));
		    }
		    else {
		    	System.out.println("No Such Record Found");
		    }
		    con.close();
		} catch(SQLException s) {
			System.out.println(s);
		}
		textField.setEditable(false);
		textField_9.setEditable(false);
		
		btnUpdateBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con=DB.getConnection();
					String author=textField_14.getText();
					List<String> list = new ArrayList<String>(Arrays.asList(author.split(",")));
					for(int n =0;n< list.size();n++) {
//						PreparedStatement ps3 = con.prepareStatement("update author SET author_name=? WHERE r_id=?");
//						ps3.setString(1, list.get(n));
//						ps3.setString(2,textField.getText());
//						ps3.executeUpdate();
						PreparedStatement ps4= con.prepareStatement("Select r_id from author where author_name = ?");
						ps4.setString(1, list.get(n));
						ResultSet rs2 = ps4.executeQuery();
						if(rs2.next()) {
							if(rs2.getString("r_id") != textField.getText()) {
								PreparedStatement ps5 = con.prepareStatement("insert into author(r_id,author_name) values(?,?);");
								ps5.setString(1,textField.getText());
								ps5.setString(2, list.get(n));
								ps5.executeUpdate();
							}
						}
						else {
							PreparedStatement ps3 = con.prepareStatement("insert into author(r_id,author_name) values(?,?) ;");
							ps3.setString(2, list.get(n));
							ps3.setString(1,textField.getText());
							ps3.executeUpdate();
						}
					}
					String squantity = textField_3.getText();
					String spages = textField_2.getText();
					int quantity=Integer.parseInt(squantity);
					int pages=Integer.parseInt(spages);
					PreparedStatement ps2 =con.prepareStatement("update books SET title=? , pages=?, quantity=?, language=?, edition=?, description=?, subject=?, location=?, genre=?, format=?, deweydecimalnumber=?, lccn=?, publisher=? WHERE r_id = ?;");
					ps2.setString(1,textField_1.getText());
					ps2.setInt(2,pages);
					ps2.setInt(3,quantity);
					ps2.setString(4,textField_4.getText());
					ps2.setString(5,textField_5.getText());
					ps2.setString(6,textField_6.getText());
					ps2.setString(7,textField_7.getText());
					ps2.setString(8,textField_8.getText());
					ps2.setString(9,textField_10.getText());
					ps2.setString(10,textField_11.getText());
					ps2.setString(11,textField_12.getText());
					ps2.setString(12,textField_13.getText());
					ps2.setString(13,textField_15.getText());
					ps2.setString(14,textField.getText());
					int m = ps2.executeUpdate();
					if(m>0) {
						JOptionPane.showMessageDialog(UpdateBook.this,"Books added successfully!");
						LibrarianSuccess.main(new String[]{});
						frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(UpdateBook.this,"Sorry, unable to save!");
					}
					con.close();
					
				} catch(SQLException s) {
					System.out.println(s);
				}
			}
		});
		JButton btnDelete = new JButton("Delete Book");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con=DB.getConnection();
					PreparedStatement ps5 = con.prepareStatement("DELETE FROM BOOKS WHERE r_id = ?;");
					ps5.setString(1,book_id);
					ps5.executeUpdate();
					con.close();
				} catch(SQLException s) {
					System.out.println(s);
				}
				BooksForm.main(new String[] {});
			}
		});
		
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
								.addComponent(lblPublisher, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								//.addComponent(c1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
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
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(125, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(161)
					.addComponent(btnUpdateBook, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(162, Short.MAX_VALUE)
					.addGap(50)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(359, Short.MAX_VALUE)
					//.addComponent(btnBack)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAddBooks)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCallNo)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
//						.addComponent(lblPublisher)
//						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPages)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuantity)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLanguage)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEdition)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescription)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSubject)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocation)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIsbn)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGenre)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFormat)
						.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDewey)
						.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLccn)
						.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAuthor)
						.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPublisher)
						.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(btnUpdateBook, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnDelete)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
