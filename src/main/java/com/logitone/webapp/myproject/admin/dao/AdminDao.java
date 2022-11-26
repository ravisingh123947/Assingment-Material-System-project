package com.logitone.webapp.myproject.admin.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.logitone.webapp.myproject.dao.DatabaseDataSource;

public class AdminDao extends DatabaseDataSource {

	public String selectEmployeeByEmailAndPassword(String username, String password) {
		String name = null;

		Connection dbCon = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			dbCon = getDbConnection();
			stmt = dbCon.createStatement();
			String sql = "SELECT * FROM admin WHERE admin_username= '" + username + "' " + " and " + "admin_password='"
					+ password + "'";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				name = rs.getString(1);
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeStatement(stmt);
			closeDbConection(dbCon);
		}
		return name;
	}

}
