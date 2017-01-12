package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.concurrent.CountDownLatch;

import com.sun.org.apache.bcel.internal.generic.Select;

public class clearKPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection conn = null;
		String sql;

		try {
			conn = DriverManager.getConnection(
					"jdbc:postgresql://10.254.201.218:5432/dataService",
					"cloud", "cloud");
			Statement statement = conn.createStatement();
			Statement statement1 = conn.createStatement();
			Statement statement2 = conn.createStatement();
			Statement statement3 = conn.createStatement();

			if (true) {
				// sql="delete from dataService.kpi1_cop";
				// int det=statement.executeUpdate(sql);
				// sql="select province,avg(\"EU0103\") as avg0,avg(\"EU0404\") as avg1,avg(\"EU0201\") as avg2,avg(\"EU0405\") as avg3,avg(\"EU0406\") as avg4,avg(\"SD0004\") as avg5,avg(\"SD0005\") as avg6,avg(\"SD0006\") as avg7,avg(\"SD0007\") as avg8,avg(\"EU0409\") as avg9,avg(\"EU0412\") as avg10,avg(\"EU0415\") as avg11,avg(\"EU0533V5\") as avg12,avg(\"EU0534V5\") as avg13,avg(\"EU0529V5\") as avg14,avg(\"EU0530V5\") as avg15,avg(\"SD0001\") as avg16,avg(\"EU0309\") as avg17,avg(\"EU0311\") as avg18,sum(\"SD0023\") as sum1,sum(\"SD0024\") as sum2,avg(\"EU0113\") as avg19,avg(\"EU0205\") as avg20,avg(\"EU0538\") as avg21,avg(\"SD0008\") as avg22,avg(\"EU0531V5\") as avg23,avg(\"ENBHA10\") as avg24,avg(\"ENBHA11\") as avg25,daytime from dataService.mrs_data";
				// ResultSet rs=statement.executeQuery(sql);
				sql = "select * from dataService.kpi1_copy where \"SD0023\" IS NULL and num>=180000 and num<=183000";

				ResultSet rs = statement.executeQuery(sql);
				while (rs.next()) {
					int i = rs.getInt("num");
					sql = "update dataService.kpi1_copy set \"SD0023\"=random()*1000,\"SD0024\"=random()*1000 where num="
							+ i + ";";
					System.out.println(sql);
					// sql="insert into dataService.kpi1_cop(Province,city,cellid,celltype,\"EU0103\",\"EU0404\",\"EU0201\",\"EU0405\",\"EU0406\",\"SD0004\",\"SD0005\",\"SD0006\",\"SD0007\",\"EU0409\",\"EU0412\",\"EU0415\",\"EU0533V5\",\"EU0534V5\",\"EU0529V5\",\"EU0530V5\",\"SD0001\",\"SD0008\",\"EU0309\",\"EU0311\",\"SD0023\",\"SD0024\",\"EU0113\",\"EU0205\",\"EU0538\",\"EU0531V5\",\"ENBHA10\",\"ENBHA11\",daytime,num)values('"+rs.getString("province")+"','"+rs.getString("city")+"','"+rs.getString("cellid")+"','"+rs.getString("celltype")+"',"+rs.getDouble("EU0103")+","+rs.getDouble("EU0404")+","+rs.getDouble("EU0201")+","+rs.getDouble("EU0405")+","+rs.getDouble("EU0406")+","+rs.getDouble("SD0004")+","+rs.getDouble("SD0005")+","+rs.getDouble("SD0006")+","+rs.getDouble("SD0007")+","+rs.getDouble("EU0409")+","+rs.getDouble("EU0412")+","+rs.getDouble("EU0415")+","+rs.getDouble("EU0533V5")+","+rs.getDouble("EU0534V5")+","+rs.getDouble("EU0529V5")+","+rs.getDouble("EU0530V5")+","+rs.getDouble("SD0001")+","+rs.getDouble("SD0008")+","+rs.getDouble("EU0309")+","+rs.getDouble("EU0311")+","+rs.getDouble("SD0023")+","+rs.getDouble("SD0024")+","+rs.getDouble("EU0113")+","+rs.getDouble("EU0205")+","+rs.getDouble("EU0538")+","+rs.getDouble("EU0531V5")+","+rs.getDouble("ENBHA10")+","+rs.getDouble("ENBHA11")+",'"+rs.getString("daytime")+"',"+rs.getInt("num")+")";
					// System.out.println(sql);
					int affectRowNum = statement2.executeUpdate(sql);
				}
				// double ran1=Math.random()*10000;
				// double ran2=Math.random()*10000;
				// while(rs.next()){

				// i++; }
				// sql="select province,celltype,avg(\"EU0103\") as avg0,avg(\"EU0404\") as avg1,avg(\"EU0201\") as avg2,avg(\"EU0405\") as avg3,avg(\"EU0406\") as avg4,avg(\"SD0004\") as avg5,avg(\"SD0005\") as avg6,avg(\"SD0006\") as avg7,avg(\"SD0007\") as avg8,avg(\"EU0409\") as avg9,avg(\"EU0412\") as avg10,avg(\"EU0415\") as avg11,avg(\"EU0533V5\") as avg12,avg(\"EU0534V5\") as avg13,avg(\"EU0529V5\") as avg14,avg(\"EU0530V5\") as avg15,avg(\"SD0001\") as avg16,avg(\"EU0309\") as avg17,avg(\"EU0311\") as avg18,sum(\"SD0023\") as sum1,sum(\"SD0024\") as sum2,avg(\"EU0113\") as avg19,avg(\"EU0205\") as avg20,avg(\"EU0538\") as avg21,avg(\"SD0008\") as avg22,avg(\"EU0531V5\") as avg23,avg(\"ENBHA10\") as avg24,avg(\"ENBHA11\") as avg25,daytime from dataService.kpi1 group by province,celltype";
				// ResultSet rs3=statement.executeQuery(sql);
				//
				// while(rs3.next()){
				// sql="insert into dataService.kpi_col(num,province,city,celltype,\"EU0103\",\"EU0404\",\"EU0201\",\"EU0405\",\"EU0406\",\"SD0004\",\"SD0005\",\"SD0006\",\"SD0007\",\"EU0409\",\"EU0412\",\"EU0415\",\"EU0533V5\",\"EU0534V5\",\"EU0529V5\",\"EU0530V5\",\"SD0001\",\"EU0309\",\"EU0311\",\"SD0023\",\"SD0024\",\"EU0113\",\"EU0205\",\"EU0538\",\"SD0008\",\"EU0531V5\",\"ENBHA10\",\"ENBHA11\",daytime) values("+i+",'"+rs3.getString("province")+"','total','"+rs3.getString("celltype")+"',"+rs3.getDouble("avg0")+","+rs3.getDouble("avg1")+","+rs3.getDouble("avg2")+","+rs3.getDouble("avg3")+","+rs3.getDouble("avg4")+","+rs3.getDouble("avg5")+","+rs3.getDouble("avg6")+","+rs3.getDouble("avg7")+","+rs3.getDouble("avg8")+","+rs3.getDouble("avg9")+","+rs3.getDouble("avg10")+","+rs3.getDouble("avg11")+","+rs3.getDouble("avg12")+","+rs3.getDouble("avg13")+","+rs3.getDouble("avg14")+","+rs3.getDouble("avg15")+","+rs3.getDouble("avg16")+","+rs3.getDouble("avg17")+","+rs3.getDouble("avg18")+","+rs3.getDouble("sum1")+","+rs3.getDouble("sum2")+","+rs3.getDouble("avg19")+","+rs3.getDouble("avg20")+","+rs3.getDouble("avg21")+","+rs3.getDouble("avg22")+","+rs3.getDouble("avg23")+","+rs3.getDouble("avg24")+","+rs3.getDouble("avg25")+",'160613'";
				// int affectRowNum = statement2.executeUpdate(sql);
				// i++;
				// }
				// sql="select province,city,avg(\"EU0103\") as avg0,avg(\"EU0404\") as avg1,avg(\"EU0201\") as avg2,avg(\"EU0405\") as avg3,avg(\"EU0406\") as avg4,avg(\"SD0004\") as avg5,avg(\"SD0005\") as avg6,avg(\"SD0006\") as avg7,avg(\"SD0007\") as avg8,avg(\"EU0409\") as avg9,avg(\"EU0412\") as avg10,avg(\"EU0415\") as avg11,avg(\"EU0533V5\") as avg12,avg(\"EU0534V5\") as avg13,avg(\"EU0529V5\") as avg14,avg(\"EU0530V5\") as avg15,avg(\"SD0001\") as avg16,avg(\"EU0309\") as avg17,avg(\"EU0311\") as avg18,sum(\"SD0023\") as sum1,sum(\"SD0024\") as sum2,avg(\"EU0113\") as avg19,avg(\"EU0205\") as avg20,avg(\"EU0538\") as avg21,avg(\"SD0008\") as avg22,avg(\"EU0531V5\") as avg23,avg(\"ENBHA10\") as avg24,avg(\"ENBHA11\") as avg25,daytime from dataService.kpi1 group by province,city";
				// ResultSet rs1=statement.executeQuery(sql);
				//
				// while(rs1.next()){
				// sql="insert into dataService.kpi_col(num,province,city,celltype,\"EU0103\",\"EU0404\",\"EU0201\",\"EU0405\",\"EU0406\",\"SD0004\",\"SD0005\",\"SD0006\",\"SD0007\",\"EU0409\",\"EU0412\",\"EU0415\",\"EU0533V5\",\"EU0534V5\",\"EU0529V5\",\"EU0530V5\",\"SD0001\",\"EU0309\",\"EU0311\",\"SD0023\",\"SD0024\",\"EU0113\",\"EU0205\",\"EU0538\",\"SD0008\",\"EU0531V5\",\"ENBHA10\",\"ENBHA11\",daytime) values("+i+",'"+rs1.getString("province")+"','"+rs1.getString("city")+"','total',"+rs1.getDouble("avg0")+","+rs1.getDouble("avg1")+","+rs1.getDouble("avg2")+","+rs1.getDouble("avg3")+","+rs1.getDouble("avg4")+","+rs1.getDouble("avg5")+","+rs1.getDouble("avg6")+","+rs1.getDouble("avg7")+","+rs1.getDouble("avg8")+","+rs1.getDouble("avg9")+","+rs1.getDouble("avg10")+","+rs1.getDouble("avg11")+","+rs1.getDouble("avg12")+","+rs1.getDouble("avg13")+","+rs1.getDouble("avg14")+","+rs1.getDouble("avg15")+","+rs1.getDouble("avg16")+","+rs1.getDouble("avg17")+","+rs1.getDouble("avg18")+","+rs1.getDouble("sum1")+","+rs1.getDouble("sum2")+","+rs1.getDouble("avg19")+","+rs1.getDouble("avg20")+","+rs1.getDouble("avg21")+","+rs1.getDouble("avg22")+","+rs1.getDouble("avg23")+","+rs1.getDouble("avg24")+","+rs1.getDouble("avg25")+",'160613'";
				// int affectRowNum = statement2.executeUpdate(sql);
				// i++;
				// }
				// sql="select province,city,celltype,avg(\"EU0103\") as avg0,avg(\"EU0404\") as avg1,avg(\"EU0201\") as avg2,avg(\"EU0405\") as avg3,avg(\"EU0406\") as avg4,avg(\"SD0004\") as avg5,avg(\"SD0005\") as avg6,avg(\"SD0006\") as avg7,avg(\"SD0007\") as avg8,avg(\"EU0409\") as avg9,avg(\"EU0412\") as avg10,avg(\"EU0415\") as avg11,avg(\"EU0533V5\") as avg12,avg(\"EU0534V5\") as avg13,avg(\"EU0529V5\") as avg14,avg(\"EU0530V5\") as avg15,avg(\"SD0001\") as avg16,avg(\"EU0309\") as avg17,avg(\"EU0311\") as avg18,sum(\"SD0023\") as sum1,sum(\"SD0024\") as sum2,avg(\"EU0113\") as avg19,avg(\"EU0205\") as avg20,avg(\"EU0538\") as avg21,avg(\"SD0008\") as avg22,avg(\"EU0531V5\") as avg23,avg(\"ENBHA10\") as avg24,avg(\"ENBHA11\") as avg25 from dataService.kpi1 group by province,city,celltype";
				// ResultSet rs2=statement.executeQuery(sql);
				//
				// while(rs2.next()){
				// sql="insert into dataService.kpi_col(num,province,city,celltype,\"EU0103\",\"EU0404\",\"EU0201\",\"EU0405\",\"EU0406\",\"SD0004\",\"SD0005\",\"SD0006\",\"SD0007\",\"EU0409\",\"EU0412\",\"EU0415\",\"EU0533V5\",\"EU0534V5\",\"EU0529V5\",\"EU0530V5\",\"SD0001\",\"EU0309\",\"EU0311\",\"SD0023\",\"SD0024\",\"EU0113\",\"EU0205\",\"EU0538\",\"SD0008\",\"EU0531V5\",\"ENBHA10\",\"ENBHA11\",daytime) values("+i+",'"+rs2.getString("province")+"','"+rs2.getString("city")+"','"+rs2.getString("celltype")+"',"+rs2.getDouble("avg0")+","+rs2.getDouble("avg1")+","+rs2.getDouble("avg2")+","+rs2.getDouble("avg3")+","+rs2.getDouble("avg4")+","+rs2.getDouble("avg5")+","+rs2.getDouble("avg6")+","+rs2.getDouble("avg7")+","+rs2.getDouble("avg8")+","+rs2.getDouble("avg9")+","+rs2.getDouble("avg10")+","+rs2.getDouble("avg11")+","+rs2.getDouble("avg12")+","+rs2.getDouble("avg13")+","+rs2.getDouble("avg14")+","+rs2.getDouble("avg15")+","+rs2.getDouble("avg16")+","+rs2.getDouble("avg17")+","+rs2.getDouble("avg18")+","+rs2.getDouble("sum1")+","+rs2.getDouble("sum2")+","+rs2.getDouble("avg19")+","+rs2.getDouble("avg20")+","+rs2.getDouble("avg21")+","+rs2.getDouble("avg22")+","+rs2.getDouble("avg23")+","+rs2.getDouble("avg24")+","+rs2.getDouble("avg25")+",'160613'";
				// int affectRowNum = statement2.executeUpdate(sql);
				// i++;
				// }

			}

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (conn != null) {
			System.out.println("You made it, take control your database now!");

		} else {
			System.out.println("Failed to make connection!");
		}
	}

}