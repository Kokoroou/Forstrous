package object;

public class Boss extends Monsters {

	private String sentence;
	private boolean talk;
	
	public Boss() {
		super();
		this.setName("Boss");
	}
	public Boss(int mapX, int mapY) {
		super(mapX, mapY);
		this.setName("Boss");
	}
	public Boss(String name, int mapX, int mapY) {
		super(name, mapX, mapY);
	}
	
	public String getSentence() {
		return this.sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	
	public boolean getTalk() {
		return this.talk;
	}
	public void setTalk(boolean talk) {
		this.talk = talk;
	}

}
