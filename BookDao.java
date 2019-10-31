import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDao {
public static int save(String book_id, String publisher, String title, int pages, int quantity, String language, String edition, 
	 String description, String subject, String location, String isbn, String genre, String format, String deweyd, String lccn){
	// this variable is returned which tells if the query is executed successfully or not
	int status=0;
	
		try {
			Connection con=DB.getConnection();
		    PreparedStatement ps1 = null;
		    // checking if the book already exists in the db
		    String sql = "SELECT ISBN FROM Books ";
		           sql += "WHERE ISBN = ?;";
		    ps1 = con.prepareStatement(sql);
		    ps1.setString(1, isbn);
		    ResultSet rs = ps1.executeQuery();
		    if (rs.next()) {
		    	status=-1;
		        System.out.println("Cannot save the book with same ISBN");
		        return status;
		    }
		    else {
		    	// adding the book in the db
				PreparedStatement ps=con.prepareStatement("insert into books(r_id,publisher, title, pages, quantity, language, edition, description, subject, location, isbn, genre, format, deweydecimalnumber, lccn) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,book_id);
				ps.setString(2,publisher);
				ps.setString(3,title);
				ps.setInt(4,pages);
				ps.setInt(5,quantity);
				ps.setString(6,language);
				ps.setString(7,edition);
				ps.setString(8,description);
				ps.setString(9,subject);
				ps.setString(10,location);
				ps.setString(11,isbn);
				ps.setString(12,genre);
				ps.setString(13,format);
				ps.setString(14,deweyd);
				ps.setString(15,lccn);
				status=ps.executeUpdate();
				con.close();
		    }
		} catch (Exception e) {
		    // handle exception
			System.out.println(e);
			return status;
		}
		
	return status;
	
}
}

