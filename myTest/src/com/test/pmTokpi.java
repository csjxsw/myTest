package com.test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class pmTokpi {

	  public static void main(String[] argv) {

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
                                  "jdbc:postgresql://10.254.201.218:5432/dataService", "cloud",
                                  "cloud");
                  Statement statement = conn.createStatement();
   	    	   Statement statement2 = conn.createStatement();
   	    	
  
   	    		   sql="select * from dataService.pmtableday";
   	    		   ResultSet rs=statement.executeQuery(sql);
   	    		   while(rs.next()){
   	    			   String province = rs.getString("province");
   	    			   String city = rs.getString("city");
   	    			   String cellid = rs.getString("cellid");
   	    			   String celltype =rs.getString("celltype");
   	    			   double EU0103 = rs.getDouble("HB06A")/rs.getDouble("HB05A")*rs.getDouble("HA06A")/rs.getDouble("HA05A");
   	    			   double EU0404 = rs.getDouble("HH13A")/(rs.getDouble("HH07A")-rs.getDouble("HH08A"));
   	    			   double EU0201 = (rs.getDouble("HC07A")-rs.getDouble("HC07D"))/(rs.getDouble("HC02A")+rs.getDouble("HC09"));
   	    			   double EU0405 = rs.getDouble("HM04")/rs.getDouble("HM02A");
   	    			   double EU0406 = rs.getDouble("HM08")/rs.getDouble("HM06A");
   	    			   double SD0004 = rs.getDouble("HM05G")/(rs.getDouble("HM05F")+rs.getDouble("HM05G")+rs.getDouble("HM05H")+rs.getDouble("HM05I")+rs.getDouble("HM05J")+rs.getDouble("HM05K")+rs.getDouble("HM05L")+rs.getDouble("HM05M"));
   	    			   double SD0005 = rs.getDouble("HM05H")/(rs.getDouble("HM05F")+rs.getDouble("HM05G")+rs.getDouble("HM05H")+rs.getDouble("HM05I")+rs.getDouble("HM05J")+rs.getDouble("HM05K")+rs.getDouble("HM05L")+rs.getDouble("HM05M"));
   	    			   double SD0006 = rs.getDouble("HM05L")/(rs.getDouble("HM05F")+rs.getDouble("HM05G")+rs.getDouble("HM05H")+rs.getDouble("HM05I")+rs.getDouble("HM05J")+rs.getDouble("HM05K")+rs.getDouble("HM05L")+rs.getDouble("HM05M"));
   	    			   double SD0007 = rs.getDouble("HM05M")/(rs.getDouble("HM05F")+rs.getDouble("HM05G")+rs.getDouble("HM05H")+rs.getDouble("HM05I")+rs.getDouble("HM05J")+rs.getDouble("HM05K")+rs.getDouble("HM05L")+rs.getDouble("HM05M"));
   	    			   double EU0409 = rs.getDouble("HM05E")/rs.getDouble("HM05D")+rs.getDouble("HM05E");
   	    			   double EU0412 = rs.getDouble("HM02E")/rs.getDouble("HM02A");
   	    			   double EU0415 = rs.getDouble("HM06E")/rs.getDouble("HM06A");
   	    			   double EU0533V5 = rs.getDouble("HH01A") * 8/rs.getDouble("HI09")*rs.getDouble("HI01");
   	    			   double EU0534V5 = rs.getDouble("HH02A") * 8/rs.getDouble("HI10")*rs.getDouble("HI02")-rs.getDouble("HI12")+rs.getDouble("HI11");
   	    			   double EU0529V5 = rs.getDouble("HI03")/rs.getDouble("HI07");
   	    			   double EU0530V5 = rs.getDouble("HI04")/rs.getDouble("HI08");
   	    			   double SD0001 = rs.getDouble("HA03");
   	    			   double SD0008 = (rs.getDouble("HE01")+rs.getDouble("HE06"))/(rs.getDouble("HE01")+rs.getDouble("HE06")+rs.getDouble("HD01A")+rs.getDouble("HD07A")+rs.getDouble("HD13A"));
   	    			   double EU0309 = rs.getDouble("HE04")/rs.getDouble("HE01");
   	    			   double EU0311 = rs.getDouble("HE09")/rs.getDouble("HE06");
   	    			   double SD0023 = rs.getDouble("HH01A")/1000;
   	    			   double SD0024 = rs.getDouble("HH02A")/1000;	    			  
   	    			   double EU0113 = rs.getDouble("HB09B")/rs.getDouble("HB05B")*rs.getDouble("HA06A")/rs.getDouble("HA05A");
   	    			   double EU0205 = ( rs.getDouble("HB11D") -rs.getDouble("HB11F")+rs.getDouble("HB12B"))/rs.getDouble("HB06B");
   	    			   double EU0538 = rs.getDouble("HB01B");
   	    			   double EU0531V5 = ( rs.getDouble("HI03")+rs.getDouble("HI04") )/(rs.getDouble("HI07")+rs.getDouble("HI08"));
   	    			   double ENBHA10 = rs.getDouble("HA10");
   	    			   double ENBHA11 = rs.getDouble("HA11");
   	    			  // sql = "select * from kpi1";
   	        		 //  ResultSet result = statement2.executeQuery(sql);
   	        		   sql = "insert into dataService.kpi1(province,city,cellid,celltype,\"EU0103\",\"EU0404\",\"EU0201\",\"EU0405\",\"EU0406\",\"SD0004\",\"SD0005\",\"SD0006\",\"SD0007\",\"EU0409\",\"EU0412\",\"EU0415\",\"EU0533V5\",\"EU0534V5\",\"EU0529V5\",\"EU0530V5\",\"SD0001\",\"EU0309\",\"EU0311\",\"SD0023\",\"SD0024\",\"EU0113\",\"EU0205\",\"EU0538\",\"SD0008\",\"EU0531V5\",\"ENBHA10\",\"ENBHA11\") values('"+province+"','"+city+"','"+cellid+"','"+celltype+"',"+EU0103+","+EU0404+","+EU0201+","+EU0405+","+EU0406+","+SD0004+","+SD0005+","+SD0006+","+SD0007+","+EU0409+","+EU0412+","+EU0415+","+EU0533V5+","+EU0534V5+","+EU0529V5+","+EU0530V5+","+SD0001+","+EU0309+","+EU0311+","+SD0023+","+SD0024+","+EU0113+","+EU0205+","+EU0538+","+SD0008+","+EU0531V5+","+ENBHA10+","+ENBHA11+")";
   	        		   int affectRowNum = statement2.executeUpdate(sql);
   	        		sql = "insert into dataService.kpi1(\"SD0023\",\"SD0024\")values(1000,1000)";
   	        	 int affectRowNum1 = statement2.executeUpdate(sql);
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
