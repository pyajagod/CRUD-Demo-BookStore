package bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class RegisterDaoImpl implements RegisterDao {
	private Connection connection;
	private PreparedStatement titlesQuery;
	private ResultSet results;
	@Override
	public List<Register> getRegisters() {
		List<Register> registerList = new ArrayList<Register>();
		try {
			connection = DBcon.getConnection();
			titlesQuery = connection.prepareStatement("SELECT loginname,password"
					+ " FROM userinfo");
			ResultSet results = titlesQuery.executeQuery();
			while (results.next()) {
				Register register= new Register(); 
				register.setloginname(results.getString("loginname"));
				register.setpassword(results.getString("password"));
				registerList.add(register); 
				
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
		return registerList;
	}

	

	@Override
	public int add(Register registerbean) {
		int result = 0;
		try {
			connection = DBcon.getConnection();
			String sql = "insert into userinfo(loginname,password)"+" values(?,?)";
			titlesQuery = connection.prepareStatement(sql);
			titlesQuery.setString(1,  registerbean.getloginname());
			titlesQuery.setString(2,  registerbean.getpassword());
			
			result = titlesQuery.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ÊÍ·Å×ÊÔ´
		finally {
			DBcon.closeResultSet(results);
			DBcon.closeStatement(titlesQuery);
			DBcon.closeConnection(connection);
		}
		return result;
	}

}
