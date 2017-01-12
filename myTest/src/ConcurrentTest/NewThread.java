package ConcurrentTest;

public class NewThread implements Runnable{
	private String province ;
	
	public NewThread(String province){
		this.province = province;
	}
	
	public void run() {
		int data = Main.count.addAndGet(1);
		System.out.println("province="+province+",data="+data);
		synchronized(Main.map){
			Main.map.put(province, data);
		}
	}

}
