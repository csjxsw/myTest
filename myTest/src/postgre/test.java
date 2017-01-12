package postgre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class test {

	public static void main(String args[]) {
//		insertPostgreSQL("BJ", 28101, 8342, 10, 7509, 355, 11551, 7, 20477,
//				498.7464, 0.0228, 0.2991, 0.4246);
		getPysicNum();
	}
	
	
	private static int getPysicNum(){
		int result = 0;
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<=9;i++){
			list.add(i);
		}
		
		for(int i=0;i<=9;i++){
			System.out.println(list.get(i));
		}
		
		Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
		
		List<Integer> list0 = new ArrayList<Integer>();list0.add(1);
		map.put(0, list0);
		
		List<Integer> list1 = new ArrayList<Integer>();list1.add(0);list1.add(6);
		map.put(1, list1);
		
		List<Integer> list2 = new ArrayList<Integer>();list2.add(3);list2.add(7);
		map.put(2, list2);
		
		List<Integer> list3 = new ArrayList<Integer>();list3.add(2);list3.add(8);
		map.put(3, list3);
		
		List<Integer> list4 = new ArrayList<Integer>();list4.add(9);
		map.put(4, list4);
		
		List<Integer> list5 = new ArrayList<Integer>();
		map.put(5, list5);
		
		List<Integer> list6 = new ArrayList<Integer>();list6.add(1);
		map.put(6, list6);
		
		List<Integer> list7 = new ArrayList<Integer>();list7.add(2);list7.add(8);
		map.put(7, list7);
		
		List<Integer> list8 = new ArrayList<Integer>();list8.add(3);list8.add(7);
		map.put(8, list8);
		
		List<Integer> list9 = new ArrayList<Integer>();list9.add(4);
		map.put(9, list9);
		
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> keys = map.keySet();
		Iterator<Integer> it = keys.iterator();
		while(it.hasNext()){
			set.add(it.next());
		}
		Set<Integer> dealList=new HashSet<Integer>();
		
		Iterator<Entry<Integer, List<Integer>>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<Integer, List<Integer>> entry = iter.next();
			int enbId = (Integer) entry.getKey();
			List<Integer> site = (List<Integer>) entry.getValue();
			
			if(dealList.contains(enbId)){
				continue;
			}else{
				dealList.add(enbId);
				List<Integer> idList = site;
				for(int i=0;i<idList.size();i++){
					Integer id = idList.get(i);
					dealList.add(id);
					if(set.contains(id)){
						set.remove(id);
					}
				}
			}
		}
		System.out.println("size="+set.size());
		
		return result;
	}

	private static void insertPostgreSQL(String province, int lteLogicSiteNum,
			int fBandOut, int eBandOut, int dBandOut, int fBandIn, int eBandIn,
			int dBandIn, int physicsNum, double averageDis, double heightRate,
			double dis700Rate, double indoorRate) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(
					"jdbc:postgresql://10.254.201.218:5432/dataService",
					"cloud", "cloud");
			System.out.println("Opened database successfully");

			stmt = conn.createStatement();
			String month = "06";
			String prov = "BJ";
			String key = "P-" + prov + "-" + month;
			String sql = "INSERT INTO dataService.EPTable (KEY,MONTH,PROVINCE,CITY,"
					+ "SD0041,SD0042,SD0046,SD0048,SD0050,SD0071,SD0073,SD0074,SD0075,SD0076,SD0077,SD0078) "
					+ "VALUES ('"
					+ key
					+ "','"
					+ month
					+ "','"
					+ prov
					+ "','"
					+ prov
					+ "',"
					+ lteLogicSiteNum
					+ ","
					+ physicsNum
					+ ","
					+ averageDis
					+ ","
					+ dis700Rate
					+ ","
					+ heightRate
					+ ","
					+ indoorRate
					+ ","
					+ fBandOut
					+ ","
					+ eBandOut
					+ ","
					+ dBandOut
					+ ","
					+ fBandIn + "," + eBandIn + "," + dBandIn + ");";
			stmt.executeUpdate(sql);

			stmt.close();
			conn.commit();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Table insert successfully");
	}

}