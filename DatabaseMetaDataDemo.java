package com.metaData_14_05_2025;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseMetaDataDemo {

public static void main(String[] args) {
try {
	              // connection with databases
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "1234");
    PreparedStatement ps = con.prepareStatement("select * from emp");
	
	

	System.out.println("----------------------------------------------");
	DatabaseMetaData metaData2 = con.getMetaData();
	System.out.println(".Database product name and version............");
	System.out.println(metaData2.getDriverName());
	System.out.println(".JDBC driver name and version............");
	System.out.println(metaData2.getDriverVersion());
	System.out.println(".Username used for the connection............");
	System.out.println(metaData2.getUserName());
	System.out.println("");
	System.out.println(metaData2.getMaxUserNameLength());
	System.out.println(".Batch updates............");
	System.out.println(metaData2.supportsBatchUpdates());
	System.out.println(".Transactions............");
	System.out.println(metaData2.supportsTransactions());
	System.out.println(".Stored procedures............");
	System.out.println(metaData2.supportsStoredProcedures());
	System.out.println(".Scrollable result sets............");
	System.out.println(metaData2.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
	System.out.println(".Whether catalogs and schemas are supported............");
	System.out.println(metaData2.supportsCatalogsInIndexDefinitions());
	ps.close();
} 

catch (Exception e) 
{
	e.printStackTrace();
}
}
}
