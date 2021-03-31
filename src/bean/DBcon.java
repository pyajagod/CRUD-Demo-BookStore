package bean;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql. PreparedStatement;
import java.sql.ResultSet ;
import java.sql.SQLException;
public class DBcon {
private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
private static final String url = "jdbc:mysql://localhost:3306/books";
private static final String user ="root" ;
private static final String psw = "123";
public static Connection getConnection() {
	Connection dbConnection = null;
	try { Class.forName(DRIVER_CLASS); 
	dbConnection = DriverManager.getConnection(url,user,psw);
	
	} catch (Exception e) {
	e.printStackTrace();
	}
	return dbConnection;
}
	public static void closeConnection(Connection dbConnection) {
	try {
	if (dbConnection != null &&(!dbConnection.isClosed())) {
		dbConnection.close();
	}
	} catch(SQLException sqlEx) {
		sqlEx.printStackTrace();
	}
	}
	
	public static void closeResultSet(ResultSet res) {
	try {
	if (res != null) {
	res. close();
	res = null;
	}
	} catch (SQLException e) {
	e.printStackTrace();
	}
	}
	public static void closeStatement(PreparedStatement pStatement)  {
	try {
	if (pStatement != null) {
	pStatement.close();
	pStatement = null;
	}
	}
	catch (SQLException e) {
		e.printStackTrace();

}
	}	
}
