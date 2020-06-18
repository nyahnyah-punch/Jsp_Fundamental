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
	
	public CustomerDto getLogin(String email, String pwd) {
		CustomerDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnLocator.getConnect();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT c_email, c_pwd , c_name ");
			sql.append("FROM customer ");
			sql.append("WHERE c_email = ? AND c_pwd = PASSWORD(?)");
			sql.append("");

			pstmt = con.prepareStatement(sql.toString());

			int index = 0;
			pstmt.setString(++index, email);
			pstmt.setString(++index, pwd);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				index = 0;
				String _email = rs.getString(++index);
				String _pwd = rs.getString(++index);
				String name = rs.getString(++index);

				dto = new CustomerDto(_email,_pwd,name);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		return dto;
	}
	
	public int insert(CustomerDto dto) {
		int resultCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnLocator.getConnect();
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO customer(c_email,c_pwd,c_name)  ");
			sql.append("VALUES(?,PASSWORD(?),?) ");
			
			pstmt = con.prepareStatement(sql.toString());

			int index = 0;
			pstmt.setString(++index, dto.getEmail());
			pstmt.setString(++index, dto.getPwd());
			pstmt.setString(++index, dto.getName());

			resultCount = pstmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return resultCount;
	}
	public int update(CustomerDto dto) {
		int resultCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnLocator.getConnect();
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE customer ");
			sql.append("SET c_pwd = PASSWORD(?), c_name = ? ");
			sql.append("WHERE c_email = ? ");

			pstmt = con.prepareStatement(sql.toString());

			int index = 0;
			pstmt.setString(++index, dto.getPwd());
			pstmt.setString(++index, dto.getName());
			pstmt.setString(++index, dto.getEmail());

			resultCount = pstmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return resultCount;
	}
	
	public boolean isExisted(String email) {
		boolean success = false;
		
		Connection con = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		
		try {
			con = ConnLocator.getConnect();
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT c_email ");
			sql.append("FROM customer ");
			sql.append("WHERE c_email = ? ");
			
			int index = 0;
			prep.setString(++index, email);
			
			rs = prep.executeQuery();
			if(rs.next()) {
				success = true;
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs != null) rs.close();
				if(prep != null) prep.close();
				if(con != null) con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return success;
		
	}
	
	public CustomerDto select(String email) {
		CustomerDto dto = null;

		Connection con = null;
		PreparedStatement prep = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kpc", "kpc12", "kpc1234");

			StringBuffer sql = new StringBuffer();
			sql.append("SELECT c_email, c_name ");
			sql.append("FROM customer ");
			sql.append("WHERE c_email = ? ");

			int index = 0;
			prep = con.prepareStatement(sql.toString());

			prep.setString(++index, email);

			rs = prep.executeQuery();
			if (rs.next()) {
				index=0;
				
				String _email = rs.getString(++index);
				String name = rs.getString(++index);

				dto = new CustomerDto(_email, name);

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