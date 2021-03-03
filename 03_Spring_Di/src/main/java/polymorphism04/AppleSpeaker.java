package polymorphism04;

public class AppleSpeaker implements Speaker{

	public AppleSpeaker() {
		System.out.println("---->AppleSpeaker 생성 ");
	}
	
	@Override
	public void volumnDown() {
		System.out.println("----> AppleSpeaker 소리작게");
	}
	
	@Override
	public void volumnUp() {
		System.out.println("----> AppleSpeaker 소리크게");
	}
}
