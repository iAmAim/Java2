package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.accounts.Account;

public class Main {

	public static void main(String[] args) throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javalvl2", "root", "");
		Statement stm = con.createStatement();
		readtDbContents(stm);
		insertToDB(stm);
		readtDbContents(stm);
		deleteDbContent(stm);
		readtDbContents(stm);
		stm.close();
		con.close();
	}
	
	private static void deleteDbContent(Statement stm) throws SQLException {
		stm.executeUpdate("delete from accounts where id =3");
	}

	private static void readtDbContents(Statement stm) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs = stm.executeQuery("select * from accounts");
		while(rs.next()){
			System.out.println("account: "+ rs.getString(1) + ": " + rs.getString(3));
		}
	}

	public static void insertToDB(Statement stm) throws SQLException{
		 stm.executeUpdate("insert into accounts values(4,4,\"Kriz\",14344)");
	}

}
