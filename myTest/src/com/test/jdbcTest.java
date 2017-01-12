package com.test;

import java.util.Properties;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class jdbcTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
       Connection conn=null;
       String sql;
       String url="jdbc:mysql://localhost:3306/pmkpi?user=root&password=203344&useUnicode=true&characterEncoding=UTF8";
       try{
    	   new com.mysql.jdbc.Driver();
    	   System.out.println("成功加载MySQL驱动程序");
    	   conn = DriverManager.getConnection(url);
    	   Statement statement = conn.createStatement();
    //	   sql=" create table student(NO char(20),name varchar(20),primary key(NO))";
   // 	   int result = statement.executeUpdate(sql);
    	  // if(result !=-1)
    	   if(true){
    		   System.out.println("创建数据表成功");
    		   sql = "insert into student(NO) values('2012003')";
    		  int result = statement.executeUpdate(sql);
    		   sql = "insert into student(NO,name) values('2012004','周小俊')";
    		   result = statement.executeUpdate(sql);
    		   sql="select * from student";
    		   ResultSet rs=statement.executeQuery(sql);
    		   System.out.println("学号\t姓名");
    		   while(rs.next()){
    			   System.out.println(rs.getString("NO")+"\t"+rs.getString("name"));
    		   }
    	   }
       }catch(SQLException e){
    	   System.out.println("MySQL操作错误");
    	   
    	   e.printStackTrace();
       }catch(Exception e){
    	   e.printStackTrace();
       }finally{
    	   conn.close();
       }
	}

}
