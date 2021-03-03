package polymorphism02;

public class SamsungTV implements TV{
	
	private SonySpeaker speaker;
	private int price;
	private int width;
	private int height;
	
	
	public SamsungTV() {
		System.out.println(">> SamsungTV 객체 생성");
	}

	public SamsungTV(SonySpeaker speaker) {
		System.out.println(">>>>>>>> SamsungTV(speaker) 객체 생성");
		this.speaker = speaker;
	}

	public SamsungTV(SonySpeaker speaker, int price) {
		System.out.println(">>>>>>>> SamsungTV(speaker, price) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}
	
	public SamsungTV(SonySpeaker speaker, int width, int height) {
		System.out.println(">>>>>>>> SamsungTV(speaker, width, height) 객체 생성");
		this.speaker = speaker;
		this.width = width;
		this.height = height;
	}
	
	
	@Override
	public void volumnDown() {
		System.out.println("SamsungTV - 소리 작게");
		speaker.volumDown();
	}
	
	@Override
	public void volumnUp() {
		System.out.println("SamsungTV - 소리 크게");	
		speaker.volumUp();
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

	@Override
	public String toString() {
		return "SamsungTV [speaker=" + speaker + ", price=" + price + ", width=" + width + ", height=" + height + "]";
	}

	
	
}
