package polymorphism02;

public class SamsungTV implements TV{
	
	public SamsungTV() {
		System.out.println(">> SamsungTV 객체 생성");
	}
	
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
	//-----------------------------
	public void initMethod() {
		System.out.println("SamsungTV - initMethod() 실행~~");
	}
	
	public void destroyMethod() {
		System.out.println("SamsungTV - destroyMethod() 실행~~");
	}
	
}
