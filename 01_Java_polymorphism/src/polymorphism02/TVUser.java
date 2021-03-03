package polymorphism02;

public class TVUser {
	public static void main(String[] args) {
		TV tv = new LgTV();
		
		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();
		
		System.out.println("---------------------");
		tv = new SamsungTV();
		
		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();
	}
}
