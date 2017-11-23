package com.theopentutorials.jdb.oracle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestOracleJdbc {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/STUDENTS");
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * STUDENTS");
			while(rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.println(rs.getString(2));
				}
			} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
				} finally {
					try {
						rs.close();
						stmt.close();
						con.close();
						} 
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
	}
}
