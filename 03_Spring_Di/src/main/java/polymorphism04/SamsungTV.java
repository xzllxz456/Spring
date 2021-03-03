package polymorphism04;

public class SamsungTV implements TV{
	
	private Speaker speaker;
	private int price;
	private int width;
	private int height;
	
	
	public SamsungTV() {
		System.out.println(">> SamsungTV 객체 생성");
	}

	public SamsungTV(Speaker speaker) {
		System.out.println(">>>>>>>> SamsungTV(speaker) 객체 생성");
		this.speaker = speaker;
	}

	public SamsungTV(Speaker speaker, int price) {
		System.out.println(">>>>>>>> SamsungTV(speaker, price) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}
	
	public SamsungTV(Speaker speaker, int width, int height) {
		System.out.println(">>>>>>>> SamsungTV(speaker, width, height) 객체 생성");
		this.speaker = speaker;
		this.width = width;
		this.height = height;
	}
	
	
	@Override
	public void volumnDown() {
		System.out.println("SamsungTV - 소리 작게");
		speaker.volumnDown();
	}
	
	@Override
	public void volumnUp() {
		System.out.println("SamsungTV - 소리 크게");	
		speaker.volumnUp();
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

	// ===========================================================
	// 게터 세터 추가
	
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
	
}
