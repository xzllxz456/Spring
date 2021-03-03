package polymorphism04;

public class LgTV implements TV {
	
	private Speaker speaker;
	private int price;
	
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
		speaker.volumnDown();
	}
	
	@Override
	public void volumnUp() {
		System.out.println("LGTV - 소리 크게~");
		speaker.volumnUp();

	}
	//-----------------------------
	public void initMethod() {
		System.out.println("SamsungTV - initMethod() 실행~~");
	}
	
	public void destroyMethod() {
		System.out.println("SamsungTV - destroyMethod() 실행~~");
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "LgTV [speaker=" + speaker + ", price=" + price + "]";
	}
	
	
	
}
