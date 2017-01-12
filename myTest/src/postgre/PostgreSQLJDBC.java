package postgre;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgreSQLJDBC {
	public static void main(String args[]) {
//		Connection conn = null;
//		try {
//			Class.forName("org.postgresql.Driver");
//			conn = DriverManager.getConnection(
//					"jdbc:postgresql://10.254.201.218:5432/dataService",
//					"cloud", "cloud");
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.err.println(e.getClass().getName() + ": " + e.getMessage());
//			System.exit(0);
//		}
		System.out.println("Opened database successfully");
	}
}