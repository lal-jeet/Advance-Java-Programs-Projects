package com.metaData_14_05_2025;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

public class metaData {

public static void main(String[] args) {
try {
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "1234");
    PreparedStatement ps = con.prepareStatement("select * from emp");
	ResultSetMetaData metaData=ps.getMetaData();
	System.out.println("Column name...........");
	System.out.println(metaData.getColumnCount());
	System.out.println("Column label and colume type...........");
	for(int i=1;i<=metaData.getColumnCount();i++) {
		System.out.print(metaData.getColumnName(i)+" "+metaData.getColumnType(i)+"     ");
	}
	
	System.out.println();
	System.out.println("Column display size...........");

	for(int i=1;i<=metaData.getColumnCount();i++) {
	System.out.print(" "+metaData.getColumnDisplaySize(i));
	
	System.out.print("  "+metaData.isNullable(i));
	}
	
	System.out.println();
	System.out.println("Whether the column is nullable...........");

	for(int i=1;i<=metaData.getColumnCount();i++) {
	
	System.out.print(metaData.isNullable(i)+"  ");
	}
	
	System.out.println();
	System.out.println("Whether the column is auto-incremented...........");

	for(int i=1;i<=metaData.getColumnCount();i++) {
	
	System.out.print(metaData.isAutoIncrement(i)+"  ");
	}
	
	
} catch (Exception e) 
{
	
}
}
}
