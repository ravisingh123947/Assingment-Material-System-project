package com.logitone.webapp.myproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDataSource {
	public Connection getDbConnection() {
		Connection dbCon = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignments_inventory", "root",
					"Ravi@2000.com");
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}

		return dbCon;
	}

	public void closeStatement(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
	}

	public void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();

		}
	}

	public void closeDbConection(Connection dbCon) {
		try {
			if (dbCon != null) {
				dbCon.close();
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();

		}
	}
}