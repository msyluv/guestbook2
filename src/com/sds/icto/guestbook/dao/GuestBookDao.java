package com.sds.icto.guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sds.icto.guestbook.vo.GuestBookVo;

public class GuestBookDao {

	private Connection getConnection() throws ClassNotFoundException,
			SQLException {

		Connection conn = null;

		// 1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. Connection 생성
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(dbURL, "webdb", "webdb");

		return conn;

	}

	public void insert(GuestBookVo vo) throws ClassNotFoundException,
			SQLException {

		// 1. Connection 생성
		Connection conn = getConnection();

		// 2. Statement(SQL) 준비
		String sql = "insert into guestbook values (guestbook_seq.nextval, ?, ?, ?, SYSDATE)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		// 3. binding

		// pstmt.setLong(1, vo.getNo());
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getPassword());
		pstmt.setString(3, vo.getMessage());
		// pstmt.setString(5, vo.getRegdate());

		// 4. query execution
		pstmt.executeUpdate();

		// 5. 자원정리
		if (pstmt != null) {
			pstmt.close();
		}

		if (conn != null) {
			conn.close();
		}

	}

	public List<GuestBookVo> fetchList() throws ClassNotFoundException,
			SQLException {

		List<GuestBookVo> list = new ArrayList<GuestBookVo>();

		// 1. Connection 생성
		Connection conn = getConnection();

		// 2. Statement 생성
		Statement stmt = conn.createStatement();

		// 3. SQL문 실행
		String sql = "select * from guestbook";
		ResultSet rs = stmt.executeQuery(sql);

		// 4. 결과 처리
		while (rs.next()) {
			Long no = rs.getLong(1);
			String name = rs.getString(2);
			String password = rs.getString(3);
			String message = rs.getString(4);
			String regdate = rs.getString(5);

			GuestBookVo vo = new GuestBookVo();
			vo.setNo(no);
			vo.setName(name);
			vo.setPassword(password);
			vo.setMessage(message);
			vo.setRegdate(regdate);

			list.add(vo);
		}

		// 5. 자원정리
		if (rs != null) {
			rs.close();
		}

		if (stmt != null) {
			stmt.close();
		}

		if (conn != null) {
			conn.close();
		}

		return list;
	}

	public void delete() throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();

		String sql = "delete from guestbook";
		stmt.executeUpdate(sql);

		stmt.close();
		conn.close();
	}

	public void delete(GuestBookVo vo) throws ClassNotFoundException,
			SQLException {
		Connection conn = getConnection();

		String sql = "delete from guestbook where no = ? and password = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setLong(1, vo.getNo());
		pstmt.setString(2, vo.getPassword());

		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}

}
