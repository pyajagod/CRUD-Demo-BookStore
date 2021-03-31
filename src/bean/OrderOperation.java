package bean;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class OrderOperation {
	private  Connection conn;
	private PreparedStatement pstmt;
	public void saveOrder(BookOrder bookoder)
	{
		try {
			conn = DBcon.getConnection();
			String sql = "insert into bookorder(username,zipcode,phone,";
			sql += "creditcard,total) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookoder.getUsername());
			pstmt.setString(2, bookoder.getname());
			pstmt.setString(3, bookoder.getPhone());
			pstmt.setString(4, bookoder.getaddress());
			pstmt.setDouble(5,bookoder.getTotal());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBcon.closeStatement(pstmt);
			DBcon.closeConnection(conn);
		}
	}
		public BookOrder qurry() {
			return null;
		}
}
