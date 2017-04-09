
public class BitPattern {

	public static void main(String[] args) {
		alternatePattern(-66);
	}
	
	public static void alternatePattern(int n) {
		if (n > 0) {
			boolean twoseq = false;
			boolean oneseq = false;
			while (n != 0) {
				n = n & 3; // retrieve last 2 bits
				if (n == 0 || n == 3) {
					System.out.println("Number not having valid pattern");
					return;
				}
				else if (n == 2 && !oneseq)
					twoseq = true;
				else if (!twoseq)
					oneseq = true;
				n = n >> 2; // retrieve next 2 bits
			}
			System.out.println("Number in sequence");
			
		} else {
			System.out.println("Please enter valid non zero positive number");
		}
	}
}
