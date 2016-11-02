package polymorphism3;

public class GoogleTV implements TV {
	private Speaker speaker;
	private int price;
	public int getPrice() {
		System.out.println("===> getPrice ȣ��");
		return price;
	}
	public void setPrice(int price) {
		System.out.println("===> setPrice ȣ��");
		this.price = price;
	}
	public Speaker getSpeaker() {
		System.out.println("===> getSpeaker ȣ��");
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker ȣ��");
		this.speaker = speaker;
	}
	public GoogleTV() {
		System.out.println("===> GoogleTV ����");
	}
	public GoogleTV(Speaker speaker) {
		System.out.println("===> GoogleTV2 ����");
		this.speaker = speaker;
	}
	public GoogleTV(Speaker speaker, String val) {
		System.out.println("===> GoogleTV3 ����");
		this.speaker = speaker;
	}
	public void powerOn() {
		System.out.println("GoogleTV---���� �Ҵ�.");
	}
	public void powerOff() {
		System.out.println("GoogleTV---���� ����.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
}
