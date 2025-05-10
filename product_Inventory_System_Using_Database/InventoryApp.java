package com.product_Inventory_System_Using_Database;

import java.sql.*;
import java.sql.Connection;

class Product {
	String productId;
	String productName;
	String category;
	int quantity;
	double price;
	String supplier;

	public void insertProduct(Connection conn) {
		try {

			String query = "INSERT INTO ProductTable (productId, productName, category, quantity, price, supplier) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, productId);
			ps.setString(2, productName);
			ps.setString(3, category);
			ps.setInt(4, quantity);
			ps.setDouble(5, price);
			ps.setString(6, supplier);
			ps.executeUpdate();
			System.out.println("Product inseted into DB successfully");
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}

class InventoryApp {
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "1234");

			Product p1 = new Product();
			p1.productId = "s44";
			p1.productName = "Whichel";
			p1.category = "Thar car";
			p1.quantity = 5;
			p1.price = 900000.0;
			p1.supplier = "TechMahindra";
			p1.insertProduct(conn);

			Product p2 = new Product();
			p2.productId = "s22";
			p2.productName = "Iphone";
			p2.category = "Mobile";
			p2.quantity = 5;
			p2.price = 59000.0;
			p2.supplier = "SonuSeller";
			p2.insertProduct(conn);

			Product p3 = new Product();
			p3.productId = "s333";
			p3.productName = "Royal infield";
			p3.category = "Bike";
			p3.quantity = 2;
			p3.price = 405000.0;
			p3.supplier = "Lal jeet ";
			p3.insertProduct(conn);

			displayProductsByCategory(conn, "Electronics");

			conn.close();
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void displayProductsByCategory(Connection conn, String category) {
		try {
			String query = "SELECT * FROM ProductTable WHERE category = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, category);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				System.out.println(rs.getString("productId") + " " + rs.getString("productName") + " "
						+ rs.getString("category") + " " + rs.getInt("quantity") + " " + rs.getDouble("price") + " "
						+ rs.getString("supplier"));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
