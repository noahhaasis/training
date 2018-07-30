
public class Blank implements Field{
	public void print() {
		String blankStringRepr = " ";
		System.out.print(blankStringRepr);
	}
	
	public boolean isBlank() {
		return true;
	}
}
