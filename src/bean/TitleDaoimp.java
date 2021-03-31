//<Titles> getTitles()
package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class TitleDaoimp implements TitleDao {
	private Connection connection;
	private PreparedStatement titlesQuery;
	private ResultSet results;
	public List<Title> getTitles() {
		List<Title> titlesList = new ArrayList<Title>();
		try {
			connection = DBcon.getConnection();
			titlesQuery = connection.prepareStatement("SELECT isbn, title, editionNumber,copyright,publisherID, imageFile, price " + " FROM titles ORDER BY title");
			ResultSet results = titlesQuery.executeQuery();
			while (results.next()) {
				Title book = new Title(); 
				book.setIsbn(results.getString("isbn"));
				book.setTitle(results.getString("title"));
				book.setEditionNumber(results.getInt("editionNumber"));
				book.setCopyright(results.getString("copyright"));
				book.setPublisherId(results.getInt("publisherID"));
				book.setImageFile(results.getString("imageFile"));
				book.setPrice(results.getFloat("price"));
				titlesList.add(book); 
			}
		}
		catch (SQLException exception) {
			exception.printStackTrace();
		}
		finally {
			DBcon.closeResultSet(results);
			DBcon.closeStatement(titlesQuery);
			DBcon.closeConnection(connection);
		}
		return titlesList;
	}

	public int add(Title titlebean) {
		int result = 0;
		try {
			connection = DBcon.getConnection();
			String sql = "insert into titles(isbn, title, editionNumber, ";
			sql += "copyright, publisherID, imageFile, price) values(?,?,?,?,?,?,?)";
			titlesQuery = connection.prepareStatement(sql);
			titlesQuery.setString(1, titlebean.getIsbn());
			titlesQuery.setString(2, titlebean.getTitle());
			titlesQuery.setInt(3, titlebean.getEditionNumber());
			titlesQuery.setString(4, titlebean.getCopyright());
			titlesQuery.setInt(5, titlebean.getPublisherId());
			titlesQuery.setString(6, titlebean.getImageFile());
			titlesQuery.setFloat(7, titlebean.getPrice());
			result = titlesQuery.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBcon.closeResultSet(results);
			DBcon.closeStatement(titlesQuery);
			DBcon.closeConnection(connection);
		}
		return result;
	}

	public int delete(String isbn) {
		int result = 0;
		try {
			connection = DBcon.getConnection();
			String sql = "delete from titles where isbn='" + isbn + "'";
			titlesQuery = connection.prepareStatement(sql);
			result = titlesQuery.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBcon.closeResultSet(results);
			DBcon.closeStatement(titlesQuery);
			DBcon.closeConnection(connection);
		}
		return result;
	}

	public int update(Title titlebean) {
		int result = 0;
		try {
			connection = DBcon.getConnection();
			String sql = "update titles set title=?, editionNumber=?, ";
			sql += "copyright=?, publisherID=?, imageFile=?, price=?  where isbn=?";
			titlesQuery = connection.prepareStatement(sql);
			titlesQuery.setString(1, titlebean.getTitle());
			titlesQuery.setInt(2, titlebean.getEditionNumber());
			titlesQuery.setString(3, titlebean.getCopyright());
			titlesQuery.setInt(4, titlebean.getPublisherId());
			titlesQuery.setString(5, titlebean.getImageFile());
			titlesQuery.setFloat(6, titlebean.getPrice());
			titlesQuery.setString(7, titlebean.getIsbn());
			result = titlesQuery.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBcon.closeResultSet(results);
			DBcon.closeStatement(titlesQuery);
			DBcon.closeConnection(connection);
		}
		return result;

	}

	public Title findByIsbn(String isbn) { 
		Title book = null;
		try {
			connection = DBcon.getConnection();
			String sql = "SELECT * FROM titles where isbn='" + isbn + "'";
			titlesQuery = connection.prepareStatement(sql);
			results = titlesQuery.executeQuery();
			if (results.next()) {
				book = new Title();
				book.setIsbn(results.getString("isbn"));
				book.setTitle(results.getString("title"));
				book.setEditionNumber(results.getInt("editionNumber"));
				book.setCopyright(results.getString("copyright"));
				book.setPublisherId(results.getInt("publisherID"));
				book.setImageFile(results.getString("imageFile"));
				book.setPrice(results.getFloat("price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBcon.closeResultSet(results);
			DBcon.closeStatement(titlesQuery);
			DBcon.closeConnection(connection);
		}

		return book;
	}

	
}
