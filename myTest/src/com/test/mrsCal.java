package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

//import util.SixdConstants;

public class mrsCal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis(); // 记录起始时间
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
			Statement statement4 = conn.createStatement();
			Statement statement5 = conn.createStatement();
			Statement state = conn.createStatement();
			Statement state1 = conn.createStatement();
			Statement state2 = conn.createStatement();
			Statement state3 = conn.createStatement();
			Statement state4 = conn.createStatement();
			Statement state5 = conn.createStatement();
			// int i=1;

			if (true) {
				sql = "delete from dataService.mrs_col";
				int det = state.executeUpdate(sql);
				/* 改变编号 */
				// sql="select \"IID\",object_id,enb_id from dataService.mrs_data1";
				// ResultSet rSet=statement1.executeQuery(sql);
				// while(rSet.next()){
				// String i=rSet.getString("IID");
				// sql="update dataService.mrs_data1 set id='"+rSet.getString("enb_id")+"_"+rSet.getString("object_id")+"' where \"IID\"='"+i+"'";
				// int rs=statement.executeUpdate(sql);
				// }
				/* 数据处理 */
				sql = "select distinct measurement from dataService.mrs_data1";
				ResultSet rSet = statement.executeQuery(sql);
				int i = 0;
				while (rSet.next()) {
					i++;
					String inum = rSet.getString("measurement");
					sql = "select distinct id from dataService.mrs_data1 where measurement='"
							+ inum + "'";
					ResultSet rs = statement1.executeQuery(sql);
					while (rs.next()) {
						String id = rs.getString("id");
						sql = "select v from dataService.mrs_data1 where measurement='"
								+ inum + "' and id='" + id + "' limit 1";
						ResultSet rs2 = statement2.executeQuery(sql);
						List<Integer> temp = new ArrayList<Integer>();
						while (rs2.next()) {
							String v = rs2.getString("v");
							String[] array = v.split("\\|");
							for (int j = 0; j < array.length - 1; j++) {

								int b = Integer.valueOf(array[j + 1])
										.intValue();

								temp.add(j, b);
							}
						}
						sql = "select v from dataService.mrs_data1 where measurement='"
								+ inum + "' and id='" + id + "' offset 1";
						// System.out.println(sql);
						ResultSet rs3 = statement3.executeQuery(sql);

						while (rs3.next()) {

							String v = rs3.getString("v");
							String[] array = v.split("\\|");
							for (int j = 0; j < array.length - 1; j++) {
								int b = Integer.valueOf(array[j + 1])
										.intValue();

								temp.set(j, temp.get(j) + b);
							}
						}
						String s = "|";
						for (int m = 0; m < temp.size(); m++) {
							s += temp.get(m) + "|";
						}
						sql = "insert into dataService.mrs_col(measurement,id,v)values('"
								+ inum + "','" + id + "','" + s + "')";
						int det2 = statement4.executeUpdate(sql);
					}
				}
				/* MR.RIPPRB的处理 */
				sql = "delete from dataService.mrs_col where measurement='MR.RIPPRB'";
				int det3 = statement5.executeUpdate(sql);
				sql = "select distinct substring(time_stamp,0,11) from dataService.mrs_data1 where measurement='MR.RIPPRB'";
				// System.out.println(sql);
				ResultSet rss = state1.executeQuery(sql);
				while (rss.next()) {
					String t = rss.getString("substring");

					System.out.println(t);
					sql = "select distinct id from dataService.mrs_data1 where substring(time_stamp,0,11)='"
							+ t + "' and measurement='MR.RIPPRB'";
					// System.out.println(sql);
					ResultSet rss4 = state5.executeQuery(sql);
					while (rss4.next()) {

						String id2 = rss4.getString("id");
						sql = "select v from dataService.mrs_data1 where measurement='MR.RIPPRB' and id='"
								+ id2 + "' limit 1";
						ResultSet rss2 = state2.executeQuery(sql);
						List<Integer> temp2 = new ArrayList<Integer>();
						while (rss2.next()) {
							String v = rss2.getString("v");
							String[] array = v.split("\\|");
							for (int j = 0; j < array.length - 1; j++) {
								int b2 = Integer.valueOf(array[j + 1])
										.intValue();
								temp2.add(j, b2);
							}
						}
						sql = "select v from dataService.mrs_data1 where measurement='MR.RIPPRB' and id='"
								+ id2 + "' offset 1";
						// System.out.println(sql);
						ResultSet rss3 = state3.executeQuery(sql);
						while (rss3.next()) {
							String v = rss3.getString("v");
							String[] array = v.split("\\|");
							for (int j = 0; j < array.length - 1; j++) {
								int b = Integer.valueOf(array[j + 1])
										.intValue();
								temp2.set(j, temp2.get(j) + b);
							}
						}
						String s1 = "|";
						for (int m1 = 0; m1 < temp2.size(); m1++) {
							s1 += temp2.get(m1) + "|";
						}
						sql = "insert into dataService.mrs_col(measurement,id,v,timestamp)values('MR.RIPPRB','"
								+ id2 + "','" + s1 + "','" + t + "')";
						int det2 = state4.executeUpdate(sql);
					}
				}
			}
		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (conn != null) {
			System.out.println("You made it, take control your database now!");
			long end = System.currentTimeMillis(); // 记录结束时间
			System.out.println("运行时间：" + (end - start) + "ms");

		} else {
			System.out.println("Failed to make connection!");
		}
	}

}