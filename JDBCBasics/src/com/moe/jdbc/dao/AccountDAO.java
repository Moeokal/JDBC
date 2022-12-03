package com.moe.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AccountDAO {


	public static void main(String[] args) {
		try(			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "okal2012");
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("select * from account");
				) {
			System.out.println(connection);
			//int executeUpdate = statement.executeUpdate("insert into account values(1,'okal','moe',1000)");
			//System.out.println(executeUpdate+" rows added");
			//int executeUpdate = statement.executeUpdate("update account set bal=5000 where accno=1");
			//System.out.println(executeUpdate+" rows updated");
			//int executeUpdate = statement.executeUpdate("delete from account where accno=1");
			//System.out.println(executeUpdate+" rows deleted");
			while(rs.next()) {
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
