package kr.or.kpc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.kpc.dto.MemberDto;
import kr.or.kpc.util.ConnLocator;

//맴버 테이블을 접근하기 위한 클래스  
//DAO = Data Access Object
public class MemberDao {

	// 드라이브로드 필요 없음
	public static MemberDao dao;
	private MemberDao() {}
	
	public static MemberDao getInstance() {
		if (dao == null) {
			dao = new MemberDao();
			
		}
		return dao;
	}
	
	/////
	public int insert(MemberDto m) {
		int resultCount = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		
		DataSource ds = null;

		try {
			con = ConnLocator.getConnect();
			

			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO member(num, NAME)");
			sql.append(" VALUES(?,?)");

			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setInt(++index, m.getNum()); // 가지고올때는 getNum() pstmt.setString(++index,
			m.getName();

			resultCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try { //connection자원 반납
				if (pstmt != null)pstmt.close();
				if (con != null)con.close();

			} catch (SQLException e) {
				e.printStackTrace();

			}

		}
		return resultCount;
	}
	/////

	/////
	public int update(MemberDto m) {
		int resultCount = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnLocator.getConnect();

			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE member ");
			sql.append("SET NAME = ? ");
			sql.append("WHERE num = ? ");

			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setString(++index, m.getName());
			pstmt.setInt(++index, m.getNum());

			resultCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return resultCount;
	}
	/////

	/////
	public int delete(int num) {
		int resultCount = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnLocator.getConnect();

			StringBuffer sql = new StringBuffer();
			sql.append("DELETE FROM member WHERE num = ?");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, num);

			resultCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					pstmt.close();

			} catch (SQLException e) {
				e.printStackTrace();

			}

		}

		return resultCount;
	}
	/////

	/////
	public ArrayList<MemberDto> select() {

		ArrayList<MemberDto> list = new ArrayList<MemberDto>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ConnLocator.getConnect();

			StringBuffer sql = new StringBuffer();
			sql.append("SELECT num, NAME ");
			sql.append("FROM member ");
			sql.append("ORDER BY num ASC ");

			pstmt = con.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				int index = 0;
				int num = rs.getInt(++index);
				String name = rs.getString(++index);
				list.add(new MemberDto(num, name));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				e.printStackTrace();

			}

		}

		return list;
	}
	/////

	/////
	public MemberDto select(int num) {
		MemberDto mdto = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ConnLocator.getConnect();

			StringBuffer sql = new StringBuffer();
			sql.append("SELECT num, NAME ");
			sql.append("FROM member ");
			sql.append("WHERE num = ? ");

			pstmt = con.prepareStatement(sql.toString());

			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			// 결과가 0아니면 1이므로 while보다는 if가 좋음
			if (rs.next()) {
				int index = 0;
				int _num = rs.getInt(++index);
				String _name = rs.getString(++index);
				mdto = new MemberDto(_num, _name);

			} else {
				System.out.println("검색 결과가 없습니다.");

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return mdto;
	}
	/////

}
