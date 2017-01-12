package ConcurrentTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
	
	public static AtomicInteger count;
	public static Map<String,Integer> map = new HashMap<String,Integer>();
	public static ConcurrentHashMap<String,Integer> conMap = new ConcurrentHashMap<String,Integer>();
	public static String[] provinceList = { "安徽","北京", "福建", "甘肃", "广东", "广西", "贵州",
			"海南", "河北", "河南", "黑龙江", "湖北", "湖南", "吉林", "江苏", "江西", "辽宁",
			"内蒙古", "宁夏", "青海", "山东", "山西", "陕西", "上海", "四川", "天津", "西藏",
			"新疆", "云南", "浙江", "重庆" };
	
	public static void main(String args[]){
		count  = new AtomicInteger(0);

		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 5, 3,TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(30));
		
		for(int i=0;i< provinceList.length ;i++){
			threadPool.execute(new NewThread(provinceList[i]));
		}
		
		System.out.println("count="+count);
		System.out.println("map.size()="+map.size());
	}
	
}
