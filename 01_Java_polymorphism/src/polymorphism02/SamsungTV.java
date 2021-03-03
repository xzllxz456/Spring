package polymorphism02;

public class SamsungTV implements TV{
	@Override
	public void volumnDown() {
		System.out.println("SamsungTV - 소리 작게");
	}
	
	@Override
	public void volumnUp() {
		System.out.println("SamsungTV - 소리 크게");		
	}
	
	public void powerOn() {
		System.out.println("SamsungTV - 전원 On");
	}
	
	public void powerOff() {
		System.out.println("SamsungTV - 전원 Off");
	}
}
