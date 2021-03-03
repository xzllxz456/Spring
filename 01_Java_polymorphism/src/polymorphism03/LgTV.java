package polymorphism03;

public class LgTV implements TV {
	
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
	
}
