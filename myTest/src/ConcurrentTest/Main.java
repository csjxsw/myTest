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
	public static String[] provinceList = { "����","����", "����", "����", "�㶫", "����", "����",
			"����", "�ӱ�", "����", "������", "����", "����", "����", "����", "����", "����",
			"���ɹ�", "����", "�ຣ", "ɽ��", "ɽ��", "����", "�Ϻ�", "�Ĵ�", "���", "����",
			"�½�", "����", "�㽭", "����" };
	
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
