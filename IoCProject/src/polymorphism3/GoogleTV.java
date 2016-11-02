package polymorphism3;

public class GoogleTV implements TV {
	private Speaker speaker;
	private int price;
	public int getPrice() {
		System.out.println("===> getPrice 호출");
		return price;
	}
	public void setPrice(int price) {
		System.out.println("===> setPrice 호출");
		this.price = price;
	}
	public Speaker getSpeaker() {
		System.out.println("===> getSpeaker 호출");
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker 호출");
		this.speaker = speaker;
	}
	public GoogleTV() {
		System.out.println("===> GoogleTV 생성");
	}
	public GoogleTV(Speaker speaker) {
		System.out.println("===> GoogleTV2 생성");
		this.speaker = speaker;
	}
	public GoogleTV(Speaker speaker, String val) {
		System.out.println("===> GoogleTV3 생성");
		this.speaker = speaker;
	}
	public void powerOn() {
		System.out.println("GoogleTV---전원 켠다.");
	}
	public void powerOff() {
		System.out.println("GoogleTV---전원 끈다.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
}
