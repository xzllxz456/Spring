package polymorphism03;

public class LgTV implements TV {
	
	public LgTV() {
		System.out.println(">> LGTV 객체 생성");
	}
	
	@Override
	public void powerOff() {
		System.out.println("LGTV - 전원 OFF");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LGTV - 전원 ON");
	}
	
	@Override
	public void volumnDown() {
		System.out.println("LGTV - 소리 작게~");
	}
	
	@Override
	public void volumnUp() {
		System.out.println("LGTV - 소리 크게~");
	}
	//-----------------------------
	public void initMethod() {
		System.out.println("SamsungTV - initMethod() 실행~~");
	}
	
	public void destroyMethod() {
		System.out.println("SamsungTV - destroyMethod() 실행~~");
	}
	
}
