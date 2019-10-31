import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import javax.swing.JTable;
import java.sql.SQLException;

public class SearchBook extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public static void main(String search, int n) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBook frame = new SearchBook(search, n);
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
	public SearchBook(String search, int n) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 900, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		String data[][]=null;
		String column[]=null;
		try{
			Connection con=DB.getConnection();
			ResultSet rs = null;
			PreparedStatement ps = null;
			// Searching based on each field
			switch(n){
			case 1:
				ps=con.prepareStatement("select * from books where r_id LIKE '%"+search+"%'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);				
				rs=ps.executeQuery();
				break;
			case 2:
				ps=con.prepareStatement("select * from books where title LIKE '%"+search+"%'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);				
				rs=ps.executeQuery();
				break;
			case 3:
				ps=con.prepareStatement("select * from books where language LIKE '%"+search+"%'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);				
				rs=ps.executeQuery();
				break;
			case 4:
				ps=con.prepareStatement("select * from books where edition LIKE '%"+search+"%'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);				
				rs=ps.executeQuery();
				break;
			case 5:
				ps=con.prepareStatement("select * from books where description LIKE '%"+search+"%'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);				
				rs=ps.executeQuery();
				break;
			case 6:
				ps=con.prepareStatement("select * from books where subject LIKE '%"+search+"%'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);				
				rs=ps.executeQuery();
				break;
			case 7:
				ps=con.prepareStatement("select * from books where location LIKE '%"+search+"%'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);				
				rs=ps.executeQuery();
				break;
			case 8:
				ps=con.prepareStatement("select * from books where isbn LIKE '%"+search+"%'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);				
				rs=ps.executeQuery();
				break;
			case 9:
				ps=con.prepareStatement("select * from books where genre LIKE '%"+search+"%'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);				
				rs=ps.executeQuery();
				break;
			case 10:
				ps=con.prepareStatement("select * from books where format LIKE '%"+search+"%'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);				
				rs=ps.executeQuery();
				break;
			case 11:
				ps=con.prepareStatement("select * from books where deweydecimalnumber LIKE '%"+search+"%'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);				
				rs=ps.executeQuery();
				break;
			case 12:
				ps=con.prepareStatement("select * from books where lccn LIKE '%"+search+"%'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);				
				rs=ps.executeQuery();
				break;
			case 13:
				ps=con.prepareStatement("select * from author where author_name LIKE '%"+search+"%'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);				
				rs=ps.executeQuery();
				break;
			}
//			PreparedStatement ps=con.prepareStatement("select * from books where r_id LIKE '%"+book_id+"%'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//			ResultSet rs=ps.executeQuery();
			
			ResultSetMetaData rsmd=rs.getMetaData();
			int cols=rsmd.getColumnCount();
			column=new String[cols];
			for(int i=1;i<=cols;i++){
				column[i-1]=rsmd.getColumnName(i);
			}
			
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();
			data=new String[rows][cols];
			int count=0;
			while(rs.next()){
				for(int i=1;i<=cols;i++){
					data[count][i-1]=rs.getString(i);
				}
				count++;
			}
			con.close();
		}catch(SQLException e){System.out.println(e);}
		// Filling the table
		table = new JTable(data,column);
		JScrollPane sp=new JScrollPane(table);
		
		contentPane.add(sp, BorderLayout.CENTER);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	// When clicked on an entry on the table we call the update book class with the book_id of the row to update the book.
	            UpdateBook.main(table.getValueAt(table.getSelectedRow(), 0).toString());
	        }
	    });
	}

}
