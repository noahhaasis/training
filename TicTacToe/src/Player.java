import java.util.HashMap;

public class Player implements Field{
	static HashMap<Character, String> reprs = new HashMap<Character, String>(2);
	String name;
	String repr;
	
	/*
	 * @param name The name is a arbitrary string that stands for the player
	 * @param repr The players representation on the board. Can be either 'x' or 'o'.
	 */
	Player(String name, char repr) throws IllegalArgumentException {
		reprs.put('x',"x");
		reprs.put('o', "o");
		this.name = name;
		this.repr = reprs.get(Character.toLowerCase(repr));
		if (this.repr == null) {
			throw new IllegalArgumentException();
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void print() {
		System.out.print(repr);
	}
	
	public boolean isBlank() {
		return false;
	}
}
