package kr.or.kpc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.kpc.dto.CustomerDto;
import kr.or.kpc.util.ConnLocator;

public class CustomerDao {
	
	public static CustomerDao dao;
	private CustomerDao() {}
	public static CustomerDao getInstance() {
		if(dao == null) {
			dao = new CustomerDao();
		}
		return dao;
		
	}
	
	//회원 존재여부
	public CustomerDto getLogin(String email, String pwd) {
	CustomerDto dto = null;
	Connection con = null;
	PreparedStatement prep = null;
	ResultSet rs = null;

	try {
		con = ConnLocator.getConnect();

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT c_email, c_pwd, c_name ");
		sql.append("FROM customer ");
		sql.append("WHERE c_email = ? AND c_pwd = PASSWORD(?) ");

		prep = con.prepareStatement(sql.toString());
		
		int index = 0;
		
		prep.setString(++index, email);
		prep.setString(++index, pwd);

		rs = prep.executeQuery();
		if (rs.next()) {
			index = 0;
			String _email = rs.getString(++index);
			String _pwd = rs.getString(++index);
			String name = rs.getString(++index);

			dto = new CustomerDto(_email, _pwd, name);

		}

	} catch (SQLException e) {
		e.printStackTrace();

	} finally {
		try {
			if (rs != null)
				rs.close();
			if (prep != null)
				prep.close();
			if (con != null)
				con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	return dto;
		
	}

}
