package com.wolff.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
@ManagedBean
public class Conexion {

	public Connection conn;

	
	public void getConn() {
		
		  String url = "jdbc:mysql://127.0.0.1:3306/holly";
		  
		  String user = "root";
		  
		  String password = "";
		 
		
		
			/*
			 * String user = "hollystv_mwolff2"; String password = "Holly"; String dbHost =
			 * "mysql3000.mochahost.com"; String dbName = "hollystv_db2"; String url
			 * ="jdbc:mysql://"+dbHost+":3306/"+dbName;
			 */
		  
		  
		  
		  try { Class.forName("com.mysql.jdbc.Driver"); conn =
		  DriverManager.getConnection(url,user,password);
		  System.out.println("connected"); }catch(SQLException | ClassNotFoundException
		  e) { e.printStackTrace(); }
		 
	}


	
}
