package PrenotazioneVoli;

import java.util.Scanner;

public class TestScanner {

	private Scanner S;
	
	public TestScanner() {
		// TODO Auto-generated constructor stub
		S = new Scanner(System.in);
	}

	public int nextInt(){
		S = new Scanner(System.in);
		int i = S.nextInt();
		S.reset();
		return i;
	}
	
	public String next(){
		S = new Scanner(System.in);
		String i = S.next();
		S.reset();
		return i;
	}
	
	
	
}
