package com.project.connection;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;

public class MyConnectionDetail {
public Connection getConnetion() throws Exception{
	Context ic=new InitialContext();
	DataSource ds=(DataSource)ic.lookup("java:/comp/env/jdbc/OracleDB");
	
	
	
	return ds.getConnection();
	
}
}
